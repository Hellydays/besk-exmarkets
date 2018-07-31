package by.besk.exmarkets.entity;

public class Order {
	
	private String amount;
	private String price;
	private OrderDirection direction;
	
	public Order() {
		
	}
	
	public Order(String amount, String price, OrderDirection direction) {
		super();
		this.amount = amount;
		this.price = price;
		this.direction = direction;
	}
	
	

}
