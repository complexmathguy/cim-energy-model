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
 * Aggregate handler for VoltageAdjusterDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltageAdjusterDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageAdjusterDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageAdjusterDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageAdjusterDynamicsAggregate(CreateVoltageAdjusterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageAdjusterDynamicsCommand" );
    	CreateVoltageAdjusterDynamicsEvent event = new CreateVoltageAdjusterDynamicsEvent(command.getVoltageAdjusterDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageAdjusterDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageAdjusterDynamicsCommand" );
    	UpdateVoltageAdjusterDynamicsEvent event = new UpdateVoltageAdjusterDynamicsEvent(command.getVoltageAdjusterDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageAdjusterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageAdjusterDynamicsCommand" );
        apply(new DeleteVoltageAdjusterDynamicsEvent(command.getVoltageAdjusterDynamicsId()));
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
    void on(CreateVoltageAdjusterDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageAdjusterDynamicsEvent" );
    	this.voltageAdjusterDynamicsId = event.getVoltageAdjusterDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageAdjusterDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID voltageAdjusterDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(VoltageAdjusterDynamicsAggregate.class.getName());
}
