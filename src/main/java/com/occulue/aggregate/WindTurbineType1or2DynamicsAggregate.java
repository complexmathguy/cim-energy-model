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
 * Aggregate handler for WindTurbineType1or2Dynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to WindTurbineType1or2Dynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindTurbineType1or2DynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindTurbineType1or2DynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindTurbineType1or2DynamicsAggregate(CreateWindTurbineType1or2DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindTurbineType1or2DynamicsCommand" );
    	CreateWindTurbineType1or2DynamicsEvent event = new CreateWindTurbineType1or2DynamicsEvent(command.getWindTurbineType1or2DynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindTurbineType1or2DynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindTurbineType1or2DynamicsCommand" );
    	UpdateWindTurbineType1or2DynamicsEvent event = new UpdateWindTurbineType1or2DynamicsEvent(command.getWindTurbineType1or2DynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindTurbineType1or2DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindTurbineType1or2DynamicsCommand" );
        apply(new DeleteWindTurbineType1or2DynamicsEvent(command.getWindTurbineType1or2DynamicsId()));
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
    void on(CreateWindTurbineType1or2DynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindTurbineType1or2DynamicsEvent" );
    	this.windTurbineType1or2DynamicsId = event.getWindTurbineType1or2DynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindTurbineType1or2DynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windTurbineType1or2DynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType1or2DynamicsAggregate.class.getName());
}
