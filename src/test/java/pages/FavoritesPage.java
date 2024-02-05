package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import exceptions.EndTestException;
import io.appium.java_client.AppiumDriver;
import tests.Report;
import utilities.Helpers;

public class FavoritesPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By addFavoriteSelector = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"Add\"]");
	
	public FavoritesPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void verifyFavoritesPage() {
		if(Helpers.waitForElement(driver, addFavoriteSelector).getText().equals("Add")) {
			Report.logStep(test, "PASS", "Succesfully navigated to the Favorites page");
		} else {
			Report.logStep(test, "FAIL", "Unable to navigate to the Favorites page");
			throw new EndTestException();
		}
	}

}
