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
 * Aggregate handler for DCEquipmentContainer as outlined for the CQRS pattern, all write responsibilities 
 * related to DCEquipmentContainer are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCEquipmentContainerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCEquipmentContainerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCEquipmentContainerAggregate(CreateDCEquipmentContainerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCEquipmentContainerCommand" );
    	CreateDCEquipmentContainerEvent event = new CreateDCEquipmentContainerEvent(command.getDCEquipmentContainerId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCEquipmentContainerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCEquipmentContainerCommand" );
    	UpdateDCEquipmentContainerEvent event = new UpdateDCEquipmentContainerEvent(command.getDCEquipmentContainerId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCEquipmentContainerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCEquipmentContainerCommand" );
        apply(new DeleteDCEquipmentContainerEvent(command.getDCEquipmentContainerId()));
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
    void on(CreateDCEquipmentContainerEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCEquipmentContainerEvent" );
    	this.dCEquipmentContainerId = event.getDCEquipmentContainerId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCEquipmentContainerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCEquipmentContainerId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCEquipmentContainerAggregate.class.getName());
}
