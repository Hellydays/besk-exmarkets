package by.besk.exmarkets.pages;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.besk.exmarkets.entity.OrderDirection;
import by.besk.exmarkets.entity.Trade;

public class HomePage extends AbstractPage {

	@FindBy(css = "div[class = 'sc-CtfFt iDEcMD'] input[name='amount']")
	List<WebElement> limitAmountInputs;

	@FindBy(css = "div[class = 'sc-CtfFt iDEcMD'] input[name='price']")
	List<WebElement> limitPriceInputs;

	@FindBy(css = "div[class = 'sc-CtfFt iDEcMD'] button[class='sc-iQNlJl obcEF']")
	WebElement limitBuyButton;

	@FindBy(css = "div[class = 'sc-CtfFt iDEcMD'] button[class='sc-iQNlJl ihVaYs']")
	WebElement limitSellButton;

	@FindBy(css = " ul[class='sc-csuQGl hHWhox'] a[href='/funds/open-orders']")
	WebElement openOrdersMenuButton;

	@FindBy(css = "div[class='sc-VJcYb gBzEEx'] table  tbody tr")
	List<WebElement> orderBookOrders;

	@FindBy(css = "div[class='sc-btzYZH khKPEr'] div tr")
	List<WebElement> recentTradesOrders;


	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);

	@Override
	public void openPage() {

	}

	public void enterAmount(String amount, OrderDirection direction) {
		
		WebElement limitAmountField = null;
		System.out.println(limitAmountInputs.size());

		switch (direction) {
		case BUY:
			limitAmountField = limitAmountInputs.get(0);
			break;
		case SELL:
			limitAmountField = limitAmountInputs.get(1);
		}

		limitAmountField.click();
		limitAmountField.sendKeys(amount);
	}

	public void enterPrice(String price, OrderDirection direction) {
		WebElement limitPriceField = null;

		switch (direction) {
		case BUY:
			limitPriceField = limitPriceInputs.get(0);
			break;
		case SELL:
			limitPriceField = limitPriceInputs.get(1);
		}

		limitPriceField.click();
		limitPriceField.clear();
		limitPriceField.sendKeys(price);
	}

	public void submitLimitOrder(OrderDirection direction) {
		switch (direction) {
		case BUY:
			wait.until(ExpectedConditions.elementToBeClickable(limitBuyButton));
			limitBuyButton.click();
			break;
		case SELL:
			wait.until(ExpectedConditions.elementToBeClickable(limitBuyButton));
			limitSellButton.click();
		}
	}

	public void navigateToOpenOrders() {
		openOrdersMenuButton.click();
	}

	public List<Trade> getRecentTrades() {
		List<WebElement> orderPropertiesList = null;
		List<Trade> recentTrades = new ArrayList<>();

		Trade trade = new Trade();

		if (recentTradesOrders != null && recentTradesOrders.size() > 0) {
			for (WebElement element : recentTradesOrders) {
				orderPropertiesList = element.findElements(By.tagName("td"));
				trade.setTime(convertTime(orderPropertiesList.get(0).getText()));
				trade.setPrice(orderPropertiesList.get(1).getText());
				trade.setQuantity(orderPropertiesList.get(2).getText());
				recentTrades.add(trade);

				System.out.println(trade.toString());
			}
		} else {
			System.out.println("There are no recent trades");
		}

		return recentTrades;
	}
	
	public void getOrderBook() {
		for(WebElement element : orderBookOrders) {
			
		}
		
	}

	public LocalTime convertTime(String time) {
		LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mm:ss a"));
		return localTime;

	}

}
