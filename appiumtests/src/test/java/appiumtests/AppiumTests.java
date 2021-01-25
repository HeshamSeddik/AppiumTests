package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
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

public class AppiumTests {
	
	static AndroidDriver<MobileElement> driver;
	static WebDriverWait wait;
	private static final String BASE_VIEW_ID = "com.fanzword.staging:id/";
	
	private static final String MATCH_ID = "ll_match";
	private static final String RATE_PLAYER_ID = "iv_rate_player";
	private static final String RATE_PLAYER_BTN_ID = "btn_rate_player";
	private static final String RATE_PLAYER_EIGHT_BTN = "tv_eight";
	private static final String RECOMMEND_A_SUB_ID = "iv_recommend_sub";
	private static final String OUT_PLAYER_SPN = "spn_player";
	private static final String IN_PLAYER_SPN = "spn_backup_player";
	private static final String PLAYER_NAME_LISTING_ID = "tv_player_name";
	private static final String SUBMIT_BTN_ID = "btn_submit";
	private static final String SANDWITCH_ID = "btn_drawer";
	private static final String LOGOUT_ID = "tv_logout";
	private static final String CONFIRM_LOGOUT_ID = "btn_logout";
	private static final String AWAY_TEAM_SCORE_ID = "et_team_away_score";
	private static final String HOME_TEAM_SCORE_ID = "et_team_home_score";
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
	
	
	
	public static void signin(){		
		fillIn(ET_EMAIL_ID, email);
		fillIn(ET_PASSWORD_ID, pw);
		click(SIGN_IN_ID);
		
	}
	
	public static void signup() {
		int randomNumber = rng(100000);
		fillIn(ET_USERNAME_ID, "Etch" + randomNumber);
		fillIn(ET_EMAIL_ID,"EtchAutomation"+ randomNumber +"@fanzword.com");
		fillIn(ET_PASSWORD_ID, pw);
		fillIn(ET_CONFIRM_PASSWORD_ID, pw);
		click(TV_COUNTRY_ID);
		clickOneIndex(TV_COUNTRY_NAME_ID, rng(7));
		click(CREATE_ACCOUNT_ID);
	}
	
	public static void logout() {
		click(SANDWITCH_ID);
		click(LOGOUT_ID);
		click(CONFIRM_LOGOUT_ID);
	}
	
	public static void guestLogin() {
		click(SKIP_ID);
		click(CONTINUE_ID);
		clickIndexRange("sw_league", 1, 9);
		click(SAVE_ID);
		click(ACTV_FAVORITE_TEAM_ID);
		fillIn(ACTV_FAVORITE_TEAM_ID,"Manchester" );
		delay(2);
		(new TouchAction(driver)).tap(PointOption.point(503, 871)).perform();
		click(SAVE_ID);
	}
	
	public static void ratePlayer() {
		click(RATE_PLAYER_ID);
		click(RATE_PLAYER_BTN_ID);
		click(RATE_PLAYER_EIGHT_BTN);
	}
	
	public static void recommendSub() {
		click(RECOMMEND_A_SUB_ID);
		click(OUT_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(IN_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(SUBMIT_BTN_ID);
	}
	
	public static void predictScore() {
		click(LL_PREDICT_SCORE_ID);
		fillIn(HOME_TEAM_SCORE_ID, Integer.toString(rng(9)));
		fillIn(AWAY_TEAM_SCORE_ID, Integer.toString(rng(9)));
		click(SAVE_ID);
	}
	
	public static void guestPredictScore() {
		click(LL_PREDICT_SCORE_ID);
		click(CREATE_ACCOUNT_ID);
		signup();
		predictScore();
	}
	
	public static void guestRatePlayer() {
		click(RATE_PLAYER_ID);
		click(RATE_PLAYER_BTN_ID);
		click(CREATE_ACCOUNT_ID);
		signup();
		click(RATE_PLAYER_BTN_ID);
		click(RATE_PLAYER_EIGHT_BTN);
	}
	
	public static void guestRecommendSub() {
		click(RECOMMEND_A_SUB_ID);
		click(OUT_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(IN_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(SUBMIT_BTN_ID);
		click(CREATE_ACCOUNT_ID);
		signup();
		click(SUBMIT_BTN_ID);
	}
	
	public static void clickOneIndex(String id, int index) {
		List<MobileElement> elements = listing(id);
		clickIndex(elements, index);
	}
	
	public static MobileElement find(String id) {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		return driver.findElement(By.id(BASE_VIEW_ID + id));
	}
	
	public static void click(String id) {
//		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		find(id).click();
		return;
	}
	
	public static void fillIn(String id, String text) {
		find(id).sendKeys(text);
		return;
	}
	public static void selectMatch(int index) {
		clickOneIndex(MATCH_ID, index);
	}
	
	public static List<MobileElement> listing(String id) {
		System.out.println("Trying to retrive the List");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		List<MobileElement> parent = driver.findElements(By.id(BASE_VIEW_ID + id));
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
	
	
	
	private static ExpectedCondition<Boolean> elementFound(final By locator) {
	    return new ExpectedCondition<Boolean>() {
	    	public Boolean apply(WebDriver driver) {
	            WebElement el = driver.findElement(locator);
	            return el != null;
	        }
	    };
	}
	
//	private static ExpectedCondition<Boolean> elementsFound(final By locator) {
//	    return new ExpectedCondition<Boolean>() {
//	    	public Boolean apply(WebDriver driver) {
//	    		List<WebElement> el = driver.findElements(locator);
//	            return el != null;
//	        }
//	    };
//	}
	
}
