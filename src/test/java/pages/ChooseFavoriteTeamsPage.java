package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class ChooseFavoriteTeamsPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By backArrowSelector = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	By searchBarSelector = By.id("com.fivemobile.thescore:id/search_bar_placeholder");
	
	public ChooseFavoriteTeamsPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickOnSearchBar() {
		Helpers.waitForElement(driver, searchBarSelector).click();
	}

}
