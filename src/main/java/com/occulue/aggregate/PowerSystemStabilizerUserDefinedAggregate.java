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
 * Aggregate handler for PowerSystemStabilizerUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to PowerSystemStabilizerUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PowerSystemStabilizerUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PowerSystemStabilizerUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PowerSystemStabilizerUserDefinedAggregate(CreatePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePowerSystemStabilizerUserDefinedCommand" );
    	CreatePowerSystemStabilizerUserDefinedEvent event = new CreatePowerSystemStabilizerUserDefinedEvent(command.getPowerSystemStabilizerUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePowerSystemStabilizerUserDefinedCommand" );
    	UpdatePowerSystemStabilizerUserDefinedEvent event = new UpdatePowerSystemStabilizerUserDefinedEvent(command.getPowerSystemStabilizerUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePowerSystemStabilizerUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePowerSystemStabilizerUserDefinedCommand" );
        apply(new DeletePowerSystemStabilizerUserDefinedEvent(command.getPowerSystemStabilizerUserDefinedId()));
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
    void on(CreatePowerSystemStabilizerUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreatePowerSystemStabilizerUserDefinedEvent" );
    	this.powerSystemStabilizerUserDefinedId = event.getPowerSystemStabilizerUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdatePowerSystemStabilizerUserDefinedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.proprietary = event.getProprietary();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID powerSystemStabilizerUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemStabilizerUserDefinedAggregate.class.getName());
}
