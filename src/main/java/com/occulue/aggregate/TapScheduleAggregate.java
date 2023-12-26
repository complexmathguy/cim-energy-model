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
 * Aggregate handler for TapSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to TapSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TapScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TapScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TapScheduleAggregate(CreateTapScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTapScheduleCommand" );
    	CreateTapScheduleEvent event = new CreateTapScheduleEvent(command.getTapScheduleId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTapScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTapScheduleCommand" );
    	UpdateTapScheduleEvent event = new UpdateTapScheduleEvent(command.getTapScheduleId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTapScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTapScheduleCommand" );
        apply(new DeleteTapScheduleEvent(command.getTapScheduleId()));
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
    void on(CreateTapScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateTapScheduleEvent" );
    	this.tapScheduleId = event.getTapScheduleId();
    }
    
    @EventSourcingHandler
    void on(UpdateTapScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID tapScheduleId;
    

    private static final Logger LOGGER 	= Logger.getLogger(TapScheduleAggregate.class.getName());
}
