package ui.StepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;


import Utilities.GenericFunctions;
import Utilities.WebBrowser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;

import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;

import ui.PageAction.HomePage;


public class HomeSteps {

	WebDriver driver;
	HomePage objHomePage;

	public HomeSteps() {
		this.driver = WebBrowser.getDriver();
		objHomePage = new HomePage(driver);
	}

	
	@Given("^I am logged in$")
    public void i_am_logged_in() throws Throwable {
	
		 // Build a new authorized API client service.
        Tasks service = Quickstart.getTasksService();

        // Print the first 10 task lists.
        TaskLists result = service.tasklists().list()
             .setMaxResults(Long.valueOf(10))
             .execute();
  
        List<TaskList> tasklists = result.getItems();
        if (tasklists == null || tasklists.size() == 0) {
            System.out.println("No task lists found.");
        } else {
            System.out.println("Task lists:");
            for (TaskList tasklist : tasklists) {
                System.out.printf("%s (%s)\n",
                        tasklist.getTitle(),
                        tasklist.getId());
            }
        }
    
	
	}
	
	
	
}