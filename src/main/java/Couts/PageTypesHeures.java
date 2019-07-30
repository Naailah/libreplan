package Couts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GR4.LibrePlan4.Outils;
import GR4.LibrePlan4.PageBandeau;

import static org.junit.Assert.*;

public class PageTypesHeures extends PageBandeau{


	@FindBy (xpath="//button[contains(@id,'0-b')][@class='z-menu-btn']")
	private WebElement bouton_couts;
	
	@FindBy (xpath="//a[contains(@href,'typeofworkhours')]")
	private WebElement lien_types_heures;
	
	@FindBy(xpath="//div[substring(@id,5)='j4-cap']")
	private WebElement titre_types_heures;
	
	@FindBy(xpath="//div[contains(@class,'clickable')]/descendant::table[1]//th[not(contains(@id,'faker'))]")
	private List<WebElement> tableau_type_heure;
	
	@FindBy(xpath="//table[substring(@id,5)='25-box']")
	private WebElement bouton_creer_types_heures;
	
	@FindBy(xpath="//td[substring(@id,5)='45-cnt']")
	private WebElement titre_creer_types_heures;
	
	@FindBy(xpath="//input[substring(@id,5)='i5']")
	private WebElement champ_code;
	
	@FindBy(xpath="//input[substring(@id,5)='m5']")
	private WebElement champ_nom;
	
	@FindBy(xpath="//div[substring(@id,5)='75-hm']/span")
	private WebElement titre_onglet;
	
	@FindBy(xpath="//input[substring(@id,5)='p5']")
	private WebElement champ_prix;
	
	@FindBy (xpath="//input[substring(@id,5)='j5-real']")
	private WebElement case_a_cocher_code;
	
	@FindBy (xpath="//input[substring(@id,5)='j5-real']/following-sibling::label")
	private WebElement label_case_a_cocher_code;
	
	@FindBy (xpath="//input[substring(@id,5)='s5-real']")
	private WebElement case_a_cocher_activite;
	
	@FindBy (xpath="//table[substring(@id,5)='t5-box']//tr[2]/td[2]")
	private WebElement bouton_enregistrer;

	@FindBy (xpath="//table[substring(@id,5)='u5-box']//tr[2]/td[2]")
	private WebElement bouton_sauver_et_continuer;

	@FindBy (xpath="//table[substring(@id,5)='v5-box']//tr[2]/td[2]")
	private WebElement bouton_annuler;
	
	@FindBy (xpath="//div[@class='z-errbox-center']")
	private WebElement msg_erreur;
	
	@FindBy (xpath="//div[@class='z-errbox-center']/../../../..")
	private WebElement msg_erreur_couleur;
	
	@FindBy (xpath="//div[@class='z-errbox-left z-arrow-l']")
	private WebElement fleche_erreur;
	
	@FindBy (xpath="//div[@class='z-errbox-right z-errbox-close']")
	private WebElement croix_erreur;	
	
	@FindBy (xpath="//div[substring(@id,5)='y3-cave']")
	private WebElement background;
	
	@FindBy (xpath="//div[substring(@id,5)='t4']")
	private WebElement message_validation;
	
	@FindBy (xpath="//div[substring(@id,5)='t4']/span")
	private WebElement message_validation_texte;
	
	@FindBy (xpath="//tr[substring(@id,5)='w4']/td[1]/div/span")
	private WebElement tableau_case_1;
	
	@FindBy (xpath="//tr[substring(@id,5)='w4']/td[2]/div/span")
	private WebElement tableau_case_2;
	
	@FindBy (xpath="//tr[substring(@id,5)='w4']/td[3]/div//span")
	private WebElement tableau_case_3;
	
	@FindBy (xpath="//span[substring(@id,5)='h6']")
	private WebElement prix;
	
	@FindBy (xpath="//td[substring(@id,5)='45-cnt']")
	private WebElement titre_modifier_type_heures;

	@FindBy (xpath="//span[substring(@id,5)='56']")
	private WebElement nom_type;
	
	@FindBy (xpath="//span[contains(.,'azerty')]")
	private WebElement code;
	
	@FindBy (xpath="//a[contains(@href,'costcategories')]")
	private WebElement lien_categories_couts;
	
