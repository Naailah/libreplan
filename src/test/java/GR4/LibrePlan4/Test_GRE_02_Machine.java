package GR4.LibrePlan4;
import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Projet.PageNewProject;
import Projet.PageProjet;
import Ressources.PageMachine;

public class Test_GRE_02_Machine extends Test_connexion  {

	@Test
	public void creationMachine() throws Exception {
	PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
	PageMachine page_machine = page_projet.addMachine(driver);
	page_machine.verifierFiltre();
	page_machine.cliquerCreer();
	page_machine.decocherGenerer();
	page_machine.renseignerCode("MACHINETEST1");
	page_machine.renseignerNom("MACHINETEST1");
	page_machine.renseignerDesc("MACHINETEST1");
	page_machine.clickSave();
	page_machine.checkMessage();
	page_machine.clickAnnuler();
	}
}
