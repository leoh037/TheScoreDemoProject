package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Helpers {

	public static WebElement waitForElement(AppiumDriver driver, By by) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofMillis(200));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return element;
		} catch (Exception e){
			return null;
		}
	}
	
	public static List<WebElement> getElementList(AppiumDriver driver, By by){
		List<WebElement> elementList;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.pollingEvery(Duration.ofMillis(200));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			elementList = driver.findElements(by);
			return elementList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void sendKeys(AppiumDriver driver, WebElement element, String keys) {
		element.click();
		element.clear();
		element.sendKeys(keys);
	}

}
