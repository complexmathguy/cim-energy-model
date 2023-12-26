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
 * Aggregate handler for WindGenTurbineType2IEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenTurbineType2IEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenTurbineType2IECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenTurbineType2IECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenTurbineType2IECAggregate(CreateWindGenTurbineType2IECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenTurbineType2IECCommand" );
    	CreateWindGenTurbineType2IECEvent event = new CreateWindGenTurbineType2IECEvent(command.getWindGenTurbineType2IECId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenTurbineType2IECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenTurbineType2IECCommand" );
    	UpdateWindGenTurbineType2IECEvent event = new UpdateWindGenTurbineType2IECEvent(command.getWindGenTurbineType2IECId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenTurbineType2IECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenTurbineType2IECCommand" );
        apply(new DeleteWindGenTurbineType2IECEvent(command.getWindGenTurbineType2IECId()));
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
    void on(CreateWindGenTurbineType2IECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenTurbineType2IECEvent" );
    	this.windGenTurbineType2IECId = event.getWindGenTurbineType2IECId();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenTurbineType2IECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenTurbineType2IECId;
    

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType2IECAggregate.class.getName());
}
