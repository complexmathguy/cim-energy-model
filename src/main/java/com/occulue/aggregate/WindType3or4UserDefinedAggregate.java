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
 * Aggregate handler for WindType3or4UserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to WindType3or4UserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindType3or4UserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindType3or4UserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindType3or4UserDefinedAggregate(CreateWindType3or4UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindType3or4UserDefinedCommand" );
    	CreateWindType3or4UserDefinedEvent event = new CreateWindType3or4UserDefinedEvent(command.getWindType3or4UserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindType3or4UserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindType3or4UserDefinedCommand" );
    	UpdateWindType3or4UserDefinedEvent event = new UpdateWindType3or4UserDefinedEvent(command.getWindType3or4UserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindType3or4UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindType3or4UserDefinedCommand" );
        apply(new DeleteWindType3or4UserDefinedEvent(command.getWindType3or4UserDefinedId()));
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
    void on(CreateWindType3or4UserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindType3or4UserDefinedEvent" );
    	this.windType3or4UserDefinedId = event.getWindType3or4UserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateWindType3or4UserDefinedEvent event) {
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
    private UUID windType3or4UserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(WindType3or4UserDefinedAggregate.class.getName());
}
