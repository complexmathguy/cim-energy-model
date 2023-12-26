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
 * Aggregate handler for MeasurementValueSource as outlined for the CQRS pattern, all write responsibilities 
 * related to MeasurementValueSource are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MeasurementValueSourceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MeasurementValueSourceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MeasurementValueSourceAggregate(CreateMeasurementValueSourceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMeasurementValueSourceCommand" );
    	CreateMeasurementValueSourceEvent event = new CreateMeasurementValueSourceEvent(command.getMeasurementValueSourceId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMeasurementValueSourceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMeasurementValueSourceCommand" );
    	UpdateMeasurementValueSourceEvent event = new UpdateMeasurementValueSourceEvent(command.getMeasurementValueSourceId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMeasurementValueSourceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMeasurementValueSourceCommand" );
        apply(new DeleteMeasurementValueSourceEvent(command.getMeasurementValueSourceId()));
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
    void on(CreateMeasurementValueSourceEvent event) {	
    	LOGGER.info( "Event sourcing CreateMeasurementValueSourceEvent" );
    	this.measurementValueSourceId = event.getMeasurementValueSourceId();
    }
    
    @EventSourcingHandler
    void on(UpdateMeasurementValueSourceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID measurementValueSourceId;
    

    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueSourceAggregate.class.getName());
}
