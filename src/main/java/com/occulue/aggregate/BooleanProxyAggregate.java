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
 * Aggregate handler for BooleanProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to BooleanProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BooleanProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BooleanProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BooleanProxyAggregate(CreateBooleanProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBooleanProxyCommand" );
    	CreateBooleanProxyEvent event = new CreateBooleanProxyEvent(command.getBooleanProxyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBooleanProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBooleanProxyCommand" );
    	UpdateBooleanProxyEvent event = new UpdateBooleanProxyEvent(command.getBooleanProxyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBooleanProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBooleanProxyCommand" );
        apply(new DeleteBooleanProxyEvent(command.getBooleanProxyId()));
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
    void on(CreateBooleanProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateBooleanProxyEvent" );
    	this.booleanProxyId = event.getBooleanProxyId();
    }
    
    @EventSourcingHandler
    void on(UpdateBooleanProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID booleanProxyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(BooleanProxyAggregate.class.getName());
}
