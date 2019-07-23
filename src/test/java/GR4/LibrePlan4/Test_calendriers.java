package GR4.LibrePlan4;


import org.junit.Test;
import org.openqa.selenium.support.PageFactory;


import Ressources.PageCreerCalendrier;
import Ressources.PageListedecalendriers;

public class Test_calendriers extends Test_connexion {

	@Test

	public void Testcalendriers() throws InterruptedException {
		

		
		
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
		
		
		// PAS DE TEST 5 :
		// Créer un calendrier dérivé.
		page_liste_de_calendriers.clicCreerDerive1();
		// Vérification du titre "Créer Calendrier".
		page_creer_calendrier.verificationTitreCreerCalendrier();
		// Vérification du champ "Nom" vide et du type "Dérivé du calendrier Calendrier - Test 1".
		page_creer_calendrier.verificationChampNomVide();
		page_creer_calendrier.verificationTexteChampCalendrierDerive1();
		
		
		// PAS DE TEST 6 :
		// Renseigner l'ensemble des champs et cliquer sur Enregistrer : message d'erreur.
		page_creer_calendrier.remplirChampNomCalendrier();
		page_creer_calendrier.verifierGenererCodeCochee();
		page_creer_calendrier.cliquerEnregistrerContinuerCalendrier();
		page_creer_calendrier.verificationAffichageMessageErreurTitre();
		// Le message doit être affiché en orange:
		page_creer_calendrier.verificationCouleurOrange();
		
		
		// PAS DE TEST 7 :
		// Renseigner l'ensemble des champs pour un cas passant.
		page_creer_calendrier.remplirChampNomCalendrierDerive();
		page_creer_calendrier.verifierGenererCodeCochee();
		page_creer_calendrier.cliquerEnregistrerContinuerCalendrier();
		// Affichage du message "Calendrier de base "Calendrier - Test Calendrier Dérivé" enregistré".
		page_creer_calendrier.verificationMessageSuccesCalendrier();
		// Vérifier que le titre de la page est "Calendrier - Test Calendrier Dérivé"
		page_creer_calendrier.verificationTitreCreerCalendrierDerive();
		
		
		// PAS DE TEST 8 :
		// Retour page de gestion des calendriers.
		page_creer_calendrier.cliquerAnnulerCalendrier();
		// Vérifier que " Calendrier - Test Calendrier Dérivé" est une sous catégorie de "Calendrier - Test 1".
		page_liste_de_calendriers.verificationSousCategorie();
		
		
		// PAS DE TEST 9 :
		// Cliquer sur le bouton [-] pour refermer la ligne du calendrier dérivé.
		page_liste_de_calendriers.verificationAffichageCalendrierDerive();	
		page_liste_de_calendriers.replierCalendrierDerive();		
		page_liste_de_calendriers.verificationNonAffichageCalendrierDerive();
		
		
		// PAS DE TEST 10 :
		// Créer un calendrier par copie.
		page_liste_de_calendriers.copierCalendrier1();
		page_creer_calendrier.verificationTitreCreerCalendrierTest1();
		page_creer_calendrier.verificationChampNomCopie();
		page_creer_calendrier.verificationTypeCopie();
		
		
		// PAS DE TEST 11 :
		// Créer un calendrier par copie - Nom du calendrier non conforme
		page_creer_calendrier.cliquerEnregistrerContinuerCalendrier();
		page_creer_calendrier.verificationAffichageMessageErreurTitre();
		// Le message doit être affiché en orange:
		page_creer_calendrier.verificationCouleurOrange();
		
		
		// PAS DE TEST 12 :
		// 	Créer un calendrier par copie - bouton [Enregistrer]
		page_creer_calendrier.remplirChampNomCopie();
		page_creer_calendrier.verifierGenererCodeCochee();
		page_creer_calendrier.cliquerEnregistrerCalendrier();
		page_liste_de_calendriers.verificationTitreListeDeCalendriers();
		page_liste_de_calendriers.verificationMessageSuccesCalendrier();
		page_liste_de_calendriers.compterNombreSousCategories();
	}

}
