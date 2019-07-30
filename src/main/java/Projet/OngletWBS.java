package Projet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GR4.LibrePlan4.Outils;

public class OngletWBS {

	@FindBy(xpath = "//td[.='Détail du projet'][@class='z-button-cm']")
	private WebElement bouton_detail_projet;

	@FindBy(xpath = "//span[.='WBS (tâches)'][@class='z-tab-text']")
	private WebElement onglet_WBS;

	@FindBy(xpath = "//div[substring(@id,6)='c-hm']/span[@class='z-tab-text']")
	private List<WebElement> liste_onglets;

	@FindBy(xpath = "//table[substring(@id,5)='r3']//td[not(null)][@class='z-button-cm']")
	private List<WebElement> liste_menus;

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_save.png']")
	private WebElement bouton_save;

	@FindBy(xpath = "//span[@class='planner-icon z-button'][@title='Enregistrer le projet']")
	private WebElement info_bulle_save;

	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_back.png']")
	private WebElement bouton_annuler;

	@FindBy(xpath = "//span[@class='planner-icon z-button'][@title=\"Annuler l'édition\"]")
	private WebElement info_bulle_annuler;

	
	@FindBy(xpath = "//div[@class='z-messagebox']/span")
	private WebElement popup_text;
	
	@FindBy(xpath = "//span[@class='z-messagebox-btn z-button']//td[.='OK'][@class='z-button-cm']")
	private WebElement bouton_ok_popup;
	
	@FindBy(xpath = "//span[@class='z-messagebox-btn z-button']//td[.='Annuler'][@class='z-button-cm']")
	private WebElement bouton_annuler_popup;
	
	@FindBy(xpath = "//div[@class='z-window-modal-cr']")
	private WebElement popup;
	
	
	
	
	
	public void verifierBoutonDetail() {
		// Vérifie la présence du bouton 'detail du projet'
		assertTrue(bouton_detail_projet.isDisplayed());
	}

	public void verifierOngletWBS() {
		// Vérifier la présence de l'onglet WBS
		assertTrue(onglet_WBS.isDisplayed());
	}

	public void verifierMenuHorizontal() {
		String onglets = " WBS (tâches) Données générales Coût Avancement Libellés Exigence de critère Matériels Formulaires qualité des tâches Autorisation";
		Outils.verifTableau(onglets, liste_onglets);

	}

	public void verifierMenuVertical() {
		String menus = " Planification de projet Détail du projet Chargement des ressources  Allocation avancée Tableau de bord";
		Outils.verifTableau(menus, liste_menus);

	}

	public void verifierBoutonSave(WebDriver driver) throws InterruptedException {

		// Vérifier le bouton save
		assertTrue(bouton_save.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(bouton_save).build().perform();
		Thread.sleep(1000);

		// Vérifier l'infobulle enregistrer
		assertTrue(info_bulle_save.isDisplayed());
	}

	public void verifierBoutonAnnuler(WebDriver driver) throws InterruptedException {

		// Vérifier le bouton save
		assertTrue(bouton_annuler.isDisplayed());
		Actions actions = new Actions(driver);
		actions.moveToElement(bouton_annuler).build().perform();
		Thread.sleep(1000);

		// Vérifier l'infobulle enregistrer
		assertTrue(info_bulle_annuler.isDisplayed());
	}

	public void cliquerBoutonSave(WebDriver driver) throws InterruptedException {

		// Cliquer le bouton save
		bouton_save.click();
	}
	
	public void cliquerBoutonAnnulerEdition(WebDriver driver) throws InterruptedException {

		// Cliquer le bouton annuler edition
		bouton_annuler.click();
		Thread.sleep(700);
		assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?",popup_text.getText());
		assertTrue(bouton_ok_popup.isDisplayed());
		assertTrue(bouton_annuler_popup.isDisplayed());
	}
	
	public void cliquerBoutonAnnulerPopup(WebDriver driver) throws InterruptedException {

		// Cliquer le bouton annuler popup
		bouton_annuler_popup.click();
		/*WebElement popup2 = driver.findElement(By.xpath("//span[@class='z-messagebox-btn z-button']//td[.='Annuler'][@class='z-button-cm']"));
		Thread.sleep(700);
		assertFalse(popup2.isDisplayed());*/
		
	}
	
	public PageProjet cliquerBoutonOKPopup(WebDriver driver) throws InterruptedException {

		// Cliquer le bouton annuler popup
		bouton_ok_popup.click();
		return PageFactory.initElements(driver, PageProjet.class);
	}
}
