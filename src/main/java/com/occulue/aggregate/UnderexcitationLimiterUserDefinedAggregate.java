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
 * Aggregate handler for UnderexcitationLimiterUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcitationLimiterUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcitationLimiterUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcitationLimiterUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcitationLimiterUserDefinedAggregate(CreateUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcitationLimiterUserDefinedCommand" );
    	CreateUnderexcitationLimiterUserDefinedEvent event = new CreateUnderexcitationLimiterUserDefinedEvent(command.getUnderexcitationLimiterUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcitationLimiterUserDefinedCommand" );
    	UpdateUnderexcitationLimiterUserDefinedEvent event = new UpdateUnderexcitationLimiterUserDefinedEvent(command.getUnderexcitationLimiterUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcitationLimiterUserDefinedCommand" );
        apply(new DeleteUnderexcitationLimiterUserDefinedEvent(command.getUnderexcitationLimiterUserDefinedId()));
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
    void on(CreateUnderexcitationLimiterUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcitationLimiterUserDefinedEvent" );
    	this.underexcitationLimiterUserDefinedId = event.getUnderexcitationLimiterUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcitationLimiterUserDefinedEvent event) {
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
    private UUID underexcitationLimiterUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcitationLimiterUserDefinedAggregate.class.getName());
}
