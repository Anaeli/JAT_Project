package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;
import framework.pages.dashboard.DashboardPage;

/**
 * User story board related to a project.
 * @author Eliana Navia
 *
 */
public class ProjectPage {
	WebDriver driver;
	@FindBy(css ="div.project-name.ng-binding")
	WebElement nameProject;
	@FindBy(linkText ="DashBoard")
	WebElement dashboardLink;
	//Expand the form to create a player
	@FindBy( css = "span.fa.fa-user" )
	WebElement addUserIcon;
	//To add a user story
	@FindBy( id = "newUserStory_link" )
	WebElement addUserStoryBtn;
	//To verify the player name 
	@FindBy( css = "div.panel.panel-itemPlayer > div.panel-heading > div.title2.ng-binding" )
	WebElement playerName;
	//To verify user story title 
	@FindBy( xpath = "//div[contains(@class,'title ng-scope ng-binding')]")
	WebElement userStoryTitle;
	
	/**
	 * Initialize the web elements.
	 */
	public ProjectPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * Expand the form to create a player.
	 * @return PlayerForm 
	 */
	public PlayerForm clickAddUserIcon(){
		addUserIcon.click();
		return new PlayerForm();
	}

	/**
	 * Return the project name displayed in the top.
	 * @return
	 */
	public String getNameProjectText(){
		return nameProject.getText();
	}
	/**
	 * Return the player name of the first layout.
	 * @return
	 */
	public String getPlayerNameText(){
		return playerName.getText();
	}
	
	/**
	 * 
	 * @return the user story title of the first layout.
	 */
	public String getUserStoryText(){
		return userStoryTitle.getText();
	}
	/**
	 * Click in the dashboard link displayed in the menu on the top right.
	 * @return
	 */
	public DashboardPage clickDashboardLink(){
		dashboardLink.click();
		return new DashboardPage();
	}
	/**
	 * Click "+ Add Story" button that expand the form to create a US.
	 * @return UserStoryForm
	 */
	public UserStoryForm clickAddStoryBtn(){
		addUserStoryBtn.click();
		return new UserStoryForm();
	}
	/**
	 * Refresh the page
	 */
	public void pageRefresh(){
		driver.navigate().refresh();
	}
}
