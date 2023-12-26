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
 * Aggregate handler for AngleRadians as outlined for the CQRS pattern, all write responsibilities 
 * related to AngleRadians are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AngleRadiansAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AngleRadiansAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AngleRadiansAggregate(CreateAngleRadiansCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAngleRadiansCommand" );
    	CreateAngleRadiansEvent event = new CreateAngleRadiansEvent(command.getAngleRadiansId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAngleRadiansCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAngleRadiansCommand" );
    	UpdateAngleRadiansEvent event = new UpdateAngleRadiansEvent(command.getAngleRadiansId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAngleRadiansCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAngleRadiansCommand" );
        apply(new DeleteAngleRadiansEvent(command.getAngleRadiansId()));
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
    void on(CreateAngleRadiansEvent event) {	
    	LOGGER.info( "Event sourcing CreateAngleRadiansEvent" );
    	this.angleRadiansId = event.getAngleRadiansId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAngleRadiansEvent event) {
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
    private UUID angleRadiansId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(AngleRadiansAggregate.class.getName());
}
