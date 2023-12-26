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
 * Aggregate handler for ValueAliasSet as outlined for the CQRS pattern, all write responsibilities 
 * related to ValueAliasSet are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ValueAliasSetAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ValueAliasSetAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ValueAliasSetAggregate(CreateValueAliasSetCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateValueAliasSetCommand" );
    	CreateValueAliasSetEvent event = new CreateValueAliasSetEvent(command.getValueAliasSetId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateValueAliasSetCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateValueAliasSetCommand" );
    	UpdateValueAliasSetEvent event = new UpdateValueAliasSetEvent(command.getValueAliasSetId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteValueAliasSetCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteValueAliasSetCommand" );
        apply(new DeleteValueAliasSetEvent(command.getValueAliasSetId()));
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
    void on(CreateValueAliasSetEvent event) {	
    	LOGGER.info( "Event sourcing CreateValueAliasSetEvent" );
    	this.valueAliasSetId = event.getValueAliasSetId();
    }
    
    @EventSourcingHandler
    void on(UpdateValueAliasSetEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID valueAliasSetId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ValueAliasSetAggregate.class.getName());
}
