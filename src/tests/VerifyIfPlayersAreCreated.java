package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.PlayerForm;
import framework.pages.project.ProjectPage;

/**
 * This test case verifies that a player is created.
 * @author Eliana Navia
 *
 */
public class VerifyIfPlayersAreCreated {
	public DashboardPage objDashboard;
	public NewProjectForm objNewProject;
	public PlayerForm objPlayer;
	public ProjectPage objProject;

	/**
	 * Preconditions a project created (in the first row of the project list)
	 */
	@BeforeTest
	public void preconditions(){
		objNewProject = new NewProjectForm();
		objProject = new ProjectPage();
		objPlayer = new PlayerForm();
		objDashboard = new DashboardPage();
		objNewProject.createNewProject("1abc","1", "Linear: 0, 1, 2 , 3 , 4, 5, 6, 7, 8, 9, 10");
	}

	/**
	 *
	 * @return Object[][] where first column contains 'user email'
	 * and second column contains 'role'
	 */
	@DataProvider(name="playerData")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] {
				{"Player1@yopmail.com", "Team Member"},
				{"Player2@yopmail.com", "Scrum Master"},
				{"Player3@yopmail.com", "Product Owner"}
		};
	}
	/**
	 * Verify is the player are created successfully, 3 players should be created.
	 * @param emailPlayer
	 * @param rolePlayer
	 */
	@Test(dataProvider="playerData")
	public void testVerifyIfPlayersAreCreated(String emailPlayer,String rolePlayer){
		objPlayer.addPlayer(emailPlayer, rolePlayer);
		objProject.pageRefresh();
		Assert.assertTrue(objProject.getPlayerNameText().contains(emailPlayer));

	}
	/**
	 * After the test is executed the project where the players were created is deleted.
	 */
	@AfterTest
	public void postconditions(){
		objProject.clickDashboardLink();
		objDashboard.deleteProject();
	}
}
