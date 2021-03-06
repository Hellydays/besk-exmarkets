package by.besk.exmarkets.steps;

import org.openqa.selenium.WebDriver;

import by.besk.exmarkets.entity.Order;
import by.besk.exmarkets.entity.OrderDirection;
import by.besk.exmarkets.pages.EnteringPinPage;
import by.besk.exmarkets.pages.HomePage;
import by.besk.exmarkets.pages.OpenOrdersPage;

public class Steps {

	WebDriver driver;

	public Steps(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePage login(String userLink, String pin) throws InterruptedException {

		EnteringPinPage enteringPinPage = new EnteringPinPage(driver);
		enteringPinPage.openPage();
		enteringPinPage.goToPIN(userLink);
		enteringPinPage.enterPIN(pin);
		enteringPinPage.submitPIN();

		HomePage homePage = new HomePage(driver);
		return homePage;

	}
	
	public HomePage createLimitOrder(String amount, String price, OrderDirection direction) {
		HomePage homePage = new HomePage(driver);
		homePage.enterAmount(amount, direction);
		homePage.enterPrice(price, direction);
		homePage.submitLimitOrder(direction);
		return homePage;
	}
	
	public OpenOrdersPage getOpenOrders() {
		HomePage homePage = new HomePage(driver);
		homePage.navigateToOpenOrders();
		
		driver.navigate().refresh();
		
		OpenOrdersPage openOrdersPage = new OpenOrdersPage(driver);
		openOrdersPage.getListOfOpenOrders();
		return openOrdersPage;
	}
	
	public HomePage getRecentTrades() {
		HomePage homePage = new HomePage(driver);
		homePage.getRecentTrades();
		return homePage;
	}

}
