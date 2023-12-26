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
 * Aggregate handler for IntegerProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to IntegerProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class IntegerProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public IntegerProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public IntegerProxyAggregate(CreateIntegerProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateIntegerProxyCommand" );
    	CreateIntegerProxyEvent event = new CreateIntegerProxyEvent(command.getIntegerProxyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateIntegerProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateIntegerProxyCommand" );
    	UpdateIntegerProxyEvent event = new UpdateIntegerProxyEvent(command.getIntegerProxyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteIntegerProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteIntegerProxyCommand" );
        apply(new DeleteIntegerProxyEvent(command.getIntegerProxyId()));
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
    void on(CreateIntegerProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateIntegerProxyEvent" );
    	this.integerProxyId = event.getIntegerProxyId();
    }
    
    @EventSourcingHandler
    void on(UpdateIntegerProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID integerProxyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(IntegerProxyAggregate.class.getName());
}
