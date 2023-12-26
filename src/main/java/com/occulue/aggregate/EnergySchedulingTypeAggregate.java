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
 * Aggregate handler for EnergySchedulingType as outlined for the CQRS pattern, all write responsibilities 
 * related to EnergySchedulingType are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EnergySchedulingTypeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EnergySchedulingTypeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EnergySchedulingTypeAggregate(CreateEnergySchedulingTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEnergySchedulingTypeCommand" );
    	CreateEnergySchedulingTypeEvent event = new CreateEnergySchedulingTypeEvent(command.getEnergySchedulingTypeId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEnergySchedulingTypeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEnergySchedulingTypeCommand" );
    	UpdateEnergySchedulingTypeEvent event = new UpdateEnergySchedulingTypeEvent(command.getEnergySchedulingTypeId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEnergySchedulingTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEnergySchedulingTypeCommand" );
        apply(new DeleteEnergySchedulingTypeEvent(command.getEnergySchedulingTypeId()));
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
    void on(CreateEnergySchedulingTypeEvent event) {	
    	LOGGER.info( "Event sourcing CreateEnergySchedulingTypeEvent" );
    	this.energySchedulingTypeId = event.getEnergySchedulingTypeId();
    }
    
    @EventSourcingHandler
    void on(UpdateEnergySchedulingTypeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID energySchedulingTypeId;
    

    private static final Logger LOGGER 	= Logger.getLogger(EnergySchedulingTypeAggregate.class.getName());
}
