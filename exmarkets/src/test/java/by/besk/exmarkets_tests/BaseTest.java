package by.besk.exmarkets_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.besk.exmarkets.steps.Steps;

public abstract class BaseTest {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "src/main/resources/chromedriver";
	
	private static final String FIREFOX = "webdriver.gecko.driver";
	private static final String FIREFOX_PATH = "src/main/resources/geckodriver";
	

	protected Steps stepsChrome;
	protected Steps stepsFirefox;
	
	public void startChrome() {
		System.setProperty(CHROME, CHROME_PATH);
		stepsChrome = setConfigureBrowserDriver(new ChromeDriver());
		System.out.println("Chrome setup");
	}
	
	public void startFirefox() {
		System.setProperty(FIREFOX, FIREFOX_PATH);
		stepsFirefox = setConfigureBrowserDriver(new FirefoxDriver());
		System.out.println("Firefox setup");
	}
	
	public Steps setConfigureBrowserDriver(WebDriver driver) {	
		Steps steps = new Steps(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		return steps;
	}

	//for now is not called
	public void finish(WebDriver driver) {
		driver.close();
		System.out.println("chrome closed");
	}

}
