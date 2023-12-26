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
 * Aggregate handler for DecimalProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to DecimalProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DecimalProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DecimalProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DecimalProxyAggregate(CreateDecimalProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDecimalProxyCommand" );
    	CreateDecimalProxyEvent event = new CreateDecimalProxyEvent(command.getDecimalProxyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDecimalProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDecimalProxyCommand" );
    	UpdateDecimalProxyEvent event = new UpdateDecimalProxyEvent(command.getDecimalProxyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDecimalProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDecimalProxyCommand" );
        apply(new DeleteDecimalProxyEvent(command.getDecimalProxyId()));
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
    void on(CreateDecimalProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateDecimalProxyEvent" );
    	this.decimalProxyId = event.getDecimalProxyId();
    }
    
    @EventSourcingHandler
    void on(UpdateDecimalProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID decimalProxyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DecimalProxyAggregate.class.getName());
}
