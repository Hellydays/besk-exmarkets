package by.besk.exmarkets.entity;


import java.time.LocalTime;

public class Trade {

	private LocalTime time;
	private String price;
	private String quantity;

	public Trade() {

	}

	public Trade(LocalTime time, String price, String quantity) {
		super();
		this.time = time;
		this.price = price;
		this.quantity = quantity;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Trade [time=" + time + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
