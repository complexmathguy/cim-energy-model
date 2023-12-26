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
 * Aggregate handler for Voltage as outlined for the CQRS pattern, all write responsibilities 
 * related to Voltage are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageAggregate(CreateVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageCommand" );
    	CreateVoltageEvent event = new CreateVoltageEvent(command.getVoltageId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageCommand" );
    	UpdateVoltageEvent event = new UpdateVoltageEvent(command.getVoltageId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageCommand" );
        apply(new DeleteVoltageEvent(command.getVoltageId()));
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
    void on(CreateVoltageEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageEvent" );
    	this.voltageId = event.getVoltageId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageEvent event) {
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
    private UUID voltageId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageAggregate.class.getName());
}
