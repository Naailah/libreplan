package GR4.LibrePlan4;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageConnexion extends PageBandeau {

	@FindBy (xpath="//input[@name='j_username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='j_password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement bouton_submit;
	
	public PageConnexion() {
		super();
		
	}
	
}
