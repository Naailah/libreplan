package Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageProfilsListe {

	@FindBy (xpath="//button[contains(@id,'81-b')][@class='z-menu-btn']")
	private WebElement bouton_configuration;
	
	@FindBy (xpath="")
	private WebElement iframe_config;
	
	@FindBy (xpath="//div[contains(@id,'Q91')]//a[contains(@id,'Qc1-a')]")
	private WebElement lien_profils;
	
	
	
	public PageProfilsListe() {	
		
	}

	public void mouseoverConfiguration(WebDriver driver) {
		Actions moConfig = new Actions(driver);
		moConfig.moveToElement(bouton_configuration).build().perform();
//		driver.switchTo().frame(iframe_config);
		lien_profils.click();
		

		
	}
	


}
