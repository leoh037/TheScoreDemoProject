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
	By infoFieldTitleSelector = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/title\"]");
	By infoFieldValueSelector = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/value\"]");
	
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
		List<WebElement> infoTitleElements = Helpers.getElementList(driver, infoFieldTitleSelector);
		int numberOfElements = infoTitleElements.size();
		String expectedInfoTitles = "Birth DateBirth PlaceHeightWeightShoots";
		String actualInfoTitle = "";
		for(int i = 0; i < numberOfElements; i++) { actualInfoTitle = actualInfoTitle + infoTitleElements.get(i).getText(); }
		List<WebElement> infoValueElements = Helpers.getElementList(driver, infoFieldValueSelector);
		numberOfElements = infoValueElements.size();
		String expectedPlayerInfo = birthDate + birthPlace + height + weight + shoots;
		String actualPlayerInfo = "";
		for(int i = 0; i < numberOfElements; i++) { actualPlayerInfo = actualPlayerInfo + infoValueElements.get(i).getText(); }
		if(actualInfoTitle.equals(expectedInfoTitles) && actualPlayerInfo.equals(expectedPlayerInfo)) {
			Report.logStep(test, "PASS", "Succesfully navigated to the correct INFO tab for " + playerName);
		} else {
			Report.logStep(test, "FAIL", "Did not navigate to the correct INFO tab for " + playerName);
			throw new EndTestException();
		}
	}

}
