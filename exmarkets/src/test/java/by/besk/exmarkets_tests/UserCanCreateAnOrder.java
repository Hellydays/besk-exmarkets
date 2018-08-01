package by.besk.exmarkets_tests;

import org.testng.annotations.Test;

import by.besk.exmarkets.entity.OrderDirection;
import by.besk.exmarkets.pages.HomePage;
import by.besk.exmarkets.pages.OpenOrdersPage;

public class UserCanCreateAnOrder extends BaseTest {
	
	private final String LOGIN_LINK_USER_1 = "https://demo4-dev.exmarkets.com/login?email=plakhotnik.o@gmail.com";
	private final String PIN_CODE_USER_1 = "0633956";
	
	private final String LOGIN_LINK_USER_2 = "https://demo4-dev.exmarkets.com/login?email=e.skorodilo@besk.com";
	private final String PIN_CODE_USER_2 = "2100938";
	
	private final String LOGIN_LINK_USER_3 = "http://demo4-dev.exmarkets.com/login?email=powardev@ya.ru";
	private final String PIN_CODE_USER_3 = "4218181";
	
	
	
	@Test
	public void userCanCreateAnOrder() throws InterruptedException {
		HomePage homePage = steps.login(LOGIN_LINK_USER_1, PIN_CODE_USER_1);
		steps.createLimitOrder("2", "0.055", OrderDirection.BUY);
		
		//to re-check what can be done here to avoid using .sleep
		Thread.sleep(3000);
		
		steps.createLimitOrder("1", "0.05", OrderDirection.BUY);
		
		OpenOrdersPage openOrdersPage = steps.getOpenOrders();
		
		// this .sleep is used just to see the results in real-time and can be removed anytime
		Thread.sleep(3000);
	}

}
