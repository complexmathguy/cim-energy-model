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
 * Aggregate handler for BasicIntervalSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to BasicIntervalSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BasicIntervalScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BasicIntervalScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BasicIntervalScheduleAggregate(CreateBasicIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBasicIntervalScheduleCommand" );
    	CreateBasicIntervalScheduleEvent event = new CreateBasicIntervalScheduleEvent(command.getBasicIntervalScheduleId(), command.getStartTime(), command.getValue1Unit(), command.getValue2Unit());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBasicIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBasicIntervalScheduleCommand" );
    	UpdateBasicIntervalScheduleEvent event = new UpdateBasicIntervalScheduleEvent(command.getBasicIntervalScheduleId(), command.getStartTime(), command.getValue1Unit(), command.getValue2Unit());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBasicIntervalScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBasicIntervalScheduleCommand" );
        apply(new DeleteBasicIntervalScheduleEvent(command.getBasicIntervalScheduleId()));
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
    void on(CreateBasicIntervalScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateBasicIntervalScheduleEvent" );
    	this.basicIntervalScheduleId = event.getBasicIntervalScheduleId();
        this.startTime = event.getStartTime();
        this.value1Unit = event.getValue1Unit();
        this.value2Unit = event.getValue2Unit();
    }
    
    @EventSourcingHandler
    void on(UpdateBasicIntervalScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.startTime = event.getStartTime();
        this.value1Unit = event.getValue1Unit();
        this.value2Unit = event.getValue2Unit();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID basicIntervalScheduleId;
    
    private String startTime;
    private String value1Unit;
    private String value2Unit;

    private static final Logger LOGGER 	= Logger.getLogger(BasicIntervalScheduleAggregate.class.getName());
}
