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
 * Aggregate handler for AsynchronousMachineUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to AsynchronousMachineUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AsynchronousMachineUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AsynchronousMachineUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AsynchronousMachineUserDefinedAggregate(CreateAsynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAsynchronousMachineUserDefinedCommand" );
    	CreateAsynchronousMachineUserDefinedEvent event = new CreateAsynchronousMachineUserDefinedEvent(command.getAsynchronousMachineUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAsynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAsynchronousMachineUserDefinedCommand" );
    	UpdateAsynchronousMachineUserDefinedEvent event = new UpdateAsynchronousMachineUserDefinedEvent(command.getAsynchronousMachineUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAsynchronousMachineUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAsynchronousMachineUserDefinedCommand" );
        apply(new DeleteAsynchronousMachineUserDefinedEvent(command.getAsynchronousMachineUserDefinedId()));
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
    void on(CreateAsynchronousMachineUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateAsynchronousMachineUserDefinedEvent" );
    	this.asynchronousMachineUserDefinedId = event.getAsynchronousMachineUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateAsynchronousMachineUserDefinedEvent event) {
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
    private UUID asynchronousMachineUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineUserDefinedAggregate.class.getName());
}
