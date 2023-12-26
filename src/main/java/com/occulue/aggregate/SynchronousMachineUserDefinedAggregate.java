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
 * Aggregate handler for SynchronousMachineUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineUserDefinedAggregate(CreateSynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineUserDefinedCommand" );
    	CreateSynchronousMachineUserDefinedEvent event = new CreateSynchronousMachineUserDefinedEvent(command.getSynchronousMachineUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineUserDefinedCommand" );
    	UpdateSynchronousMachineUserDefinedEvent event = new UpdateSynchronousMachineUserDefinedEvent(command.getSynchronousMachineUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineUserDefinedCommand" );
        apply(new DeleteSynchronousMachineUserDefinedEvent(command.getSynchronousMachineUserDefinedId()));
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
    void on(CreateSynchronousMachineUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineUserDefinedEvent" );
    	this.synchronousMachineUserDefinedId = event.getSynchronousMachineUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineUserDefinedEvent event) {
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
    private UUID synchronousMachineUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineUserDefinedAggregate.class.getName());
}
