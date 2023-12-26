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
 * Aggregate handler for Temperature as outlined for the CQRS pattern, all write responsibilities 
 * related to Temperature are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TemperatureAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TemperatureAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TemperatureAggregate(CreateTemperatureCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTemperatureCommand" );
    	CreateTemperatureEvent event = new CreateTemperatureEvent(command.getTemperatureId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTemperatureCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTemperatureCommand" );
    	UpdateTemperatureEvent event = new UpdateTemperatureEvent(command.getTemperatureId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTemperatureCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTemperatureCommand" );
        apply(new DeleteTemperatureEvent(command.getTemperatureId()));
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
    void on(CreateTemperatureEvent event) {	
    	LOGGER.info( "Event sourcing CreateTemperatureEvent" );
    	this.temperatureId = event.getTemperatureId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateTemperatureEvent event) {
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
    private UUID temperatureId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(TemperatureAggregate.class.getName());
}
