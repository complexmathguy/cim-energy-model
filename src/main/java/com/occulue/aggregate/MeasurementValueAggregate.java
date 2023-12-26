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
 * Aggregate handler for MeasurementValue as outlined for the CQRS pattern, all write responsibilities 
 * related to MeasurementValue are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MeasurementValueAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MeasurementValueAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MeasurementValueAggregate(CreateMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMeasurementValueCommand" );
    	CreateMeasurementValueEvent event = new CreateMeasurementValueEvent(command.getMeasurementValueId(), command.getSensorAccuracy(), command.getTimeStamp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMeasurementValueCommand" );
    	UpdateMeasurementValueEvent event = new UpdateMeasurementValueEvent(command.getMeasurementValueId(), command.getSensorAccuracy(), command.getTimeStamp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMeasurementValueCommand" );
        apply(new DeleteMeasurementValueEvent(command.getMeasurementValueId()));
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
    void on(CreateMeasurementValueEvent event) {	
    	LOGGER.info( "Event sourcing CreateMeasurementValueEvent" );
    	this.measurementValueId = event.getMeasurementValueId();
        this.sensorAccuracy = event.getSensorAccuracy();
        this.timeStamp = event.getTimeStamp();
    }
    
    @EventSourcingHandler
    void on(UpdateMeasurementValueEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.sensorAccuracy = event.getSensorAccuracy();
        this.timeStamp = event.getTimeStamp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID measurementValueId;
    
    private String sensorAccuracy;
    private String timeStamp;

    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueAggregate.class.getName());
}
