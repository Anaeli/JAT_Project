package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a project created is deleted.
 * @author Eliana Navia
 *
 */
public class VerifyIfAProjectIsDeleted {
	public DashboardPage objDashboard;
	public NewProjectForm objCreateProject;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeTest
	public void preconditions(){
		objCreateProject = new NewProjectForm();
		objProject = new ProjectPage();
		objDashboard = new DashboardPage();
		objCreateProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
		objProject.clickDashboardLink();
	}
	/**
	 * Update the first project. 
	 */
	@Test
	public void testVerifyIfAProjectIsUpdated(){
		String projectName = objDashboard.getProjectNameText();
		objDashboard.deleteProject();
		Assert.assertFalse(objDashboard.getProjectNameText().contains(projectName));
	}
	/**
	 * Delete the project if it has been deleted for any reason.
	 */
	@AfterTest
	public void postcondition(){
		try
		{
			if(!objDashboard.isDisplayedProjectNameText()){
				objDashboard.deleteProject();
			}
		}
		catch (Exception e)
		{
		}	
	}
}
