package GR4.LibrePlan4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConnexion extends PageBandeau {

	
	
	@FindBy (xpath="//input[@name='j_username']")
	private WebElement chmps_username;
	
	@FindBy (xpath="//input[@name='j_password']")
	private WebElement chmps_password;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement bouton_submit;
	
	public PageConnexion() {
		super();
		
	}
	
	public PageAccueil seConnecter(WebDriver driver, String username, String password) {
		Outils.renseignerChamp(chmps_username, username);
		Outils.renseignerChamp(chmps_password, password);
		bouton_submit.submit();
		return PageFactory.initElements(driver, PageAccueil.class);
	}
	
	
}
