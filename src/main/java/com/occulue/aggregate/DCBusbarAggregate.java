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
 * Aggregate handler for DCBusbar as outlined for the CQRS pattern, all write responsibilities 
 * related to DCBusbar are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCBusbarAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCBusbarAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCBusbarAggregate(CreateDCBusbarCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCBusbarCommand" );
    	CreateDCBusbarEvent event = new CreateDCBusbarEvent(command.getDCBusbarId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCBusbarCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCBusbarCommand" );
    	UpdateDCBusbarEvent event = new UpdateDCBusbarEvent(command.getDCBusbarId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCBusbarCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCBusbarCommand" );
        apply(new DeleteDCBusbarEvent(command.getDCBusbarId()));
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
    void on(CreateDCBusbarEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCBusbarEvent" );
    	this.dCBusbarId = event.getDCBusbarId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCBusbarEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCBusbarId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCBusbarAggregate.class.getName());
}
