package Projet;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;
import GR4.LibrePlan4.Outils;
import Ressources.PageListedecalendriers;

public class PageNewProject {
	
	
	@FindBy(xpath = "//div[@class='z-window-modal-cnt-noborder']/descendant::table[2]//tr[not(contains(@id,'faker'))][contains(@class,'z-row')]")
	private List<WebElement> liste_nom_form;

<<<<<<< HEAD
	@FindBy(xpath = "//div[substring(@id,5)='z4-cell']/input")
	private WebElement field_nom2;
	
	@FindBy(xpath = "//input[substring(@id,5)='p7']")
=======
	@FindBy(xpath = "//input[@class='z-textbox z-textbox-text-invalid']")
>>>>>>> d7bc929cbcdb984093a4da436bfaeb8c1716fd21
	private WebElement field_nom;

	@FindBy(xpath = "//input[substring(@id,5)='v7-real']")
	private WebElement field_modele;

	@FindBy(xpath = "//input[substring(@id,5)='38']")
	private WebElement field_code;

	@FindBy(xpath = "//div[substring(@id,5)='_8-cave']")
	private WebElement field_propositions;

	@FindBy(xpath = "//input[substring(@id,6)='9-real']")
	private WebElement field_date;

	@FindBy(xpath = "//input[substring(@id,5)='48-real']")
	private WebElement checkbox_generer;

	@FindBy(xpath = "//input[substring(@id,6)='9-real'][substring(@class,3)='datebox-inp']")
	private List<WebElement> liste_field_date;
	
	@FindBy(xpath = "//i[@class='z-datebox-btn']")
	private List<WebElement> liste_button_date;
	
	@FindBy(xpath = "//input[following-sibling::i[@class='z-datebox-btn']]")
	private List<WebElement> liste_champs_date;

	@FindBy(xpath = "//td[substring(@id,5)='2a-chdex']")
	private WebElement bouton_accepter;
	
	@FindBy (xpath="//td[@class='z-button-cm'][contains(.,'Accepter')]")
	private WebElement bouton_accepter2;
	
	@FindBy (xpath="//span[contains(.,'WBS (tâches)')]")
	private WebElement page_WBS;

	
	
	public void checkForm() throws InterruptedException {

		// vérification des champs du formulaire
		String liste_form = " Nom Modèle Code\nGénérer le code Date de début Echéance Client Calendrier";
		Outils.verifTableau(liste_form, liste_nom_form);

		field_nom.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		// Présence du champ Nom
		assertTrue(field_nom.isDisplayed());

	

		// Présence du champ Modele
		assertTrue(field_modele.isDisplayed());

		// Présence du champ Code avec une valeur par défaut
		assertTrue(field_code.getAttribute("value").contains("ORDER"));

		// CheckBox générer code cochée
		assertTrue(checkbox_generer.isSelected());

		// Vérification de la date 
		Outils.isValidFormat(liste_field_date.get(0).getAttribute("value"));
		
	
	}
	
	public void renseignerNom(String nom) {
		// Renseigner le champ Nom
		Outils.renseignerChamp(field_nom, nom);
	}
	
	public void renseignerNom2(String nom) {
		// Renseigner le champ Nom
		Outils.renseignerChamp(field_nom2, nom);
	}
	public void cliquerAccepter() {
		bouton_accepter2.click();
	}
	public void renseignerCode(String code) {
		// Renseigner le champ Code
		Outils.renseignerChamp(field_code, code);
	}
	
	public void decocherCase() {
		// Décocher la case
		checkbox_generer.click();
	}
	
	public void changerDateDebut(int i) throws Exception {
		// Cliquer le 1er calendrier
		Outils.renseignerChamp(liste_champs_date.get(2),Outils.datePlus(i));
	
	}
	
	public void changerDateEcheance(int i) throws Exception {
		// Cliquer le 2eme calendrier
		Outils.renseignerChamp(liste_champs_date.get(3),Outils.datePlus(i));
	
	}
	

	
	public OngletWBS cliquerAccepter(WebDriver driver){
		// Cliquer surle bouton accepter
		bouton_accepter.click();
		return PageFactory.initElements(driver, OngletWBS.class);
	}
	
	
	
}
