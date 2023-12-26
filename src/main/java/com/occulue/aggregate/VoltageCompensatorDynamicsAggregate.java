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
 * Aggregate handler for VoltageCompensatorDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltageCompensatorDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageCompensatorDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageCompensatorDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageCompensatorDynamicsAggregate(CreateVoltageCompensatorDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageCompensatorDynamicsCommand" );
    	CreateVoltageCompensatorDynamicsEvent event = new CreateVoltageCompensatorDynamicsEvent(command.getVoltageCompensatorDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageCompensatorDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageCompensatorDynamicsCommand" );
    	UpdateVoltageCompensatorDynamicsEvent event = new UpdateVoltageCompensatorDynamicsEvent(command.getVoltageCompensatorDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageCompensatorDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageCompensatorDynamicsCommand" );
        apply(new DeleteVoltageCompensatorDynamicsEvent(command.getVoltageCompensatorDynamicsId()));
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
    void on(CreateVoltageCompensatorDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageCompensatorDynamicsEvent" );
    	this.voltageCompensatorDynamicsId = event.getVoltageCompensatorDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageCompensatorDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID voltageCompensatorDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(VoltageCompensatorDynamicsAggregate.class.getName());
}
