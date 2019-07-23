package Ressources;

import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import GR4.LibrePlan4.Outils;

public class PageCreerCalendrier {
	
	
	// XPath du titre "Créer Calendrier"
	@FindBy(xpath = "//td[substring(@id,5)='s4-cnt'][text()='Créer Calendrier']")
	private WebElement titre_creer_calendrier;
	
	
	// XPath du titre "Créer Calendrier: Calendrier - Test Calendrier Dérivé":
	@FindBy(xpath = "//td[substring(@id,5)='s4-cnt'][text()='Créer Calendrier: Calendrier - Test Calendrier Dérivé']")
	private WebElement titre_creer_calendrier_derive;
	
	
	// XPath du titre "Créer Calendrier: Calendrier Test 1" :
	@FindBy(xpath = "//td[substring(@id,5)='s4-cnt'][text()='Créer Calendrier: Calendrier - Test 1']")
	private WebElement titre_creer_calendrier_calendrier_test_1;
	
	
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
	
	
	// XPath du champ type du calendrier dérivé rempli.
	@FindBy(xpath = "//span[substring(@id,5)='85']")
	private WebElement champ_type_calendrier;
	

	// XPath du message d'erreur "Calendrier - Test 1" existe déjà.
	@FindBy(xpath = "//div[@class='message_WARNING']/span[text()='Calendrier - Test 1 existe déjà']")
	private WebElement warning_existe_deja;
	
	
	// XPath de l'encadré orange du message d'erreur
	@FindBy(xpath= "//div[@class='message_WARNING'][contains(.,'Calendrier - Test 1')]")
	private WebElement warning_cadre_orange;
	
	
	// XPath du span pour le message de succès de la création du calendrier dérivé 1.
	@FindBy(xpath = "//div[@class='message_INFO'][contains(.,'Calendrier de base')]")
	private WebElement message_succes_creation_calendrier;



	
	
	// Méthode de vérification de la présence du titre "Créer calendrier"
	public void verificationTitreCreerCalendrier() {
		Outils.verificationTextWebElement("Créer Calendrier", titre_creer_calendrier);
	}
	
	
	// Méthode de vérification du titre "Créer Calendrier : Calendrier - Test 1"
	public void verificationTitreCreerCalendrierTest1() {
		Outils.verificationTextWebElement("Créer Calendrier: Calendrier - Test 1", titre_creer_calendrier_calendrier_test_1);
	}
	
	
	// Méthode de vérification du titre "Créer calendrier dérivé"
	public void verificationTitreCreerCalendrierDerive() {
		Outils.verificationTextWebElement("Créer Calendrier: Calendrier - Test Calendrier Dérivé", titre_creer_calendrier_derive);
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
	public void cliquerEnregistrerCalendrier() throws InterruptedException {
		bouton_enregistrer_calendrier.click();
		Thread.sleep(1000);
	}
	
	
	// Méthode de cliquer sur le bouton Enregistrer et continuer.
	public void cliquerEnregistrerContinuerCalendrier() throws InterruptedException {
		bouton_enregistrer_et_continuer_calendrier.click();
		Thread.sleep(1000);
	}
	
	
	// Méthode de cliquer sur le bouton Annuler.
	public void cliquerAnnulerCalendrier() throws InterruptedException {
		bouton_annuler_calendrier.click();
		Thread.sleep(1000);
	}
	
	
	// Méthode pour vérifier que le champ "Nom" du calendrier dérivé est vide.
	public void verificationChampNomVide() {
		assertTrue(champ_nom_calendrier.getText().isEmpty());
	}
	
	
	// Méthode de vérification du texte du champ type calendrier dérivé 1.
	public void verificationTexteChampCalendrierDerive1() {
		Outils.verificationTextWebElement("Dérivé du calendrier Calendrier - Test 1", champ_type_calendrier);
	}
	
	
	// Méthode de vérification d'affichage du message d'erreur "Calendrier 1 existe déjà".
	public void verificationAffichageMessageErreurTitre() {
		assertTrue(warning_existe_deja.isDisplayed());
	}
	
	
	// Méthode de remplir le champ "Nom" calendrier dérivé (pour le test passant).
	public void remplirChampNomCalendrierDerive() {
		Outils.renseignerChamp(champ_nom_calendrier, "Calendrier - Test Calendrier Dérivé");	
	}
	
	
	// Méthode de vérification du message de création du calendrier.
	public void verificationMessageSuccesCalendrier() {
		message_succes_creation_calendrier.isDisplayed();
		}
	
	
	// Méthode de vérification du champ "Nom" de la copie
	public void verificationChampNomCopie() {
		assertEquals("Calendrier - Test 1", champ_nom_calendrier.getAttribute("value"));
	}
	
	
	// Méthode de vérification du champ type pour la copie.
	public void verificationTypeCopie() {
		assertEquals("Calendrier source", champ_type_calendrier.getText());
	}
	
	
	// Méthode remplir nom calendrier copie
	public void remplirChampNomCopie() {
		Outils.renseignerChamp(champ_nom_calendrier, "Calendrier - Test 2");
	}
	
	
	// Méthode vérifier la couleur orange
	
	public void verificationCouleurOrange() {
		Outils.verifierCouleur(warning_cadre_orange, "#fdca87");
	}
	
	
	

}
