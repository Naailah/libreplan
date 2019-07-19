package GR4.LibrePlan4;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;

public class Test_GUP_01 extends Test_connexion {

	
	
	
	@Test
	public void gestionDUnProfil() {
		PageProfilsListe pageProfilsListe = PageFactory.initElements(driver, PageProfilsListe.class);
		pageProfilsListe.mouseoverConfiguration(driver);
	}
	
}
