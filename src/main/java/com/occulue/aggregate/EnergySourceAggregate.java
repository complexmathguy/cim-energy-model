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
 * Aggregate handler for EnergySource as outlined for the CQRS pattern, all write responsibilities 
 * related to EnergySource are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EnergySourceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EnergySourceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EnergySourceAggregate(CreateEnergySourceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEnergySourceCommand" );
    	CreateEnergySourceEvent event = new CreateEnergySourceEvent(command.getEnergySourceId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEnergySourceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEnergySourceCommand" );
    	UpdateEnergySourceEvent event = new UpdateEnergySourceEvent(command.getEnergySourceId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEnergySourceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEnergySourceCommand" );
        apply(new DeleteEnergySourceEvent(command.getEnergySourceId()));
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
    void on(CreateEnergySourceEvent event) {	
    	LOGGER.info( "Event sourcing CreateEnergySourceEvent" );
    	this.energySourceId = event.getEnergySourceId();
    }
    
    @EventSourcingHandler
    void on(UpdateEnergySourceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID energySourceId;
    

    private static final Logger LOGGER 	= Logger.getLogger(EnergySourceAggregate.class.getName());
}
