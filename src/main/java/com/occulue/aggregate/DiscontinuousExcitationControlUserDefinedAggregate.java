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
 * Aggregate handler for DiscontinuousExcitationControlUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to DiscontinuousExcitationControlUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscontinuousExcitationControlUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscontinuousExcitationControlUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscontinuousExcitationControlUserDefinedAggregate(CreateDiscontinuousExcitationControlUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscontinuousExcitationControlUserDefinedCommand" );
    	CreateDiscontinuousExcitationControlUserDefinedEvent event = new CreateDiscontinuousExcitationControlUserDefinedEvent(command.getDiscontinuousExcitationControlUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscontinuousExcitationControlUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscontinuousExcitationControlUserDefinedCommand" );
    	UpdateDiscontinuousExcitationControlUserDefinedEvent event = new UpdateDiscontinuousExcitationControlUserDefinedEvent(command.getDiscontinuousExcitationControlUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscontinuousExcitationControlUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscontinuousExcitationControlUserDefinedCommand" );
        apply(new DeleteDiscontinuousExcitationControlUserDefinedEvent(command.getDiscontinuousExcitationControlUserDefinedId()));
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
    void on(CreateDiscontinuousExcitationControlUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscontinuousExcitationControlUserDefinedEvent" );
    	this.discontinuousExcitationControlUserDefinedId = event.getDiscontinuousExcitationControlUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscontinuousExcitationControlUserDefinedEvent event) {
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
    private UUID discontinuousExcitationControlUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(DiscontinuousExcitationControlUserDefinedAggregate.class.getName());
}
