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
 * Aggregate handler for WindPlantIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindPlantIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindPlantIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindPlantIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindPlantIECAggregate(CreateWindPlantIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindPlantIECCommand" );
    	CreateWindPlantIECEvent event = new CreateWindPlantIECEvent(command.getWindPlantIECId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindPlantIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindPlantIECCommand" );
    	UpdateWindPlantIECEvent event = new UpdateWindPlantIECEvent(command.getWindPlantIECId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindPlantIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindPlantIECCommand" );
        apply(new DeleteWindPlantIECEvent(command.getWindPlantIECId()));
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
    void on(CreateWindPlantIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindPlantIECEvent" );
    	this.windPlantIECId = event.getWindPlantIECId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindPlantIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windPlantIECId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantIECAggregate.class.getName());
}
