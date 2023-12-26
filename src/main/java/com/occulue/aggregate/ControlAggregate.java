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
 * Aggregate handler for Control as outlined for the CQRS pattern, all write responsibilities 
 * related to Control are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ControlAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ControlAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ControlAggregate(CreateControlCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateControlCommand" );
    	CreateControlEvent event = new CreateControlEvent(command.getControlId(), command.getControlType(), command.getOperationInProgress(), command.getTimeStamp(), command.getUnitMultiplier(), command.getUnitSymbol());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateControlCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateControlCommand" );
    	UpdateControlEvent event = new UpdateControlEvent(command.getControlId(), command.getControlType(), command.getOperationInProgress(), command.getTimeStamp(), command.getUnitMultiplier(), command.getUnitSymbol());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteControlCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteControlCommand" );
        apply(new DeleteControlEvent(command.getControlId()));
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
    void on(CreateControlEvent event) {	
    	LOGGER.info( "Event sourcing CreateControlEvent" );
    	this.controlId = event.getControlId();
        this.controlType = event.getControlType();
        this.operationInProgress = event.getOperationInProgress();
        this.timeStamp = event.getTimeStamp();
        this.unitMultiplier = event.getUnitMultiplier();
        this.unitSymbol = event.getUnitSymbol();
    }
    
    @EventSourcingHandler
    void on(UpdateControlEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.controlType = event.getControlType();
        this.operationInProgress = event.getOperationInProgress();
        this.timeStamp = event.getTimeStamp();
        this.unitMultiplier = event.getUnitMultiplier();
        this.unitSymbol = event.getUnitSymbol();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID controlId;
    
    private String controlType;
    private String operationInProgress;
    private String timeStamp;
    private String unitMultiplier;
    private String unitSymbol;

    private static final Logger LOGGER 	= Logger.getLogger(ControlAggregate.class.getName());
}
