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
 * Aggregate handler for GenICompensationForGenJ as outlined for the CQRS pattern, all write responsibilities 
 * related to GenICompensationForGenJ are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GenICompensationForGenJAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GenICompensationForGenJAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GenICompensationForGenJAggregate(CreateGenICompensationForGenJCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGenICompensationForGenJCommand" );
    	CreateGenICompensationForGenJEvent event = new CreateGenICompensationForGenJEvent(command.getGenICompensationForGenJId(), command.getRcij(), command.getXcij());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGenICompensationForGenJCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGenICompensationForGenJCommand" );
    	UpdateGenICompensationForGenJEvent event = new UpdateGenICompensationForGenJEvent(command.getGenICompensationForGenJId(), command.getRcij(), command.getXcij());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGenICompensationForGenJCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGenICompensationForGenJCommand" );
        apply(new DeleteGenICompensationForGenJEvent(command.getGenICompensationForGenJId()));
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
    void on(CreateGenICompensationForGenJEvent event) {	
    	LOGGER.info( "Event sourcing CreateGenICompensationForGenJEvent" );
    	this.genICompensationForGenJId = event.getGenICompensationForGenJId();
        this.rcij = event.getRcij();
        this.xcij = event.getXcij();
    }
    
    @EventSourcingHandler
    void on(UpdateGenICompensationForGenJEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.rcij = event.getRcij();
        this.xcij = event.getXcij();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID genICompensationForGenJId;
    
    private String rcij;
    private String xcij;

    private static final Logger LOGGER 	= Logger.getLogger(GenICompensationForGenJAggregate.class.getName());
}
