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
 * Aggregate handler for HydroGeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to HydroGeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class HydroGeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public HydroGeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public HydroGeneratingUnitAggregate(CreateHydroGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateHydroGeneratingUnitCommand" );
    	CreateHydroGeneratingUnitEvent event = new CreateHydroGeneratingUnitEvent(command.getHydroGeneratingUnitId(), command.getEnergyConversionCapability());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateHydroGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateHydroGeneratingUnitCommand" );
    	UpdateHydroGeneratingUnitEvent event = new UpdateHydroGeneratingUnitEvent(command.getHydroGeneratingUnitId(), command.getEnergyConversionCapability());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteHydroGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteHydroGeneratingUnitCommand" );
        apply(new DeleteHydroGeneratingUnitEvent(command.getHydroGeneratingUnitId()));
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
    void on(CreateHydroGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateHydroGeneratingUnitEvent" );
    	this.hydroGeneratingUnitId = event.getHydroGeneratingUnitId();
        this.energyConversionCapability = event.getEnergyConversionCapability();
    }
    
    @EventSourcingHandler
    void on(UpdateHydroGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.energyConversionCapability = event.getEnergyConversionCapability();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID hydroGeneratingUnitId;
    
    private String energyConversionCapability;

    private static final Logger LOGGER 	= Logger.getLogger(HydroGeneratingUnitAggregate.class.getName());
}
