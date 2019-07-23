package Projet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Couts.PageTypesHeures;
import GR4.LibrePlan4.PageBandeau;


public class PageProjet extends  PageBandeau{

	@FindBy (xpath="//button[contains(.,'Calendrier')]")
	private WebElement bouton_calendrier;
	
	@FindBy (xpath="//a[contains(@href,'index.zul')]")
	private WebElement lien_projets;
	
	@FindBy (xpath="//table[@style='width:100%;height:30px;']")
	private WebElement button_add_project;
	
	@FindBy (xpath="//table[substring(@id,5)='h4-box']")
	private WebElement bouton_liste_projets;
	
	//Accéder à la liste des projets
		public void clicListeProjet(WebDriver driver) {
			bouton_liste_projets.click();
		}
}
