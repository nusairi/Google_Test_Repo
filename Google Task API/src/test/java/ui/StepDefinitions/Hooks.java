package ui.StepDefinitions;

import Utilities.WebBrowser;
import cucumber.api.java.After;

public class Hooks extends WebBrowser {
	public Hooks() {
		driver = WebBrowser.getDriver();
	}

	@After
	public void TearDown() {
		driver.quit();
		driver = null;
	}
}
