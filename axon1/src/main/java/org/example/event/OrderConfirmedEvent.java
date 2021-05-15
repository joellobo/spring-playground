package org.example.event;

public class OrderConfirmedEvent {

	private final String orderId;

	public String getOrderId() {
		return orderId;
	}

	public OrderConfirmedEvent(String orderId) {
		super();
		this.orderId = orderId;
	}

}
