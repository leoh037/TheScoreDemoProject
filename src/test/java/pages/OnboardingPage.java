package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class OnboardingPage {

	AppiumDriver driver;
	ExtentTest test;

	By doneSelector = By.id("com.fivemobile.thescore:id/btn_primary");

	public OnboardingPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickOnDone() {
		Helpers.waitForElement(driver, doneSelector).click();
	}

}
