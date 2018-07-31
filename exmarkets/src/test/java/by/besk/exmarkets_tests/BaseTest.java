package by.besk.exmarkets_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import by.besk.exmarkets.steps.Steps;

public abstract class BaseTest {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "src/main/resources/chromedriver";
	
	protected WebDriver driver;
	protected Steps steps;
	
	@BeforeTest
	public void setUpTest() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
		steps = new Steps(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void finish() {
		driver.close();
		
	}

}
