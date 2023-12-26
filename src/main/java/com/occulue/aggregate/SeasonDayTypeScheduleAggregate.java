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
 * Aggregate handler for SeasonDayTypeSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to SeasonDayTypeSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SeasonDayTypeScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SeasonDayTypeScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SeasonDayTypeScheduleAggregate(CreateSeasonDayTypeScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSeasonDayTypeScheduleCommand" );
    	CreateSeasonDayTypeScheduleEvent event = new CreateSeasonDayTypeScheduleEvent(command.getSeasonDayTypeScheduleId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSeasonDayTypeScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSeasonDayTypeScheduleCommand" );
    	UpdateSeasonDayTypeScheduleEvent event = new UpdateSeasonDayTypeScheduleEvent(command.getSeasonDayTypeScheduleId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSeasonDayTypeScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSeasonDayTypeScheduleCommand" );
        apply(new DeleteSeasonDayTypeScheduleEvent(command.getSeasonDayTypeScheduleId()));
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
    void on(CreateSeasonDayTypeScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateSeasonDayTypeScheduleEvent" );
    	this.seasonDayTypeScheduleId = event.getSeasonDayTypeScheduleId();
    }
    
    @EventSourcingHandler
    void on(UpdateSeasonDayTypeScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID seasonDayTypeScheduleId;
    

    private static final Logger LOGGER 	= Logger.getLogger(SeasonDayTypeScheduleAggregate.class.getName());
}
