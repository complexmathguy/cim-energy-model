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
 * Aggregate handler for Limit as outlined for the CQRS pattern, all write responsibilities 
 * related to Limit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LimitAggregate(CreateLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLimitCommand" );
    	CreateLimitEvent event = new CreateLimitEvent(command.getLimitId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLimitCommand" );
    	UpdateLimitEvent event = new UpdateLimitEvent(command.getLimitId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLimitCommand" );
        apply(new DeleteLimitEvent(command.getLimitId()));
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
    void on(CreateLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateLimitEvent" );
    	this.limitId = event.getLimitId();
    }
    
    @EventSourcingHandler
    void on(UpdateLimitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID limitId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LimitAggregate.class.getName());
}
