package appiumtests;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.PointOption;

public class Methods {
	
	public static AndroidDriver <MobileElement> driver;
	public static WebDriverWait wait;
	public static final String BASE_VIEW_ID = "com.fanzword.staging:id/";
	
	public static final String GET_STARTED_BTN = "btn_get_started";
	public static final String NAV_MATCHES_TAB = "item_nav_matches";
	public static final String NAV_RANKINGS_TAB = "item_nav_rankings";
	public static final String NAV_STATISTICS_TAB = "item_nav_statistics";
	public static final String NAV_PROFILE_TAB = "item_nav_favorites";
	public static final String DONT_HAVE_ACCOUNT_ID = "tv_dont_have_account";
	public static final String FACEBOOK_BTN_ID = "btn_facebook";
	public static final String FORGOT_PASSWORD_BTN_ID = "tv_forgot_password";	
	public static final String LIVE_BTN = "btn_live";
	public static final String CALENDAR_BTN = "btn_calender";
	public static final String DRAWER_BTN = "btn_drawer";
	public static final String MATCH_ID = "ll_match";
	public static final String RATE_PLAYER_ID = "iv_rate_player";
	public static final String RATE_PLAYER_BTN_ID = "btn_rate_player";
	public static final String RECOMMEND_A_SUB_ID = "iv_recommend_sub";
	public static final String OUT_PLAYER_SPN_ID = "spn_player";
	public static final String IN_PLAYER_SPN = "spn_backup_player";
	public static final String PLAYER_NAME_LISTING_ID = "tv_player_name";
	public static final String SUBMIT_BTN_ID = "btn_submit";
	public static final String SANDWITCH_ID = "btn_drawer";
	public static final String LOGOUT_ID = "tv_logout";
	public static final String CONFIRM_LOGOUT_ID = "btn_confirm_dialog_text";
	public static final String AWAY_TEAM_SCORE_ID = "et_team_away_score";
	public static final String HOME_TEAM_SCORE_ID = "et_team_home_score";
	public static final String LL_PREDICT_SCORE_ID = "ll_predict_score";
	public static final String ACTV_FAVORITE_TEAM_ID = "actv_favorite_team";
	public static final String CONTINUE_ID = "btn_continue";
	public static final String SKIP_ID = "btn_skip";
	public static final String SAVE_ID = "btn_save";
	public static final String CREATE_ACCOUNT_ID = "btn_create_account";
	public static final String SIGN_IN_ID = "btn_sign_in";
	public static final String TV_COUNTRY_NAME_ID = "tv_country_name";
	public static final String TV_COUNTRY_ID = "tv_country";
	public static final String ET_CONFIRM_PASSWORD_ID = "et_confirm_password";
	public static final String ET_PASSWORD_ID = "et_password";
	public static final String ET_EMAIL_ID = "et_email";
	public static final String ET_USERNAME_ID = "et_username";
	public static final String BACK_BTN_ID = "btn_back";
	public static final String DAYS_BAR_YESTERDAY = "//android.widget.TextView[@text = 'Yesterday']";
	public static final String DAYS_BAR_TOMORROW = "//android.widget.TextView[@text = 'Tomorrow']";
	public static final String TOAST_XPATH = "//android.widget.Toast[1]";
	public static final String RATE_GOAL_ID = "iv_rate_goal";
	public static final String SUCCESSFUL_RECOMMENDATION = "Substitution submitted successfully";
	public static final String GOAL_RATING_SLIDER_ID = "sb_player_rate";
	public static final String USER_GOAL_RATING_ID = "tv_user_rate";
	public static final String MATCH_DISCUSSIONS_ID = "iv_match_discussion";
	public static final String CREATE_POST_ID = "btn_create_post";
	public static final String CHOOSE_TOPIC_ID = "rl_choose_topic";
	public static final String EVENT_ID = "tv_event";
	public static final String POST_TEXT_ID = "et_your_opinion";
	public static final String GIPHY_BTN_ID = "btn_choose_giphy";
	public static final String GIF_CLASS_NAME = "android.widget.ImageView";
	public static final String SUBMITTED_POST_TEXT_ID = "tv_opinion";
	
