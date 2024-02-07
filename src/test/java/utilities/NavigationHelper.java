package utilities;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import pages.ChooseFavoriteLeaguesPage;
import pages.ChooseFavoriteTeamsPage;
import pages.FavoritesPage;
import pages.Modals;
import pages.OnboardingPage;
import pages.SearchFavoriteTeamPage;
import pages.WelcomePage;
import tests.Report;

public class NavigationHelper {
	
	AppiumDriver driver;
	ExtentTest test;
	
	public NavigationHelper(AppiumDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void applicationQuickSetup() {
		WelcomePage welcomePage = new WelcomePage(driver, test);
		ChooseFavoriteLeaguesPage favoriteLeaguesPage = new ChooseFavoriteLeaguesPage(driver, test);
		ChooseFavoriteTeamsPage favoriteTeamsPage = new ChooseFavoriteTeamsPage(driver, test);
		SearchFavoriteTeamPage searchForTeamPage = new SearchFavoriteTeamPage(driver, test);
		OnboardingPage onboardingPage = new OnboardingPage(driver, test);
		Modals modal = new Modals(driver, test);
		FavoritesPage favoritesPage = new FavoritesPage(driver, test);
		welcomePage.clickGetStartedButton();
		favoriteLeaguesPage.clickContinue();
		favoriteTeamsPage.clickOnSearchBar();
		searchForTeamPage.selectTeam("Toronto FC");
		onboardingPage.clickOnDone();
		modal.closeModal();
		Report.logStep(test, "PASS", "Succesfully setup application");
		favoritesPage.verifyFavoritesPage();
	}

}
