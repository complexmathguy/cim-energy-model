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
 * Aggregate handler for GroundDisconnector as outlined for the CQRS pattern, all write responsibilities 
 * related to GroundDisconnector are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GroundDisconnectorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GroundDisconnectorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GroundDisconnectorAggregate(CreateGroundDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGroundDisconnectorCommand" );
    	CreateGroundDisconnectorEvent event = new CreateGroundDisconnectorEvent(command.getGroundDisconnectorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGroundDisconnectorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGroundDisconnectorCommand" );
    	UpdateGroundDisconnectorEvent event = new UpdateGroundDisconnectorEvent(command.getGroundDisconnectorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGroundDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGroundDisconnectorCommand" );
        apply(new DeleteGroundDisconnectorEvent(command.getGroundDisconnectorId()));
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
    void on(CreateGroundDisconnectorEvent event) {	
    	LOGGER.info( "Event sourcing CreateGroundDisconnectorEvent" );
    	this.groundDisconnectorId = event.getGroundDisconnectorId();
    }
    
    @EventSourcingHandler
    void on(UpdateGroundDisconnectorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID groundDisconnectorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(GroundDisconnectorAggregate.class.getName());
}
