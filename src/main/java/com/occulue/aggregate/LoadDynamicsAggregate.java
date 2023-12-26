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
 * Aggregate handler for LoadDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadDynamicsAggregate(CreateLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadDynamicsCommand" );
    	CreateLoadDynamicsEvent event = new CreateLoadDynamicsEvent(command.getLoadDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadDynamicsCommand" );
    	UpdateLoadDynamicsEvent event = new UpdateLoadDynamicsEvent(command.getLoadDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadDynamicsCommand" );
        apply(new DeleteLoadDynamicsEvent(command.getLoadDynamicsId()));
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
    void on(CreateLoadDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadDynamicsEvent" );
    	this.loadDynamicsId = event.getLoadDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LoadDynamicsAggregate.class.getName());
}
