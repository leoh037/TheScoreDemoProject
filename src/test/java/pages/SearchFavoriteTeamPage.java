package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class SearchFavoriteTeamPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By searchBarSelector = By.id("com.fivemobile.thescore:id/search_src_text");
	By ContinueSelector = By.id("com.fivemobile.thescore:id/btn_primary");
	By recyclerSelector = By.id("com.fivemobile.thescore:id/horizontal_recycler_view");
	
	public SearchFavoriteTeamPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickOnSearchBar() {
		Helpers.waitForElement(driver, searchBarSelector).click();
	}
	
	public void clickContinue() {
		 Helpers.waitForElement(driver, ContinueSelector).click();
	}
	
	public void searchForTeam(String teamName) {
		WebElement searchBar = Helpers.waitForElement(driver, searchBarSelector);
		searchBar.click();
		Helpers.sendKeys(driver, searchBar, teamName);
		Helpers.waitForElement(driver, recyclerSelector).click();
	}
	
	public void selectTeam(String teamName) {
		searchForTeam(teamName);
		By teamSelector = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\""+teamName+"\"]");
		Helpers.waitForElement(driver, teamSelector).click();
		clickContinue();
	}

}
