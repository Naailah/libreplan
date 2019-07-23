package Couts;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GR4.LibrePlan4.Outils;

public class PageCategorieCouts {
	
	@FindBy (xpath="//div[substring(@id,5)='j4-cap']")
	private WebElement titre_categorie_couts_liste;
	
	@FindBy (xpath="//table[substring(@id,5)='x4-box']//td[contains(@class,'z-button-cm')]")
	private WebElement bouton_creer;
	
	@FindBy (xpath="//td[substring(@id,5)='z4-cnt']")
	private WebElement titre_creer_categorie_cout;
	
	@FindBy (xpath="//input[substring(@id,5)='h5']")
	private WebElement champ_nom;
	
	@FindBy (xpath="//input[substring(@id,5)='k5-real']")
	private WebElement case_activite;
	
	@FindBy (xpath="//div[substring(@id,5)='p5-body']")
	private WebElement ligne;
	
	@FindBy (xpath="//table[substring(@id,5)='o5-box']/tbody/tr[2]/td[2]")
	private WebElement bouton_ajout_ligne;
	
	@FindBy (xpath="//select[substring(@id,5)='u4']")
	private WebElement liste;
	
	@FindBy (xpath="//option[substring(@id,5)='26']")
	private WebElement liste_prix_1;
	
	@FindBy (xpath="//input[substring(@id,5)='46']")
	private WebElement champ_cout_horraire;
	
	@FindBy (xpath="//table[substring(@id,5)='x5-box']/tbody//tr[3]")
	private WebElement bouton_enregistrer;
	
	@FindBy (xpath="//span[substring(@id,5)='96']")
	private WebElement msg_validation;
	
	@FindBy (xpath="//span[substring(@id,5)='c6']")
	private WebElement nom_categorie;
	
	public void verifierTitrePageCategorieCouts() {
	//verif titre de la page
		String titre = titre_categorie_couts_liste.getText();
		assertEquals("Catégories de coût Liste", titre);
	}
	public void creerCategorieCouts() throws InterruptedException {
		bouton_creer.click();
		Thread.sleep(700);
	    //verif titre page "Créer categorie de couts"
		String titre = titre_creer_categorie_cout.getText();
		assertEquals("Créer Catégorie de coût", titre);
	    //Ajout d'un coût 
		Outils.renseignerChamp(champ_nom, "azerty");
		case_activite.click();
		bouton_ajout_ligne.click();
		//verif apparition ligne
		ligne.isDisplayed();
		//selection du type d'heure créé
		liste.click();
		liste_prix_1.click();
		bouton_enregistrer.click();
		//verification message validation
		String msg = msg_validation.getText();
		assertEquals("Catégorie de coût \"azerty\" enregistré", msg);
		//verification catégorie cout tableau
		String categorie = nom_categorie.getText();
		assertEquals("azerty", categorie);
		//verification valeur prix = 150 €
		
//				String valeur = champ_cout_horraire.getAttribute("value");
//				System.out.println(valeur);
//				assertEquals("150 €", valeur);
	}
}
