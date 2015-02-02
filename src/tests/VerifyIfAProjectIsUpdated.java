package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a project created is updated with the new information fill in the form.
 * @author Eliana Navia
 *
 */
public class VerifyIfAProjectIsUpdated {
	public DashboardPage objDashboard;
	public NewProjectForm objNewProject;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeTest
	public void preconditions(){
		objNewProject = new NewProjectForm();
		objProject = new ProjectPage();
		objDashboard = new DashboardPage();
		objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		objProject.clickDashboardLink();
	}
	/**
	 * Update the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsUpdated(){
		String projectName = "1234";
		String iterationLength = "2";
		String usPointScale = "Fibonacci: 0, 1, 2, 3, 5, 8, 13, 20, 40, 100";
		objNewProject.updateProject(projectName,iterationLength,usPointScale );
		Assert.assertTrue(objDashboard.getProjectNameText().contains(projectName));
	}
	/**
	 * After the test is executed the project is deleted.
	 */
	@AfterTest
	public void postcondition(){
		objDashboard.deleteProject();
	}
}

