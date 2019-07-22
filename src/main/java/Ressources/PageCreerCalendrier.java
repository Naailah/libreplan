package Ressources;

import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import GR4.LibrePlan4.Outils;

public class PageCreerCalendrier {
	
	
	// XPath du titre "Créer Calendrier"
	@FindBy(xpath = "//td[substring(@id,5)='s4-cnt'][text()='Créer Calendrier']")
	private WebElement titre_creer_calendrier;
	
	
	// XPath du titre de l'onglet "Données de calendrier".
	@FindBy(xpath = "//span[@class='z-tab-text'][text()='Données de calendrier']")
	private WebElement titre_donnees_de_calendrier;	
	
	
	// XPath du champ pour le Nom du calendrier
	@FindBy(xpath = "//input[substring(@id,5)='45']")
	private WebElement champ_nom_calendrier;	
	
	
	// XPath du bouton "Enregistrer"
	@FindBy(xpath = "//td[@class='z-button-cm'][text()='Enregistrer']")
	private WebElement bouton_enregistrer_calendrier;	
	
	
	// XPath du bouton "Enregistrer et continuer"
	@FindBy(xpath = "//td[@class='z-button-cm'][text()='Enregistrer et continuer']")
	private WebElement bouton_enregistrer_et_continuer_calendrier;
	
	
	// XPath du bouton "Annuler"
	@FindBy(xpath = "//td[@class='z-button-cm'][text()='Annuler']")
	private WebElement bouton_annuler_calendrier;
	
	
	// XPath de la checkbox à cocher "Générer le code"
	@FindBy(xpath = "//input[@type='checkbox'][substring(@id,5)='d5-real']")
	private WebElement checkbox_generer_le_code;
	
	
	
	
	// Méthode de vérification de la présence du titre "Créer calendrier"
	public void verificationTitreCreerCalendrier() {
		Outils.verificationTextWebElement("Créer Calendrier", titre_creer_calendrier);
	}
	
	
	// Méthode de vérification de la présence du titre "Données de calendrier".
	public void verificationTitreDonneesDeCalendrier() {
		Outils.verificationTextWebElement("Données de calendrier", titre_donnees_de_calendrier);
	}
	
	
	// Vérification qu'il s'agit bien d'un champ de formulaire.
	public void verificationChampNomCalendrier() {
		assertTrue(champ_nom_calendrier.isDisplayed());
	}

	
	// Méthode de vérification de la présence du bouton "Enregistrer".
	public void verificationBoutonEnregistrer() {
		Outils.verificationTextWebElement("Enregistrer", bouton_enregistrer_calendrier);
	}
	
	
	// Méthode de vérification de la présence du bouton "Enregistrer et continuer".
	public void verificationBoutonEnregistrerEtContinuer() {
		Outils.verificationTextWebElement("Enregistrer et continuer", bouton_enregistrer_et_continuer_calendrier);
	}
	
	
	//Méthode de vérification de la présence du bouton "Annuler".
	public void verificationBoutonAnnuler() {
		Outils.verificationTextWebElement("Annuler", bouton_annuler_calendrier);
	}
	
	
	// Méthode de remplir le champ "Nom".
	public void remplirChampNomCalendrier() {
		Outils.renseignerChamp(champ_nom_calendrier, "Calendrier - Test 1");	
	}
	
	
	// Méthode de vérifier que la case "Générer le code" cochée.
	public void verifierGenererCodeCochee() {
		assertTrue(checkbox_generer_le_code.isSelected());
	}

	
	// Méthode de cliquer sur le bouton Enregistrer.
	public void cliquerEnregistrerCalendrier() {
		bouton_enregistrer_calendrier.click();
	}

}
