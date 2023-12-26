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
 * Aggregate handler for EquivalentEquipment as outlined for the CQRS pattern, all write responsibilities 
 * related to EquivalentEquipment are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquivalentEquipmentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquivalentEquipmentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquivalentEquipmentAggregate(CreateEquivalentEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquivalentEquipmentCommand" );
    	CreateEquivalentEquipmentEvent event = new CreateEquivalentEquipmentEvent(command.getEquivalentEquipmentId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquivalentEquipmentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquivalentEquipmentCommand" );
    	UpdateEquivalentEquipmentEvent event = new UpdateEquivalentEquipmentEvent(command.getEquivalentEquipmentId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquivalentEquipmentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquivalentEquipmentCommand" );
        apply(new DeleteEquivalentEquipmentEvent(command.getEquivalentEquipmentId()));
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
    void on(CreateEquivalentEquipmentEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquivalentEquipmentEvent" );
    	this.equivalentEquipmentId = event.getEquivalentEquipmentId();
    }
    
    @EventSourcingHandler
    void on(UpdateEquivalentEquipmentEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID equivalentEquipmentId;
    

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentEquipmentAggregate.class.getName());
}
