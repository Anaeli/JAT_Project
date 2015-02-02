package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.pages.project.UserStoryForm;

/**
 * This test case verifies that a user story is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfAUserStoryIsCreated {
	public DashboardPage objDashboard;
	public NewProjectForm objNewProject;
	public UserStoryForm objUserStory;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeTest
	public void preconditions(){
		objNewProject = new NewProjectForm();
		objProject = new ProjectPage();
		objUserStory = new UserStoryForm();
		objDashboard = new DashboardPage();
		objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
	}

	/**
	 *
	 * @return Object[][] where first column contains 'user story title'
	 */
	@DataProvider(name="userStoryData")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
				{"User Story 1"},
				{"User Story 2"},
				{"User Story 3"}
		};
	}
	/**
	 * Create a user story with the values of data provider.
	 * @param userStoryTitle
	 */
	@Test(dataProvider="userStoryData")
	public void testVerifyIfAUserStoryIsCreated(String userStoryTitle){
		objUserStory.addNewUserStory(userStoryTitle);
		Assert.assertTrue(objProject.getUserStoryText().contains(userStoryTitle));
	}

	/**
	 * After the test is executed the project where the USs were created is deleted.
	 */
	@AfterTest
	public void postconditions(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}
