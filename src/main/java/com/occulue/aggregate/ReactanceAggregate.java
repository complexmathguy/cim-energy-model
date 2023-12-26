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
 * Aggregate handler for Reactance as outlined for the CQRS pattern, all write responsibilities 
 * related to Reactance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ReactanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ReactanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ReactanceAggregate(CreateReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateReactanceCommand" );
    	CreateReactanceEvent event = new CreateReactanceEvent(command.getReactanceId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateReactanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateReactanceCommand" );
    	UpdateReactanceEvent event = new UpdateReactanceEvent(command.getReactanceId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteReactanceCommand" );
        apply(new DeleteReactanceEvent(command.getReactanceId()));
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
    void on(CreateReactanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateReactanceEvent" );
    	this.reactanceId = event.getReactanceId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateReactanceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID reactanceId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ReactanceAggregate.class.getName());
}
