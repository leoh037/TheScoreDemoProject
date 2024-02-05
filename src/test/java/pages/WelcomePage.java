package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class WelcomePage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By getStartedSelector = By.id("com.fivemobile.thescore:id/btn_primary");
	
	public WelcomePage(AppiumDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	public void clickGetStartedButton() {
		Helpers.waitForElement(driver, getStartedSelector).click();
	}

}
