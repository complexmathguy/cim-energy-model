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
 * Aggregate handler for Conductor as outlined for the CQRS pattern, all write responsibilities 
 * related to Conductor are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConductorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConductorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConductorAggregate(CreateConductorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConductorCommand" );
    	CreateConductorEvent event = new CreateConductorEvent(command.getConductorId(), command.getLength());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConductorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConductorCommand" );
    	UpdateConductorEvent event = new UpdateConductorEvent(command.getConductorId(), command.getLength());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConductorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConductorCommand" );
        apply(new DeleteConductorEvent(command.getConductorId()));
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
    void on(CreateConductorEvent event) {	
    	LOGGER.info( "Event sourcing CreateConductorEvent" );
    	this.conductorId = event.getConductorId();
        this.length = event.getLength();
    }
    
    @EventSourcingHandler
    void on(UpdateConductorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.length = event.getLength();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID conductorId;
    
    private String length;

    private static final Logger LOGGER 	= Logger.getLogger(ConductorAggregate.class.getName());
}
