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
 * Aggregate handler for Seconds as outlined for the CQRS pattern, all write responsibilities 
 * related to Seconds are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SecondsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SecondsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SecondsAggregate(CreateSecondsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSecondsCommand" );
    	CreateSecondsEvent event = new CreateSecondsEvent(command.getSecondsId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSecondsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSecondsCommand" );
    	UpdateSecondsEvent event = new UpdateSecondsEvent(command.getSecondsId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSecondsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSecondsCommand" );
        apply(new DeleteSecondsEvent(command.getSecondsId()));
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
    void on(CreateSecondsEvent event) {	
    	LOGGER.info( "Event sourcing CreateSecondsEvent" );
    	this.secondsId = event.getSecondsId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateSecondsEvent event) {
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
    private UUID secondsId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(SecondsAggregate.class.getName());
}
