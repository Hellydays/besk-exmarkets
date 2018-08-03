package by.besk.exmarkets_tests;

import org.testng.annotations.Test;

import by.besk.exmarkets.pages.HomePage;

public class UserCanLogin extends BaseTest {
	
	private final String LOGIN_LINK_USER_A = "https://demo4-dev.exmarkets.com/login?email=plakhotnik.o@gmail.com";
	private final String PIN_CODE = "0633956";
	
	@Test
	public void userCanLogin() throws InterruptedException {
		HomePage homePage = stepsChrome.login(LOGIN_LINK_USER_A, PIN_CODE);
	}

}
