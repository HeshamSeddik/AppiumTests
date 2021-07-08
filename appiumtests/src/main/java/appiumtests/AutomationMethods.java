package appiumtests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class AutomationMethods extends Methods {
	
	public static void userGuide(){
		click(GET_STARTED_BTN);
	}
	
	public static void signin(){		
		fillIn(ET_EMAIL_ID, email);
		fillIn(ET_PASSWORD_ID, pw);
		click(SIGN_IN_ID);
		
	}
	
	public static void signup() {
		int randomNumber = randomNumberGenerator(100000);
		fillIn(ET_USERNAME_ID, "Etch" + randomNumber);
		fillIn(ET_EMAIL_ID,"EtchAutomation"+ randomNumber +"@fanzword.com");
		fillIn(ET_PASSWORD_ID, pw);
		fillIn(ET_CONFIRM_PASSWORD_ID, pw);
		click(TV_COUNTRY_ID);
		clickOneIndex(TV_COUNTRY_NAME_ID, randomNumberGenerator(7));
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
		clickOneIndex("sw_league", 0);
		click(SAVE_ID);
		click(ACTV_FAVORITE_TEAM_ID);
		fillIn(ACTV_FAVORITE_TEAM_ID,"Ma" );
		delay(2);
		(new TouchAction(driver)).tap(PointOption.point(309, 534)).perform();
		click(SAVE_ID);
	}
	
	public static void ratePlayer() {
		click(RATE_PLAYER_ID);
		click(RATE_PLAYER_BTN_ID);
		randomPlayerRating(Integer.toString(randomNumberGenerator(9)+1));
	}
	
	public static void rateGoal() {
		click(RATE_GOAL_ID);
		randomGoalRating();
	}
	
	public static void recommendSub() {
		click(RECOMMEND_A_SUB_ID);
		click(OUT_PLAYER_SPN_ID);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(IN_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(SUBMIT_BTN_ID);
	}
	
	public static void predictScore() {
		click(LL_PREDICT_SCORE_ID);
		fillIn(HOME_TEAM_SCORE_ID, Integer.toString(randomNumberGenerator(9)));
		fillIn(AWAY_TEAM_SCORE_ID, Integer.toString(randomNumberGenerator(9)));
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
		randomPlayerRating(Integer.toString(randomNumberGenerator(9)+1));
	}
	
	public static void guestRecommendSub() {
		click(RECOMMEND_A_SUB_ID);
		click(OUT_PLAYER_SPN_ID);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(IN_PLAYER_SPN);
		clickOneIndex(PLAYER_NAME_LISTING_ID, 1);
		click(SUBMIT_BTN_ID);
		click(CREATE_ACCOUNT_ID);
		signup();
		click(SUBMIT_BTN_ID);
	}
	
	public static void guestRateGoal() {
		click(RATE_GOAL_ID);
		click(GOAL_RATING_SLIDER_ID);
		click(CREATE_ACCOUNT_ID);
		signup();
		click(GOAL_RATING_SLIDER_ID);
		randomGoalRating();
	}
	
	public static void backToMainScreen() {
		while(assertElementBool(BACK_BTN_ID)) {
			click(BACK_BTN_ID);
		}
	}
}
