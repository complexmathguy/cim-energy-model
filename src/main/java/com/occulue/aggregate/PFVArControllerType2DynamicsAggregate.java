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
 * Aggregate handler for PFVArControllerType2Dynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArControllerType2Dynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArControllerType2DynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArControllerType2DynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArControllerType2DynamicsAggregate(CreatePFVArControllerType2DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArControllerType2DynamicsCommand" );
    	CreatePFVArControllerType2DynamicsEvent event = new CreatePFVArControllerType2DynamicsEvent(command.getPFVArControllerType2DynamicsId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArControllerType2DynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArControllerType2DynamicsCommand" );
    	UpdatePFVArControllerType2DynamicsEvent event = new UpdatePFVArControllerType2DynamicsEvent(command.getPFVArControllerType2DynamicsId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArControllerType2DynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArControllerType2DynamicsCommand" );
        apply(new DeletePFVArControllerType2DynamicsEvent(command.getPFVArControllerType2DynamicsId()));
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
    void on(CreatePFVArControllerType2DynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArControllerType2DynamicsEvent" );
    	this.pFVArControllerType2DynamicsId = event.getPFVArControllerType2DynamicsId();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArControllerType2DynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pFVArControllerType2DynamicsId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType2DynamicsAggregate.class.getName());
}
