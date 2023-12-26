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
 * Aggregate handler for Frequency as outlined for the CQRS pattern, all write responsibilities 
 * related to Frequency are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class FrequencyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public FrequencyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public FrequencyAggregate(CreateFrequencyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateFrequencyCommand" );
    	CreateFrequencyEvent event = new CreateFrequencyEvent(command.getFrequencyId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateFrequencyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateFrequencyCommand" );
    	UpdateFrequencyEvent event = new UpdateFrequencyEvent(command.getFrequencyId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteFrequencyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteFrequencyCommand" );
        apply(new DeleteFrequencyEvent(command.getFrequencyId()));
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
    void on(CreateFrequencyEvent event) {	
    	LOGGER.info( "Event sourcing CreateFrequencyEvent" );
    	this.frequencyId = event.getFrequencyId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateFrequencyEvent event) {
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
    private UUID frequencyId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(FrequencyAggregate.class.getName());
}
