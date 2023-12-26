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
 * Aggregate handler for PFVArControllerType1Dynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArControllerType1Dynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArControllerType1DynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArControllerType1DynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArControllerType1DynamicsAggregate(CreatePFVArControllerType1DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArControllerType1DynamicsCommand" );
    	CreatePFVArControllerType1DynamicsEvent event = new CreatePFVArControllerType1DynamicsEvent(command.getPFVArControllerType1DynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArControllerType1DynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArControllerType1DynamicsCommand" );
    	UpdatePFVArControllerType1DynamicsEvent event = new UpdatePFVArControllerType1DynamicsEvent(command.getPFVArControllerType1DynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArControllerType1DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArControllerType1DynamicsCommand" );
        apply(new DeletePFVArControllerType1DynamicsEvent(command.getPFVArControllerType1DynamicsId()));
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
    void on(CreatePFVArControllerType1DynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArControllerType1DynamicsEvent" );
    	this.pFVArControllerType1DynamicsId = event.getPFVArControllerType1DynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArControllerType1DynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pFVArControllerType1DynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType1DynamicsAggregate.class.getName());
}
