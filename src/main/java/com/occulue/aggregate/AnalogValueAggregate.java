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
 * Aggregate handler for AnalogValue as outlined for the CQRS pattern, all write responsibilities 
 * related to AnalogValue are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AnalogValueAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AnalogValueAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AnalogValueAggregate(CreateAnalogValueCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAnalogValueCommand" );
    	CreateAnalogValueEvent event = new CreateAnalogValueEvent(command.getAnalogValueId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAnalogValueCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAnalogValueCommand" );
    	UpdateAnalogValueEvent event = new UpdateAnalogValueEvent(command.getAnalogValueId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAnalogValueCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAnalogValueCommand" );
        apply(new DeleteAnalogValueEvent(command.getAnalogValueId()));
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
    void on(CreateAnalogValueEvent event) {	
    	LOGGER.info( "Event sourcing CreateAnalogValueEvent" );
    	this.analogValueId = event.getAnalogValueId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAnalogValueEvent event) {
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
    private UUID analogValueId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogValueAggregate.class.getName());
}
