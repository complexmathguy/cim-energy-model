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
 * Aggregate handler for ConformLoadGroup as outlined for the CQRS pattern, all write responsibilities 
 * related to ConformLoadGroup are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConformLoadGroupAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConformLoadGroupAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConformLoadGroupAggregate(CreateConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConformLoadGroupCommand" );
    	CreateConformLoadGroupEvent event = new CreateConformLoadGroupEvent(command.getConformLoadGroupId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConformLoadGroupCommand" );
    	UpdateConformLoadGroupEvent event = new UpdateConformLoadGroupEvent(command.getConformLoadGroupId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConformLoadGroupCommand" );
        apply(new DeleteConformLoadGroupEvent(command.getConformLoadGroupId()));
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
    void on(CreateConformLoadGroupEvent event) {	
    	LOGGER.info( "Event sourcing CreateConformLoadGroupEvent" );
    	this.conformLoadGroupId = event.getConformLoadGroupId();
    }
    
    @EventSourcingHandler
    void on(UpdateConformLoadGroupEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID conformLoadGroupId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadGroupAggregate.class.getName());
}
