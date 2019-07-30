package GR4.LibrePlan4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;


public abstract class Test_connexion {
	
	protected static WebDriver driver;
	String b ="chrome";
	String url ="http://localhost:8090/libreplan";
	PageAccueil page_accueil;
	
	@Before
	public void setUp() {
		driver = Outils.choisirNavigateur(b);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageConnexion pageConnexion = PageFactory.initElements(driver, PageConnexion.class);
		driver.get(url);
		pageConnexion.seConnecter(driver, "admin", "admin");
	}

	
}
