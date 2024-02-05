package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class Modals {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By closeModalIconSelector = By.id("com.fivemobile.thescore:id/dismiss_modal");
	
	public Modals(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void closeModal() {
		Helpers.waitForElement(driver, closeModalIconSelector).click();
	}

}
