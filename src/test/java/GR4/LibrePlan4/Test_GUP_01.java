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
		
//		//CHOISIR UN RÔLE DANS LE MENU DEROULANT
//		pageCreerProfil.choisirRole("Lire tous les projets");
		pageCreerProfil.selectionnerRole(driver, "Lire");
	}
	
}
