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
 * Aggregate handler for VoltageCompensatorUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltageCompensatorUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageCompensatorUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageCompensatorUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageCompensatorUserDefinedAggregate(CreateVoltageCompensatorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageCompensatorUserDefinedCommand" );
    	CreateVoltageCompensatorUserDefinedEvent event = new CreateVoltageCompensatorUserDefinedEvent(command.getVoltageCompensatorUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageCompensatorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageCompensatorUserDefinedCommand" );
    	UpdateVoltageCompensatorUserDefinedEvent event = new UpdateVoltageCompensatorUserDefinedEvent(command.getVoltageCompensatorUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageCompensatorUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageCompensatorUserDefinedCommand" );
        apply(new DeleteVoltageCompensatorUserDefinedEvent(command.getVoltageCompensatorUserDefinedId()));
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
    void on(CreateVoltageCompensatorUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageCompensatorUserDefinedEvent" );
    	this.voltageCompensatorUserDefinedId = event.getVoltageCompensatorUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageCompensatorUserDefinedEvent event) {
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
    private UUID voltageCompensatorUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageCompensatorUserDefinedAggregate.class.getName());
}
