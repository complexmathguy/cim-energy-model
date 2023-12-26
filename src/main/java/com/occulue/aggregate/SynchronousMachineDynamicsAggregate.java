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
 * Aggregate handler for SynchronousMachineDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineDynamicsAggregate(CreateSynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineDynamicsCommand" );
    	CreateSynchronousMachineDynamicsEvent event = new CreateSynchronousMachineDynamicsEvent(command.getSynchronousMachineDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineDynamicsCommand" );
    	UpdateSynchronousMachineDynamicsEvent event = new UpdateSynchronousMachineDynamicsEvent(command.getSynchronousMachineDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineDynamicsCommand" );
        apply(new DeleteSynchronousMachineDynamicsEvent(command.getSynchronousMachineDynamicsId()));
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
    void on(CreateSynchronousMachineDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineDynamicsEvent" );
    	this.synchronousMachineDynamicsId = event.getSynchronousMachineDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineDynamicsAggregate.class.getName());
}
