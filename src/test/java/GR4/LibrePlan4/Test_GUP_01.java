package GR4.LibrePlan4;

import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageCreer_ModifierProfil;
import Configuration.PageProfilsListe;

public class Test_GUP_01 extends Test_connexion {

	
	
	
	@Test
	public void gestionDUnProfil() throws Exception {
		
		//ACCEDER A LA PAGE PROFILS LISTE
		PageAccueil pageAccueil = PageFactory.initElements(driver, PageAccueil.class);
		PageProfilsListe pageProfilsListe = pageAccueil.mouseoverConfiguration(driver);
//		driver.get("http://localhost:8090/libreplan/profiles/profiles.zul");
		
		//VERIFIER LE TITRE DE LA PAGE "PROFILS LISTE"
		pageProfilsListe.verifTitreProfilsListe();
		
		//VERIFIER LA PRESENCE DES COLONNES "NOM DE PROFIL" ET "ACTIONS"
		pageProfilsListe.verifColonnesNomActions();
		
		//VERIFIER LA PRESENCE DES ICONES "MODIFIER" ET "SUPPRIMER"
		pageProfilsListe.verifIconesModifierSupprimer();
		
		//VERIFIER LA PRESENCE DU BOUTON "CREER"
		pageProfilsListe.verifBoutonCreer();
		
		//SUPPRIMER LES PROFILS CREES
		pageProfilsListe.supprProfilsCrees(driver, "Nom du profil");
		pageProfilsListe.supprProfilsCrees(driver, "Utilisateur test");
		
		//CLIQUER SUR LE BOUTON "CREER"
		PageCreer_ModifierProfil pageCreer_ModifierProfil = pageProfilsListe.cliquerBoutonCreer(driver);
		
		//VERIFIER LE TITRE DE LA PAGE "CREER PROFIL"
		pageCreer_ModifierProfil.verifTitreCreerModifProfil("Créer Profil");
		
		//VERIFIER LA PRESENCE DES ELEMENTS DE L'ONGLET "DONNEES DE PROFIL"
		pageCreer_ModifierProfil.verifDonneesDeProfil();
		
		//SAISIR UNE VALEUR DANS LE CHAMPS "NOM"
		pageCreer_ModifierProfil.saisirNomProfil("Nom du profil");
		
		//CHOISIR LE RÔLE "LIRE TOUS LES PROJETS" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Lire");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//VERIFIER L'AJOUT DU RÔLE "LIRE TOUS LES PROJETS"
		pageCreer_ModifierProfil.verifAjoutDuRole("Lire tous les projets");
		
		//VERIFIER LA PRESENCE DE L'ICONE "POUBELLE"
		pageCreer_ModifierProfil.verifIconeSupprimerRole();
		
		//VERIFIER LA PRESENCE DE L'INFOBULLE "SUPPRIMER"
		pageCreer_ModifierProfil.verifInfobulle(driver);
		
		//CHOISIR LE RÔLE "FEUILLE DE TEMPS" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Feuille");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//CHOISIR LE RÔLE "CRITERE" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Critère");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//CHOISIR LE RÔLE "CALENDRIER" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Calendrier");
		
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//VERIFIER L'AJOUT DES RÔLES "FEUILLE DE TEMPS", "CALENDRIER" ET "CRITERE"
		pageCreer_ModifierProfil.verifAjout3roles();
		
		//CHOISIR LE RÔLE "LIRE TOUS LES PROJETS" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Lire");
				
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//VERIFIER QU'IL N'Y A PAS DE DOUBLON
		pageCreer_ModifierProfil.verifPasDeDoublon();
		
		//SUPPRIMER LE RÔLE "CRITERE"
		pageCreer_ModifierProfil.supprRoleCritere();
		
		//VERIFIER LA SUPPRESSION DU RÔLE "CRITERE"
		pageCreer_ModifierProfil.verifSupprRoleCritere();
		
		//SUPPRIMER TOUS LES RÔLES
		pageCreer_ModifierProfil.supprRoles();
		
		//VERIFIER LA SUPPRESSION DE TOUS LES RÔLES
		pageCreer_ModifierProfil.verifListeVide();
		
		//CLIQUER SUR LE BOUTON "ENREGISTRER"
		pageCreer_ModifierProfil.clicEnregister(driver);
		
		//VERIFIER LE TITRE DE LA PAGE "PROFILS LISTE"
		pageProfilsListe.verifTitreProfilsListe();
		
		//VERIFIER LE MESSAGE DE CONFIRMATION D'ENREGISTREMENT
		pageProfilsListe.verifMsgConfirmation("Nom du profil");
		
		//VERIFIER L'AJOUT DU PROFIL
		pageProfilsListe.verifAjoutNomDuProfil("Nom du profil");
//		pageProfilsListe.verifAjoutProfil(driver,"Nom du profil");
		
		//CLIQUER SUR L'ICÔNE "MODIFIER"
		pageProfilsListe.cliquerModifNomDuProfil(driver);
		
		//VERIFIER LE TITRE DE LA PAGE "MODIFIER PROFIL"
		pageCreer_ModifierProfil.verifTitreCreerModifProfil("Modifier Profil: Nom du profil");
		
		//VERIFIER QU'IL N'Y A AUCUN RÔLE D'ATTRIBUER AU PROFIL
		pageCreer_ModifierProfil.verifTableauVide();
		
		//CHOISIR LE RÔLE "FEUILLE DE TEMPS" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Feuille");
				
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
				
		//CHOISIR LE RÔLE "CRITERE" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Critère");
				
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
				
		//CHOISIR LE RÔLE "CALENDRIER" DANS LE MENU DEROULANT
		pageCreer_ModifierProfil.selectionnerRole(driver, "Calendrier");
				
		//CLIQUER SUR LE BOUTON "AJOUTER UN RÔLE"
		pageCreer_ModifierProfil.cliquerAjouterRole();
		
		//VERIFIER L'AJOUT DES RÔLES "FEUILLE DE TEMPS", "CALENDRIER" ET "CRITERE"
		pageCreer_ModifierProfil.verifAjout3roles();
		
		//MODIFIER LE NOM DU PROFIL
		pageCreer_ModifierProfil.saisirNomProfil("Utilisateur test");
		
		//CLIQUER SUR LE BOUTON "ENREGISTRER"
		pageCreer_ModifierProfil.clicEnregister(driver);
		
		//VERIFIER LE TITRE DE LA PAGE "PROFILS LISTE"
		pageProfilsListe.verifTitreProfilsListe();
		
		//VERIFIER LE MESSAGE DE CONFIRMATION D'ENREGISTREMENT
		pageProfilsListe.verifMsgConfirmation("Utilisateur test");
				
		//VERIFIER L'AJOUT DU PROFIL
		pageProfilsListe.verifAjoutUtilisateurTest("Utilisateur test");
		
		//SUPPRIMER LES PROFILS CREES
		pageProfilsListe.supprProfilsCrees(driver, "Nom du profil");
		pageProfilsListe.supprProfilsCrees(driver, "Utilisateur test");
	}
	
}
