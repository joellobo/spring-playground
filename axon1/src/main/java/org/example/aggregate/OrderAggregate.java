package org.example.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.example.command.ConfirmOrderCommand;
import org.example.command.PlaceOrderCommand;
import org.example.command.ShipOrderCommand;
import org.example.event.OrderConfirmedEvent;
import org.example.event.OrderPlacedEvent;
import org.example.event.OrderShippedEvent;

public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;
	private boolean orderConfirmed;
	private FixtureConfiguration<OrderAggregate> fixture;

	@CommandHandler
	public OrderAggregate(PlaceOrderCommand command) {
		AggregateLifecycle.apply(new OrderPlacedEvent(command.getOrderId(), command.getProduct()));
	}

	@EventSourcingHandler
	public void on(OrderPlacedEvent event) {
		this.orderId = event.getOrderId();
		orderConfirmed = false;
	}

	protected OrderAggregate() {
	}
	
	@CommandHandler 
	public void handle(ConfirmOrderCommand command) { 
		AggregateLifecycle.apply(new OrderConfirmedEvent(orderId)); 
	} 

	@CommandHandler 
	public void handle(ShipOrderCommand command) { 
	    if (!orderConfirmed) { 
	        throw new UnconfirmedOrderException(); 
	    } 
	    AggregateLifecycle.apply(new OrderShippedEvent(orderId)); 
	} 

	@EventSourcingHandler 
	public void on(OrderConfirmedEvent event) { 
	    orderConfirmed = true; 
	}

}
