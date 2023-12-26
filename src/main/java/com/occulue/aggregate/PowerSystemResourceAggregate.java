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
 * Aggregate handler for PowerSystemResource as outlined for the CQRS pattern, all write responsibilities 
 * related to PowerSystemResource are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PowerSystemResourceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PowerSystemResourceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PowerSystemResourceAggregate(CreatePowerSystemResourceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePowerSystemResourceCommand" );
    	CreatePowerSystemResourceEvent event = new CreatePowerSystemResourceEvent(command.getPowerSystemResourceId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePowerSystemResourceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePowerSystemResourceCommand" );
    	UpdatePowerSystemResourceEvent event = new UpdatePowerSystemResourceEvent(command.getPowerSystemResourceId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePowerSystemResourceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePowerSystemResourceCommand" );
        apply(new DeletePowerSystemResourceEvent(command.getPowerSystemResourceId()));
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
    void on(CreatePowerSystemResourceEvent event) {	
    	LOGGER.info( "Event sourcing CreatePowerSystemResourceEvent" );
    	this.powerSystemResourceId = event.getPowerSystemResourceId();
    }
    
    @EventSourcingHandler
    void on(UpdatePowerSystemResourceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID powerSystemResourceId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemResourceAggregate.class.getName());
}
