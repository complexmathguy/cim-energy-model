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
 * Aggregate handler for MechanicalLoadDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to MechanicalLoadDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MechanicalLoadDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MechanicalLoadDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MechanicalLoadDynamicsAggregate(CreateMechanicalLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMechanicalLoadDynamicsCommand" );
    	CreateMechanicalLoadDynamicsEvent event = new CreateMechanicalLoadDynamicsEvent(command.getMechanicalLoadDynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMechanicalLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMechanicalLoadDynamicsCommand" );
    	UpdateMechanicalLoadDynamicsEvent event = new UpdateMechanicalLoadDynamicsEvent(command.getMechanicalLoadDynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMechanicalLoadDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMechanicalLoadDynamicsCommand" );
        apply(new DeleteMechanicalLoadDynamicsEvent(command.getMechanicalLoadDynamicsId()));
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
    void on(CreateMechanicalLoadDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateMechanicalLoadDynamicsEvent" );
    	this.mechanicalLoadDynamicsId = event.getMechanicalLoadDynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdateMechanicalLoadDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID mechanicalLoadDynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(MechanicalLoadDynamicsAggregate.class.getName());
}
