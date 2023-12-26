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
 * Aggregate handler for ActivePowerLimit as outlined for the CQRS pattern, all write responsibilities 
 * related to ActivePowerLimit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ActivePowerLimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ActivePowerLimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ActivePowerLimitAggregate(CreateActivePowerLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateActivePowerLimitCommand" );
    	CreateActivePowerLimitEvent event = new CreateActivePowerLimitEvent(command.getActivePowerLimitId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateActivePowerLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateActivePowerLimitCommand" );
    	UpdateActivePowerLimitEvent event = new UpdateActivePowerLimitEvent(command.getActivePowerLimitId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteActivePowerLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteActivePowerLimitCommand" );
        apply(new DeleteActivePowerLimitEvent(command.getActivePowerLimitId()));
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
    void on(CreateActivePowerLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateActivePowerLimitEvent" );
    	this.activePowerLimitId = event.getActivePowerLimitId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateActivePowerLimitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID activePowerLimitId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerLimitAggregate.class.getName());
}
