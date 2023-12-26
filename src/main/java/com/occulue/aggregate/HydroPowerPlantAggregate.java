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
 * Aggregate handler for HydroPowerPlant as outlined for the CQRS pattern, all write responsibilities 
 * related to HydroPowerPlant are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class HydroPowerPlantAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public HydroPowerPlantAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public HydroPowerPlantAggregate(CreateHydroPowerPlantCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateHydroPowerPlantCommand" );
    	CreateHydroPowerPlantEvent event = new CreateHydroPowerPlantEvent(command.getHydroPowerPlantId(), command.getHydroPlantStorageType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateHydroPowerPlantCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateHydroPowerPlantCommand" );
    	UpdateHydroPowerPlantEvent event = new UpdateHydroPowerPlantEvent(command.getHydroPowerPlantId(), command.getHydroPlantStorageType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteHydroPowerPlantCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteHydroPowerPlantCommand" );
        apply(new DeleteHydroPowerPlantEvent(command.getHydroPowerPlantId()));
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
    void on(CreateHydroPowerPlantEvent event) {	
    	LOGGER.info( "Event sourcing CreateHydroPowerPlantEvent" );
    	this.hydroPowerPlantId = event.getHydroPowerPlantId();
        this.hydroPlantStorageType = event.getHydroPlantStorageType();
    }
    
    @EventSourcingHandler
    void on(UpdateHydroPowerPlantEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.hydroPlantStorageType = event.getHydroPlantStorageType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID hydroPowerPlantId;
    
    private String hydroPlantStorageType;

    private static final Logger LOGGER 	= Logger.getLogger(HydroPowerPlantAggregate.class.getName());
}
