package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import framework.pages.dashboard.DashboardPage;
import framework.pages.dashboard.NewProjectForm;
import framework.pages.project.ProjectPage;
import framework.util.ReadExcelFile;

/**
 * This test case verifies that a project is created after the form is filled with valid information and saved.
 * 
 * @author Eliana Navia
 *
 */
public class VerifyIfProjectsAreCreated {
	public DashboardPage objDashboard;
	public NewProjectForm objCreateProject;
	public ProjectPage objProject;

	/**
	 * Initialization of all classes used in the test
	 */
	@BeforeTest
	public void preconditions (){
		objCreateProject = new NewProjectForm();
		objProject = new ProjectPage();
		objDashboard = new DashboardPage();
	}

	/**
	 * Read the data of a excel file.
	 * @return Object[][] where first column contains 'project name'
	 * second column contains 'iteration length', and the third 'Point Scale'
	 * @throws IOException
	 */
	@DataProvider(name="projectData")
	public Object[][] getDataFromXlsx() throws IOException{
		//Create a object of ReadExcelFile class
		ReadExcelFile objExcelFile = new ReadExcelFile();
		//Prepare the path of excel file
		String filePath = System.getProperty("user.dir")+"\\src\\tests\\resources";
		//Call read file method of the class to read data
		Object[][] data =objExcelFile.readExcel(filePath,"JATDataProvider.xlsx","ProjectData");
		return data;
	}

	/**
	 * Execute the TCs with data provide by a excel file.
	 * @param projectName
	 * @param iterationLength
	 * @param usPointScale
	 */
	@Test(dataProvider="projectData")
	public void testVerifyIfProjectsAreCreated(String projectName, String iterationLength, String usPointScale){
		objCreateProject.createNewProject(projectName,iterationLength,usPointScale );
		//Verify if the project name is the same that the text displayed in the project page
		Assert.assertTrue(objProject.getNameProjectText().contains(projectName));
		//Return to dashboard page to start the test again .
		//Postconditions
		objProject.clickDashboardLink();
		objDashboard.deleteProject(); //delete the project after it is created.
	}

	/**
	 * This method only delete a project.
	 * @AfterTest
	public void deleteProject(){
		objDashboard.deleteProject();
	}*/
}

