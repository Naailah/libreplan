package Configuration;


import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy (xpath="//fieldset[substring(@id,5)='b5']//td[@class='z-button-cm'][text()='Ajouter un rôle']")
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
		Outils.verifTableau(" Nom du rôle\nActions", colonnes_nomRoleActions);
		bouton_enregistrer.isDisplayed();
		Outils.verificationTextWebElement("Enregistrer", bouton_enregistrer);
		bouton_sauver.isDisplayed();
		Outils.verificationTextWebElement("Annuler", bouton_annuler);
	}
	
	public void saisirNomProfil() {
		Outils.renseignerChamp(chmps_nom, "Nom du profil");
	}
	
	public void choisirRole(String role) {
		Outils.selectOption(bouton_menuDeroulant, role);
		String real = bouton_menuDeroulant.getAttribute("value");
		System.out.println(bouton_menuDeroulant.getAttribute("value"));
		assertEquals("[FAIL] Le rôle n'a pas été sélectionné correctement.", role, real);
		
	}
	
	public void selectionnerRole(WebDriver driver, String role) {
		Outils.selectionnerOption_pageCreerProfil(driver, role, bouton_flecheMenuDeroulant);
	}
	
}
