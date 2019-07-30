package Ressources;
import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GR4.LibrePlan4.Outils;

public class PageMachine {

	@FindBy (xpath="//td[.='Filtre'][@class='z-button-cm']")
	private WebElement button_filtre;
	
	
	@FindBy (xpath="//div[@class='clickable-rows z-grid']//following-sibling::span[@class=\"create-button global-action z-button\"]/table/tbody/tr/td[.='Créer'][@class='z-button-cm']")
	private WebElement button_creer;
	

	@FindBy(xpath = "//input[@type='checkbox']//following-sibling::label[.='Générer le code']")
	private List<WebElement> checkbox_generer;
	
	
	@FindBy(xpath = "//input[@style='width:350px;']")
	private WebElement field_code;
	
	@FindBy(xpath = "//input[@style='width:500px;'][@class='focus-element z-textbox']")
	private WebElement field_nom;
	
	@FindBy(xpath = "//input[@style='width:500px;'][@class='z-textbox']")
	private WebElement field_description;
	
	
	@FindBy(xpath = "//td[.='Sauver et continuer']")
	private WebElement button_save;
	
	
	@FindBy(xpath = "//span[.='Machine \"MACHINETEST1\" enregistré']")
	private WebElement message_success;
	
	
	@FindBy(xpath = "//table[@style='width:100%;height:100%']/tbody/tr/td[.='Annuler']")
	private List<WebElement> buttons_annuler;

	
	public void verifierFiltre() {
		assertTrue(button_filtre.isDisplayed());
	}
	
	public void cliquerCreer() {
		button_creer.click();
	
	}
	
	public void decocherGenerer() {
		checkbox_generer.get(0).click();
	}
	
	public void renseignerCode(String code) {
		Outils.renseignerChamp(field_code, code);
	}
	
	public void renseignerNom(String nom) {
		Outils.renseignerChamp(field_nom, nom);
	}
	
	public void renseignerDesc(String desc) {
		Outils.renseignerChamp(field_description, desc);
	}
	
	
	public void clickSave() {
		button_save.click();
	}
	
	public void checkMessage() {
		assertTrue(message_success.isDisplayed());
	}
	
	public void clickAnnuler() {
		buttons_annuler.get(1).click();
	}
}
