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
 * Aggregate handler for Breaker as outlined for the CQRS pattern, all write responsibilities 
 * related to Breaker are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BreakerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BreakerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BreakerAggregate(CreateBreakerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBreakerCommand" );
    	CreateBreakerEvent event = new CreateBreakerEvent(command.getBreakerId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBreakerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBreakerCommand" );
    	UpdateBreakerEvent event = new UpdateBreakerEvent(command.getBreakerId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBreakerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBreakerCommand" );
        apply(new DeleteBreakerEvent(command.getBreakerId()));
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
    void on(CreateBreakerEvent event) {	
    	LOGGER.info( "Event sourcing CreateBreakerEvent" );
    	this.breakerId = event.getBreakerId();
    }
    
    @EventSourcingHandler
    void on(UpdateBreakerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID breakerId;
    

    private static final Logger LOGGER 	= Logger.getLogger(BreakerAggregate.class.getName());
}
