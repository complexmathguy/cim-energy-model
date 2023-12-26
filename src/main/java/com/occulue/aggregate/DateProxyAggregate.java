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
 * Aggregate handler for DateProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to DateProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DateProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DateProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DateProxyAggregate(CreateDateProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDateProxyCommand" );
    	CreateDateProxyEvent event = new CreateDateProxyEvent(command.getDateProxyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDateProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDateProxyCommand" );
    	UpdateDateProxyEvent event = new UpdateDateProxyEvent(command.getDateProxyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDateProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDateProxyCommand" );
        apply(new DeleteDateProxyEvent(command.getDateProxyId()));
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
    void on(CreateDateProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateDateProxyEvent" );
    	this.dateProxyId = event.getDateProxyId();
    }
    
    @EventSourcingHandler
    void on(UpdateDateProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dateProxyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DateProxyAggregate.class.getName());
}
