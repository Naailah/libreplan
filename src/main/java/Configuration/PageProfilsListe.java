package Configuration;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GR4.LibrePlan4.Outils;

public class PageProfilsListe {

	@FindBy (xpath="//button[substring(@id,5)='81-b'][@class='z-menu-btn']")
	private WebElement bouton_configuration;
	
//	@FindBy (xpath="//a[substring(@id,5)='c1-a']")
//	private WebElement lien_profils;
	
	@FindBy (xpath="//a[contains(@href,'profiles.zul')]")
	private WebElement lien_profils;
	
	@FindBy (xpath="//table[@style='table-layout:fixed;']//div[text()='Nom de profil']")
	private WebElement colonne_nom;
	
	@FindBy	(xpath="//div[@class='clickable-rows z-grid']//table[@style='table-layout:fixed;']//div[text()='Actions']")
	private WebElement colonne_actions;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Créer']")
	private WebElement bouton_creer;


	
	
	
	public PageProfilsListe() {	
		
	}

	/**
	 * Permet de faire un mouseover sur l'onglet "Configuration"
	 * @param driver
	 */
	public void mouseoverConfiguration(WebDriver driver) {
		Actions moConfig = new Actions(driver);
		moConfig.moveToElement(bouton_configuration).build().perform();
		lien_profils.click();		
	}
	
	/**
	 * Permet de vérifier la présence de la colonne "Nom de profil"
	 */
	public void verifColonneNom() {
//		System.out.println(colonne_nom.getText());
		Outils.verificationTextWebElement("Nom de profil", colonne_nom);
	}
	
	/**
	 * Permet de vérifier la présence de la colonne "Actions"
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
}
