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
 * Aggregate handler for PFVArControllerType2UserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArControllerType2UserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArControllerType2UserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArControllerType2UserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArControllerType2UserDefinedAggregate(CreatePFVArControllerType2UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArControllerType2UserDefinedCommand" );
    	CreatePFVArControllerType2UserDefinedEvent event = new CreatePFVArControllerType2UserDefinedEvent(command.getPFVArControllerType2UserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArControllerType2UserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArControllerType2UserDefinedCommand" );
    	UpdatePFVArControllerType2UserDefinedEvent event = new UpdatePFVArControllerType2UserDefinedEvent(command.getPFVArControllerType2UserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArControllerType2UserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArControllerType2UserDefinedCommand" );
        apply(new DeletePFVArControllerType2UserDefinedEvent(command.getPFVArControllerType2UserDefinedId()));
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
    void on(CreatePFVArControllerType2UserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArControllerType2UserDefinedEvent" );
    	this.pFVArControllerType2UserDefinedId = event.getPFVArControllerType2UserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArControllerType2UserDefinedEvent event) {
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
    private UUID pFVArControllerType2UserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType2UserDefinedAggregate.class.getName());
}
