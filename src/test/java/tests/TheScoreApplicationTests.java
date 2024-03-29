package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.SearchContentPage;
import pages.SoccerPlayerPage;
import utilities.NavigationHelper;

public class TheScoreApplicationTests extends BaseClass {
	
	@Test(testName="theScore App Navigation", description="Navigating to the main page of theScore app")
	public void searchForPlayerTest(){
		String playerName = "Tajon Buchanan";
		try {
			NavigationHelper quickNavigation = new NavigationHelper(driver, test);
			quickNavigation.applicationQuickSetup();
			NavigationBar navigation = new NavigationBar(driver, test);
			navigation.clickOnSearchBar();
			SearchContentPage searchContentPage = new SearchContentPage(driver, test);
			searchContentPage.selectPlayer(playerName, "Soccer");
			SoccerPlayerPage playerPage = new SoccerPlayerPage(driver, test);
			playerPage.verifySoccerPlayerPage(playerName, "#17 / M / INT");
			playerPage.verifySoccerPlayerInfo(playerName, "1999-02-08 (Age 24)", "Brampton, Canada", "6'0\"", "150 lbs", "Right");
			playerPage.clickOnBackArrow();
			searchContentPage.verifySearchContentPage();
			Thread.sleep(1000);
			logStep(test, "PASS", "The test was able to complete all of its steps");
		} catch (Exception e){
			logStep(test, "FAIL", "The test was not able to complete all of its steps");
			Assert.fail();
		}
	}

}
