package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.SearchResultsPage;
import pages.SoccerPlayerPage;
import utilities.NavigationHelper;

public class Tests extends BaseClass {
	
	@Test(testName="theScore App Navigation", description="Navigating to the main page of theScore app")
	public void DummyTest(){
		NavigationHelper quickNavigation = new NavigationHelper(driver, test);
		NavigationBar navigation = new NavigationBar(driver, test);
		SearchResultsPage searchPage = new SearchResultsPage(driver, test);
		SoccerPlayerPage playerPage = new SoccerPlayerPage(driver, test);
		try {
			quickNavigation.applicationSetup();
			navigation.clickOnSearchBar();
			searchPage.selectPlayer("Tajon Buchanan", "Soccer");
			playerPage.verifySoccerPlayerPage("Tajon Buchanan", "#17 / M / INT");
			playerPage.verifySoccerPlayerInfo("Tajon Buchanan", "1999-02-08 (Age 24)", "Brampton, Canada", "6'0\"", "150 lbs", "Right");
			playerPage.clickOnBackArrow();
			Thread.sleep(1000);
			logStep(test, "INFO", "The test was able to complete all of its steps");
		} catch (Exception e){
			logStep(test, "INFO", "The test was not able to complete all of its steps");
			Assert.fail();
		}
	}

}
