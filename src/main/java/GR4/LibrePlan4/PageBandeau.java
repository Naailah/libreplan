package GR4.LibrePlan4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBandeau {
	
	@FindBy(xpath="//button[contains(.,'Calendrier')]")
	private WebElement onglet_calendrier;
	
	@FindBy(xpath="//button[contains(.,'Ressources')]")
	private WebElement onglet_ressources;
	
	@FindBy(xpath="//button[contains(.,'Coûts')]")
	private WebElement onglet_couts;
	
	@FindBy(xpath="//td[@class='migas_linea']")
	private WebElement fil_arianne;
	
	public PageAccueil goPageAccueil(WebDriver driver) {
		//driver.switchTo().frame(0);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(onglet_calendrier).build().perform();	
		//driver.switchTo().defaultContent();
		
		onglet_calendrier.click();
		onglet_calendrier.click();
		driver.findElement(By.xpath("//a/@href[contains(.,'company_s')]")).click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	/*public PageRessources clickPageRessources(WebDriver driver) {
		onglet_ressources.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}*/
}
