package tests;

import java.lang.reflect.Method;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;

public class BaseClass extends Report {
	
	static AppiumDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		try {
		DesiredCapabilities capabilities = new  DesiredCapabilities();
		
		//capabilities for the mobile device
		capabilities.setCapability("platformName", "ANDROID");
		capabilities.setCapability("platformVersion", "14");
		capabilities.setCapability("deviceName", "SM-S911W");
		capabilities.setCapability("udid", "RFCWB174NDR");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("newCommandTimeout", 60);
		capabilities.setCapability("autoGrantPermissions", true);
		
		//capabilities for the application
		capabilities.setCapability("appPackage", "com.fivemobile.thescore");
		capabilities.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");
		//capabilities.setCapability("noReset", "true");
		
		URL appiumServerURL = new URL("http://0.0.0.0:4723");
		driver = new AppiumDriver(appiumServerURL, capabilities);
		
		} catch (Exception e) {
			System.out.println("Exception Cause: " + e.getCause());
			System.out.println("Exception Message: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void beforeMethod(Method testMethod) {
		Test currentRunningTest = testMethod.getAnnotation(Test.class);
		testName = currentRunningTest.testName();
		testDescription = currentRunningTest.description();
		test = extent.createTest(testName, testDescription);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		reportSetup();
	}
	
	@AfterSuite
	public void afterSuite() {
		reportTeardown();
	}

}
