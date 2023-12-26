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
 * Aggregate handler for MonthDay as outlined for the CQRS pattern, all write responsibilities 
 * related to MonthDay are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MonthDayAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MonthDayAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MonthDayAggregate(CreateMonthDayCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMonthDayCommand" );
    	CreateMonthDayEvent event = new CreateMonthDayEvent(command.getMonthDayId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMonthDayCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMonthDayCommand" );
    	UpdateMonthDayEvent event = new UpdateMonthDayEvent(command.getMonthDayId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMonthDayCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMonthDayCommand" );
        apply(new DeleteMonthDayEvent(command.getMonthDayId()));
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
    void on(CreateMonthDayEvent event) {	
    	LOGGER.info( "Event sourcing CreateMonthDayEvent" );
    	this.monthDayId = event.getMonthDayId();
    }
    
    @EventSourcingHandler
    void on(UpdateMonthDayEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID monthDayId;
    

    private static final Logger LOGGER 	= Logger.getLogger(MonthDayAggregate.class.getName());
}
