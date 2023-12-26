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
 * Aggregate handler for ThermalGeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to ThermalGeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ThermalGeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ThermalGeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ThermalGeneratingUnitAggregate(CreateThermalGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateThermalGeneratingUnitCommand" );
    	CreateThermalGeneratingUnitEvent event = new CreateThermalGeneratingUnitEvent(command.getThermalGeneratingUnitId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateThermalGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateThermalGeneratingUnitCommand" );
    	UpdateThermalGeneratingUnitEvent event = new UpdateThermalGeneratingUnitEvent(command.getThermalGeneratingUnitId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteThermalGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteThermalGeneratingUnitCommand" );
        apply(new DeleteThermalGeneratingUnitEvent(command.getThermalGeneratingUnitId()));
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
    void on(CreateThermalGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateThermalGeneratingUnitEvent" );
    	this.thermalGeneratingUnitId = event.getThermalGeneratingUnitId();
    }
    
    @EventSourcingHandler
    void on(UpdateThermalGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID thermalGeneratingUnitId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ThermalGeneratingUnitAggregate.class.getName());
}
