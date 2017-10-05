package ui.PageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ui.OR.HomeOR;

public class HomePage extends HomeOR 
{
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
}
