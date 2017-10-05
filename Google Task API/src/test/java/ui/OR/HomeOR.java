package ui.OR;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.*;
import Utilities.WebBrowser;

public class HomeOR extends WebBrowser 
{
	@FindBy(id="nav-search-submit-text")
	public WebElement searchBox;
	
	@FindBy(xpath=".//*[@id='page']/div[1]")
	public WebElement img_Nordea;
	
	@FindBy(xpath="//*[@class='nordeaLogo']/img")
	public WebElement header_Nordea;
	
	@FindBy(xpath="//h3[@class='teal'][text()='Get Ready']")
	public WebElement txt_step1;
	
	
	
	
}


