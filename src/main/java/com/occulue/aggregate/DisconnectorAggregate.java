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
 * Aggregate handler for Disconnector as outlined for the CQRS pattern, all write responsibilities 
 * related to Disconnector are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DisconnectorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DisconnectorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DisconnectorAggregate(CreateDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDisconnectorCommand" );
    	CreateDisconnectorEvent event = new CreateDisconnectorEvent(command.getDisconnectorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDisconnectorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDisconnectorCommand" );
    	UpdateDisconnectorEvent event = new UpdateDisconnectorEvent(command.getDisconnectorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDisconnectorCommand" );
        apply(new DeleteDisconnectorEvent(command.getDisconnectorId()));
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
    void on(CreateDisconnectorEvent event) {	
    	LOGGER.info( "Event sourcing CreateDisconnectorEvent" );
    	this.disconnectorId = event.getDisconnectorId();
    }
    
    @EventSourcingHandler
    void on(UpdateDisconnectorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID disconnectorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DisconnectorAggregate.class.getName());
}
