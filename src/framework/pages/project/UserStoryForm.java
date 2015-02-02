package framework.pages.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.SeleniumDriverManager;

/**
 * Form to add, delete and update a user story.
 * @author Eliana Navia
 *
 */
public class UserStoryForm {
	public ProjectPage objProject;
	WebDriver driver;
	@FindBy(id = "us-title")
	WebElement userStoryTitleField;
	@FindBy(id = "createUS")
	WebElement createUSBtn;

	/**
	 * Initialize the web elements.
	 */
	public UserStoryForm(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		objProject = new ProjectPage();
	}
	/**
	 * Set the user story title.
	 * @param userStoryTitle
	 */
	public void setUserStoryTitle(String userStoryTitle){
		userStoryTitleField.clear();
		userStoryTitleField.sendKeys(userStoryTitle);
	}
	/**
	 * Click in the "Create" button this collapse the form.
	 * @return
	 */
	public ProjectPage clickCreateUSBtn(){
		createUSBtn.click();
		return new ProjectPage();
	}

	/**
	 * Create a US in Icebox pane where only the title is obligatory.
	 * @param userStoryTitle
	 * @return
	 */
	public ProjectPage addNewUserStory(String userStoryTitle){
		objProject.clickAddStoryBtn();
		setUserStoryTitle(userStoryTitle);
		return clickCreateUSBtn();
	}


}
