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
 * Aggregate handler for VoltagePerReactivePower as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltagePerReactivePower are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltagePerReactivePowerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltagePerReactivePowerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltagePerReactivePowerAggregate(CreateVoltagePerReactivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltagePerReactivePowerCommand" );
    	CreateVoltagePerReactivePowerEvent event = new CreateVoltagePerReactivePowerEvent(command.getVoltagePerReactivePowerId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltagePerReactivePowerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltagePerReactivePowerCommand" );
    	UpdateVoltagePerReactivePowerEvent event = new UpdateVoltagePerReactivePowerEvent(command.getVoltagePerReactivePowerId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltagePerReactivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltagePerReactivePowerCommand" );
        apply(new DeleteVoltagePerReactivePowerEvent(command.getVoltagePerReactivePowerId()));
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
    void on(CreateVoltagePerReactivePowerEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltagePerReactivePowerEvent" );
    	this.voltagePerReactivePowerId = event.getVoltagePerReactivePowerId();
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltagePerReactivePowerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
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
    private UUID voltagePerReactivePowerId;
    
    private String denominatorMultiplier;
    private String denominatorUnit;
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(VoltagePerReactivePowerAggregate.class.getName());
}
