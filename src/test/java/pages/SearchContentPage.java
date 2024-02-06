package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import exceptions.EndTestException;
import io.appium.java_client.AppiumDriver;
import tests.Report;
import utilities.Helpers;

public class SearchContentPage {

	AppiumDriver driver;
	ExtentTest test;

	By searchBarSelector = By.id("com.fivemobile.thescore:id/search_src_text");
	By allTabSelector = By.xpath("//android.widget.TextView[@text=\"ALL\"]");
	By teamsTabSelector = By.xpath("//android.widget.TextView[@text=\"TEAMS\"]");
	By playerTabSelector = By.xpath("//android.widget.TextView[@text=\"PLAYERS\"]");
	By newsTabSelector = By.xpath("//android.widget.TextView[@text=\"NEWS\"]");
	By contentLocator = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\"]");

	public SearchContentPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void verifySearchContentPage() {
		String expectedText = "ALLTEAMSPLAYERSNEWS";
		String actualAllTabText = Helpers.waitForElement(driver, allTabSelector).getText();
		String actualTeamsTabText = Helpers.waitForElement(driver, teamsTabSelector).getText();
		String actualPlayerTabText = Helpers.waitForElement(driver, playerTabSelector).getText();
		String actualNewsTabText = Helpers.waitForElement(driver, newsTabSelector).getText();
		if(expectedText.equals(actualAllTabText+actualTeamsTabText+actualPlayerTabText+actualNewsTabText)) {
			Report.logStep(test, "PASS", "Succesfully navigated to the Search Content page");
		} else {
			Report.logStep(test, "FAIL", "Unable to navigate to the Search Content page");
			throw new EndTestException();
		}
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
