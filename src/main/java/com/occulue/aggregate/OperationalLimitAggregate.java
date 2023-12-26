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
 * Aggregate handler for OperationalLimit as outlined for the CQRS pattern, all write responsibilities 
 * related to OperationalLimit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OperationalLimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OperationalLimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OperationalLimitAggregate(CreateOperationalLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOperationalLimitCommand" );
    	CreateOperationalLimitEvent event = new CreateOperationalLimitEvent(command.getOperationalLimitId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOperationalLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOperationalLimitCommand" );
    	UpdateOperationalLimitEvent event = new UpdateOperationalLimitEvent(command.getOperationalLimitId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOperationalLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOperationalLimitCommand" );
        apply(new DeleteOperationalLimitEvent(command.getOperationalLimitId()));
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
    void on(CreateOperationalLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateOperationalLimitEvent" );
    	this.operationalLimitId = event.getOperationalLimitId();
    }
    
    @EventSourcingHandler
    void on(UpdateOperationalLimitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID operationalLimitId;
    

    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitAggregate.class.getName());
}
