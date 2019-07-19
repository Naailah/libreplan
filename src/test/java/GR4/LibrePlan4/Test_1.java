package GR4.LibrePlan4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Test_1 extends Test_connexion {
	
@Test
public void clickAccueil() {
	PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
	//page_accueil.syso();
	page_accueil.goPageAccueil(driver);
	
}

}
