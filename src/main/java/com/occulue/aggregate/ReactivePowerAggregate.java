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
 * Aggregate handler for ReactivePower as outlined for the CQRS pattern, all write responsibilities 
 * related to ReactivePower are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ReactivePowerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ReactivePowerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ReactivePowerAggregate(CreateReactivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateReactivePowerCommand" );
    	CreateReactivePowerEvent event = new CreateReactivePowerEvent(command.getReactivePowerId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateReactivePowerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateReactivePowerCommand" );
    	UpdateReactivePowerEvent event = new UpdateReactivePowerEvent(command.getReactivePowerId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteReactivePowerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteReactivePowerCommand" );
        apply(new DeleteReactivePowerEvent(command.getReactivePowerId()));
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
    void on(CreateReactivePowerEvent event) {	
    	LOGGER.info( "Event sourcing CreateReactivePowerEvent" );
    	this.reactivePowerId = event.getReactivePowerId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateReactivePowerEvent event) {
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
    private UUID reactivePowerId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ReactivePowerAggregate.class.getName());
}
