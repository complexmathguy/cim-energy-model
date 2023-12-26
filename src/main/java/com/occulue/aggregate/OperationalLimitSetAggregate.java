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
 * Aggregate handler for OperationalLimitSet as outlined for the CQRS pattern, all write responsibilities 
 * related to OperationalLimitSet are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OperationalLimitSetAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OperationalLimitSetAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OperationalLimitSetAggregate(CreateOperationalLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOperationalLimitSetCommand" );
    	CreateOperationalLimitSetEvent event = new CreateOperationalLimitSetEvent(command.getOperationalLimitSetId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOperationalLimitSetCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOperationalLimitSetCommand" );
    	UpdateOperationalLimitSetEvent event = new UpdateOperationalLimitSetEvent(command.getOperationalLimitSetId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOperationalLimitSetCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOperationalLimitSetCommand" );
        apply(new DeleteOperationalLimitSetEvent(command.getOperationalLimitSetId()));
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
    void on(CreateOperationalLimitSetEvent event) {	
    	LOGGER.info( "Event sourcing CreateOperationalLimitSetEvent" );
    	this.operationalLimitSetId = event.getOperationalLimitSetId();
    }
    
    @EventSourcingHandler
    void on(UpdateOperationalLimitSetEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID operationalLimitSetId;
    

    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitSetAggregate.class.getName());
}
