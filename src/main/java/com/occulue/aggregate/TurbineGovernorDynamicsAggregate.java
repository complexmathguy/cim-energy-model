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
 * Aggregate handler for TurbineGovernorDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to TurbineGovernorDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TurbineGovernorDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TurbineGovernorDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TurbineGovernorDynamicsAggregate(CreateTurbineGovernorDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTurbineGovernorDynamicsCommand" );
    	CreateTurbineGovernorDynamicsEvent event = new CreateTurbineGovernorDynamicsEvent(command.getTurbineGovernorDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTurbineGovernorDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTurbineGovernorDynamicsCommand" );
    	UpdateTurbineGovernorDynamicsEvent event = new UpdateTurbineGovernorDynamicsEvent(command.getTurbineGovernorDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTurbineGovernorDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTurbineGovernorDynamicsCommand" );
        apply(new DeleteTurbineGovernorDynamicsEvent(command.getTurbineGovernorDynamicsId()));
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
    void on(CreateTurbineGovernorDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateTurbineGovernorDynamicsEvent" );
    	this.turbineGovernorDynamicsId = event.getTurbineGovernorDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateTurbineGovernorDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID turbineGovernorDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(TurbineGovernorDynamicsAggregate.class.getName());
}
