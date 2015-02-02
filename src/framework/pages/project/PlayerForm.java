package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

/**
 * Form to create, update and delete a player.
 * @author Eliana Navia
 *
 */
public class PlayerForm {
	WebDriver driver;
	public ProjectPage objProject;
	//Elements to create a Player
	@FindBy(id = "player-emailPlayer" )
	WebElement emailPlayerField;
	@FindBy(xpath = "//div[@id='addPlayer']/div/form/div[2]/select" )
	WebElement rolePlayerComboBox;
	@FindBy(xpath = "//button[@type='submit']" )
	WebElement submitBtn;

	/**
	 * Initialize the web elements.
	 */
	public PlayerForm (){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		objProject = new ProjectPage();
	}
	/**
	 * Set the email player with the value insert by the user.
	 * @param emailPlayer
	 */
	public void setEmailPlayer(String emailPlayer){
		emailPlayerField.clear();
		emailPlayerField.sendKeys(emailPlayer);
	}
	/**
	 * Set the role player (Team Member, Scrum Master, Stakeholder)
	 * @param rolePlayer
	 */
	public void setRolePlayer(String rolePlayer){
		rolePlayerComboBox.click();
		rolePlayerComboBox.sendKeys(rolePlayer);
	}
	/**
	 * Click in the submit button to save the values inserted in the form.
	 * @return
	 */
	public ProjectPage clickSubmitBtn(){
		submitBtn.click();
		return new ProjectPage();
	}
/**
 * Steps to add a player in the project.
 * @param emailPlayer
 * @param rolePlayer
 * @return
 */
	public ProjectPage addPlayer(String emailPlayer, String rolePlayer){
		objProject.clickAddUserIcon();
		setEmailPlayer(emailPlayer);
		setRolePlayer(rolePlayer);
		return clickSubmitBtn();
	}

}
