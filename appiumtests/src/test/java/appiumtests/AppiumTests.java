package appiumtests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTests extends AutomationMethods{
	
	
	@BeforeTest
	public static void initialization() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "EtchEmulator");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		
//		cap.setCapability("deviceName", "Galaxy J7 (2016)");
//		cap.setCapability("udid", "52034a51fc3a83fb");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "8.1.0");
		
//		cap.setCapability("deviceName", "Lenovo");
//		cap.setCapability("udid", "f6a8d454");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "7.0");
		
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
		userGuide();
		signin();
		selectMatch(0);
		ratePlayer();
	}
	
	@Test (priority = 1)
	public static void rateGoalTestcase() {
		userGuide();
		signin();
		selectMatch(0);
		rateGoal();
	}
	
	@Test (priority = 2)
	public static void recommendSubTestcase() {
		userGuide();
		signin();
		selectMatch(0);
		recommendSub();
		assertToastMessage(SUCCESSFUL_RECOMMENDATION);
	}
	
	@Test (priority = 3)
	public static void predictScoreTestcase() {
		userGuide();
		signin();
		selectMatch(0);
		predictScore();
	}
	
	@Test (priority = 4)
	public static void guestRatePlayerTestcase() {
		userGuide();
		guestLogin();
		selectMatch(0);
		guestRatePlayer();
	}
	
	@Test (priority = 5)
	public static void guestRateGoalTestcase() {
		userGuide();
		guestLogin();
		selectMatch(0);
		guestRateGoal();
	}
	
	@Test (priority = 6)
	public static void guestRecommendSubTestcase() {
		userGuide();
		guestLogin();
		selectMatch(0);
		guestRecommendSub();
		
	}
	
	@Test (priority = 7)
	public static void guestPredictScoreTestcase() {
		userGuide();
		guestLogin();
		selectMatch(0);
		guestPredictScore();
	}
	
	@AfterMethod
	public static void betweenTests() {
		delay(2);
		backToMainScreen();
		logout();
		
//		driver.startActivity(new Activity("com.fanzword.staging", "com.fanzword.ui.activities.MainActivity"));
	}
	
	
}