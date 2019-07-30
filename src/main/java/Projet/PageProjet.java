package Projet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GR4.LibrePlan4.Outils;
import GR4.LibrePlan4.PageBandeau;
import static org.junit.Assert.*;

public class PageProjet extends  PageBandeau{

	@FindBy (xpath="//button[contains(.,'Calendrier')]")
	private WebElement bouton_calendrier;
	
	@FindBy (xpath="//a[contains(@href,'/libreplan/planner/index.zul;orders_list')]")
	private WebElement lien_projets;
	
	@FindBy (xpath="//table[@style='width:100%;height:30px;']")
	private WebElement button_add_project;
	
	@FindBy (xpath="//table[substring(@id,5)='h4-box']")
	private WebElement bouton_liste_projets;
	
	@FindBy (xpath="//td[.='Planification de projet'][@align='left']")
	private WebElement bouton_planif_projets;
	
	@FindBy (xpath="//option[.='Trimestre']")
	private WebElement option_trimestre;
	
	@FindBy (xpath="//option[.='Mois']")
	private WebElement option_mois;
	
	@FindBy (xpath="//select[not(.='')]")
	private WebElement options;
	
	@FindBy (xpath="//td[contains(.,'janv.')]")
			private List<WebElement> liste_janvier;
	
	
	//Accéder à la liste des projets
		public void clicListeProjet(WebDriver driver) {
			bouton_liste_projets.click();
		}
	
	//Cliquer sur le bouton de planification des projets
		public void clicPlanifProjet(WebDriver driver) {
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(bouton_planif_projets);
			actions2.click();
			actions2.build().perform();
			//bouton_planif_projets.click();
		}
	@FindBy(xpath = "//table[substring(@id,5)='r3']//td[not(null)][@class='z-button-cm']")
	private List<WebElement> liste_menus;
	
	
	

	public PageListeProjets mouseoverCalendrier_Projet(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		Outils.clickMenu(driver,"Calendrier","Projet");
		return PageFactory.initElements(driver, PageListeProjets.class); 
	}
	
	
	public void verifierMenuVertical() {
		String menu = "Planification de projet";
		assertEquals(menu, liste_menus.get(0).getText());

	}
	
	public void choisirOptionTrimestre() {
		options.click();
		option_trimestre.click();
	}
	
	public void choisirOptionMois() {
		options.click();
		option_mois.click();
		String planning =" 2018,H1\n2018,H2\n2019,H1\n2019,H2\n2020,H1\njanv. févr. mars avr. mai juin juil. août sept. oct. nov. déc. janv. févr. mars avr. mai juin juil. août sept. oct. nov. déc. janv. févr. mars avr. mai juin janv. févr. mars avr. mai juin juil. août sept. oct. nov. déc. janv. févr. mars avr. mai juin juil. août sept. oct. nov. déc. janv. févr. mars avr. mai juin janv. janv. janv.     ";
		Outils.verifTableau(planning, liste_janvier);
	}
	
	
}