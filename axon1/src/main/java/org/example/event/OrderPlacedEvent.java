package org.example.event;

public class OrderPlacedEvent {

	private final String orderId;
	private final String product;

	public String getOrderId() {
		return orderId;
	}

	public String getProduct() {
		return product;
	}

	public OrderPlacedEvent(String orderId, String product) {
		super();
		this.orderId = orderId;
		this.product = product;
	}

}
