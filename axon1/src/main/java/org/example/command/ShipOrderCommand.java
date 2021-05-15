package org.example.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ShipOrderCommand {
	
	@TargetAggregateIdentifier
    private final String orderId;

	public String getOrderId() {
		return orderId;
	}

	public ShipOrderCommand(String orderId) {
		super();
		this.orderId = orderId;
	}

}
