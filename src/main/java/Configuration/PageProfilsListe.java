package Configuration;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GR4.LibrePlan4.Outils;
import GR4.LibrePlan4.PageBandeau;

public class PageProfilsListe extends PageBandeau {


	@FindBy (xpath="//table[@style='table-layout:fixed;']//div[text()='Nom de profil']")
	private WebElement colonne_nom;
	
	@FindBy	(xpath="//div[@class='clickable-rows z-grid']//table[@style='table-layout:fixed;']//div[text()='Actions']")
	private WebElement colonne_actions;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Créer']")
	private WebElement bouton_creer;

	@FindBy (xpath="//img[@src='/libreplan/common/img/ico_editar1.png']")
	private WebElement listeIcones_modifier;
	
	@FindBy (xpath="//img[@src='/libreplan/common/img/ico_borrar1.png']")
	private WebElement listeIcones_supprimer;
	
	@FindBy (xpath="//tr[substring(@id,5)='m4']")
	private List<WebElement> listeColonnes_nomActions;
	
	@FindBy (xpath="//div[@class='message_INFO']")
	private WebElement msgConfirmation;
	
	@FindBy (xpath="//tr[td/div/span[text()='Nom du profil']]")
	private List<WebElement> ligne_nomDuProfil;
	
	@FindBy (xpath="//tr[td/div/span[contains(.,'Nom du profil')]]//td//span[@title='Modifier']")
	private WebElement icone_modifier_nomDuProfil;
	
	@FindBy (xpath="//div[@class='z-window-embedded-header'][text()='Profils Liste']")
	private WebElement titre_profilsListe;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='OK']")
	private WebElement bouton_ok;
	
	@FindBy (xpath="//tr[td/div/span[text()='Utilisateur test']]")
	private List<WebElement> ligne_utilisateurTest;

	
	
	public PageProfilsListe() {	
		
	}

	
	
	/**
	 * Permet de vérifier la présence des colonnes "Nom de profil" et "Actions"
	 */
	public void verifColonnesNomActions() {
		Outils.verifTableau(" " + "Nom de profil\nActions", listeColonnes_nomActions);
	}	
	
	/**
	 * OLD - Permet de vérifier la présence de la colonne "Nom de profil"
	 */
	public void verifColonneNom() {
//		System.out.println(colonne_nom.getText());
		Outils.verificationTextWebElement("Nom de profil", colonne_nom);
	}
	
	/**
	 * OLD - Permet de vérifier la présence de la colonne "Actions"
	 */
	public void verifColonneActions() {
//		System.out.println(colonne_actions.getText());
		Outils.verificationTextWebElement("Actions", colonne_actions);
	}
	
	/**
	 * Permet de vérifier la présence du bouton "Créer" 
	 */
	public void verifBoutonCreer() {
		assertTrue("[FAIL] Le bouton n'est pas présent", bouton_creer.isDisplayed());
//		System.out.println(bouton_creer.getText());
		Outils.verificationTextWebElement("Créer", bouton_creer);
	}

	
	/** 
	 * Permet de cliquer sur le bouton "Créer"
	 * @param driver
	 * @return
	 */
	public PageCreer_ModifierProfil cliquerBoutonCreer(WebDriver driver) throws Exception {
		Thread.sleep(500);
		bouton_creer.isDisplayed();
		bouton_creer.click();
		return PageFactory.initElements(driver, PageCreer_ModifierProfil.class);
	}
	
//	public void insererProfil () throws Exception {
//		Outils.insertData("src/main/resources/datasets/insertProfile.xml");
//	}
	
	public void verifIconesModifierSupprimer() {
		listeIcones_modifier.isDisplayed();
		listeIcones_supprimer.isDisplayed();
	}
	
	public void verifMsgConfirmation(String nom) {
		msgConfirmation.isDisplayed();
		Outils.verificationTextWebElement("Profil \"" + nom + "\" enregistré", msgConfirmation);
		Outils.verifierCouleur(msgConfirmation, "#cceecc");
	}
	
//	public void verifAjoutProfil(WebDriver driver, String nom) throws Exception {	
//		List<WebElement> ligne_profil = driver.findElements(By.xpath("//tr[td/div/span[text()='\"" + nom + "\"']]"));
//		Thread.sleep(500);
//		Outils.verifTableau(" " + nom, ligne_profil);
//	}
	
	public void verifAjoutNomDuProfil(String nom) {
		Outils.verifTableau(" " + nom, ligne_nomDuProfil);
	}
	
	public void verifAjoutUtilisateurTest(String nom) {
		Outils.verifTableau(" " + nom, ligne_utilisateurTest);
	}
	
	public PageCreer_ModifierProfil cliquerModifNomDuProfil(WebDriver driver) {
		icone_modifier_nomDuProfil.isDisplayed();
		icone_modifier_nomDuProfil.click();
		return PageFactory.initElements(driver, PageCreer_ModifierProfil.class);
	}
	
	public void verifTitreProfilsListe() throws Exception {
		titre_profilsListe.isDisplayed();
		Thread.sleep(500);
		Outils.verificationTextWebElement("Profils Liste", titre_profilsListe);
	}
	
	public boolean supprProfilsCrees(WebDriver driver, String nom) {
//	WebElement supprProfil = driver.findElement(By.xpath("//tr[td/div/span[contains(.,'" + nom + "')]]//td//span[@title='Supprimer']"));
		

//		if(!supprProfil.isDisplayed()) {
//			System.out.println("Pas displayed");
//		}
//		else{
//			supprProfil.click();
//		}
		
		
		
		try {
			WebElement supprProfil = driver.findElement(By.xpath("//tr[td/div/span[contains(.,'" + nom + "')]]//td//span[@title='Supprimer']"));
			supprProfil.isDisplayed();
			supprProfil.click();
			bouton_ok.isDisplayed();
			bouton_ok.click();
		
			}
			catch(Exception e) {
				System.out.println("[FAIL] Le profil " + nom + " n'est pas présent");
				return false;
//			throw e;
			} return true;
//		finally {
//			System.out.println("[FAIL] Le profil " + nom + " n'est pas présent");
//		}
		
		
				
	}



	private By findElement(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}




	

}
