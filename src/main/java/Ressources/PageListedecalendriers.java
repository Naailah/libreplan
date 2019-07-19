package Ressources;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;


import GR4.LibrePlan4.Outils;

public class PageListedecalendriers {
	
	WebDriver driver;
	
	
	
	// XPath du titre "Liste de calendriers"
	@FindBy(xpath="//div[substring(@id,5)='j4-cap'][text()='Liste de calendriers']")
	private WebElement titre_Liste_de_calendriers;
	
	
	// Liste des noms de colonnes
	@FindBy(xpath = "//div[contains(@class,'dottree')]/table//th[not(contains(@id,'faker'))]")
	private List<WebElement> liste_noms_colonnes_calendrier;
	
	
	// XPath du bouton "Créer un calendrier"
	@FindBy(xpath = "//table[contains(@id,'q4-box')]//td[@class='z-button-cm'][text()='Créer']")
	private WebElement bouton_creer_calendrier;
	
	
	// XPath de la ligne de création de "Calendrier Test 1"
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']")
	private WebElement ligne_calendrier_test_1;
	
	
	// XPath de l'icone "Créer une dérivé" pour "Calendrier Test 1"
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']/following::table[contains(@id,'8-box')][@style='width:100%;height:100%']")
	private WebElement icone_creer_une_derive;


	
	
	// Méthode de vérification du titre "Liste de calendriers"
	public void verificationTitreListeDeCalendriers() {
		Outils.verificationTextWebElement("Liste de calendriers", titre_Liste_de_calendriers);
	}
	
	
	// Méthode de vérification des noms de colonne à partir de Outils.
	public void verificationNomsColonnesCalendrier() {
		Outils.verifTableau(" Nom Hérité de la date Héritages à jour Opérations", liste_noms_colonnes_calendrier);
	}
	
	
	// Méthode de vérification de la présence du bouton "Créer" un calendrier.
	public void verificationBoutonCreerCalendrier() {
		Outils.verificationTextWebElement("Créer", bouton_creer_calendrier);
	}
	
	// Méthode de cliquer sur le bouton "Créer un calendrier"
	public void clicCreerCalendrier() {
		bouton_creer_calendrier.click();
	}
	
	
	// Instanciation de la page "Créer Calendrier" à partir de "Liste de calendriers".
	
	public PageCreerCalendrier creerUnCalendrier(WebDriver driver) {
		bouton_creer_calendrier.click();
		return PageFactory.initElements(driver, PageCreerCalendrier.class);
	}

	
	// Méthode de vérification de la ligne "Calendrier - Test 1".
	public void verificationLigneCalendrierTest1() {
		Outils.verificationTextWebElement("Calendrier - Test 1", ligne_calendrier_test_1);
	}


}
