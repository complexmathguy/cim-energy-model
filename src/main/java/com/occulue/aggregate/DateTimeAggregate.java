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
 * Aggregate handler for DateTime as outlined for the CQRS pattern, all write responsibilities 
 * related to DateTime are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DateTimeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DateTimeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DateTimeAggregate(CreateDateTimeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDateTimeCommand" );
    	CreateDateTimeEvent event = new CreateDateTimeEvent(command.getDateTimeId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDateTimeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDateTimeCommand" );
    	UpdateDateTimeEvent event = new UpdateDateTimeEvent(command.getDateTimeId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDateTimeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDateTimeCommand" );
        apply(new DeleteDateTimeEvent(command.getDateTimeId()));
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
    void on(CreateDateTimeEvent event) {	
    	LOGGER.info( "Event sourcing CreateDateTimeEvent" );
    	this.dateTimeId = event.getDateTimeId();
    }
    
    @EventSourcingHandler
    void on(UpdateDateTimeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dateTimeId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DateTimeAggregate.class.getName());
}
