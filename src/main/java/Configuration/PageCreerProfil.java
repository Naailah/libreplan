package Configuration;


import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GR4.LibrePlan4.Outils;
import GR4.LibrePlan4.PageBandeau;

public class PageCreerProfil extends PageBandeau{
	
	@FindBy (xpath="//input[substring(@id,5)='a5']")
	private WebElement chmps_nom;
	
	@FindBy (xpath="//span[@class='z-tab-text']")
	private WebElement onglet_donneesProfil;
	
	@FindBy (xpath="//fieldset[substring(@id,5)='b5']//span[substring(@id,5)='c5-cnt']")
	private WebElement texte_associationRoles;
	
	@FindBy (xpath="//fieldset[substring(@id,5)='b5']//i[substring(@id,5)='e5']")
	private WebElement menuDeroulant;
	
//	@FindBy (xpath="//fieldset[substring(@id,5)='b5']//td[@class='z-button-cm'][text()='Ajouter un rôle']")
//	private WebElement bouton_ajouterRole;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Ajouter un rôle']")
	private WebElement bouton_ajouterRole;
	
	@FindBy (xpath="//div[substring(@id,5)='g5'][@class='z-grid']")
	private List<WebElement> colonnes_nomRoleActions;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Enregistrer']")
	private WebElement bouton_enregistrer;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Sauver et continuer']")
	private WebElement bouton_sauver;
	
	@FindBy (xpath="//td[@class='z-button-cm'][text()='Annuler']")
	private WebElement bouton_annuler;
	
	@FindBy (xpath="//div[substring(@id,5)='e5-pp']")
	private WebElement bouton_menuDeroulant;
	
//	@FindBy (xpath="td[substring(@id,5)='e5-chdex']")
//	private WebElement bouton_menuDeroulant;
	
	@FindBy (xpath="//table[substring(@id,5)='e5-cave']//td[contains(.,'Lire')]")
	private WebElement lien_lireProjets;
	
	@FindBy (xpath="//i[substring(@id,5)='e5-btn']")
	private WebElement bouton_flecheMenuDeroulant;

	@FindBy (xpath="//table[substring(@id,5)='e5-cave']//tr[substring(@id,1,4)='qOwP']/td[@class='z-comboitem-text']")
	private WebElement lien_optionsRole;
	
//	@FindBy (xpath="//tr[substring(@id,5)='q4']")
//	private List<WebElement> ligne_lireProjets;
	
	@FindBy (xpath="//fieldset//div[substring(@id,8)='body']/table/tbody/tr[@class='z-row']")
	private List<WebElement> ligne_lireProjets;
	
	@FindBy (xpath="//tr[td/div/span[contains(.,'Lire')]]//td//span[@title='Supprimer']")
	private WebElement icone_suppr;
	
	@FindBy (xpath="//tr[td/div/span[contains(.,'Lire')]]//td//span[@title='Supprimer']/table[@class='z-button-over']")
	private WebElement infobulle_suppr;
	

	
	public PageCreerProfil() {
		
	}

	
	/**
	 * Vérifier la présence des éléments de l'onglet "Données de profil"
	 * 
	 */
	public void verifDonneesDeProfil() {
		onglet_donneesProfil.isDisplayed();
		Outils.verificationTextWebElement("Données de profil", onglet_donneesProfil);
		chmps_nom.isDisplayed();
		assertTrue("[FAIL] Le champs n'est pas vide", chmps_nom.getText().isEmpty());
		texte_associationRoles.isDisplayed();
		Outils.verificationTextWebElement("Association avec les rôles" , texte_associationRoles);
		menuDeroulant.isDisplayed();
		assertTrue(menuDeroulant.getText().isEmpty());
		bouton_ajouterRole.isDisplayed();
		Outils.verificationTextWebElement("Ajouter un rôle", bouton_ajouterRole);
		Outils.verifTableau(" " + "Nom du rôle\nActions", colonnes_nomRoleActions);
		bouton_enregistrer.isDisplayed();
		Outils.verificationTextWebElement("Enregistrer", bouton_enregistrer);
		bouton_sauver.isDisplayed();
		Outils.verificationTextWebElement("Annuler", bouton_annuler);
	}
	
	public void saisirNomProfil() {
		Outils.renseignerChamp(chmps_nom, "Nom du profil");
	}
	
	public void selectionnerRole(WebDriver driver, String role) throws Exception {
		Outils.selectionnerOption_pageCreerProfil(driver, role, bouton_flecheMenuDeroulant);
	}
	
	public void cliquerAjouterRole() {
		bouton_ajouterRole.click();
		chmps_nom.click();
	}
	
	public void verifAjoutDuRole(String role) {
		Outils.verifTableau(" " + role, ligne_lireProjets);
	}
	
	public void verifIconeSupprimerRole() {
		icone_suppr.isDisplayed();
	}
	
	public void verifInfobulle(WebDriver driver) {
		Actions moPoubelle = new Actions(driver);
		moPoubelle.moveToElement(icone_suppr).build().perform();
		assertTrue("[FAIL] L'infobulle ne s'affiche pas", infobulle_suppr.isDisplayed());
	}
	
	
	
}
