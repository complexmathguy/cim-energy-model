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
 * Aggregate handler for WindPlantUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to WindPlantUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindPlantUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindPlantUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindPlantUserDefinedAggregate(CreateWindPlantUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindPlantUserDefinedCommand" );
    	CreateWindPlantUserDefinedEvent event = new CreateWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindPlantUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindPlantUserDefinedCommand" );
    	UpdateWindPlantUserDefinedEvent event = new UpdateWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindPlantUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindPlantUserDefinedCommand" );
        apply(new DeleteWindPlantUserDefinedEvent(command.getWindPlantUserDefinedId()));
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
    void on(CreateWindPlantUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindPlantUserDefinedEvent" );
    	this.windPlantUserDefinedId = event.getWindPlantUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateWindPlantUserDefinedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.proprietary = event.getProprietary();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windPlantUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantUserDefinedAggregate.class.getName());
}
