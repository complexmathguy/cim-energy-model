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
 * Aggregate handler for PFVArControllerType1UserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArControllerType1UserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArControllerType1UserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArControllerType1UserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArControllerType1UserDefinedAggregate(CreatePFVArControllerType1UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArControllerType1UserDefinedCommand" );
    	CreatePFVArControllerType1UserDefinedEvent event = new CreatePFVArControllerType1UserDefinedEvent(command.getPFVArControllerType1UserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArControllerType1UserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArControllerType1UserDefinedCommand" );
    	UpdatePFVArControllerType1UserDefinedEvent event = new UpdatePFVArControllerType1UserDefinedEvent(command.getPFVArControllerType1UserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArControllerType1UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArControllerType1UserDefinedCommand" );
        apply(new DeletePFVArControllerType1UserDefinedEvent(command.getPFVArControllerType1UserDefinedId()));
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
    void on(CreatePFVArControllerType1UserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArControllerType1UserDefinedEvent" );
    	this.pFVArControllerType1UserDefinedId = event.getPFVArControllerType1UserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArControllerType1UserDefinedEvent event) {
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
    private UUID pFVArControllerType1UserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType1UserDefinedAggregate.class.getName());
}
