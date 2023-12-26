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
 * Aggregate handler for GeographicalRegion as outlined for the CQRS pattern, all write responsibilities 
 * related to GeographicalRegion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GeographicalRegionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GeographicalRegionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GeographicalRegionAggregate(CreateGeographicalRegionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGeographicalRegionCommand" );
    	CreateGeographicalRegionEvent event = new CreateGeographicalRegionEvent(command.getGeographicalRegionId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGeographicalRegionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGeographicalRegionCommand" );
    	UpdateGeographicalRegionEvent event = new UpdateGeographicalRegionEvent(command.getGeographicalRegionId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGeographicalRegionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGeographicalRegionCommand" );
        apply(new DeleteGeographicalRegionEvent(command.getGeographicalRegionId()));
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
    void on(CreateGeographicalRegionEvent event) {	
    	LOGGER.info( "Event sourcing CreateGeographicalRegionEvent" );
    	this.geographicalRegionId = event.getGeographicalRegionId();
    }
    
    @EventSourcingHandler
    void on(UpdateGeographicalRegionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID geographicalRegionId;
    

    private static final Logger LOGGER 	= Logger.getLogger(GeographicalRegionAggregate.class.getName());
}
