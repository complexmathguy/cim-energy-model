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
 * Aggregate handler for DayType as outlined for the CQRS pattern, all write responsibilities 
 * related to DayType are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DayTypeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DayTypeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DayTypeAggregate(CreateDayTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDayTypeCommand" );
    	CreateDayTypeEvent event = new CreateDayTypeEvent(command.getDayTypeId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDayTypeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDayTypeCommand" );
    	UpdateDayTypeEvent event = new UpdateDayTypeEvent(command.getDayTypeId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDayTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDayTypeCommand" );
        apply(new DeleteDayTypeEvent(command.getDayTypeId()));
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
    void on(CreateDayTypeEvent event) {	
    	LOGGER.info( "Event sourcing CreateDayTypeEvent" );
    	this.dayTypeId = event.getDayTypeId();
    }
    
    @EventSourcingHandler
    void on(UpdateDayTypeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dayTypeId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DayTypeAggregate.class.getName());
}
