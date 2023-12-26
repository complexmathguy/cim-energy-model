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
 * Aggregate handler for AnalogLimit as outlined for the CQRS pattern, all write responsibilities 
 * related to AnalogLimit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AnalogLimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AnalogLimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AnalogLimitAggregate(CreateAnalogLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAnalogLimitCommand" );
    	CreateAnalogLimitEvent event = new CreateAnalogLimitEvent(command.getAnalogLimitId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAnalogLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAnalogLimitCommand" );
    	UpdateAnalogLimitEvent event = new UpdateAnalogLimitEvent(command.getAnalogLimitId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAnalogLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAnalogLimitCommand" );
        apply(new DeleteAnalogLimitEvent(command.getAnalogLimitId()));
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
    void on(CreateAnalogLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateAnalogLimitEvent" );
    	this.analogLimitId = event.getAnalogLimitId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAnalogLimitEvent event) {
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
    private UUID analogLimitId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogLimitAggregate.class.getName());
}
