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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author formation
 *
 */
/**
 * @author formation
 *
 */
public class Outils {
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5433/libreplan";
	private static final String USER = "libreplan";
	private static final String PASSWORD = "libreplan";
	
	/**
	 * Permet de vérifier le contenu d'un tableau
	 * @param listeColonneAttendu
	 * @param colonnes
	 */
	public static void verifTableau(String listeColonneAttendu, List<WebElement> colonnes) {
		String listeColonnesReel = new String();
		for(WebElement colonne : colonnes) {
			System.out.println(colonne.getText());
			listeColonnesReel = listeColonnesReel + " " + colonne.getText();
		}
		System.out.println(listeColonnesReel);
		assertEquals(listeColonneAttendu, listeColonnesReel);
	}
	
	
	/**
	 * Permet d'écrire dans un champs de saisie
	 * @param we
	 * @param s
	 */
	public static void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	
	/**
	 * Permet de sélectionner une option d'un menu déroulant (avec un select)
	 * @param menu
	 * @param option
	 */
	public static void selectOption(WebElement menu, String option) {
		Select select = new Select(menu);
		select.selectByValue(option);
	}
	
	/**
	 * Permet de faire un copier/coller
	 * @param element_a_copier
	 * @param element_a_coller
	 */
	public static void copierColler(WebElement element_a_copier, WebElement element_a_coller) {
		element_a_copier.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element_a_copier.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		element_a_coller.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}
		
	/**
	 * Permet de vérifier que deux string sont identiques
	 * @param expected
	 * @param we
	 */
	public static void verificationTextWebElement(String expected, WebElement we) {
		try{
			assertEquals(expected, we.getText());
		}catch(Error e) {
			System.out.println("[FAIL] verificationTextWebElement \n expected : "+expected+"\n real="+ we.getText());
			throw e;
		}
	}
	

	
	/**
	 * Permet de sélectionner le navigateur pour l'exécution des tests
	 * @param browser
	 * @return
	 */
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
		Thread.sleep(1000);
		WebElement selectOption = driver.findElement(By.xpath("//table[substring(@id,5)='e5-cave']//tr/td[@class='z-comboitem-text'][contains(.,'" + option + "')]"));
		System.out.println(selectOption.getText());
		assertTrue("[FAIL] Pas la bonne sélection", selectOption.getText().contains(option));
		selectOption.click();		
	}

	
		/**
		 * Permet de vérifier que la date est au format jj mois. aaaa
		 * @param dateForm
		 */
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
		
		
		/**
		 * Permet de vérifier la taille d'une liste
		 * @param liste
		 * @param taille
		 */
		public static void verifTailleListe(List<WebElement> liste, int taille) {
			int listSize = liste.size();
			System.out.println(listSize);
			assertTrue(taille == listSize);
		}
		
		/**
		 * Permet de supprimer un élément d'une liste selon l'index
		 * @param liste
		 * @throws Exception
		 */
		public static void supprimerElementListe(List<WebElement> liste, int index, int valeur_i, int valeur_tant_que_i_inf_ou_egal) throws Exception{
			for(int i = index; i <= valeur_tant_que_i_inf_ou_egal; i++)
			{
				liste.get(index).click();
				Thread.sleep(1000);
			}
		}
		
		/**
		 * Permet de vérifier la couleur de fond
		 * @param msgBox
		 * @param couleurHexminuscule
		 */
		public static void verifierCouleur(WebElement msgBox, String couleurHexminuscule) {
			System.out.println(msgBox.getText());
			String rgbCode = msgBox.getCssValue("Background").substring(0, 18);
			System.out.println(rgbCode);
			String[] numbers = rgbCode.replace("rgb(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
			String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
			System.out.println(hex);
			assertTrue("[FAIL] Pas la bonne couleur", couleurHexminuscule.equals(hex));
		}
		
		/**
		 * Permet d'ajouter un certain nombre de jours à la date du jour
		 * @param plus
		 * @return
		 * @throws Exception
		 */
		public static String datePlus(int plus) throws Exception {
			//Retourne la date du jour + le nombre de jours passés en paramètres
			Calendar date = new GregorianCalendar();
			String rdata;
			Calendar end_date = date;
			DateFormatSymbols dFR = new DateFormatSymbols(Locale.FRENCH);
			String[] moisCourtsFR = dFR.getShortMonths();
			//String datePlus;
			end_date.add(Calendar.DAY_OF_MONTH, plus);
			rdata =(end_date.get(Calendar.DAY_OF_MONTH)+" "+ (moisCourtsFR[end_date.get(Calendar.MONTH)]+" "+end_date.get(Calendar.YEAR)));
			System.out.println("jdjfhf :"+rdata);
			return rdata;
		}
		
		/**
		 * Permet de cliquer sur un sous-menu
		 * @param driver
		 * @param title
		 * @param subtitle
		 */
		public static void clickMenu(WebDriver driver, String title, String subtitle) {
			WebElement section = driver.findElement(By.xpath("//*[contains(@class,'mainmenu')]/descendant::button[contains(.,'"+ title.trim()+"')]/.."));
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Actions actions = new Actions(driver);
			actions.moveToElement(section);
			actions.build().perform();
			
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(wait.until(ExpectedConditions.visibilityOf(section.findElement(By.xpath("//div[contains(@class, 'submenu')]/ul/li/descendant::a[contains(., '"+subtitle+"')]")))));
			actions2.click();
			actions2.build().perform();
		}
		
		/**
		 * Permet de lire des données en base
		 * @param filename
		 * @return
		 * @throws Exception
		 */
		private static IDataSet readDataSet(String filename) throws Exception {
			return new FlatXmlDataSetBuilder().build(new File(filename));
		}

		/**
		 * Permet d'insérer des données en base
		 * @param path_to_file
		 * @throws Exception
		 */
		public static void insertData(String path_to_file) throws Exception {
			IDataSet dataset = readDataSet(path_to_file);
			IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
			databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
			databaseTester.setDataSet(dataset);
			databaseTester.onSetup();
		}
			
		
		/**
		 * Permet de supprimer des données en base
		 * @param path_to_file
		 * @throws Exception
		 */
		public static void deleteAllData(String path_to_file) throws Exception {
			IDataSet dataset = readDataSet(path_to_file);
			IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
			databaseTester.setSetUpOperation(DatabaseOperation.DELETE_ALL);
			databaseTester.setDataSet(dataset);
			databaseTester.onSetup();
		}

		/**
		 * Permet de comparer des données en base
		 * @param table
		 * @param path_to_file
		 * @param col
		 * @throws SQLException
		 * @throws Exception
		 */
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


		
		

		/**
		 * Permet de retourner un numéro de ligne dans un tableau
		 * @param driver
		 * @param s
		 * @return
		 */
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

	
}
