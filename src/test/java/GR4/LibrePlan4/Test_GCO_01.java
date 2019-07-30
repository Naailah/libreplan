package GR4.LibrePlan4;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;
import Couts.PageCategorieCouts;
import Couts.PageTypesHeures;
import Projet.PageProjet;

public class Test_GCO_01 extends Test_connexion {

	
	
	
	@Test
	public void creerUnTypeDHeure() throws InterruptedException {
		PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
		PageTypesHeures page_types_heures = page_projet.mouseoverCoutsTypes(driver);
		page_types_heures.verifTitre();
		page_types_heures.creerTypeHeure(driver);
		PageCategorieCouts page_categorie_couts = page_types_heures.mouseoverCoutsCategorie(driver);
		page_categorie_couts.verifierTitrePageCategorieCouts();
		page_categorie_couts.creerCategorieCouts();
	}
}
