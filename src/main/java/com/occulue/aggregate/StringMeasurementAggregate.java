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
 * Aggregate handler for StringMeasurement as outlined for the CQRS pattern, all write responsibilities 
 * related to StringMeasurement are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StringMeasurementAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StringMeasurementAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StringMeasurementAggregate(CreateStringMeasurementCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStringMeasurementCommand" );
    	CreateStringMeasurementEvent event = new CreateStringMeasurementEvent(command.getStringMeasurementId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStringMeasurementCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStringMeasurementCommand" );
    	UpdateStringMeasurementEvent event = new UpdateStringMeasurementEvent(command.getStringMeasurementId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStringMeasurementCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStringMeasurementCommand" );
        apply(new DeleteStringMeasurementEvent(command.getStringMeasurementId()));
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
    void on(CreateStringMeasurementEvent event) {	
    	LOGGER.info( "Event sourcing CreateStringMeasurementEvent" );
    	this.stringMeasurementId = event.getStringMeasurementId();
    }
    
    @EventSourcingHandler
    void on(UpdateStringMeasurementEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID stringMeasurementId;
    

    private static final Logger LOGGER 	= Logger.getLogger(StringMeasurementAggregate.class.getName());
}
