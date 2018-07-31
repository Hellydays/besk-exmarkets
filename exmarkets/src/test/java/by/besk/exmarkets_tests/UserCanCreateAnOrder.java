package by.besk.exmarkets_tests;

import org.testng.annotations.Test;

import by.besk.exmarkets.entity.OrderDirection;
import by.besk.exmarkets.pages.HomePage;

public class UserCanCreateAnOrder extends BaseTest {
	
	private final String LOGIN_LINK_USER_A = "https://demo4-dev.exmarkets.com/login?email=plakhotnik.o@gmail.com";
	private final String PIN_CODE = "0633956";
	
	@Test
	public void userCanLogin() throws InterruptedException {
		HomePage homePage = steps.login(LOGIN_LINK_USER_A, PIN_CODE);
		homePage = steps.createLimitOrder("20", "0.45", OrderDirection.BUY);
		
		Thread.sleep(3000);
	}

}
