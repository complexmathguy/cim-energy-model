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
 * Aggregate handler for ControlAreaGeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to ControlAreaGeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ControlAreaGeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ControlAreaGeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ControlAreaGeneratingUnitAggregate(CreateControlAreaGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateControlAreaGeneratingUnitCommand" );
    	CreateControlAreaGeneratingUnitEvent event = new CreateControlAreaGeneratingUnitEvent(command.getControlAreaGeneratingUnitId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateControlAreaGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateControlAreaGeneratingUnitCommand" );
    	UpdateControlAreaGeneratingUnitEvent event = new UpdateControlAreaGeneratingUnitEvent(command.getControlAreaGeneratingUnitId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteControlAreaGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteControlAreaGeneratingUnitCommand" );
        apply(new DeleteControlAreaGeneratingUnitEvent(command.getControlAreaGeneratingUnitId()));
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
    void on(CreateControlAreaGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateControlAreaGeneratingUnitEvent" );
    	this.controlAreaGeneratingUnitId = event.getControlAreaGeneratingUnitId();
    }
    
    @EventSourcingHandler
    void on(UpdateControlAreaGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID controlAreaGeneratingUnitId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ControlAreaGeneratingUnitAggregate.class.getName());
}
