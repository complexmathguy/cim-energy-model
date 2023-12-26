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
 * Aggregate handler for EnergyArea as outlined for the CQRS pattern, all write responsibilities 
 * related to EnergyArea are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EnergyAreaAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EnergyAreaAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EnergyAreaAggregate(CreateEnergyAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEnergyAreaCommand" );
    	CreateEnergyAreaEvent event = new CreateEnergyAreaEvent(command.getEnergyAreaId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEnergyAreaCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEnergyAreaCommand" );
    	UpdateEnergyAreaEvent event = new UpdateEnergyAreaEvent(command.getEnergyAreaId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEnergyAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEnergyAreaCommand" );
        apply(new DeleteEnergyAreaEvent(command.getEnergyAreaId()));
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
    void on(CreateEnergyAreaEvent event) {	
    	LOGGER.info( "Event sourcing CreateEnergyAreaEvent" );
    	this.energyAreaId = event.getEnergyAreaId();
    }
    
    @EventSourcingHandler
    void on(UpdateEnergyAreaEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID energyAreaId;
    

    private static final Logger LOGGER 	= Logger.getLogger(EnergyAreaAggregate.class.getName());
}
