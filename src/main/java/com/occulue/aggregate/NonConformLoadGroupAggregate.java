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
 * Aggregate handler for NonConformLoadGroup as outlined for the CQRS pattern, all write responsibilities 
 * related to NonConformLoadGroup are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class NonConformLoadGroupAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public NonConformLoadGroupAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public NonConformLoadGroupAggregate(CreateNonConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateNonConformLoadGroupCommand" );
    	CreateNonConformLoadGroupEvent event = new CreateNonConformLoadGroupEvent(command.getNonConformLoadGroupId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateNonConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateNonConformLoadGroupCommand" );
    	UpdateNonConformLoadGroupEvent event = new UpdateNonConformLoadGroupEvent(command.getNonConformLoadGroupId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteNonConformLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteNonConformLoadGroupCommand" );
        apply(new DeleteNonConformLoadGroupEvent(command.getNonConformLoadGroupId()));
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
    void on(CreateNonConformLoadGroupEvent event) {	
    	LOGGER.info( "Event sourcing CreateNonConformLoadGroupEvent" );
    	this.nonConformLoadGroupId = event.getNonConformLoadGroupId();
    }
    
    @EventSourcingHandler
    void on(UpdateNonConformLoadGroupEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID nonConformLoadGroupId;
    

    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadGroupAggregate.class.getName());
}
