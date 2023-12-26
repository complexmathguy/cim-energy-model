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
 * Aggregate handler for AnalogControl as outlined for the CQRS pattern, all write responsibilities 
 * related to AnalogControl are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AnalogControlAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AnalogControlAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AnalogControlAggregate(CreateAnalogControlCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAnalogControlCommand" );
    	CreateAnalogControlEvent event = new CreateAnalogControlEvent(command.getAnalogControlId(), command.getMaxValue(), command.getMinValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAnalogControlCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAnalogControlCommand" );
    	UpdateAnalogControlEvent event = new UpdateAnalogControlEvent(command.getAnalogControlId(), command.getMaxValue(), command.getMinValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAnalogControlCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAnalogControlCommand" );
        apply(new DeleteAnalogControlEvent(command.getAnalogControlId()));
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
    void on(CreateAnalogControlEvent event) {	
    	LOGGER.info( "Event sourcing CreateAnalogControlEvent" );
    	this.analogControlId = event.getAnalogControlId();
        this.maxValue = event.getMaxValue();
        this.minValue = event.getMinValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAnalogControlEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.maxValue = event.getMaxValue();
        this.minValue = event.getMinValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID analogControlId;
    
    private String maxValue;
    private String minValue;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogControlAggregate.class.getName());
}
