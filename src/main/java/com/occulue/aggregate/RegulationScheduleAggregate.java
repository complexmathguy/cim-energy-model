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
 * Aggregate handler for RegulationSchedule as outlined for the CQRS pattern, all write responsibilities 
 * related to RegulationSchedule are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RegulationScheduleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RegulationScheduleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RegulationScheduleAggregate(CreateRegulationScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRegulationScheduleCommand" );
    	CreateRegulationScheduleEvent event = new CreateRegulationScheduleEvent(command.getRegulationScheduleId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRegulationScheduleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRegulationScheduleCommand" );
    	UpdateRegulationScheduleEvent event = new UpdateRegulationScheduleEvent(command.getRegulationScheduleId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRegulationScheduleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRegulationScheduleCommand" );
        apply(new DeleteRegulationScheduleEvent(command.getRegulationScheduleId()));
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
    void on(CreateRegulationScheduleEvent event) {	
    	LOGGER.info( "Event sourcing CreateRegulationScheduleEvent" );
    	this.regulationScheduleId = event.getRegulationScheduleId();
    }
    
    @EventSourcingHandler
    void on(UpdateRegulationScheduleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID regulationScheduleId;
    

    private static final Logger LOGGER 	= Logger.getLogger(RegulationScheduleAggregate.class.getName());
}
