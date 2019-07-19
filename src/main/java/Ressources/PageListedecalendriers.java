package Ressources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageListedecalendriers {
	
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@id,'r-b')][@class='z-menu-btn']")
	private WebElement button_ressources;

	public void clickRessources() {
		Actions a = new Actions(driver);
		a.moveToElement(button_ressources).build().perform();
	}	
	
	

	@FindBy(xpath = "//table[contains(@id,'q4-box')]//td[@class='z-button-cm'][text()='Créer']")
	private WebElement button_creer_calendrier;
	
	public void clickCreerCalendrier() {
		button_creer_calendrier.click();
	}
	
	
	@FindBy(xpath = "//input[contains(@id,'Q45')][@style='width:300px;']")
	private WebElement champ_nom_calendrier;
	
	@FindBy(xpath = "//input[@type='checkbox'][contains(@id,'Qd5-real')]")
	private WebElement checkbox_nom_calendrier;
	
	@FindBy(xpath = "//td[@class='z-button-cm'][text()='Enregistrer']")
	private WebElement button_enregistrer_calendrier;
	
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']")
	private WebElement ligne_calendrier_test_1;
	
	



}
