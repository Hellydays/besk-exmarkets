package by.besk.exmarkets.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.besk.exmarkets.entity.OrderDirection;

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

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void enterAmount(String amount, OrderDirection direction) {
		WebElement limitAmountField = null;

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
			limitBuyButton.click();
			break;
		case SELL:
			limitSellButton.click();
		}

	}
	
	public void navigateToOpenOrders() {
		openOrdersMenuButton.click();
	}

}
