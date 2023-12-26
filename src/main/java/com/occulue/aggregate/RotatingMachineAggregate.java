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
 * Aggregate handler for RotatingMachine as outlined for the CQRS pattern, all write responsibilities 
 * related to RotatingMachine are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RotatingMachineAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RotatingMachineAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RotatingMachineAggregate(CreateRotatingMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRotatingMachineCommand" );
    	CreateRotatingMachineEvent event = new CreateRotatingMachineEvent(command.getRotatingMachineId(), command.getRatedPowerFactor(), command.getRatedS(), command.getRatedU());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRotatingMachineCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRotatingMachineCommand" );
    	UpdateRotatingMachineEvent event = new UpdateRotatingMachineEvent(command.getRotatingMachineId(), command.getRatedPowerFactor(), command.getRatedS(), command.getRatedU());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRotatingMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRotatingMachineCommand" );
        apply(new DeleteRotatingMachineEvent(command.getRotatingMachineId()));
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
    void on(CreateRotatingMachineEvent event) {	
    	LOGGER.info( "Event sourcing CreateRotatingMachineEvent" );
    	this.rotatingMachineId = event.getRotatingMachineId();
        this.ratedPowerFactor = event.getRatedPowerFactor();
        this.ratedS = event.getRatedS();
        this.ratedU = event.getRatedU();
    }
    
    @EventSourcingHandler
    void on(UpdateRotatingMachineEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ratedPowerFactor = event.getRatedPowerFactor();
        this.ratedS = event.getRatedS();
        this.ratedU = event.getRatedU();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID rotatingMachineId;
    
    private String ratedPowerFactor;
    private String ratedS;
    private String ratedU;

    private static final Logger LOGGER 	= Logger.getLogger(RotatingMachineAggregate.class.getName());
}
