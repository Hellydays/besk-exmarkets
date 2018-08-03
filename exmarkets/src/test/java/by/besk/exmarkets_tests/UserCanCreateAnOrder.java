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
	
//	private final String LOGIN_LINK_USER_3 = "http://demo4-dev.exmarkets.com/login?email=powardev@ya.ru";
//	private final String PIN_CODE_USER_3 = "4218181";

	@Test
	public void orderMatching() throws InterruptedException {
		
		startChrome();
	
		HomePage homePage = stepsChrome.login(LOGIN_LINK_USER_1, PIN_CODE_USER_1);
		
		//to re-check what can be done here to avoid using .sleep:
		stepsChrome.createLimitOrder("1.2", "0.5566", OrderDirection.SELL);
		Thread.sleep(1000);
		stepsChrome.createLimitOrder("1", "0.5564", OrderDirection.SELL);
		Thread.sleep(1000);
		stepsChrome.createLimitOrder("0.75", "0.55635", OrderDirection.SELL);
		Thread.sleep(1000);
		stepsChrome.createLimitOrder("3", "0.55630", OrderDirection.SELL);
		Thread.sleep(1000);
		
		startFirefox();
		
		HomePage homePage2 = stepsFirefox.login(LOGIN_LINK_USER_2, PIN_CODE_USER_2);
		Thread.sleep(2000);
		stepsFirefox.createLimitOrder("0.4", "0.5568", OrderDirection.BUY);
		Thread.sleep(1000);
		stepsFirefox.createLimitOrder("0.5", "0.55635", OrderDirection.BUY);
		Thread.sleep(1000);
		stepsFirefox.createLimitOrder("2.5", "0.55637", OrderDirection.BUY);
		Thread.sleep(1000);
		stepsFirefox.createLimitOrder("3", "0.55629", OrderDirection.BUY);
		Thread.sleep(1000);
		stepsFirefox.createLimitOrder("0.5", "0.55639", OrderDirection.BUY);
		
		stepsFirefox.getRecentTrades();
		
		// this .sleep is used just to see the results in real-time and can be removed anytime
		Thread.sleep(3000);
	}

}
