package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;

/**
 * Logout of JAT
 * @author Eliana Navia
 *
 */
public class Logout {
	public WebDriver driver;
	@FindBy(xpath ="//div/span")
	WebElement dropdown;
	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	/**
	 * Initialize the driver and web elements. 
	 */
	public Logout(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Expand the drop down located in top right of the page under user email text.
	 */
    public void clickDropdown(){
    	dropdown.click();
    }
    
    /**
     * Click logout button
     */
    public void clickLogout(){
    	logoutLink.click();
    }
    
    /**
     * Perform logout of the application
     */
    public void logout(){
    	clickDropdown();
    	clickLogout();
    }
}
