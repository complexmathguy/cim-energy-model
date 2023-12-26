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
 * Aggregate handler for Discrete as outlined for the CQRS pattern, all write responsibilities 
 * related to Discrete are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscreteAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscreteAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscreteAggregate(CreateDiscreteCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscreteCommand" );
    	CreateDiscreteEvent event = new CreateDiscreteEvent(command.getDiscreteId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscreteCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscreteCommand" );
    	UpdateDiscreteEvent event = new UpdateDiscreteEvent(command.getDiscreteId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscreteCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscreteCommand" );
        apply(new DeleteDiscreteEvent(command.getDiscreteId()));
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
    void on(CreateDiscreteEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscreteEvent" );
    	this.discreteId = event.getDiscreteId();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscreteEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID discreteId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DiscreteAggregate.class.getName());
}
