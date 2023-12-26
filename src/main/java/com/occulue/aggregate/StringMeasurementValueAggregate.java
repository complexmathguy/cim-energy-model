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
 * Aggregate handler for StringMeasurementValue as outlined for the CQRS pattern, all write responsibilities 
 * related to StringMeasurementValue are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StringMeasurementValueAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StringMeasurementValueAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StringMeasurementValueAggregate(CreateStringMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStringMeasurementValueCommand" );
    	CreateStringMeasurementValueEvent event = new CreateStringMeasurementValueEvent(command.getStringMeasurementValueId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStringMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStringMeasurementValueCommand" );
    	UpdateStringMeasurementValueEvent event = new UpdateStringMeasurementValueEvent(command.getStringMeasurementValueId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStringMeasurementValueCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStringMeasurementValueCommand" );
        apply(new DeleteStringMeasurementValueEvent(command.getStringMeasurementValueId()));
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
    void on(CreateStringMeasurementValueEvent event) {	
    	LOGGER.info( "Event sourcing CreateStringMeasurementValueEvent" );
    	this.stringMeasurementValueId = event.getStringMeasurementValueId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateStringMeasurementValueEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID stringMeasurementValueId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(StringMeasurementValueAggregate.class.getName());
}
