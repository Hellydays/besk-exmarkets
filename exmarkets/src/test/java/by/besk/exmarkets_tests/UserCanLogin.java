package by.besk.exmarkets_tests;

import org.testng.annotations.Test;

import by.besk.exmarkets.pages.HomePage;

public class UserCanLogin extends BaseTest {
	
	private final String PIN_CODE = "0633956";
	
	@Test
	public void userCanLogin() throws InterruptedException {
		HomePage homePage = steps.login(PIN_CODE);
	}

}
