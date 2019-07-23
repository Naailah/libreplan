package Ressources;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
	// XPath de l'icône "Créer une dérive" de Calendrier - Test 1.
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']/ancestor::tr/td/div/span/table/tbody/tr/td/img[@src='/libreplan/common/img/ico_derived1.png']")
	// @FindBy (xpath = "//tr[td/div/span[contains(.,'Calendrier - Test 1')]]//td//span[@src='/libreplan/common/img/ico_derived1.png']")
	private WebElement icone_creer_derive_1;
	
	
	// XPath de la ligne "Calendrier dérivé"
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test Calendrier Dérivé']")
	private WebElement ligne_calendrier_derive;
	
	
	// XPath du [-] pour le calendrier dérivé.
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']/preceding-sibling::span[substring(@id,7)='-open']")
	private WebElement bouton_replier_calendrier_derive;
	
	
	// XPath de l'icône "copier le calendrier 1".
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier - Test 1']/ancestor::tr/td/div/span/table/tbody/tr/td/img[@src='/libreplan/common/img/ico_copy1.png']")
	private WebElement icone_copier_calendrier_1;
	
	// XPath du message d'enregistrement du calendrier 2
	@FindBy(xpath = "//span[@class='z-label'][text()='Calendrier de base \"Calendrier - Test 2\" enregistré']")
	//tr[@class='z-treerow'][contains(@span,
	private WebElement message_succes_calendrier_2;
	
	// XPath du logo de la sous catégorie
	@FindBy(xpath = "//span[@class='z-dottree-line z-dottree-last']")
	private WebElement sousbranche_derive;
	
	// XPath du span pour le message de succès de la création du calendrier dérivé 1.
	@FindBy(xpath = "//div[@class='message_INFO'][contains(.,'Calendrier de base')]")
	private WebElement message_succes_creation_calendrier;
	
	
	@FindBy(xpath= "//span[@class='z-dottree-line z-dottree-last']")
	private List<WebElement> liste_souscategorie;

	
	
	// Méthode de compter le nombre de sous-catégories
	public void compterNombreSousCategories() {		
	int nbcategories = liste_souscategorie.size();
	System.out.println(nbcategories);
	assertTrue(nbcategories==1);
	}
	
	
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
	
	
	// Méthode pour cliquer sur l'icône" Créer une dérive" de "Calendrier - Test 1".
	public void clicCreerDerive1() {
		icone_creer_derive_1.click();
	}
	
	
	// Méthode pour vérifier que "calendrier dérivé" est affiché
	public void verificationAffichageCalendrierDerive() {
		assertTrue(ligne_calendrier_derive.isDisplayed());
	}
	
	
	// Méthode pour replier le calendrier dérivé.
	public void replierCalendrierDerive() {
		bouton_replier_calendrier_derive.click();
	}
	
	
	// Méthode pour vérifier que le calendrier dérivé n'est plus affiché.
	public void verificationNonAffichageCalendrierDerive() {
		assertFalse(ligne_calendrier_derive.isDisplayed());
	}
	
	
	// Méthode pour cliquer sur la copie du calendrier
	public void copierCalendrier1() {
		icone_copier_calendrier_1.click();
	}



	// Méthode de vérification de l'affichage du logo de sous catégorie.
	public void verificationSousCategorie() {
		sousbranche_derive.isDisplayed();
	}
	
	
	// Méthode de vérification du message de création du calendrier.
	public void verificationMessageSuccesCalendrier() {
		message_succes_creation_calendrier.isDisplayed();
		}
	
	
	// Méthode de vérification d'absence de logo de sous catégorie
	
	
}
