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
 * Aggregate handler for DCChopper as outlined for the CQRS pattern, all write responsibilities 
 * related to DCChopper are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCChopperAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCChopperAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCChopperAggregate(CreateDCChopperCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCChopperCommand" );
    	CreateDCChopperEvent event = new CreateDCChopperEvent(command.getDCChopperId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCChopperCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCChopperCommand" );
    	UpdateDCChopperEvent event = new UpdateDCChopperEvent(command.getDCChopperId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCChopperCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCChopperCommand" );
        apply(new DeleteDCChopperEvent(command.getDCChopperId()));
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
    void on(CreateDCChopperEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCChopperEvent" );
    	this.dCChopperId = event.getDCChopperId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCChopperEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCChopperId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCChopperAggregate.class.getName());
}
