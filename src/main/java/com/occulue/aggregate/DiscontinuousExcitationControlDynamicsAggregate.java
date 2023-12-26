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
 * Aggregate handler for DiscontinuousExcitationControlDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to DiscontinuousExcitationControlDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscontinuousExcitationControlDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscontinuousExcitationControlDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscontinuousExcitationControlDynamicsAggregate(CreateDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscontinuousExcitationControlDynamicsCommand" );
    	CreateDiscontinuousExcitationControlDynamicsEvent event = new CreateDiscontinuousExcitationControlDynamicsEvent(command.getDiscontinuousExcitationControlDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscontinuousExcitationControlDynamicsCommand" );
    	UpdateDiscontinuousExcitationControlDynamicsEvent event = new UpdateDiscontinuousExcitationControlDynamicsEvent(command.getDiscontinuousExcitationControlDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscontinuousExcitationControlDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscontinuousExcitationControlDynamicsCommand" );
        apply(new DeleteDiscontinuousExcitationControlDynamicsEvent(command.getDiscontinuousExcitationControlDynamicsId()));
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
    void on(CreateDiscontinuousExcitationControlDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscontinuousExcitationControlDynamicsEvent" );
    	this.discontinuousExcitationControlDynamicsId = event.getDiscontinuousExcitationControlDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscontinuousExcitationControlDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID discontinuousExcitationControlDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DiscontinuousExcitationControlDynamicsAggregate.class.getName());
}
