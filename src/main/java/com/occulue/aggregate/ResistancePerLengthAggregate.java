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
 * Aggregate handler for ResistancePerLength as outlined for the CQRS pattern, all write responsibilities 
 * related to ResistancePerLength are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ResistancePerLengthAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ResistancePerLengthAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ResistancePerLengthAggregate(CreateResistancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateResistancePerLengthCommand" );
    	CreateResistancePerLengthEvent event = new CreateResistancePerLengthEvent(command.getResistancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateResistancePerLengthCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateResistancePerLengthCommand" );
    	UpdateResistancePerLengthEvent event = new UpdateResistancePerLengthEvent(command.getResistancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteResistancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteResistancePerLengthCommand" );
        apply(new DeleteResistancePerLengthEvent(command.getResistancePerLengthId()));
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
    void on(CreateResistancePerLengthEvent event) {	
    	LOGGER.info( "Event sourcing CreateResistancePerLengthEvent" );
    	this.resistancePerLengthId = event.getResistancePerLengthId();
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateResistancePerLengthEvent event) {
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
    private UUID resistancePerLengthId;
    
    private String denominatorMultiplier;
    private String denominatorUnit;
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ResistancePerLengthAggregate.class.getName());
}
