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
 * Aggregate handler for ExcitationSystemUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcitationSystemUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcitationSystemUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcitationSystemUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcitationSystemUserDefinedAggregate(CreateExcitationSystemUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcitationSystemUserDefinedCommand" );
    	CreateExcitationSystemUserDefinedEvent event = new CreateExcitationSystemUserDefinedEvent(command.getExcitationSystemUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcitationSystemUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcitationSystemUserDefinedCommand" );
    	UpdateExcitationSystemUserDefinedEvent event = new UpdateExcitationSystemUserDefinedEvent(command.getExcitationSystemUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcitationSystemUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcitationSystemUserDefinedCommand" );
        apply(new DeleteExcitationSystemUserDefinedEvent(command.getExcitationSystemUserDefinedId()));
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
    void on(CreateExcitationSystemUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcitationSystemUserDefinedEvent" );
    	this.excitationSystemUserDefinedId = event.getExcitationSystemUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateExcitationSystemUserDefinedEvent event) {
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
    private UUID excitationSystemUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(ExcitationSystemUserDefinedAggregate.class.getName());
}
