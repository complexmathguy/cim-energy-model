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
 * Aggregate handler for Dynamicsmodel as outlined for the CQRS pattern, all write responsibilities 
 * related to Dynamicsmodel are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DynamicsmodelAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DynamicsmodelAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DynamicsmodelAggregate(CreateDynamicsmodelCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDynamicsmodelCommand" );
    	CreateDynamicsmodelEvent event = new CreateDynamicsmodelEvent(command.getDynamicsmodelId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDynamicsmodelCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDynamicsmodelCommand" );
    	UpdateDynamicsmodelEvent event = new UpdateDynamicsmodelEvent(command.getDynamicsmodelId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDynamicsmodelCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDynamicsmodelCommand" );
        apply(new DeleteDynamicsmodelEvent(command.getDynamicsmodelId()));
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
    void on(CreateDynamicsmodelEvent event) {	
    	LOGGER.info( "Event sourcing CreateDynamicsmodelEvent" );
    	this.dynamicsmodelId = event.getDynamicsmodelId();
    }
    
    @EventSourcingHandler
    void on(UpdateDynamicsmodelEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dynamicsmodelId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DynamicsmodelAggregate.class.getName());
}
