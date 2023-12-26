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
 * Aggregate handler for ActivePower as outlined for the CQRS pattern, all write responsibilities 
 * related to ActivePower are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ActivePowerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ActivePowerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ActivePowerAggregate(CreateActivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateActivePowerCommand" );
    	CreateActivePowerEvent event = new CreateActivePowerEvent(command.getActivePowerId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateActivePowerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateActivePowerCommand" );
    	UpdateActivePowerEvent event = new UpdateActivePowerEvent(command.getActivePowerId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteActivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteActivePowerCommand" );
        apply(new DeleteActivePowerEvent(command.getActivePowerId()));
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
    void on(CreateActivePowerEvent event) {	
    	LOGGER.info( "Event sourcing CreateActivePowerEvent" );
    	this.activePowerId = event.getActivePowerId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateActivePowerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID activePowerId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerAggregate.class.getName());
}
