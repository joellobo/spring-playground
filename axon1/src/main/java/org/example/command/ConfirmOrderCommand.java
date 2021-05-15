package org.example.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class ConfirmOrderCommand {
	
	@TargetAggregateIdentifier
    private final String orderId;

	public ConfirmOrderCommand(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

}
