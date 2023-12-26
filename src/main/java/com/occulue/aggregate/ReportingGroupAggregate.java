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
 * Aggregate handler for ReportingGroup as outlined for the CQRS pattern, all write responsibilities 
 * related to ReportingGroup are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ReportingGroupAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ReportingGroupAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ReportingGroupAggregate(CreateReportingGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateReportingGroupCommand" );
    	CreateReportingGroupEvent event = new CreateReportingGroupEvent(command.getReportingGroupId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateReportingGroupCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateReportingGroupCommand" );
    	UpdateReportingGroupEvent event = new UpdateReportingGroupEvent(command.getReportingGroupId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteReportingGroupCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteReportingGroupCommand" );
        apply(new DeleteReportingGroupEvent(command.getReportingGroupId()));
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
    void on(CreateReportingGroupEvent event) {	
    	LOGGER.info( "Event sourcing CreateReportingGroupEvent" );
    	this.reportingGroupId = event.getReportingGroupId();
    }
    
    @EventSourcingHandler
    void on(UpdateReportingGroupEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID reportingGroupId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ReportingGroupAggregate.class.getName());
}
