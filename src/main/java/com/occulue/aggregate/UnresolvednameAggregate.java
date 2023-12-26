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
 * Aggregate handler for Unresolvedname as outlined for the CQRS pattern, all write responsibilities 
 * related to Unresolvedname are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnresolvednameAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnresolvednameAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnresolvednameAggregate(CreateUnresolvednameCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateUnresolvednameCommand" );
    	CreateUnresolvednameEvent event = new CreateUnresolvednameEvent(command.getUnresolvednameId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnresolvednameCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateUnresolvednameCommand" );
    	UpdateUnresolvednameEvent event = new UpdateUnresolvednameEvent(command.getUnresolvednameId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnresolvednameCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnresolvednameCommand" );
        apply(new DeleteUnresolvednameEvent(command.getUnresolvednameId()));
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
    void on(CreateUnresolvednameEvent event) {	
    	LOGGER.info( "Event sourcing CreateUnresolvednameEvent" );
    	this.unresolvednameId = event.getUnresolvednameId();
    }
    
    @EventSourcingHandler
    void on(UpdateUnresolvednameEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID unresolvednameId;
    

    private static final Logger LOGGER 	= Logger.getLogger(UnresolvednameAggregate.class.getName());
}
