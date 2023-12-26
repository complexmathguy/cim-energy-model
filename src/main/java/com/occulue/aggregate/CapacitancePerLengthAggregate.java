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
 * Aggregate handler for CapacitancePerLength as outlined for the CQRS pattern, all write responsibilities 
 * related to CapacitancePerLength are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CapacitancePerLengthAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CapacitancePerLengthAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CapacitancePerLengthAggregate(CreateCapacitancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCapacitancePerLengthCommand" );
    	CreateCapacitancePerLengthEvent event = new CreateCapacitancePerLengthEvent(command.getCapacitancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCapacitancePerLengthCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCapacitancePerLengthCommand" );
    	UpdateCapacitancePerLengthEvent event = new UpdateCapacitancePerLengthEvent(command.getCapacitancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCapacitancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCapacitancePerLengthCommand" );
        apply(new DeleteCapacitancePerLengthEvent(command.getCapacitancePerLengthId()));
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
    void on(CreateCapacitancePerLengthEvent event) {	
    	LOGGER.info( "Event sourcing CreateCapacitancePerLengthEvent" );
    	this.capacitancePerLengthId = event.getCapacitancePerLengthId();
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateCapacitancePerLengthEvent event) {
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
    private UUID capacitancePerLengthId;
    
    private String denominatorMultiplier;
    private String denominatorUnit;
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(CapacitancePerLengthAggregate.class.getName());
}
