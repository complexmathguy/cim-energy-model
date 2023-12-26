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
 * Aggregate handler for AccumulatorReset as outlined for the CQRS pattern, all write responsibilities 
 * related to AccumulatorReset are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AccumulatorResetAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AccumulatorResetAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AccumulatorResetAggregate(CreateAccumulatorResetCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAccumulatorResetCommand" );
    	CreateAccumulatorResetEvent event = new CreateAccumulatorResetEvent(command.getAccumulatorResetId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAccumulatorResetCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAccumulatorResetCommand" );
    	UpdateAccumulatorResetEvent event = new UpdateAccumulatorResetEvent(command.getAccumulatorResetId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAccumulatorResetCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAccumulatorResetCommand" );
        apply(new DeleteAccumulatorResetEvent(command.getAccumulatorResetId()));
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
    void on(CreateAccumulatorResetEvent event) {	
    	LOGGER.info( "Event sourcing CreateAccumulatorResetEvent" );
    	this.accumulatorResetId = event.getAccumulatorResetId();
    }
    
    @EventSourcingHandler
    void on(UpdateAccumulatorResetEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID accumulatorResetId;
    

    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorResetAggregate.class.getName());
}
