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
 * Aggregate handler for AnalogLimitSet as outlined for the CQRS pattern, all write responsibilities 
 * related to AnalogLimitSet are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AnalogLimitSetAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AnalogLimitSetAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AnalogLimitSetAggregate(CreateAnalogLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAnalogLimitSetCommand" );
    	CreateAnalogLimitSetEvent event = new CreateAnalogLimitSetEvent(command.getAnalogLimitSetId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAnalogLimitSetCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAnalogLimitSetCommand" );
    	UpdateAnalogLimitSetEvent event = new UpdateAnalogLimitSetEvent(command.getAnalogLimitSetId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAnalogLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAnalogLimitSetCommand" );
        apply(new DeleteAnalogLimitSetEvent(command.getAnalogLimitSetId()));
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
    void on(CreateAnalogLimitSetEvent event) {	
    	LOGGER.info( "Event sourcing CreateAnalogLimitSetEvent" );
    	this.analogLimitSetId = event.getAnalogLimitSetId();
    }
    
    @EventSourcingHandler
    void on(UpdateAnalogLimitSetEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID analogLimitSetId;
    

    private static final Logger LOGGER 	= Logger.getLogger(AnalogLimitSetAggregate.class.getName());
}
