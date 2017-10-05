package Utilities;

import java.util.List;
import java.util.NoSuchElementException;
import java.lang.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;


public class GenericFunctions extends WebBrowser {

	
	public static void verifyPageTitle(String expectedTitle) {
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

	
	public static boolean isElementDisplayed(WebElement element) {
		try {
			if (element.isDisplayed()) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	
	public static boolean checkCurrentPageName(String pageName) {
		try {
			driver.findElement(By.xpath("//h4[contains(text(),'" + pageName + "')]"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public static boolean isElementDisplayed(By locator) {
		try {
			if (driver.findElement(locator).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	
	public static void clickAnyButtonByText(String textToClick) {
		driver.findElement(By.xpath("//button[text()='" + textToClick + "']")).click();
	}

	
	public static void clickAnyLinkByText(String linkToClick) {
		driver.findElement(By.xpath("//a/span[text()='" + linkToClick + "']")).click();
	}

	
	public static String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	
	public static String getCurrentPageHeader(String pageTitle) {
		return driver.findElement(By.xpath("//h3[text()='" + pageTitle + "']")).getText();
	}

	
	public static String getElementText(WebElement element) {
		return element.getText();
	}

	
	public static void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	
	public static void clickAnyTileByText(String tileToClick) {
		driver.findElement(By.xpath("//h2[text()='" + tileToClick + "']")).click();
	}

	
	public static void selectNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	
	public static boolean isTitlePresent(String expectedtitle) {
		List<WebElement> list_PopupTitles = driver.findElements(By.xpath("//h4"));
		for (WebElement element : list_PopupTitles) {
			if (element.getText().contains(expectedtitle)) {
				return true;
			}
		}
		return false;
	}

	
	public static void javascriptClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
	
	
	public static String getCurrentPageTitle(){
		return driver.getTitle();
	}
	
	
	public static void sendData(String inputField, String inputData){
		
		driver.findElement(By.id("//*[text()='" + inputField + "']")).sendKeys(inputData);
		
	}
	
	
	public static void HoverAndClick(String hover, String click) throws InterruptedException{

         WebElement webElementToHover = driver.findElement(By.linkText(hover));

         Actions action = new Actions(driver);
         action.moveToElement(webElementToHover).build().perform();

         Thread.sleep(2000);

         driver.findElement(By.linkText(click)).click();
         
     }
	 
	 public static void Sleep(int milliseconds) throws InterruptedException{
		 
		 Thread.sleep(milliseconds);
		 
	}
	 
	 
}
	


