package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class SearchResultsPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By searchBarSelector = By.id("com.fivemobile.thescore:id/search_src_text");
	By allTabSelector = By.xpath("");
	By teamsTabSelector = By.xpath("");
	By playerTabSelector = By.xpath("//android.widget.LinearLayout[@content-desc=\"Players\"]");
	By newsTabSelector = By.xpath("");
	By contentLocator = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\"]");
	
	public SearchResultsPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void searchForContent(String contentName) {
		WebElement searchBar = Helpers.waitForElement(driver, searchBarSelector);
		Helpers.sendKeys(driver, searchBar, contentName);
	}
	
	public void selectPlayer(String playerName, String league) {
		searchForContent(playerName);
		Helpers.waitForElement(driver, playerTabSelector).click();
		getPlayer(playerName + " ("+league+")").click();
	}
	
	private WebElement getPlayer(String playerName) {
		List<WebElement> playerElementList = Helpers.getElementList(driver, contentLocator);
		int listSize = playerElementList.size();
		if (listSize > 0) {
			WebElement playerElement;
			String playerElementElementName;
			int i = 0;
			while (i < listSize) {
				playerElement = playerElementList.get(i++);
				playerElementElementName = playerElement.getText();
				if (playerElementElementName.equals(playerName)) {
					return playerElement;
				}
			}
		}
		return null;
	}

}
