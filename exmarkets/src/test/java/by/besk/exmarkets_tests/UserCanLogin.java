package by.besk.exmarkets_tests;

import org.testng.annotations.Test;

import by.besk.exmarkets.pages.EnteringPIN;

public class UserCanLogin extends BaseTest {
	
	private final String PIN_CODE = "0633956";
	
	@Test
	public void userCanLogin() throws InterruptedException {
		EnteringPIN emp = new EnteringPIN(driver);
		emp.openPage();
		emp.enterPIN(PIN_CODE);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
