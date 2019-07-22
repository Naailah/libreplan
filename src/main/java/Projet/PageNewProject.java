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
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;
import GR4.LibrePlan4.Outils;

public class PageNewProject {
	@FindBy(xpath = "//div[@class='z-window-modal-cnt-noborder']/descendant::table[2]//tr[not(contains(@id,'faker'))][contains(@class,'z-row')]")
	private List<WebElement> liste_nom_form;

	@FindBy(xpath = "//input[substring(@id,5)='p7']")
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

	public void checkForm() {

		// vérification des champs du formulaire
		String liste_form = " Nom Modèle Code\nGénérer le code Date de début Echéance Client Calendrier";
		Outils.verifTableau(liste_form, liste_nom_form);

		field_nom.sendKeys(Keys.chord(Keys.CONTROL, "a"));

		// Présence du champ Nom
		assertTrue(field_nom.isDisplayed());

		// Renseigner le champ Nom
		Outils.renseignerChamp(field_nom, "PROJET_TEST1");

		// Présence du champ Modele
		assertTrue(field_modele.isDisplayed());

		// Présence du champ Code avec une valeur par défaut
		assertTrue(field_code.getAttribute("value").contains("ORDER00"));

		// CheckBox générer code cochée
		assertTrue(checkbox_generer.isSelected());

		//Vérification de la date 
		
		Outils.isValidFormat(liste_field_date.get(0).getAttribute("value"));

	}

	
}