	public static final String postText = "This is an automated text for testing the create post feature";
	
	
	public static String email = "etch@fanzword.com";
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
		find(id).click();
		return;
	}
	
	public static void fillIn(String id, String text) {
		find(id).sendKeys(text);
		return;
	}
	
	public static void selectMatch(int index) {
		if(assertElementBool(MATCH_ID)) {
			clickOneIndex(MATCH_ID, index);
		}
		else {
//			driver.findElementByXPath(DAYS_BAR_YESTERDAY).click();
			click(LIVE_BTN);
			clickOneIndex(MATCH_ID, index);
		}
	}
	
	
	public static List<MobileElement> listing(String id) {	
//		System.out.println("Trying to retrieve the List");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + id)));
		wait.until(elementFound(By.id(BASE_VIEW_ID + id)));
		List<MobileElement> parent = driver.findElements(By.id(BASE_VIEW_ID + id));
//		System.out.println("List retrieved...");
//		System.out.println(parent.size());
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
	
	public static void randomPlayerRating(String index) {
		System.out.println("Player rating "+index);
		driver.findElementByXPath("//android.widget.TextView[@text = '"+index+"']").click();
		
	}
	
	public static void selectClassName(String className) {
		wait.until(elementFound(By.className(className)));
		driver.findElements(By.className(className)).get(6).click();
	}
	
	public static void assertElement(String id) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID+id))).isDisplayed();
	}
	
	public static boolean assertElementBool(String id) {

		boolean elementVisibility = false;
		if(driver.findElementsById(BASE_VIEW_ID+id).size() > 0 ) {
			elementVisibility = true;
		}
		
		return elementVisibility;
	}
	
	public static void assertText(String id, String expected) {
		
		boolean textAssertion = false;
		if(driver.findElementById(BASE_VIEW_ID+id).getText().equalsIgnoreCase(expected)) {
			textAssertion = true;
		}
		if(textAssertion) {
			System.out.println("Success, the submitted text is the same as the actual text");
		}else {
			System.out.println("Failure, the submitted text doesn't match the actual text");
		}
	}
	
	public static void assertElementText(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isDisplayed();
	}
	
	public static void assertIsSelected(String description) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(description))).isSelected();
	}
	
	public static boolean assertPageTitle(String id) {
		String x = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText();
		boolean y = x.trim() == id;
		System.out.println(y);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BASE_VIEW_ID + "tv_title"))).getText() == id;
	}
	
	public static void assertToastMessage(String expected) {
		
		String toastMessage = driver.findElementByXPath(TOAST_XPATH).getAttribute("name");
		Assert.assertEquals(expected, toastMessage);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[1]").getAttribute("name")));
				
	}
	
	
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
	
	public static void randomGoalRating() {
		
		WebElement slider = driver.findElementById(BASE_VIEW_ID + GOAL_RATING_SLIDER_ID);
		int xAxisStartPoint = slider.getLocation().getX();
		int xAxisEndPoint = xAxisStartPoint + slider.getSize().getWidth();
		int yAxis = slider.getLocation().getY();
		int moveTo = randomNumberGenerator(slider.getSize().getWidth()-1);
		System.out.println(xAxisStartPoint + "\n" + xAxisEndPoint  + "\n" + yAxis);
		String initialValue = driver.findElementById(BASE_VIEW_ID + USER_GOAL_RATING_ID).getText();
		TouchAction t = new TouchAction(driver);
		t.longPress(PointOption.point(xAxisStartPoint+20,yAxis)).moveTo(PointOption.point(moveTo,yAxis)).release().perform();
		String endValue = driver.findElementById("com.fanzword.staging:id/tv_user_rate").getText();
		
		if(initialValue.equalsIgnoreCase(endValue)) {
			System.out.println("initialValue = "+ initialValue + "\nendValue = "+ endValue + "\nUnsuccessful goal rating");
		}
		else {
			System.out.println("initialValue = "+ initialValue + "\nendValue = "+ endValue + "\nSuccessful goal rating");
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
