package GR4.LibrePlan4;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;
import Couts.PageTypesHeures;

public class Test_GCO_01 extends Test_connexion {

	
	
	
	@Test
	public void creerUnTypeDHeure() {
		PageTypesHeures page_types_heures = PageFactory.initElements(driver, PageTypesHeures.class);
		page_types_heures.mouseoverCouts(driver);
		
	}
}
