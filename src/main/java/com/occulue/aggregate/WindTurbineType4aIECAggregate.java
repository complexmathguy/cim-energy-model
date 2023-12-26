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
 * Aggregate handler for WindTurbineType4aIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindTurbineType4aIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindTurbineType4aIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindTurbineType4aIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindTurbineType4aIECAggregate(CreateWindTurbineType4aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindTurbineType4aIECCommand" );
    	CreateWindTurbineType4aIECEvent event = new CreateWindTurbineType4aIECEvent(command.getWindTurbineType4aIECId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindTurbineType4aIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindTurbineType4aIECCommand" );
    	UpdateWindTurbineType4aIECEvent event = new UpdateWindTurbineType4aIECEvent(command.getWindTurbineType4aIECId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindTurbineType4aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindTurbineType4aIECCommand" );
        apply(new DeleteWindTurbineType4aIECEvent(command.getWindTurbineType4aIECId()));
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
    void on(CreateWindTurbineType4aIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindTurbineType4aIECEvent" );
    	this.windTurbineType4aIECId = event.getWindTurbineType4aIECId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindTurbineType4aIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windTurbineType4aIECId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType4aIECAggregate.class.getName());
}
