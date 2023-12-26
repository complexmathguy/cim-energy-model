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
 * Aggregate handler for TurbineLoadControllerUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to TurbineLoadControllerUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TurbineLoadControllerUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TurbineLoadControllerUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TurbineLoadControllerUserDefinedAggregate(CreateTurbineLoadControllerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTurbineLoadControllerUserDefinedCommand" );
    	CreateTurbineLoadControllerUserDefinedEvent event = new CreateTurbineLoadControllerUserDefinedEvent(command.getTurbineLoadControllerUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTurbineLoadControllerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTurbineLoadControllerUserDefinedCommand" );
    	UpdateTurbineLoadControllerUserDefinedEvent event = new UpdateTurbineLoadControllerUserDefinedEvent(command.getTurbineLoadControllerUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTurbineLoadControllerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTurbineLoadControllerUserDefinedCommand" );
        apply(new DeleteTurbineLoadControllerUserDefinedEvent(command.getTurbineLoadControllerUserDefinedId()));
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
    void on(CreateTurbineLoadControllerUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateTurbineLoadControllerUserDefinedEvent" );
    	this.turbineLoadControllerUserDefinedId = event.getTurbineLoadControllerUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateTurbineLoadControllerUserDefinedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.proprietary = event.getProprietary();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID turbineLoadControllerUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(TurbineLoadControllerUserDefinedAggregate.class.getName());
}
