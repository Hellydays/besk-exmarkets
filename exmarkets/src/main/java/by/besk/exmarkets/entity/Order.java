package by.besk.exmarkets.entity;

import java.time.LocalDateTime;

public class Order {

	private int id;
	private OrderDirection direction;
	private String pair;
	private String amount;
	private String price;
	private String total;
	private String status;
	private LocalDateTime createdAt;

	public Order() {

	}

	public Order(int id, OrderDirection direction, String pair, String amount, String price, String total,
			String status, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.direction = direction;
		this.pair = pair;
		this.amount = amount;
		this.price = price;
		this.total = total;
		this.status = status;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderDirection getDirection() {
		return direction;
	}

	public void setDirection(OrderDirection direction) {
		this.direction = direction;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", direction=" + direction + ", pair=" + pair + ", amount=" + amount + ", price="
				+ price + ", total=" + total + ", status=" + status + ", createdAt=" + createdAt + "]";
	}


}
