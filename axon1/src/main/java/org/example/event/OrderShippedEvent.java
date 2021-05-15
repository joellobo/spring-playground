package org.example.event;

public class OrderShippedEvent {

	private final String orderId;

	public String getOrderId() {
		return orderId;
	}

	public OrderShippedEvent(String orderId) {
		super();
		this.orderId = orderId;
	}

}
