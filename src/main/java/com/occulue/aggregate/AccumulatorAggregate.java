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
 * Aggregate handler for Accumulator as outlined for the CQRS pattern, all write responsibilities 
 * related to Accumulator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AccumulatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AccumulatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AccumulatorAggregate(CreateAccumulatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAccumulatorCommand" );
    	CreateAccumulatorEvent event = new CreateAccumulatorEvent(command.getAccumulatorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAccumulatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAccumulatorCommand" );
    	UpdateAccumulatorEvent event = new UpdateAccumulatorEvent(command.getAccumulatorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAccumulatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAccumulatorCommand" );
        apply(new DeleteAccumulatorEvent(command.getAccumulatorId()));
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
    void on(CreateAccumulatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateAccumulatorEvent" );
    	this.accumulatorId = event.getAccumulatorId();
    }
    
    @EventSourcingHandler
    void on(UpdateAccumulatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID accumulatorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorAggregate.class.getName());
}
