package GR4.LibrePlan4;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageCreerProfil;
import Configuration.PageProfilsListe;

public class Test_GUP_01 extends Test_connexion {

	
	
	
	@Test
	public void gestionDUnProfil() throws Exception {
		
		//ACCEDER A LA PAGE PROFILS LISTE
		PageAccueil pageAccueil = PageFactory.initElements(driver, PageAccueil.class);
		PageProfilsListe pageProfilsListe = pageAccueil.mouseoverConfiguration(driver);
//		driver.get("http://localhost:8090/libreplan/profiles/profiles.zul");
		
		//VERIFIER LA PRESENCE DES COLONNES "NOM DE PROFIL" ET "ACTIONS"
		pageProfilsListe.verifColonnesNomActions();
		
		//VERIFIER LA PRESENCE DES ICONES "MODIFIER" ET "SUPPRIMER"
		pageProfilsListe.verifIconesModifierSupprimer();
		
		//VERIFIER LA PRESENCE DU BOUTON "CREER"
		pageProfilsListe.verifBoutonCreer();
		
		//CLIQUER SUR LE BOUTON "CREER"
		PageCreerProfil pageCreerProfil = pageProfilsListe.cliquerBoutonCreer(driver);
		
		//VERIFIER LA PRESENCE DES ELEMENTS DE L'ONGLET "DONNEES DE PROFIL"
		pageCreerProfil.verifDonneesDeProfil();
		
		//SAISIR UNE VALEUR DANS LE CHAMPS "NOM"
		pageCreerProfil.saisirNomProfil();
		
		//CHOISIR LE RÔLE "LIRE TOUS LES PROJETS" DANS LE MENU DEROULANT
		pageCreerProfil.selectionnerRole(driver, "Lire");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreerProfil.cliquerAjouterRole();
		
		//VERIFIER L'AJOUT DU RÔLE "LIRE TOUS LES PROJETS"
		pageCreerProfil.verifAjoutDuRole("Lire tous les projets");
		
		//VERIFIER LA PRESENCE DE L'ICONE "POUBELLE"
		pageCreerProfil.verifIconeSupprimerRole();
		
		//VERIFIER LA PRESENCE DE L'INFOBULLE "SUPPRIMER"
		pageCreerProfil.verifInfobulle(driver);
		
		//CHOISIR LE RÔLE "FEUILLE DE TEMPS" DANS LE MENU DEROULANT
		pageCreerProfil.selectionnerRole(driver, "Feuille");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreerProfil.cliquerAjouterRole();
		
		//CHOISIR LE RÔLE "CRITERE" DANS LE MENU DEROULANT
		pageCreerProfil.selectionnerRole(driver, "Critère");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreerProfil.cliquerAjouterRole();
		
		//CHOISIR LE RÔLE "CALENDRIER" DANS LE MENU DEROULANT
		pageCreerProfil.selectionnerRole(driver, "Calendrier");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreerProfil.cliquerAjouterRole();
		
		//VERIFIER L'AJOUT DES RÔLES "FEUILLE DE TEMPS", "CALENDRIER" ET "CRITERE"
		pageCreerProfil.verifAjout3roles();
		
		//CHOISIR LE RÔLE "LIRE TOUS LES PROJETS" DANS LE MENU DEROULANT
		pageCreerProfil.selectionnerRole(driver, "Lire");
				
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreerProfil.cliquerAjouterRole();
		
		//VERIFIER QU'IL N'Y A PAS DE DOUBLON
		pageCreerProfil.verifPasDeDoublon();
		
		//SUPPRIMER LE RÔLE "CRITERE"
		pageCreerProfil.supprRoleCritere();
		
		//VERIFIER LA SUPPRESSION DU RÔLE "CRITERE"
		pageCreerProfil.verifSupprRoleCritere();
		
		//SUPPRIMER TOUS LES RÔLES
		pageCreerProfil.supprRoles();
	}
	
}
