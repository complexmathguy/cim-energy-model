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
 * Aggregate handler for Substation as outlined for the CQRS pattern, all write responsibilities 
 * related to Substation are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SubstationAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SubstationAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SubstationAggregate(CreateSubstationCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSubstationCommand" );
    	CreateSubstationEvent event = new CreateSubstationEvent(command.getSubstationId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSubstationCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSubstationCommand" );
    	UpdateSubstationEvent event = new UpdateSubstationEvent(command.getSubstationId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSubstationCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSubstationCommand" );
        apply(new DeleteSubstationEvent(command.getSubstationId()));
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
    void on(CreateSubstationEvent event) {	
    	LOGGER.info( "Event sourcing CreateSubstationEvent" );
    	this.substationId = event.getSubstationId();
    }
    
    @EventSourcingHandler
    void on(UpdateSubstationEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID substationId;
    

    private static final Logger LOGGER 	= Logger.getLogger(SubstationAggregate.class.getName());
}
