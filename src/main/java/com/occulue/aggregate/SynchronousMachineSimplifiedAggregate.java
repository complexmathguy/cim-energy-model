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
 * Aggregate handler for SynchronousMachineSimplified as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineSimplified are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineSimplifiedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineSimplifiedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineSimplifiedAggregate(CreateSynchronousMachineSimplifiedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineSimplifiedCommand" );
    	CreateSynchronousMachineSimplifiedEvent event = new CreateSynchronousMachineSimplifiedEvent(command.getSynchronousMachineSimplifiedId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineSimplifiedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineSimplifiedCommand" );
    	UpdateSynchronousMachineSimplifiedEvent event = new UpdateSynchronousMachineSimplifiedEvent(command.getSynchronousMachineSimplifiedId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineSimplifiedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineSimplifiedCommand" );
        apply(new DeleteSynchronousMachineSimplifiedEvent(command.getSynchronousMachineSimplifiedId()));
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
    void on(CreateSynchronousMachineSimplifiedEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineSimplifiedEvent" );
    	this.synchronousMachineSimplifiedId = event.getSynchronousMachineSimplifiedId();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineSimplifiedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineSimplifiedId;
    

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineSimplifiedAggregate.class.getName());
}
