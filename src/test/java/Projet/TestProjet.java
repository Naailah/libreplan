package Projet;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;
import GR4.LibrePlan4.Test_connexion;

public class TestProjet extends Test_connexion {
	
	@Test
	public void projet() {
		PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
		PageNewProject page_new_projet = page_projet.addProject(driver);
		page_new_projet.checkForm();
	}
	
}
