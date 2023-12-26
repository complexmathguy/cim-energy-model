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
 * Aggregate handler for StationSupply as outlined for the CQRS pattern, all write responsibilities 
 * related to StationSupply are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StationSupplyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StationSupplyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StationSupplyAggregate(CreateStationSupplyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStationSupplyCommand" );
    	CreateStationSupplyEvent event = new CreateStationSupplyEvent(command.getStationSupplyId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStationSupplyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStationSupplyCommand" );
    	UpdateStationSupplyEvent event = new UpdateStationSupplyEvent(command.getStationSupplyId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStationSupplyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStationSupplyCommand" );
        apply(new DeleteStationSupplyEvent(command.getStationSupplyId()));
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
    void on(CreateStationSupplyEvent event) {	
    	LOGGER.info( "Event sourcing CreateStationSupplyEvent" );
    	this.stationSupplyId = event.getStationSupplyId();
    }
    
    @EventSourcingHandler
    void on(UpdateStationSupplyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID stationSupplyId;
    

    private static final Logger LOGGER 	= Logger.getLogger(StationSupplyAggregate.class.getName());
}
