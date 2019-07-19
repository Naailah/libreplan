package Configuration;


import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
//		Outils.verifTableau("Nom du rôle Actions", colonnes);
		
	}
	
	
	
}
