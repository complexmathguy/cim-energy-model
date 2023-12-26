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
 * Aggregate handler for AngleDegrees as outlined for the CQRS pattern, all write responsibilities 
 * related to AngleDegrees are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AngleDegreesAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AngleDegreesAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AngleDegreesAggregate(CreateAngleDegreesCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAngleDegreesCommand" );
    	CreateAngleDegreesEvent event = new CreateAngleDegreesEvent(command.getAngleDegreesId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAngleDegreesCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAngleDegreesCommand" );
    	UpdateAngleDegreesEvent event = new UpdateAngleDegreesEvent(command.getAngleDegreesId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAngleDegreesCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAngleDegreesCommand" );
        apply(new DeleteAngleDegreesEvent(command.getAngleDegreesId()));
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
    void on(CreateAngleDegreesEvent event) {	
    	LOGGER.info( "Event sourcing CreateAngleDegreesEvent" );
    	this.angleDegreesId = event.getAngleDegreesId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAngleDegreesEvent event) {
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
    private UUID angleDegreesId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(AngleDegreesAggregate.class.getName());
}
