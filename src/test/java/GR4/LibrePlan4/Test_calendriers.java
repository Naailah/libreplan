package GR4.LibrePlan4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import Ressources.PageCreerCalendrier;
import Ressources.PageListedecalendriers;

public class Test_calendriers extends Test_connexion {

	@Test

	public void Testcalendriers() {
		

		
		
		// PAS DE TEST 2 :
		// Cliquer sur "Calendriers" dans "Ressources".
		PageAccueil pageAccueil = PageFactory.initElements(driver, PageAccueil.class);
        PageListedecalendriers page_liste_de_calendriers = pageAccueil.mouseoverRessources(driver);
		// Affichage de la page, vérifier la présence du titre "Liste de calendriers".
		page_liste_de_calendriers.verificationTitreListeDeCalendriers();	
		// Vérifier les éléments du tableau.
		page_liste_de_calendriers.verificationNomsColonnesCalendrier();		
		//Vérifier la présence du bouton "Créer".
		page_liste_de_calendriers.verificationBoutonCreerCalendrier();
	
		
		// PAS DE TEST 3 :
		// Affichage de la page "Créer calendrier", vérification du titre "Créer Calendrier", du titre "Données de Calendrier", des boutons "Enregistrer", "Enregistrer et continuer", "Annuler".
		PageCreerCalendrier page_creer_calendrier = page_liste_de_calendriers.creerUnCalendrier(driver);
		page_creer_calendrier.verificationTitreCreerCalendrier();
		page_creer_calendrier.verificationTitreDonneesDeCalendrier();
		page_creer_calendrier.verificationChampNomCalendrier();
		page_creer_calendrier.verificationBoutonEnregistrer();
		page_creer_calendrier.verificationBoutonEnregistrerEtContinuer();
		page_creer_calendrier.verificationBoutonAnnuler();
		
		
		// PAS DE TEST 4 :
		// Remplir le champ "Nom", vérifier que la case "Générer le code" est cochée, et Enregistrer.
		page_creer_calendrier.remplirChampNomCalendrier();
		page_creer_calendrier.verifierGenererCodeCochee();
		page_creer_calendrier.cliquerEnregistrerCalendrier();
		// Retour sur la page "Liste de calendriers".
		page_liste_de_calendriers.verificationTitreListeDeCalendriers();
		// Vérification de la ligne créée "Calendrier - Test 1".
		page_liste_de_calendriers.verificationLigneCalendrierTest1();
		
		
		
	
			
		

	}

}
