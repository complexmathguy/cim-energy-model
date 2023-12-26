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
 * Aggregate handler for DCConductingEquipment as outlined for the CQRS pattern, all write responsibilities 
 * related to DCConductingEquipment are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCConductingEquipmentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCConductingEquipmentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCConductingEquipmentAggregate(CreateDCConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCConductingEquipmentCommand" );
    	CreateDCConductingEquipmentEvent event = new CreateDCConductingEquipmentEvent(command.getDCConductingEquipmentId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCConductingEquipmentCommand" );
    	UpdateDCConductingEquipmentEvent event = new UpdateDCConductingEquipmentEvent(command.getDCConductingEquipmentId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCConductingEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCConductingEquipmentCommand" );
        apply(new DeleteDCConductingEquipmentEvent(command.getDCConductingEquipmentId()));
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
    void on(CreateDCConductingEquipmentEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCConductingEquipmentEvent" );
    	this.dCConductingEquipmentId = event.getDCConductingEquipmentId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCConductingEquipmentEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCConductingEquipmentId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCConductingEquipmentAggregate.class.getName());
}
