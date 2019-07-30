package Projet;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GR4.LibrePlan4.Outils;

import static org.junit.Assert.*;

public class PageListeProjets {
	
	@FindBy(xpath = "//tr[@class='clickable-rows projects-list z-row']/td")
	private List<WebElement> liste_details_projet;
	
	@FindBy(xpath = "//span[@title='Modifier']//img")
	private WebElement bouton_modifier;
	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']")
	private WebElement bouton_supp;
	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_planificador1.png']")
	private WebElement bouton_prev;
	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_derived1.png']")
	private WebElement bouton_modele;
	
	public void verifierProjet(String projet) {
		assertEquals(projet,liste_details_projet.get(0).getText());
	}
	
	public void verifierDetailsProjet(String details) {
		Outils.verifTableau(details, liste_details_projet);
	}
	
	public void verifierIcones()
	{
		assertTrue(bouton_modifier.isDisplayed());
		assertTrue(bouton_supp.isDisplayed());
		assertTrue(bouton_prev.isDisplayed());
		assertTrue(bouton_modele.isDisplayed());
	}
	
	
}
