package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTests {

	private static final String ET_USERNAME_ID = "et_username";
	static AppiumDriver<MobileElement> driver;
	final static String BASE_VIEW_ID = "com.fanzword.staging:id/";
	static String email = "hseddik@identity-solutions.org";
	static String pw = "12345678";
	public static void main(String[] args) {
		
		try {
			initialization();
		}catch (Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}
//		signin();
		Test1();
		
	}
	
	public static void initialization() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "Lenovo");
		cap.setCapability("udid", "f6a8d454");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("appPackage", "com.fanzword.staging");
		cap.setCapability("appActivity", "com.fanzword.ui.activities.MainActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("Application started...");
		
	}
	
	
	public static void Test1() {
		guestLogin();
		clickIndex(BASE_VIEW_ID + "ll_match", 0);
		guestPredictScore();
		signUp();
		predictScore();
	}
	
	public static void signin(){		
		fillIn("et_email", email);
		fillIn("et_password", pw);
		click("btn_sign_in");
		
	}
	
	public static void signUp() {
		int randomNumber = rng(100000);
		fillIn(ET_USERNAME_ID, "Etch" + randomNumber);
		fillIn("et_email","EtchAutomation"+ randomNumber +"@fanzword.com");
		fillIn("et_password", pw);
		fillIn("et_confirm_password", pw);
		click("tv_country");
		clickIndex(BASE_VIEW_ID + "tv_country_name", 2);
		click("btn_create_account");
	}
	
	public static void guestLogin() {
		click("tv_skip");
		click("btn_continue");
		clickIndexRange(BASE_VIEW_ID + "sw_league", 1, 9);
		click("btn_save");
		click("actv_favorite_team");
		fillIn("actv_favorite_team","Manchester" );
		delay(2);
		(new TouchAction(driver)).tap(PointOption.point(503, 871)).perform();
		click("btn_save");
	}
	
	public static void clickIndex(String id, int index) {
		List<MobileElement> elements = listing(id);
		clickIndex(elements, index);
	}
	
	public static void guestPredictScore() {
		click("ll_predict_score");
		click("btn_create_account");
	}
	
	public static void predictScore() {
		click("ll_predict_score");
		fillIn("et_team_home_score", Integer.toString(rng(9)));
		fillIn("et_team_away_score", Integer.toString(rng(9)));
		click("btn_save");
	}
	
	public static MobileElement find(String id) {
		return driver.findElement(By.id(BASE_VIEW_ID + id));
	}
	
	public static void click(String id) {
		find(id).click();
		return;
	}
	
	public static void fillIn(String id, String text) {
		find(id).sendKeys(text);
		return;
	}
	
	public static List<MobileElement> listing(String id) {
		System.out.println("Trying to retrive the List");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MobileElement> parent = driver.findElements(By.id(id));
		System.out.println("List retrieved...");
		System.out.println(parent.size());
		return parent;
	}
	
	
	public static void clickIndex(List<MobileElement> p, int index) {
		p.get(index).click();
		return;
	}
	
	public static void clickIndexRange(String id, int i, int j) {
		List<MobileElement> elementList = listing(id);
		for(;i<=j;i++) {
			clickIndex(elementList, i);
		}
	}
	
	public static int rng(int range) {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(range);
	}
	
	public static void delay(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	private ExpectedCondition<Boolean> elementFoundAndClicked(final By locator) {
//	    return new ExpectedCondition<Boolean>() {
//	        public Boolean apply(WebDriver driver) {
//	            WebElement el = driver.findElement(locator);
//	            el.click();
//	            return true;
//	        }
//	    };
//	}
	
	
	
}
