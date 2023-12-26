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
 * Aggregate handler for WindGenTurbineType1IEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenTurbineType1IEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenTurbineType1IECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenTurbineType1IECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenTurbineType1IECAggregate(CreateWindGenTurbineType1IECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenTurbineType1IECCommand" );
    	CreateWindGenTurbineType1IECEvent event = new CreateWindGenTurbineType1IECEvent(command.getWindGenTurbineType1IECId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenTurbineType1IECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenTurbineType1IECCommand" );
    	UpdateWindGenTurbineType1IECEvent event = new UpdateWindGenTurbineType1IECEvent(command.getWindGenTurbineType1IECId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenTurbineType1IECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenTurbineType1IECCommand" );
        apply(new DeleteWindGenTurbineType1IECEvent(command.getWindGenTurbineType1IECId()));
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
    void on(CreateWindGenTurbineType1IECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenTurbineType1IECEvent" );
    	this.windGenTurbineType1IECId = event.getWindGenTurbineType1IECId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenTurbineType1IECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenTurbineType1IECId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType1IECAggregate.class.getName());
}
