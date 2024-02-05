package pages;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import utilities.Helpers;

public class NavigationBar {

	AppiumDriver driver;
	ExtentTest test;

	By searchBarSelector = By.id("com.fivemobile.thescore:id/search_bar_text_view");
	By newsPageSelector = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[1]");
	By scoresPageSelector = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[2]");
	By favoritesPageSelector = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[3]");
	By betPageSelector = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[4]");
	By leaguesPageSelector = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/navigation_bar_item_icon_view\"])[5]");

	public void clickOnSearchBar() {
		Helpers.waitForElement(driver, searchBarSelector).click();
	}

	public NavigationBar(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void navigateToNewsPage() {
		Helpers.waitForElement(driver, newsPageSelector).click();
	}

	public void navigateToScoresPage() {
		Helpers.waitForElement(driver, scoresPageSelector).click();
	}

	public void navigateToFavoritesPage() {
		Helpers.waitForElement(driver, favoritesPageSelector).click();
	}

	public void navigateToBetPage() {
		Helpers.waitForElement(driver, betPageSelector).click();
	}

	public void navigateToLeaguesPage() {
		Helpers.waitForElement(driver, leaguesPageSelector).click();
	}

}
