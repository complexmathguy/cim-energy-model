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
 * Aggregate handler for DCBreaker as outlined for the CQRS pattern, all write responsibilities 
 * related to DCBreaker are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCBreakerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCBreakerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCBreakerAggregate(CreateDCBreakerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCBreakerCommand" );
    	CreateDCBreakerEvent event = new CreateDCBreakerEvent(command.getDCBreakerId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCBreakerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCBreakerCommand" );
    	UpdateDCBreakerEvent event = new UpdateDCBreakerEvent(command.getDCBreakerId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCBreakerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCBreakerCommand" );
        apply(new DeleteDCBreakerEvent(command.getDCBreakerId()));
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
    void on(CreateDCBreakerEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCBreakerEvent" );
    	this.dCBreakerId = event.getDCBreakerId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCBreakerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCBreakerId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCBreakerAggregate.class.getName());
}
