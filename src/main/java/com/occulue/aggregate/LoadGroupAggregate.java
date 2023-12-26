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
 * Aggregate handler for LoadGroup as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadGroup are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadGroupAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadGroupAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadGroupAggregate(CreateLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadGroupCommand" );
    	CreateLoadGroupEvent event = new CreateLoadGroupEvent(command.getLoadGroupId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadGroupCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadGroupCommand" );
    	UpdateLoadGroupEvent event = new UpdateLoadGroupEvent(command.getLoadGroupId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadGroupCommand" );
        apply(new DeleteLoadGroupEvent(command.getLoadGroupId()));
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
    void on(CreateLoadGroupEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadGroupEvent" );
    	this.loadGroupId = event.getLoadGroupId();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadGroupEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadGroupId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LoadGroupAggregate.class.getName());
}
