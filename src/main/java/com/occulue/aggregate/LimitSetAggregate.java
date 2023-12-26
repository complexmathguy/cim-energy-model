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
 * Aggregate handler for LimitSet as outlined for the CQRS pattern, all write responsibilities 
 * related to LimitSet are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LimitSetAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LimitSetAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LimitSetAggregate(CreateLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLimitSetCommand" );
    	CreateLimitSetEvent event = new CreateLimitSetEvent(command.getLimitSetId(), command.getIsPercentageLimits());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLimitSetCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLimitSetCommand" );
    	UpdateLimitSetEvent event = new UpdateLimitSetEvent(command.getLimitSetId(), command.getIsPercentageLimits());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLimitSetCommand" );
        apply(new DeleteLimitSetEvent(command.getLimitSetId()));
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
    void on(CreateLimitSetEvent event) {	
    	LOGGER.info( "Event sourcing CreateLimitSetEvent" );
    	this.limitSetId = event.getLimitSetId();
        this.isPercentageLimits = event.getIsPercentageLimits();
    }
    
    @EventSourcingHandler
    void on(UpdateLimitSetEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.isPercentageLimits = event.getIsPercentageLimits();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID limitSetId;
    
    private String isPercentageLimits;

    private static final Logger LOGGER 	= Logger.getLogger(LimitSetAggregate.class.getName());
}
