package appiumtests;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;

public class Methods {
	
	public static AndroidDriver <MobileElement> driver;
	public static WebDriverWait wait;
	public static final String BASE_VIEW_ID = "com.fanzword.staging:id/";
	
	public static final String NAV_MATCHES_TAB = "item_nav_matches";
	public static final String NAV_RANKINGS_TAB = "item_nav_rankings";
	public static final String NAV_STATISTICS_TAB = "item_nav_statistics";
	public static final String NAV_PROFILE_TAB = "item_nav_favorites";
	public static final String LIVE_BTN = "btn_live";
	public static final String CALENDAR_BTN = "btn_calender";
	public static final String DRAWER_BTN = "btn_drawer";
	public static final String MATCH_ID = "ll_match";
	public static final String RATE_PLAYER_ID = "iv_rate_player";
	public static final String RATE_PLAYER_BTN_ID = "btn_rate_player";
	public static final String RATE_PLAYER_EIGHT_BTN = "tv_eight";
	public static final String RECOMMEND_A_SUB_ID = "iv_recommend_sub";
	public static final String OUT_PLAYER_SPN = "spn_player";
	public static final String IN_PLAYER_SPN = "spn_backup_player";
	public static final String PLAYER_NAME_LISTING_ID = "tv_player_name";
	public static final String SUBMIT_BTN_ID = "btn_submit";
	public static final String SANDWITCH_ID = "btn_drawer";
	public static final String LOGOUT_ID = "tv_logout";
	public static final String CONFIRM_LOGOUT_ID = "btn_logout";
	public static final String AWAY_TEAM_SCORE_ID = "et_team_away_score";
	public static final String HOME_TEAM_SCORE_ID = "et_team_home_score";
	public static final String LL_PREDICT_SCORE_ID = "ll_predict_score";
	public static final String ACTV_FAVORITE_TEAM_ID = "actv_favorite_team";
	public static final String CONTINUE_ID = "btn_continue";
	public static final String SKIP_ID = "tv_skip";
	public static final String SAVE_ID = "btn_save";
	public static final String CREATE_ACCOUNT_ID = "btn_create_account";
	public static final String SIGN_IN_ID = "btn_sign_in";
	public static final String TV_COUNTRY_NAME_ID = "tv_country_name";
	public static final String TV_COUNTRY_ID = "tv_country";
	public static final String ET_CONFIRM_PASSWORD_ID = "et_confirm_password";
	public static final String ET_PASSWORD_ID = "et_password";
	public static final String ET_EMAIL_ID = "et_email";
	public static final String ET_USERNAME_ID = "et_username";
	
	public static String email = "hseddik@identity-solutions.org";
	public static String pw = "12345678";
	
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
	
	public static void assertElement(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID+id))).isDisplayed();
		
	}
	
	public static void assertElementText(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isDisplayed();
		
	}
	
	public static void assertIsSelected(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isSelected();
		
	}
	
//	public static boolean assertPageTitle(String id) {
//		String x = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText();
//		boolean y = x.trim() == id;
//		System.out.println(y);
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText() == id;
//	}
	
	public static int randomNumberGenerator(int range) {
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
