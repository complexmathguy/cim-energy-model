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
 * Aggregate handler for AsynchronousMachineDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to AsynchronousMachineDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AsynchronousMachineDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AsynchronousMachineDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AsynchronousMachineDynamicsAggregate(CreateAsynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAsynchronousMachineDynamicsCommand" );
    	CreateAsynchronousMachineDynamicsEvent event = new CreateAsynchronousMachineDynamicsEvent(command.getAsynchronousMachineDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAsynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAsynchronousMachineDynamicsCommand" );
    	UpdateAsynchronousMachineDynamicsEvent event = new UpdateAsynchronousMachineDynamicsEvent(command.getAsynchronousMachineDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAsynchronousMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAsynchronousMachineDynamicsCommand" );
        apply(new DeleteAsynchronousMachineDynamicsEvent(command.getAsynchronousMachineDynamicsId()));
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
    void on(CreateAsynchronousMachineDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateAsynchronousMachineDynamicsEvent" );
    	this.asynchronousMachineDynamicsId = event.getAsynchronousMachineDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateAsynchronousMachineDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID asynchronousMachineDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineDynamicsAggregate.class.getName());
}
