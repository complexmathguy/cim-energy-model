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
 * Aggregate handler for StringProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to StringProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StringProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StringProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StringProxyAggregate(CreateStringProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStringProxyCommand" );
    	CreateStringProxyEvent event = new CreateStringProxyEvent(command.getStringProxyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStringProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStringProxyCommand" );
    	UpdateStringProxyEvent event = new UpdateStringProxyEvent(command.getStringProxyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStringProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStringProxyCommand" );
        apply(new DeleteStringProxyEvent(command.getStringProxyId()));
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
    void on(CreateStringProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateStringProxyEvent" );
    	this.stringProxyId = event.getStringProxyId();
    }
    
    @EventSourcingHandler
    void on(UpdateStringProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID stringProxyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(StringProxyAggregate.class.getName());
}
