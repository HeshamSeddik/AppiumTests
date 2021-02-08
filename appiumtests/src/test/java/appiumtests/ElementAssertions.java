package appiumtests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ElementAssertions extends AutomationMethods{


	@BeforeSuite
	public static void initialization() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		
//		cap.setCapability("deviceName", "Android Emulator");
//		cap.setCapability("udid", "emulator-5554");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "10");
		
		cap.setCapability("deviceName", "Lenovo");
		cap.setCapability("udid", "f6a8d454");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.fanzword.staging");
		cap.setCapability("appActivity", "com.fanzword.ui.activities.SplashActivity");
		
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
	
	@BeforeTest
	public static void login() {
		signin();
	}
	
	@Test
	public static void assetNavTabs() {
		assertElementText("Today");
		assertElement(NAV_MATCHES_TAB);
		assertElement(NAV_STATISTICS_TAB);
		assertElement(NAV_RANKINGS_TAB);
		assertElement(NAV_PROFILE_TAB);
		System.out.println("All main tabs are displayed");
	}
	
	@Test
	public static void assetNavBar() {
//		String x = assertPageTitle("Matches")  ? "Correct title" : "Incorrect title";
//		System.out.println(x);
//		assertPageTitle("Matches");
		assertElementText("Today");
		assertIsSelected("Today");
		assertElement(CALENDAR_BTN);
		assertElement(LIVE_BTN);
		assertElement(DRAWER_BTN);
		System.out.println("All main tabs are displayed");
	}
	
}
