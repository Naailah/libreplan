package Couts;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import GR4.LibrePlan4.Outils;

import static org.junit.Assert.*;

public class PageTypesHeures {


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
	
	public void mouseoverCouts(WebDriver driver) {
		//aller sur l'onglet couts/types d'heures
		Actions moCouts = new Actions(driver);
		moCouts.moveToElement(bouton_couts).build().perform();
		lien_types_heures.click();
		//verif titre de la page
		String titre = titre_types_heures.getText();
		assertEquals("Types d'heures Liste", titre);
		String listeColonnesAttendu =" Code Nom de type Prix par défaut Activé Actions";
		//verif tableau
		Outils.verifTableau(listeColonnesAttendu, tableau_type_heure);

	}
	public void clickBoutonCreer(WebDriver driver) throws InterruptedException {
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

	}
}
