package GR4.LibrePlan4;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageCreerProfil;
import Configuration.PageProfilsListe;

public class Test_GUP_01 extends Test_connexion {

	
	
	
	@Test
	public void gestionDUnProfil() {
		
		//ACCEDER A LA PAGE PROFILS LISTE
		PageProfilsListe pageProfilsListe = PageFactory.initElements(driver, PageProfilsListe.class);
		pageProfilsListe.mouseoverConfiguration(driver);
//		driver.get("http://localhost:8090/libreplan/profiles/profiles.zul");
		
		//INSERER UN PROFIL EN BASE DE DONNEES
		
		//VERIFIER LA PRESENCE DE LA COLONNE "NOM DE PROFIL"
		pageProfilsListe.verifColonneNom();
		
		//VERIFIER LA PRESENCE DE LA COLONNE "ACTION"
		pageProfilsListe.verifColonneActions();
		
		//VERIFIER LA PRESENCE DES ICONES "MODIFIER" ET "SUPPRIMER"
		
		//VERIFIER LA PRESENCE DU BOUTON "CREER"
		pageProfilsListe.verifBoutonCreer();
		
		//CLIQUER SUR LE BOUTON "CREER"
		PageCreerProfil pageCreerProfil = pageProfilsListe.cliquerBoutonCreer(driver);
		
	}
	
}
