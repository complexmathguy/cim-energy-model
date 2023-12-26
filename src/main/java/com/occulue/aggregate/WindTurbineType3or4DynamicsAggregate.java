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
 * Aggregate handler for WindTurbineType3or4Dynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to WindTurbineType3or4Dynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindTurbineType3or4DynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindTurbineType3or4DynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindTurbineType3or4DynamicsAggregate(CreateWindTurbineType3or4DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindTurbineType3or4DynamicsCommand" );
    	CreateWindTurbineType3or4DynamicsEvent event = new CreateWindTurbineType3or4DynamicsEvent(command.getWindTurbineType3or4DynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindTurbineType3or4DynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindTurbineType3or4DynamicsCommand" );
    	UpdateWindTurbineType3or4DynamicsEvent event = new UpdateWindTurbineType3or4DynamicsEvent(command.getWindTurbineType3or4DynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindTurbineType3or4DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindTurbineType3or4DynamicsCommand" );
        apply(new DeleteWindTurbineType3or4DynamicsEvent(command.getWindTurbineType3or4DynamicsId()));
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
    void on(CreateWindTurbineType3or4DynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindTurbineType3or4DynamicsEvent" );
    	this.windTurbineType3or4DynamicsId = event.getWindTurbineType3or4DynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindTurbineType3or4DynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windTurbineType3or4DynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType3or4DynamicsAggregate.class.getName());
}
