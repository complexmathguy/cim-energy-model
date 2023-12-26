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
 * Aggregate handler for MonthDayInterval as outlined for the CQRS pattern, all write responsibilities 
 * related to MonthDayInterval are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MonthDayIntervalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MonthDayIntervalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MonthDayIntervalAggregate(CreateMonthDayIntervalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMonthDayIntervalCommand" );
    	CreateMonthDayIntervalEvent event = new CreateMonthDayIntervalEvent(command.getMonthDayIntervalId(), command.getEnd(), command.getStart());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMonthDayIntervalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMonthDayIntervalCommand" );
    	UpdateMonthDayIntervalEvent event = new UpdateMonthDayIntervalEvent(command.getMonthDayIntervalId(), command.getEnd(), command.getStart());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMonthDayIntervalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMonthDayIntervalCommand" );
        apply(new DeleteMonthDayIntervalEvent(command.getMonthDayIntervalId()));
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
    void on(CreateMonthDayIntervalEvent event) {	
    	LOGGER.info( "Event sourcing CreateMonthDayIntervalEvent" );
    	this.monthDayIntervalId = event.getMonthDayIntervalId();
        this.end = event.getEnd();
        this.start = event.getStart();
    }
    
    @EventSourcingHandler
    void on(UpdateMonthDayIntervalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.end = event.getEnd();
        this.start = event.getStart();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID monthDayIntervalId;
    
    private String end;
    private String start;

    private static final Logger LOGGER 	= Logger.getLogger(MonthDayIntervalAggregate.class.getName());
}
