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
 * Aggregate handler for DCDisconnector as outlined for the CQRS pattern, all write responsibilities 
 * related to DCDisconnector are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCDisconnectorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCDisconnectorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCDisconnectorAggregate(CreateDCDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCDisconnectorCommand" );
    	CreateDCDisconnectorEvent event = new CreateDCDisconnectorEvent(command.getDCDisconnectorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCDisconnectorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCDisconnectorCommand" );
    	UpdateDCDisconnectorEvent event = new UpdateDCDisconnectorEvent(command.getDCDisconnectorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCDisconnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCDisconnectorCommand" );
        apply(new DeleteDCDisconnectorEvent(command.getDCDisconnectorId()));
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
    void on(CreateDCDisconnectorEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCDisconnectorEvent" );
    	this.dCDisconnectorId = event.getDCDisconnectorId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCDisconnectorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCDisconnectorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCDisconnectorAggregate.class.getName());
}
