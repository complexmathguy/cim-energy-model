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
 * Aggregate handler for ConformLoadSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to ConformLoadSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConformLoadScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConformLoadScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConformLoadScheduleAggregate(CreateConformLoadScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConformLoadScheduleCommand" );
    	CreateConformLoadScheduleEvent event = new CreateConformLoadScheduleEvent(command.getConformLoadScheduleId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConformLoadScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConformLoadScheduleCommand" );
    	UpdateConformLoadScheduleEvent event = new UpdateConformLoadScheduleEvent(command.getConformLoadScheduleId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConformLoadScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConformLoadScheduleCommand" );
        apply(new DeleteConformLoadScheduleEvent(command.getConformLoadScheduleId()));
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
    void on(CreateConformLoadScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateConformLoadScheduleEvent" );
    	this.conformLoadScheduleId = event.getConformLoadScheduleId();
    }
    
    @EventSourcingHandler
    void on(UpdateConformLoadScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID conformLoadScheduleId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadScheduleAggregate.class.getName());
}
