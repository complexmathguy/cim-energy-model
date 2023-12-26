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
 * Aggregate handler for ReactiveCapabilityCurve as outlined for the CQRS pattern, all write responsibilities 
 * related to ReactiveCapabilityCurve are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ReactiveCapabilityCurveAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ReactiveCapabilityCurveAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ReactiveCapabilityCurveAggregate(CreateReactiveCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateReactiveCapabilityCurveCommand" );
    	CreateReactiveCapabilityCurveEvent event = new CreateReactiveCapabilityCurveEvent(command.getReactiveCapabilityCurveId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateReactiveCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateReactiveCapabilityCurveCommand" );
    	UpdateReactiveCapabilityCurveEvent event = new UpdateReactiveCapabilityCurveEvent(command.getReactiveCapabilityCurveId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteReactiveCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteReactiveCapabilityCurveCommand" );
        apply(new DeleteReactiveCapabilityCurveEvent(command.getReactiveCapabilityCurveId()));
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
    void on(CreateReactiveCapabilityCurveEvent event) {	
    	LOGGER.info( "Event sourcing CreateReactiveCapabilityCurveEvent" );
    	this.reactiveCapabilityCurveId = event.getReactiveCapabilityCurveId();
    }
    
    @EventSourcingHandler
    void on(UpdateReactiveCapabilityCurveEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID reactiveCapabilityCurveId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ReactiveCapabilityCurveAggregate.class.getName());
}
