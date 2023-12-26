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
 * Aggregate handler for PowerSystemStabilizerDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to PowerSystemStabilizerDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PowerSystemStabilizerDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PowerSystemStabilizerDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PowerSystemStabilizerDynamicsAggregate(CreatePowerSystemStabilizerDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePowerSystemStabilizerDynamicsCommand" );
    	CreatePowerSystemStabilizerDynamicsEvent event = new CreatePowerSystemStabilizerDynamicsEvent(command.getPowerSystemStabilizerDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePowerSystemStabilizerDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePowerSystemStabilizerDynamicsCommand" );
    	UpdatePowerSystemStabilizerDynamicsEvent event = new UpdatePowerSystemStabilizerDynamicsEvent(command.getPowerSystemStabilizerDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePowerSystemStabilizerDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePowerSystemStabilizerDynamicsCommand" );
        apply(new DeletePowerSystemStabilizerDynamicsEvent(command.getPowerSystemStabilizerDynamicsId()));
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
    void on(CreatePowerSystemStabilizerDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreatePowerSystemStabilizerDynamicsEvent" );
    	this.powerSystemStabilizerDynamicsId = event.getPowerSystemStabilizerDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdatePowerSystemStabilizerDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID powerSystemStabilizerDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemStabilizerDynamicsAggregate.class.getName());
}
