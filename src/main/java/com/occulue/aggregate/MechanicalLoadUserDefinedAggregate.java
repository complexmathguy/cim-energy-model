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
 * Aggregate handler for MechanicalLoadUserDefined as outlined for the CQRS pattern, all write responsibilities 
 * related to MechanicalLoadUserDefined are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MechanicalLoadUserDefinedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MechanicalLoadUserDefinedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MechanicalLoadUserDefinedAggregate(CreateMechanicalLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMechanicalLoadUserDefinedCommand" );
    	CreateMechanicalLoadUserDefinedEvent event = new CreateMechanicalLoadUserDefinedEvent(command.getMechanicalLoadUserDefinedId(), command.getProprietary());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMechanicalLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMechanicalLoadUserDefinedCommand" );
    	UpdateMechanicalLoadUserDefinedEvent event = new UpdateMechanicalLoadUserDefinedEvent(command.getMechanicalLoadUserDefinedId(), command.getProprietary());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMechanicalLoadUserDefinedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMechanicalLoadUserDefinedCommand" );
        apply(new DeleteMechanicalLoadUserDefinedEvent(command.getMechanicalLoadUserDefinedId()));
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
    void on(CreateMechanicalLoadUserDefinedEvent event) {	
    	LOGGER.info( "Event sourcing CreateMechanicalLoadUserDefinedEvent" );
    	this.mechanicalLoadUserDefinedId = event.getMechanicalLoadUserDefinedId();
        this.proprietary = event.getProprietary();
    }
    
    @EventSourcingHandler
    void on(UpdateMechanicalLoadUserDefinedEvent event) {
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
    private UUID mechanicalLoadUserDefinedId;
    
    private String proprietary;

    private static final Logger LOGGER 	= Logger.getLogger(MechanicalLoadUserDefinedAggregate.class.getName());
}
