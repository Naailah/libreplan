package Couts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import GR4.LibrePlan4.Outils;

import static org.junit.Assert.*;

public class PageTypesHeures {


	@FindBy (xpath="//button[contains(@id,'0-b')][@class='z-menu-btn']")
	private WebElement bouton_couts;
	
	@FindBy (xpath="//a[contains(@href,'typeofworkhours')]")
	private WebElement lien_types_heures;
	
	@FindBy(xpath="//div[contains(@class,'clickable')]/descendant::table[1]//th[not(contains(@id,'faker'))]")
	private List<WebElement> tableau_type_heure;
	
	@FindBy(xpath="//table[substring(@id,5)='25-box']")
	private WebElement bouton_creer_types_heures;
	
	public PageTypesHeures() {	
		
	}

	public void mouseoverCouts(WebDriver driver) {
		Actions moCouts = new Actions(driver);
		moCouts.moveToElement(bouton_couts).build().perform();
//		driver.switchTo().frame(iframe_config);
		lien_types_heures.click();
		String listeColonnesAttendu =" Code Nom de type Prix par défaut Activé Actions";
		Outils.verifTableau(listeColonnesAttendu, tableau_type_heure);
//		String listeColonnesReel = new String();
//		for(WebElement colonne : tableau_type_heure) {
//			listeColonnesReel = listeColonnesReel+colonne.getText();
//		}
//		System.out.println(listeColonnesReel);
//		assertEquals(listeColonnesAttendu, listeColonnesReel);
	}
	public void clickBoutonCreer(WebDriver driver) {
		bouton_creer_types_heures.click();
	}
}
