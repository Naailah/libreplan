package GR4.LibrePlan4;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Outils {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5433/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";
	
	public static void verifTableau(String listeColonneAttendu, List<WebElement> colonnes) {
		String listeColonnesReel = new String();
		for(WebElement colonne : colonnes) {
			System.out.println(colonne.getText());
			listeColonnesReel = listeColonnesReel + " " + colonne.getText();
		}
		System.out.println(listeColonnesReel);
		assertEquals(listeColonneAttendu, listeColonnesReel);
	}
	
	private static IDataSet readDataSet(String filename) throws Exception {
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}

	public static void insertData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}
		
	public static void insertDataDateUpdate(String path_to_file) throws Exception {
		IDataSet dataset = dateUpdate(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	public static void deleteAllData(String path_to_file) throws Exception {
		IDataSet dataset = readDataSet(path_to_file);
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
		databaseTester.setDataSet(dataset);
		databaseTester.onSetup();
	}

	public static void compareData(String table, String path_to_file, String... col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable(table);
		IDataSet expectedDataSet = readDataSet(path_to_file);
		//IDataSet expectedDataSet=dateUpdate(path_to_file);
		ITable expectedTable = expectedDataSet.getTable(table);
		String tab[] = col;
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
	}

	public static IDataSet dateUpdate(String path_to_file) throws Exception {
		IDataSet data = readDataSet(path_to_file);
		Calendar date = new GregorianCalendar();
		ReplacementDataSet rData = new ReplacementDataSet(data);
		rData.addReplacementObject("[current_date]", date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1)
				+ "-" + date.get(Calendar.DAY_OF_MONTH) + " 12:00:00");
		Calendar end_date = date;
		end_date.add(Calendar.DAY_OF_MONTH, 1);
		rData.addReplacementObject("[next_date]", end_date.get(Calendar.YEAR) + "-" + (end_date.get(Calendar.MONTH) + 1)
				+ "-" + end_date.get(Calendar.DAY_OF_MONTH) + " 12:00:00");
		return rData;
	}
	
	
	

	public static int retournerNumeroDeLigne(WebDriver driver , String s){ 
		int ligneCourante = 1;
		List<WebElement> list_lignes = driver.findElements(By.xpath("//table/tbody/tr[@bgcolor='#FFFF88']"));
		for(WebElement ligne : list_lignes){
			int casecourante=0;
		   List<WebElement> list_cases = ligne.findElements(By.xpath("td"));
		   for( WebElement case_td : list_cases) {
			   casecourante++;
			   System.out.println("ligne_courante = "+ligneCourante+"\ncase courante = "+casecourante);
			   if(case_td.getText().equals(s)){
				   System.out.println("ligne_courante = ".toUpperCase()+ligneCourante+"\ncase courante = ".toUpperCase()+casecourante);
				return ligneCourante;
		   }
		   }
	      ligneCourante++;
		}
		return -1;
	}

	public static void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	
	public static void selectOption(WebElement menu, String option) {
		Select select = new Select(menu);
		select.selectByValue(option);
	}
	
	public static void copierColler(WebElement element_a_copier, WebElement element_a_coller) {
		element_a_copier.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element_a_copier.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		element_a_coller.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}
		
	public static void verificationTextWebElement(String expected, WebElement we) {
		try{
			assertEquals(expected, we.getText());
		}catch(Error e) {
			System.out.println("[FAIL] verificationTextWebElement \n expected : "+expected+"\n real="+ we.getText());
			throw e;
		}
	}
	
	
	
	public static WebDriver choisirNavigateur(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			return new FirefoxDriver();
			
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			return new InternetExplorerDriver();
			

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			return new ChromeDriver();
			

		default:
			System.out.println("browser mal renseigné");
			return null;
		}
	}
	
	/**
	 * Permet de sélectionner une option dans le menu déroulant de la page CreerProfil
	 * @param driver
	 * @param option
	 * @param bouton_flecheMenuDeroulant
	 */
	public static void selectionnerOption_pageCreerProfil(WebDriver driver, String option, WebElement bouton_flecheMenuDeroulant) throws Exception {
		bouton_flecheMenuDeroulant.click();
		Thread.sleep(5000);
		WebElement selectOption = driver.findElement(By.xpath("//table[substring(@id,5)='e5-cave']//tr/td[@class='z-comboitem-text'][contains(.,'" + option + "')]"));
		System.out.println(selectOption.getText());
		assertTrue("[FAIL] Pas la bonne sélection", selectOption.getText().contains(option));
		selectOption.click();		
	}

	
	// Vérifie que la date est au format jj mois. aaaa
		public static void isValidFormat(String dateForm) {
			// jour mois et année de la date du champ
			int jour = Integer.parseInt(dateForm.substring(0,2));
			String mois = dateForm.substring(3,8);
			int annee = Integer.parseInt(dateForm.substring(9,13));
			
			// Variables avec la date du jour
			Calendar actuelle = Calendar.getInstance();
			DateFormatSymbols dFR = new DateFormatSymbols(Locale.FRENCH);
			String[] moisCourtsFR = dFR.getShortMonths();
			
			//Vérification de la date
			assertEquals(actuelle.get(Calendar.DATE),jour);
			
			
			//Vérification du mois 
			assertEquals(moisCourtsFR[actuelle.get(Calendar.MONTH)],mois);
			
			//Vérification de l'année
			assertTrue(actuelle.get(Calendar.YEAR)==annee);
			
		
			// Syso de vérification
			System.out.println(" date du jour : "+actuelle.get(Calendar.DATE)+" "+actuelle.get(Calendar.MONTH)+" "+actuelle.get(Calendar.YEAR));
			System.out.println(" date du champ : "+jour+" "+mois+" "+annee);
			
		}
	
}
