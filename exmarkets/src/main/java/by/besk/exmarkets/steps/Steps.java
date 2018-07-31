package by.besk.exmarkets.steps;

import org.openqa.selenium.WebDriver;

import by.besk.exmarkets.pages.EnteringPinPage;
import by.besk.exmarkets.pages.HomePage;

public class Steps {

	WebDriver driver;

	public Steps(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePage login(String pin) throws InterruptedException {

		EnteringPinPage enteringPinPage = new EnteringPinPage(driver);
		enteringPinPage.openPage();
		enteringPinPage.enterPIN(pin);
		enteringPinPage.submitPIN();

		HomePage homePage = new HomePage(driver);
		return homePage;

	}

}
