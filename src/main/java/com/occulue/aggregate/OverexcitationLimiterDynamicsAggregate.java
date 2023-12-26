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
 * Aggregate handler for OverexcitationLimiterDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcitationLimiterDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcitationLimiterDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcitationLimiterDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcitationLimiterDynamicsAggregate(CreateOverexcitationLimiterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcitationLimiterDynamicsCommand" );
    	CreateOverexcitationLimiterDynamicsEvent event = new CreateOverexcitationLimiterDynamicsEvent(command.getOverexcitationLimiterDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcitationLimiterDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcitationLimiterDynamicsCommand" );
    	UpdateOverexcitationLimiterDynamicsEvent event = new UpdateOverexcitationLimiterDynamicsEvent(command.getOverexcitationLimiterDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcitationLimiterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcitationLimiterDynamicsCommand" );
        apply(new DeleteOverexcitationLimiterDynamicsEvent(command.getOverexcitationLimiterDynamicsId()));
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
    void on(CreateOverexcitationLimiterDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateOverexcitationLimiterDynamicsEvent" );
    	this.overexcitationLimiterDynamicsId = event.getOverexcitationLimiterDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcitationLimiterDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID overexcitationLimiterDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(OverexcitationLimiterDynamicsAggregate.class.getName());
}