	public void verifTitre() {
//		//aller sur l'onglet couts/types d'heures
//		Actions moCouts = new Actions(driver);
//		moCouts.moveToElement(bouton_couts).build().perform();
//		lien_types_heures.click();
		//verif titre de la page
		String titre = titre_types_heures.getText();
		assertEquals("Types d'heures Liste", titre);
		String listeColonnesAttendu =" Code Nom de type Prix par défaut Activé Actions";
		//verif tableau
		Outils.verifTableau(listeColonnesAttendu, tableau_type_heure);

	}
	public void creerTypeHeure(WebDriver driver) throws InterruptedException {
		//clic bouton creer
		bouton_creer_types_heures.click();
		Thread.sleep(1000);
		//verif titre page
		String titre2 = titre_creer_types_heures.getText();
		System.out.println(titre2);
		assertEquals("Créer Type d'heures", titre2);
		//verif champs de saisie
		assertTrue(champ_nom.isDisplayed());
		assertTrue(champ_nom.getText().isEmpty());
		assertTrue(champ_prix.isDisplayed());
		assertTrue(champ_prix.getText().isEmpty());
		assertEquals("true", champ_code.getAttribute("disabled"));
		//assertFalse(champ_code.getText().isEmpty()); -->ne marche pas
		//verif checkboxes
		assertTrue(case_a_cocher_code.isDisplayed());
		assertTrue(case_a_cocher_code.isSelected());
		String label = label_case_a_cocher_code.getText();
		assertEquals("Générer le code", label);
		assertTrue(case_a_cocher_activite.isDisplayed());
		assertTrue(case_a_cocher_activite.isSelected());
		//verifs boutons
		assertTrue(bouton_enregistrer.isDisplayed());
		assertTrue(bouton_sauver_et_continuer.isDisplayed());
		assertTrue(bouton_annuler.isDisplayed());
		//creer type d'heure --> prix incorrect
		Outils.renseignerChamp(champ_nom, "Prix 1");
		Outils.copierColler(champ_nom, champ_prix);
		bouton_enregistrer.click();
		//verif message erreur
		Thread.sleep(1000);
		assertTrue(msg_erreur.isDisplayed());
		String message = msg_erreur.getText();
		assertEquals("Vous devez spécifier un nombre au lieu de Prix 1.", message);
		assertTrue(fleche_erreur.isDisplayed());
		assertTrue(croix_erreur.isDisplayed());
		//verif couleur message d'erreur
		Outils.verifierCouleur(msg_erreur_couleur, "#fdf2e7");
		//saisie "150" dans le champ prix
		Outils.renseignerChamp(champ_prix, "150");
		//contournement anno apparition "€"
		background.click();
		//verification apparition symbole €
		String valeur = champ_prix.getAttribute("value");
		System.out.println(valeur);
		assertEquals("150 €", valeur);
		//générer msg erreur code incorrect 
		case_a_cocher_code.click();
		Thread.sleep(1000);
		champ_code.clear();
		bouton_enregistrer.click();
		//verif couleur message d'erreur
	//	WebElement msg_erreur_couleur1 = driver.findElement(By.xpath("//div[@class='z-errbox-center']/../../../.."));
		//Outils.verifierCouleur(msg_erreur_couleur, "#fdf2e7");
		//verif message erreur
		Thread.sleep(1000);
		assertTrue(msg_erreur.isDisplayed());
		String message2 = msg_erreur.getText();
		System.out.println(message2);
		//message -> "ne peut PAS être vide", et non "ne peut être vide"
		assertEquals("ne peut pas être vide", message2);
		Thread.sleep(1000);
		assertTrue(fleche_erreur.isDisplayed());
		assertTrue(croix_erreur.isDisplayed());
		//saisie champ code
		Outils.renseignerChamp(champ_code, "azerty");
		bouton_enregistrer.click();
		//verif titre de la page
		Thread.sleep(1000);
		String titre = titre_types_heures.getText();
		assertEquals("Types d'heures Liste", titre);
		//verif message validation
		assertTrue(message_validation.isDisplayed());
		String message_val = message_validation_texte.getText();
		System.out.println(message_val);
		assertEquals("Type d'heures \"Prix 1\" enregistré", message_val);
		//verif couleur message validation
		Outils.verifierCouleur(message_validation, "#cceecc");
		//creation liste pour verif tableau
		List<WebElement>liste_tableau = new ArrayList<>();
		liste_tableau.add(tableau_case_1);
		liste_tableau.add(tableau_case_2);
		liste_tableau.add(tableau_case_3);
		//accès à la page de modification via colonne "Prix par défaut"
		prix.click();
		//vérifier le titre de la page
		Thread.sleep(1000);
		String titre3 = titre_modifier_type_heures.getText();
		assertEquals("Modifier Type d'heures: Prix 1", titre3);
		//cliquer sur bouton annuler
		bouton_annuler.click();
		//vérifier le titre de la page
		Thread.sleep(1000);
		assertEquals("Types d'heures Liste", titre);
		//Modifier un type d'heure - accès à la page de modification via colonne "Nom de type"
		nom_type.click();
		//vérifier le titre de la page
		Thread.sleep(1000);
		assertEquals("Modifier Type d'heures: Prix 1", titre3);
		//cliquer sur bouton annuler
		bouton_annuler.click();
		//vérifier le titre de la page
		assertEquals("Types d'heures Liste", titre);
		//Modifier un type d'heure - accès à la page de modification via colonne "Code"
		Thread.sleep(1000);
		code.click();
		//vérifier le titre de la page
		Thread.sleep(1000);
		assertEquals("Modifier Type d'heures: Prix 1", titre3);
		//Modifier un type d'heure - désactivé le type
		case_a_cocher_activite.click();
		bouton_enregistrer.click();
		// /!\ aucun message d'erreur n'est renvoyé --> pb ds le code ? pb de MaJ du CdT?
		
	}
	
	public PageCategorieCouts mouseoverCoutsCategorie(WebDriver driver) throws InterruptedException {
		//aller sur l'onglet couts/categories de couts
		Actions moCouts = new Actions(driver);
		moCouts.moveToElement(bouton_couts).build().perform();
//		Thread.sleep(1000);
		lien_categories_couts.click();
		return PageFactory.initElements(driver, PageCategorieCouts.class);
	}
}
