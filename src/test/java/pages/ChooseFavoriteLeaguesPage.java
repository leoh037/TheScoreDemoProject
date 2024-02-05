package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

public class ChooseFavoriteLeaguesPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By continueSelector = By.id("com.fivemobile.thescore:id/btn_primary");
	By backArrowSelector = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	
	public ChooseFavoriteLeaguesPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickContinue() {
		driver.findElement(continueSelector).click();
	}
	
}
