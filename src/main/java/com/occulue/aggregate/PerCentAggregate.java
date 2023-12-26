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
 * Aggregate handler for PerCent as outlined for the CQRS pattern, all write responsibilities 
 * related to PerCent are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PerCentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PerCentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PerCentAggregate(CreatePerCentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePerCentCommand" );
    	CreatePerCentEvent event = new CreatePerCentEvent(command.getPerCentId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePerCentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePerCentCommand" );
    	UpdatePerCentEvent event = new UpdatePerCentEvent(command.getPerCentId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePerCentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePerCentCommand" );
        apply(new DeletePerCentEvent(command.getPerCentId()));
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
    void on(CreatePerCentEvent event) {	
    	LOGGER.info( "Event sourcing CreatePerCentEvent" );
    	this.perCentId = event.getPerCentId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdatePerCentEvent event) {
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
    private UUID perCentId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(PerCentAggregate.class.getName());
}
