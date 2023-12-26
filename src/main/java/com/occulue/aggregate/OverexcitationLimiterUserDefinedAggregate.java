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
 * Aggregate handler for OverexcitationLimiterUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcitationLimiterUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcitationLimiterUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcitationLimiterUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcitationLimiterUserDefinedAggregate(CreateOverexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcitationLimiterUserDefinedCommand" );
    	CreateOverexcitationLimiterUserDefinedEvent event = new CreateOverexcitationLimiterUserDefinedEvent(command.getOverexcitationLimiterUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcitationLimiterUserDefinedCommand" );
    	UpdateOverexcitationLimiterUserDefinedEvent event = new UpdateOverexcitationLimiterUserDefinedEvent(command.getOverexcitationLimiterUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcitationLimiterUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcitationLimiterUserDefinedCommand" );
        apply(new DeleteOverexcitationLimiterUserDefinedEvent(command.getOverexcitationLimiterUserDefinedId()));
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
    void on(CreateOverexcitationLimiterUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateOverexcitationLimiterUserDefinedEvent" );
    	this.overexcitationLimiterUserDefinedId = event.getOverexcitationLimiterUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcitationLimiterUserDefinedEvent event) {
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
    private UUID overexcitationLimiterUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcitationLimiterUserDefinedAggregate.class.getName());
}
