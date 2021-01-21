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
	
	static AppiumDriver<MobileElement> driver;
	final static String BASE_VIEW_ID = "com.fanzword.staging:id/";
	private static final String ET_TEAM_AWAY_SCORE_ID = "et_team_away_score";
	private static final String ET_TEAM_HOME_SCORE_ID = "et_team_home_score";
	private static final String LL_PREDICT_SCORE_ID = "ll_predict_score";
	private static final String ACTV_FAVORITE_TEAM_ID = "actv_favorite_team";
	private static final String CONTINUE_ID = "btn_continue";
	private static final String SKIP_ID = "tv_skip";
	private static final String SAVE_ID = "btn_save";
	private static final String CREATE_ACCOUNT_ID = "btn_create_account";
	private static final String SIGN_IN_ID = "btn_sign_in";
	private static final String TV_COUNTRY_NAME_ID = "tv_country_name";
	private static final String TV_COUNTRY_ID = "tv_country";
	private static final String ET_CONFIRM_PASSWORD_ID = "et_confirm_password";
	private static final String ET_PASSWORD_ID = "et_password";
	private static final String ET_EMAIL_ID = "et_email";
	private static final String ET_USERNAME_ID = "et_username";
	
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
		fillIn(ET_EMAIL_ID, email);
		fillIn(ET_PASSWORD_ID, pw);
		click(SIGN_IN_ID);
		
	}
	
	public static void signUp() {
		int randomNumber = rng(100000);
		fillIn(ET_USERNAME_ID, "Etch" + randomNumber);
		fillIn(ET_EMAIL_ID,"EtchAutomation"+ randomNumber +"@fanzword.com");
		fillIn(ET_PASSWORD_ID, pw);
		fillIn(ET_CONFIRM_PASSWORD_ID, pw);
		click(TV_COUNTRY_ID);
		clickIndex(BASE_VIEW_ID + TV_COUNTRY_NAME_ID, 2);
		click(CREATE_ACCOUNT_ID);
	}
	
	public static void guestLogin() {
		click(SKIP_ID);
		click(CONTINUE_ID);
		clickIndexRange(BASE_VIEW_ID + "sw_league", 1, 9);
		click(SAVE_ID);
		click(ACTV_FAVORITE_TEAM_ID);
		fillIn(ACTV_FAVORITE_TEAM_ID,"Manchester" );
		delay(2);
		(new TouchAction(driver)).tap(PointOption.point(503, 871)).perform();
		click(SAVE_ID);
	}
	
	public static void clickIndex(String id, int index) {
		List<MobileElement> elements = listing(id);
		clickIndex(elements, index);
	}
	
	public static void guestPredictScore() {
		click(LL_PREDICT_SCORE_ID);
		click(CREATE_ACCOUNT_ID);
	}
	
	public static void predictScore() {
		click(LL_PREDICT_SCORE_ID);
		fillIn(ET_TEAM_HOME_SCORE_ID, Integer.toString(rng(9)));
		fillIn(ET_TEAM_AWAY_SCORE_ID, Integer.toString(rng(9)));
		click(SAVE_ID);
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
