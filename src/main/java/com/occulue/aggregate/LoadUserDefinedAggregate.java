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
 * Aggregate handler for LoadUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadUserDefinedAggregate(CreateLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadUserDefinedCommand" );
    	CreateLoadUserDefinedEvent event = new CreateLoadUserDefinedEvent(command.getLoadUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadUserDefinedCommand" );
    	UpdateLoadUserDefinedEvent event = new UpdateLoadUserDefinedEvent(command.getLoadUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadUserDefinedCommand" );
        apply(new DeleteLoadUserDefinedEvent(command.getLoadUserDefinedId()));
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
    void on(CreateLoadUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadUserDefinedEvent" );
    	this.loadUserDefinedId = event.getLoadUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadUserDefinedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.proprietary = event.getProprietary();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(LoadUserDefinedAggregate.class.getName());
}
