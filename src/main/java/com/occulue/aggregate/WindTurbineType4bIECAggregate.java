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
 * Aggregate handler for WindTurbineType4bIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindTurbineType4bIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindTurbineType4bIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindTurbineType4bIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindTurbineType4bIECAggregate(CreateWindTurbineType4bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindTurbineType4bIECCommand" );
    	CreateWindTurbineType4bIECEvent event = new CreateWindTurbineType4bIECEvent(command.getWindTurbineType4bIECId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindTurbineType4bIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindTurbineType4bIECCommand" );
    	UpdateWindTurbineType4bIECEvent event = new UpdateWindTurbineType4bIECEvent(command.getWindTurbineType4bIECId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindTurbineType4bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindTurbineType4bIECCommand" );
        apply(new DeleteWindTurbineType4bIECEvent(command.getWindTurbineType4bIECId()));
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
    void on(CreateWindTurbineType4bIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindTurbineType4bIECEvent" );
    	this.windTurbineType4bIECId = event.getWindTurbineType4bIECId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindTurbineType4bIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windTurbineType4bIECId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType4bIECAggregate.class.getName());
}
