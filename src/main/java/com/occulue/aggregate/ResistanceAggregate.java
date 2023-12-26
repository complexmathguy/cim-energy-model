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
 * Aggregate handler for Resistance as outlined for the CQRS pattern, all write responsibilities 
 * related to Resistance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ResistanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ResistanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ResistanceAggregate(CreateResistanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateResistanceCommand" );
    	CreateResistanceEvent event = new CreateResistanceEvent(command.getResistanceId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateResistanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateResistanceCommand" );
    	UpdateResistanceEvent event = new UpdateResistanceEvent(command.getResistanceId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteResistanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteResistanceCommand" );
        apply(new DeleteResistanceEvent(command.getResistanceId()));
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
    void on(CreateResistanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateResistanceEvent" );
    	this.resistanceId = event.getResistanceId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateResistanceEvent event) {
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
    private UUID resistanceId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ResistanceAggregate.class.getName());
}
