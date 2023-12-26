package com.occulue.aggregate;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

/**
 * Aggregate handler for Money as outlined for the CQRS pattern, all write responsibilities 
 * related to Money are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MoneyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MoneyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MoneyAggregate(CreateMoneyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMoneyCommand" );
    	CreateMoneyEvent event = new CreateMoneyEvent(command.getMoneyId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMoneyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMoneyCommand" );
    	UpdateMoneyEvent event = new UpdateMoneyEvent(command.getMoneyId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMoneyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMoneyCommand" );
        apply(new DeleteMoneyEvent(command.getMoneyId()));
    }

	// ----------------------------------------------
	// association command handlers
	// ----------------------------------------------

    // single association commands

    // multiple association commands

	// ----------------------------------------------
	// intrinsic event source handlers
	// ----------------------------------------------
    @EventSourcingHandler
    void on(CreateMoneyEvent event) {	
    	LOGGER.info( "Event sourcing CreateMoneyEvent" );
    	this.moneyId = event.getMoneyId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateMoneyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID moneyId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(MoneyAggregate.class.getName());
}
