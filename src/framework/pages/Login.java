package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;
/**
 * To sign in JAT 
 * @author Eliana Navia
 *
 */
public class Login {
	WebDriver driver;
	//Username field
	@FindBy(xpath = "//input[@type='text']")
	WebElement userEmail;
	@FindBy(xpath = "//input[@type='password']")
	//Password field
	WebElement userPassword;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement signinBtn;

	/**
	 * Initialize the singleton to driver manipulation. 
	 */
	public Login(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		driver.get("http://172.20.8.22:3001");
	}
	/**
	 * Set the user email field with the data provide by the user in the sign in form.
	 * @param email
	 */
	public void setUserEmail(String email){
		userEmail.sendKeys(email);
	}
	/**
	 * Set the password field with the data provide by the user in the sign in form.
	 * @param password
	 */
	public void setUserPassword(String password){
		userPassword.sendKeys(password);
	}
	/**
	 * Click in the "Sign in" button this display the dashboard page.
	 * @return
	 */
	public DashboardPage clickSigninBtn(){
		signinBtn.click();
		return new DashboardPage();
	}
	/**
	 * 
	 * @return user email located in top right of the page.
	 */
	public String getLoginEmailText(){
		return userEmail.getText();
	}
	/**
	 * Login into JAT, displayed the dashboard page.
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	public DashboardPage loginIntoJAT(String userEmail, String userPassword){
		setUserEmail(userEmail);
		setUserPassword(userPassword);
		return clickSigninBtn();	
	}
	/**
	 * Close the browser.
	 */
	public void closeBrowser(){
		SeleniumDriverManager.getManager().quitDriver();
	}
	
}
