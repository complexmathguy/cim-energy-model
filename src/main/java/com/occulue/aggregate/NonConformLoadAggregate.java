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
 * Aggregate handler for NonConformLoad as outlined for the CQRS pattern, all write responsibilities 
 * related to NonConformLoad are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class NonConformLoadAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public NonConformLoadAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public NonConformLoadAggregate(CreateNonConformLoadCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateNonConformLoadCommand" );
    	CreateNonConformLoadEvent event = new CreateNonConformLoadEvent(command.getNonConformLoadId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateNonConformLoadCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateNonConformLoadCommand" );
    	UpdateNonConformLoadEvent event = new UpdateNonConformLoadEvent(command.getNonConformLoadId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteNonConformLoadCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteNonConformLoadCommand" );
        apply(new DeleteNonConformLoadEvent(command.getNonConformLoadId()));
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
    void on(CreateNonConformLoadEvent event) {	
    	LOGGER.info( "Event sourcing CreateNonConformLoadEvent" );
    	this.nonConformLoadId = event.getNonConformLoadId();
    }
    
    @EventSourcingHandler
    void on(UpdateNonConformLoadEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID nonConformLoadId;
    

    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadAggregate.class.getName());
}
