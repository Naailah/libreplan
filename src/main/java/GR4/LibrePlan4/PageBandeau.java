package GR4.LibrePlan4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBandeau {
	
	@FindBy(id="//button[contains(.,'Calendrier')]")
	private WebElement onglet_calendrier;
	
	@FindBy(id="//button[contains(.,'Ressources')]")
	private WebElement onglet_ressources;
	
	@FindBy(id="//button[contains(.,'Coûts')]")
	private WebElement onglet_couts;
	
	@FindBy(xpath="//td[@class='migas_linea']")
	private WebElement fil_arianne;
	
	public PageAccueil clickPageAccueil(WebDriver driver) {
		onglet_calendrier.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	/*public PageRessources clickPageRessources(WebDriver driver) {
		onglet_ressources.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}*/
}
