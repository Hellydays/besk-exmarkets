package by.besk.exmarkets.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.besk.exmarkets.entity.Order;
import by.besk.exmarkets.entity.OrderDirection;

public class OpenOrdersPage extends AbstractPage {

	@FindBy(css = "tbody tr")
	List<WebElement> listOfOpenOrders;

	public OpenOrdersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {

	}

	public void getListOfOpenOrders() {
		List<WebElement> orderPropertiesList = null;
		Order order = new Order();
		if (listOfOpenOrders != null && listOfOpenOrders.size() > 0) {
			for (WebElement element : listOfOpenOrders) {

				orderPropertiesList = element.findElements(By.tagName("td"));
				order.setId(Integer.parseInt(orderPropertiesList.get(0).getText()));
				order.setDirection(getOrderDirection(orderPropertiesList.get(1).getText()));

				order.setPair(orderPropertiesList.get(2).getText());
				order.setAmount(orderPropertiesList.get(3).getText());
				order.setPrice(orderPropertiesList.get(4).getText());
				order.setTotal(orderPropertiesList.get(5).getText());
				order.setStatus(orderPropertiesList.get(6).getText());
				order.setCreatedAt(convertToDate(orderPropertiesList.get(7).getText()));

				System.out.println(order.toString());
			}
		} else {
			System.out.println("No Open Orders");
		}

	}

	public OrderDirection getOrderDirection(String directionString) {
		OrderDirection direction = null;
		switch (directionString) {
		case "BUY":
			direction = direction.BUY;
			break;
		case "SELL":
			direction = direction.SELL;
		}
		return direction;
	}

	public LocalDateTime convertToDate(String dateSample) {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMM d, h:mm:ss a")
				.parseDefaulting(ChronoField.YEAR, 2018).toFormatter();
		LocalDateTime localDate = LocalDateTime.parse(dateSample, formatter);
		return localDate;
	}

}
