package Configuration;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.http.util.Args;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public PageCreerProfil cliquerBoutonCreer(WebDriver driver) {
		bouton_creer.click();
		return PageFactory.initElements(driver, PageCreerProfil.class);
	}
	
//	public void insererProfil () throws Exception {
//		Outils.insertData("src/main/resources/datasets/insertProfile.xml");
//	}
	
	public void verifIconesModifierSupprimer() {
		listeIcones_modifier.isDisplayed();
		listeIcones_supprimer.isDisplayed();
	}
	
	public void verifMsgConfirmation() {
		msgConfirmation.isDisplayed();
		Outils.verificationTextWebElement("Profil \"Nom du profil\" enregistré", msgConfirmation);
		Outils.verifierCouleur(msgConfirmation);
	}
	
//	String color = driver.findElement(By.xpath("//div[@class='gb_e gb_f gb_g gb_xb']/a")).getCssValue("color");
//	String[] numbers = color.replace("rgb(", "").replace(")", "").split(",");
//	int r = Integer.parseInt(numbers[0].trim());
//	int g = Integer.parseInt(numbers[1].trim());
//	int b = Integer.parseInt(numbers[2].trim());
//	System.out.println("r: " + r + "g: " + g + "b: " + b);
//	String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
//	System.out.println(hex);
//	
//	
//	
//	
//	public void convertioncouleur() {
//
//
//	}
	
	
}
