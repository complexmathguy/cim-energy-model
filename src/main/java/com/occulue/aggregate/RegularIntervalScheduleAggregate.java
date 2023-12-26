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
 * Aggregate handler for RegularIntervalSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to RegularIntervalSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RegularIntervalScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RegularIntervalScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RegularIntervalScheduleAggregate(CreateRegularIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRegularIntervalScheduleCommand" );
    	CreateRegularIntervalScheduleEvent event = new CreateRegularIntervalScheduleEvent(command.getRegularIntervalScheduleId(), command.getEndTime(), command.getTimeStep());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRegularIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRegularIntervalScheduleCommand" );
    	UpdateRegularIntervalScheduleEvent event = new UpdateRegularIntervalScheduleEvent(command.getRegularIntervalScheduleId(), command.getEndTime(), command.getTimeStep());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRegularIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRegularIntervalScheduleCommand" );
        apply(new DeleteRegularIntervalScheduleEvent(command.getRegularIntervalScheduleId()));
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
    void on(CreateRegularIntervalScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateRegularIntervalScheduleEvent" );
    	this.regularIntervalScheduleId = event.getRegularIntervalScheduleId();
        this.endTime = event.getEndTime();
        this.timeStep = event.getTimeStep();
    }
    
    @EventSourcingHandler
    void on(UpdateRegularIntervalScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.endTime = event.getEndTime();
        this.timeStep = event.getTimeStep();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID regularIntervalScheduleId;
    
    private String endTime;
    private String timeStep;

    private static final Logger LOGGER 	= Logger.getLogger(RegularIntervalScheduleAggregate.class.getName());
}
