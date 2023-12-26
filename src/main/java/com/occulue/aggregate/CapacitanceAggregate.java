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
 * Aggregate handler for Capacitance as outlined for the CQRS pattern, all write responsibilities 
 * related to Capacitance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CapacitanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CapacitanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CapacitanceAggregate(CreateCapacitanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCapacitanceCommand" );
    	CreateCapacitanceEvent event = new CreateCapacitanceEvent(command.getCapacitanceId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCapacitanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCapacitanceCommand" );
    	UpdateCapacitanceEvent event = new UpdateCapacitanceEvent(command.getCapacitanceId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCapacitanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCapacitanceCommand" );
        apply(new DeleteCapacitanceEvent(command.getCapacitanceId()));
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
    void on(CreateCapacitanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateCapacitanceEvent" );
    	this.capacitanceId = event.getCapacitanceId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateCapacitanceEvent event) {
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
    private UUID capacitanceId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(CapacitanceAggregate.class.getName());
}
