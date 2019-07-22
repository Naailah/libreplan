package Projet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageProjet {

	@FindBy (xpath="//button[contains(.,'Calendrier')]")
	private WebElement bouton_calendrier;
	
	@FindBy (xpath="//a[contains(@href,'index.zul')]")
	private WebElement lien_projets;
	
	@FindBy (xpath="//table[@style='width:100%;height:30px;']")
	private WebElement button_add_project;
	

	
	
	

	public void mouseoverCalendrier_Projet(WebDriver driver) {
		Actions mo= new Actions(driver);
		mo.moveToElement(bouton_calendrier).build().perform();
		lien_projets.click();
		
	}
	
	public PageNewProject addProject(WebDriver driver) {
		Actions mo= new Actions(driver);
		mo.moveToElement(driver.findElement(By.xpath("//table[@style='width:100%;height:30px;']//img"))).click().build().perform();
		
		return  PageFactory.initElements(driver, PageNewProject.class);
		
	}
	
	
}