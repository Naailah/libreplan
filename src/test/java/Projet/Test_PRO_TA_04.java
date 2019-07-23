package Projet;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import GR4.LibrePlan4.Test_connexion;

public class Test_PRO_TA_04 extends Test_connexion {
	
	@Test
	public void afficherPlanningProjet() throws InterruptedException {
	PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
	page_projet.clicListeProjet(driver);
	PageNewProject page_new_project = page_projet.addProject(driver);
	page_new_project.renseignerNom("Projet1");
}
}
