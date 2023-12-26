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
 * Aggregate handler for TurbineGovernorUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to TurbineGovernorUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TurbineGovernorUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TurbineGovernorUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TurbineGovernorUserDefinedAggregate(CreateTurbineGovernorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTurbineGovernorUserDefinedCommand" );
    	CreateTurbineGovernorUserDefinedEvent event = new CreateTurbineGovernorUserDefinedEvent(command.getTurbineGovernorUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTurbineGovernorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTurbineGovernorUserDefinedCommand" );
    	UpdateTurbineGovernorUserDefinedEvent event = new UpdateTurbineGovernorUserDefinedEvent(command.getTurbineGovernorUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTurbineGovernorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTurbineGovernorUserDefinedCommand" );
        apply(new DeleteTurbineGovernorUserDefinedEvent(command.getTurbineGovernorUserDefinedId()));
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
    void on(CreateTurbineGovernorUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateTurbineGovernorUserDefinedEvent" );
    	this.turbineGovernorUserDefinedId = event.getTurbineGovernorUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateTurbineGovernorUserDefinedEvent event) {
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
    private UUID turbineGovernorUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(TurbineGovernorUserDefinedAggregate.class.getName());
}
