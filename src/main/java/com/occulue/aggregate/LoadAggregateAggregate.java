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
 * Aggregate handler for LoadAggregate as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadAggregate are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadAggregateAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadAggregateAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadAggregateAggregate(CreateLoadAggregateCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadAggregateCommand" );
    	CreateLoadAggregateEvent event = new CreateLoadAggregateEvent(command.getLoadAggregateId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadAggregateCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadAggregateCommand" );
    	UpdateLoadAggregateEvent event = new UpdateLoadAggregateEvent(command.getLoadAggregateId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadAggregateCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadAggregateCommand" );
        apply(new DeleteLoadAggregateEvent(command.getLoadAggregateId()));
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
    void on(CreateLoadAggregateEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadAggregateEvent" );
    	this.loadAggregateId = event.getLoadAggregateId();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadAggregateEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadAggregateId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LoadAggregateAggregate.class.getName());
}
