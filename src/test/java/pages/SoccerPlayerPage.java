package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import exceptions.EndTestException;
import io.appium.java_client.AppiumDriver;
import tests.Report;
import utilities.Helpers;

public class SoccerPlayerPage {
	
	AppiumDriver driver;
	ExtentTest test;
	
	By backArrowSelector = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	By playerNameSelector = By.id("com.fivemobile.thescore:id/txt_player_name");
	By playerDetailsSelector = By.id("com.fivemobile.thescore:id/detail_subtitle");
	By statsTabSelector = By.xpath("//android.widget.LinearLayout[@content-desc=\"Stats\"]");
	By infoTabSelector = By.xpath("//android.widget.LinearLayout[@content-desc=\"Info\"]");
	By infoSelector = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/value\"]");
	
	public SoccerPlayerPage(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickOnBackArrow() {
		Helpers.waitForElement(driver, backArrowSelector).click();
	}
	
	public void navigateToStatsTab() {
		Helpers.waitForElement(driver, statsTabSelector).click();
	}
	
	public void navigateToInfoTab() {
		Helpers.waitForElement(driver, infoTabSelector).click();
	}
	
	public void verifySoccerPlayerPage(String playerName, String playerDetails) {
		String actualName = Helpers.waitForElement(driver, playerNameSelector).getText();
		String actualDetails = Helpers.waitForElement(driver, playerDetailsSelector).getText();
		if((actualName + actualDetails).equals(playerName+playerDetails)){
			Report.logStep(test, "PASS", "Succesfully navigated to the correct player page for " + playerName);
		} else {
			Report.logStep(test, "FAIL", "Did not navigate to the correct player page for " + playerName);
			throw new EndTestException();
		}
	}
	
	public void verifySoccerPlayerInfo(String playerName, String birthDate, String birthPlace, String height, String weight, String shoots) {
		navigateToInfoTab();
		List<WebElement> infoElements = Helpers.getElementList(driver, infoSelector);
		int numberOfElements = infoElements.size();
		String expectedPlayerInfo = birthDate + birthPlace + height + weight + shoots;
		String actualPlayerInfo = "";
		for(int i = 0; i < numberOfElements; i++) { actualPlayerInfo = actualPlayerInfo + infoElements.get(i).getText(); }
		if(actualPlayerInfo.equals(expectedPlayerInfo)) {
			Report.logStep(test, "PASS", "Succesfully navigated to the correct INFO tab for " + playerName);
		} else {
			Report.logStep(test, "FAIL", "Did not navigate to the correct INFO tab for " + playerName);
			throw new EndTestException();
		}
	}

}
