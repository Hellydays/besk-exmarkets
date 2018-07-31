package by.besk.exmarkets.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnteringPinPage extends AbstractPage {

	//hard-coded link 
	private final String LOGIN_LINK = "https://demo4-dev.exmarkets.com/login?email=plakhotnik.o@gmail.com";

	@FindBy(css = "input[name = 'pin']")
	WebElement inputPIN;
	
	@FindBy(css = "button[type = 'submit']")
	WebElement submitPIN;

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public EnteringPinPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(LOGIN_LINK);

	}

	public void enterPIN(String pin) throws InterruptedException {
		
		Thread.sleep(2000); //this is extremely bad solution but the only that works, tried implicitly wait, 
		//expectedEconditions it doesn't help
		
		inputPIN.click();
		inputPIN.click();
		inputPIN.sendKeys(pin);
	}
	
	public void submitPIN() {
		submitPIN.click();
	}

}
