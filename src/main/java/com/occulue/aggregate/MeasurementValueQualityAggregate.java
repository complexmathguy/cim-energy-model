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
 * Aggregate handler for MeasurementValueQuality as outlined for the CQRS pattern, all write responsibilities 
 * related to MeasurementValueQuality are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MeasurementValueQualityAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MeasurementValueQualityAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MeasurementValueQualityAggregate(CreateMeasurementValueQualityCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMeasurementValueQualityCommand" );
    	CreateMeasurementValueQualityEvent event = new CreateMeasurementValueQualityEvent(command.getMeasurementValueQualityId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMeasurementValueQualityCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMeasurementValueQualityCommand" );
    	UpdateMeasurementValueQualityEvent event = new UpdateMeasurementValueQualityEvent(command.getMeasurementValueQualityId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMeasurementValueQualityCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMeasurementValueQualityCommand" );
        apply(new DeleteMeasurementValueQualityEvent(command.getMeasurementValueQualityId()));
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
    void on(CreateMeasurementValueQualityEvent event) {	
    	LOGGER.info( "Event sourcing CreateMeasurementValueQualityEvent" );
    	this.measurementValueQualityId = event.getMeasurementValueQualityId();
    }
    
    @EventSourcingHandler
    void on(UpdateMeasurementValueQualityEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID measurementValueQualityId;
    

    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueQualityAggregate.class.getName());
}
