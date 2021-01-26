package appiumtests;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTests extends AutomationMethods{
	
	
	@BeforeTest
	public static void initialization() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Lenovo");
		cap.setCapability("udid", "f6a8d454");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.fanzword.staging");
		cap.setCapability("appActivity", "com.fanzword.ui.activities.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver<MobileElement>(url, cap);
		wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		wait = new FluentWait<AppiumDriver<MobileElement>>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(1))
//				.ignoring(NoSuchElementException.class)
//				.ignoring(TimeoutException.class);
		
		System.out.println("Application started...");
		
	}
	
	@Test (priority = 0)
	public static void ratePlayerTestcase() {
		signin();
		selectMatch(0);
		ratePlayer();
	}
	
	@Test (priority = 1)
	public static void recommendSubTestcase() {
		signin();
		selectMatch(0);
		recommendSub();
	}
	
	@Test (priority = 2)
	public static void predictScoreTestcase() {
		signin();
		selectMatch(0);
		predictScore();
	}
	
	@Test (priority = 3)
	public static void guestPredictScoreTestcase() {
		guestLogin();
		selectMatch(0);
		guestPredictScore();
	}
	
	@Test (priority = 4)
	public static void guestRatePlayerTestcase() {
		guestLogin();
		selectMatch(0);
		guestRatePlayer();
	}
	
	@Test (priority = 5)
	public static void guestRecommendSubTestcase() {
		guestLogin();
		selectMatch(0);
		guestRecommendSub();
	}
	
	@AfterMethod
	public static void betweenTests() {
		delay(1);
		driver.startActivity(new Activity("com.fanzword.staging", "com.fanzword.ui.activities.MainActivity"));
		logout();
	}
	
	
}