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
 * Aggregate handler for WindGenTurbineType3IEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenTurbineType3IEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenTurbineType3IECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenTurbineType3IECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenTurbineType3IECAggregate(CreateWindGenTurbineType3IECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenTurbineType3IECCommand" );
    	CreateWindGenTurbineType3IECEvent event = new CreateWindGenTurbineType3IECEvent(command.getWindGenTurbineType3IECId(), command.getDipmax(), command.getDiqmax());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenTurbineType3IECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenTurbineType3IECCommand" );
    	UpdateWindGenTurbineType3IECEvent event = new UpdateWindGenTurbineType3IECEvent(command.getWindGenTurbineType3IECId(), command.getDipmax(), command.getDiqmax());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenTurbineType3IECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenTurbineType3IECCommand" );
        apply(new DeleteWindGenTurbineType3IECEvent(command.getWindGenTurbineType3IECId()));
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
    void on(CreateWindGenTurbineType3IECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenTurbineType3IECEvent" );
    	this.windGenTurbineType3IECId = event.getWindGenTurbineType3IECId();
        this.dipmax = event.getDipmax();
        this.diqmax = event.getDiqmax();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenTurbineType3IECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dipmax = event.getDipmax();
        this.diqmax = event.getDiqmax();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenTurbineType3IECId;
    
    private String dipmax;
    private String diqmax;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3IECAggregate.class.getName());
}
