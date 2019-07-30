package GR4.LibrePlan4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configuration.PageProfilsListe;
import Couts.PageTypesHeures;
import Projet.PageNewProject;
import Ressources.PageListedecalendriers;
import Ressources.PageMachine;

public abstract class PageBandeau {
	
	@FindBy(xpath="//button[contains(.,'Calendrier')]")
	private WebElement onglet_calendrier;
	
/*	@FindBy(xpath="//button[contains(.,'Ressources')]")
	private WebElement onglet_ressources;
	
	@FindBy(xpath="//button[contains(.,'Coûts')]")
	private WebElement onglet_couts;
	
	@FindBy(xpath="//td[@class='migas_linea']")
	private WebElement fil_arianne;*/
	
	@FindBy(xpath="//a[contains(@href.,'company_s')]")
	private WebElement vue_compagnie;
	
	@FindBy (xpath="//button[substring(@id,5)='81-b'][@class='z-menu-btn']")
	private WebElement bouton_configuration;
	
//	@FindBy (xpath="//a[substring(@id,5)='c1-a']")
//	private WebElement lien_profils;
	
	@FindBy (xpath="//a[contains(@href,'profiles.zul')]")
	private WebElement lien_profils;
	
	
	// XPath de l'onglet "Ressources"
	@FindBy(xpath = "//button[substring(@id,5)='r-b'][@class='z-menu-btn']")
	private WebElement bouton_ressources;
	
	// XPath du lien "Calendriers" dans l'onglet "Ressources"
	@FindBy(xpath = "//a[contains(@href,'calendars.zul')]")
	private WebElement lien_calendriers;
	
	// XPath de l'onglet "Coûts"
	@FindBy (xpath="//button[contains(@id,'0-b')][@class='z-menu-btn']")
	private WebElement bouton_couts;
	
	// XPath du lien "Types d'heures" dans l'onglet "Coûts"
	@FindBy (xpath="//a[contains(@href,'typeofworkhours')]")
	private WebElement lien_types_heures;
	
	
	/**
	 * Permet de faire un mouseover sur l'onglet "Configuration"
	 * @param driver
	 */
	public PageProfilsListe mouseoverConfiguration(WebDriver driver) {
		Actions moConfig = new Actions(driver);
		moConfig.moveToElement(bouton_configuration).build().perform();
		lien_profils.click();
		return PageFactory.initElements(driver, PageProfilsListe.class);
	}
	
	//aller sur l'onglet couts/types d'heures
	public PageTypesHeures mouseoverCoutsTypes(WebDriver driver) {
		Actions moCouts = new Actions(driver);
		moCouts.moveToElement(bouton_couts).build().perform();
		lien_types_heures.click();
		return PageFactory.initElements(driver, PageTypesHeures.class);
	}
	
	
	// Méthode de cliquer sur "Ressources"
	public PageListedecalendriers mouseoverRessources(WebDriver driver) {
        Actions moRessources = new Actions(driver);
        moRessources.moveToElement(bouton_ressources).build().perform();
        lien_calendriers.click();    
        return PageFactory.initElements(driver, PageListedecalendriers.class);
    }
	
	

		
	public PageAccueil goPageAccueil(WebDriver driver) {
		//driver.switchTo().frame(0);
		Actions compagnie = new Actions(driver);
		compagnie.moveToElement(onglet_calendrier).build().perform();	
		//driver.switchTo().defaultContent();
		vue_compagnie.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	public void syso() {
		System.out.println("test");
	}
	
	/*public PageRessources clickPageRessources(WebDriver driver) {
		onglet_ressources.click();
		return PageFactory.initElements(driver, PageAccueil.class);
	}*/
	
	// Créer un nouveau projet
	public PageNewProject addProject(WebDriver driver) {
		Actions mo= new Actions(driver);
		mo.moveToElement(driver.findElement(By.xpath("//table[@style='width:100%;height:30px;']//img"))).click().build().perform();
		
		return  PageFactory.initElements(driver, PageNewProject.class);
		
	}
	
	
	//Créer une machine
	public PageMachine addMachine(WebDriver driver) {
		Outils.clickMenu(driver, "Ressources", "Machines");
		
		return  PageFactory.initElements(driver, PageMachine.class);
		
	}
}
