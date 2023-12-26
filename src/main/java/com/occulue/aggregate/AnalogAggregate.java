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
 * Aggregate handler for Analog as outlined for the CQRS pattern, all write responsibilities 
 * related to Analog are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AnalogAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AnalogAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AnalogAggregate(CreateAnalogCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAnalogCommand" );
    	CreateAnalogEvent event = new CreateAnalogEvent(command.getAnalogId(), command.getPositiveFlowIn());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAnalogCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAnalogCommand" );
    	UpdateAnalogEvent event = new UpdateAnalogEvent(command.getAnalogId(), command.getPositiveFlowIn());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAnalogCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAnalogCommand" );
        apply(new DeleteAnalogEvent(command.getAnalogId()));
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
    void on(CreateAnalogEvent event) {	
    	LOGGER.info( "Event sourcing CreateAnalogEvent" );
    	this.analogId = event.getAnalogId();
        this.positiveFlowIn = event.getPositiveFlowIn();
    }
    
    @EventSourcingHandler
    void on(UpdateAnalogEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.positiveFlowIn = event.getPositiveFlowIn();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID analogId;
    
    private String positiveFlowIn;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogAggregate.class.getName());
}
