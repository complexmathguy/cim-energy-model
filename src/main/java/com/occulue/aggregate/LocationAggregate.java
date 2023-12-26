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
 * Aggregate handler for Location as outlined for the CQRS pattern, all write responsibilities 
 * related to Location are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LocationAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LocationAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LocationAggregate(CreateLocationCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLocationCommand" );
    	CreateLocationEvent event = new CreateLocationEvent(command.getLocationId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLocationCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLocationCommand" );
    	UpdateLocationEvent event = new UpdateLocationEvent(command.getLocationId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLocationCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLocationCommand" );
        apply(new DeleteLocationEvent(command.getLocationId()));
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
    void on(CreateLocationEvent event) {	
    	LOGGER.info( "Event sourcing CreateLocationEvent" );
    	this.locationId = event.getLocationId();
    }
    
    @EventSourcingHandler
    void on(UpdateLocationEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID locationId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LocationAggregate.class.getName());
}
