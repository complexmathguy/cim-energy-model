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
 * Aggregate handler for ConductingEquipment as outlined for the CQRS pattern, all write responsibilities 
 * related to ConductingEquipment are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConductingEquipmentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConductingEquipmentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConductingEquipmentAggregate(CreateConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConductingEquipmentCommand" );
    	CreateConductingEquipmentEvent event = new CreateConductingEquipmentEvent(command.getConductingEquipmentId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConductingEquipmentCommand" );
    	UpdateConductingEquipmentEvent event = new UpdateConductingEquipmentEvent(command.getConductingEquipmentId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConductingEquipmentCommand" );
        apply(new DeleteConductingEquipmentEvent(command.getConductingEquipmentId()));
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
    void on(CreateConductingEquipmentEvent event) {	
    	LOGGER.info( "Event sourcing CreateConductingEquipmentEvent" );
    	this.conductingEquipmentId = event.getConductingEquipmentId();
    }
    
    @EventSourcingHandler
    void on(UpdateConductingEquipmentEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID conductingEquipmentId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ConductingEquipmentAggregate.class.getName());
}
