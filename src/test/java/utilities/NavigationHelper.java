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
		welcomePage.clickGetStartedButton();
		
		ChooseFavoriteLeaguesPage favoriteLeaguesPage = new ChooseFavoriteLeaguesPage(driver, test);
		favoriteLeaguesPage.clickContinue();
		
		ChooseFavoriteTeamsPage favoriteTeamsPage = new ChooseFavoriteTeamsPage(driver, test);
		favoriteTeamsPage.clickOnSearchBar();
		
		SearchFavoriteTeamPage searchForTeamPage = new SearchFavoriteTeamPage(driver, test);
		searchForTeamPage.selectTeam("Toronto FC");
		
		OnboardingPage onboardingPage = new OnboardingPage(driver, test);
		onboardingPage.clickOnDone();
		
		Modals modal = new Modals(driver, test);
		modal.closeModal();
		
		Report.logStep(test, "PASS", "Succesfully setup application");
		
		FavoritesPage favoritesPage = new FavoritesPage(driver, test);
		favoritesPage.verifyFavoritesPage();
	}

}
