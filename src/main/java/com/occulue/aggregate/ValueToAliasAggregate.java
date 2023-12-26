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
 * Aggregate handler for ValueToAlias as outlined for the CQRS pattern, all write responsibilities 
 * related to ValueToAlias are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ValueToAliasAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ValueToAliasAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ValueToAliasAggregate(CreateValueToAliasCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateValueToAliasCommand" );
    	CreateValueToAliasEvent event = new CreateValueToAliasEvent(command.getValueToAliasId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateValueToAliasCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateValueToAliasCommand" );
    	UpdateValueToAliasEvent event = new UpdateValueToAliasEvent(command.getValueToAliasId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteValueToAliasCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteValueToAliasCommand" );
        apply(new DeleteValueToAliasEvent(command.getValueToAliasId()));
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
    void on(CreateValueToAliasEvent event) {	
    	LOGGER.info( "Event sourcing CreateValueToAliasEvent" );
    	this.valueToAliasId = event.getValueToAliasId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateValueToAliasEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID valueToAliasId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ValueToAliasAggregate.class.getName());
}
