package framework.pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.common.SeleniumDriverManager;

/**
 * List of project that belong to a user, a project could be add, update and delete.
 * @author Eliana Navia
 */
public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath ="//div[2]/button")
	WebElement newProjectBtn;
	@FindBy(linkText = "Update") 
	WebElement updateProjectLink;
	@FindBy(linkText = "Delete") 
	WebElement deleteProjectLink;
	// Elements to delete a project
	@FindBy(id = "button-0")
	WebElement okBtn;
	//Find elements to verifications
	@FindBy(xpath ="//span[contains(@title, 'email')]")
	WebElement userEmail;
	@FindBy(css ="div.title2")
	WebElement projectName;

	/**
	 * Initialize the driver and web elements. 
	 */
	public DashboardPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Click in new project button.
	 * @return
	 */
	public NewProjectForm clickNewProject(){
		newProjectBtn.click();
		return new NewProjectForm();
	}
	/**
	 * Click in update project link.
	 * @return
	 */
	public NewProjectForm clickUpdateProject(){
		updateProjectLink.click();
		return new NewProjectForm();
	}
	/**
	 * Click in delete project link.
	 * @return
	 */
	public void clickDeleteLink(){
		deleteProjectLink.click();
	}
	/**
	 * Click in OK button in the confirmation message to delete a project.
	 * @return Dashboard page
	 */
	public DashboardPage clickOkBtn(){
		okBtn.click();
		return this;
	}
	/**
	 * Delete the first project of project list.
	 */
	public DashboardPage deleteProject(){
		//xpath= "(//a[contains(text(), 'Delete')])[7])" @param pName, to delete a project based in its name.
		clickDeleteLink();
		return clickOkBtn();
	}
	/**
	 * 
	 * @return user email
	 */
	public String getLoginEmailText(){
		return userEmail.getText();
	}
	/**
	 *
	 * @return project name of the first project in the list.
	 */
	public String getProjectNameText(){
		return projectName.getText();
	}
	/**
	 * Return true if project name is found in the dashboard page otherwise return false.
	 * @return 
	 */
	public boolean isDisplayedProjectNameText(){
		return projectName.isDisplayed();
	}
}
