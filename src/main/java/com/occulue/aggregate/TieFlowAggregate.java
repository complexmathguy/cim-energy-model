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
 * Aggregate handler for TieFlow as outlined for the CQRS pattern, all write responsibilities 
 * related to TieFlow are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TieFlowAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TieFlowAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TieFlowAggregate(CreateTieFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTieFlowCommand" );
    	CreateTieFlowEvent event = new CreateTieFlowEvent(command.getTieFlowId(), command.getPositiveFlowIn());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTieFlowCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTieFlowCommand" );
    	UpdateTieFlowEvent event = new UpdateTieFlowEvent(command.getTieFlowId(), command.getPositiveFlowIn());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTieFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTieFlowCommand" );
        apply(new DeleteTieFlowEvent(command.getTieFlowId()));
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
    void on(CreateTieFlowEvent event) {	
    	LOGGER.info( "Event sourcing CreateTieFlowEvent" );
    	this.tieFlowId = event.getTieFlowId();
        this.positiveFlowIn = event.getPositiveFlowIn();
    }
    
    @EventSourcingHandler
    void on(UpdateTieFlowEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.positiveFlowIn = event.getPositiveFlowIn();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID tieFlowId;
    
    private String positiveFlowIn;

    private static final Logger LOGGER 	= Logger.getLogger(TieFlowAggregate.class.getName());
}
