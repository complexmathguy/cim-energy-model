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
 * Aggregate handler for CurrentFlow as outlined for the CQRS pattern, all write responsibilities 
 * related to CurrentFlow are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CurrentFlowAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CurrentFlowAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CurrentFlowAggregate(CreateCurrentFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCurrentFlowCommand" );
    	CreateCurrentFlowEvent event = new CreateCurrentFlowEvent(command.getCurrentFlowId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCurrentFlowCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCurrentFlowCommand" );
    	UpdateCurrentFlowEvent event = new UpdateCurrentFlowEvent(command.getCurrentFlowId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCurrentFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCurrentFlowCommand" );
        apply(new DeleteCurrentFlowEvent(command.getCurrentFlowId()));
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
    void on(CreateCurrentFlowEvent event) {	
    	LOGGER.info( "Event sourcing CreateCurrentFlowEvent" );
    	this.currentFlowId = event.getCurrentFlowId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateCurrentFlowEvent event) {
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
    private UUID currentFlowId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(CurrentFlowAggregate.class.getName());
}
