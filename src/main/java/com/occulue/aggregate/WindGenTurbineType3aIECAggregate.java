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
 * Aggregate handler for WindGenTurbineType3aIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenTurbineType3aIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenTurbineType3aIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenTurbineType3aIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenTurbineType3aIECAggregate(CreateWindGenTurbineType3aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenTurbineType3aIECCommand" );
    	CreateWindGenTurbineType3aIECEvent event = new CreateWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId(), command.getKpc(), command.getTic(), command.getXs());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenTurbineType3aIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenTurbineType3aIECCommand" );
    	UpdateWindGenTurbineType3aIECEvent event = new UpdateWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId(), command.getKpc(), command.getTic(), command.getXs());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenTurbineType3aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenTurbineType3aIECCommand" );
        apply(new DeleteWindGenTurbineType3aIECEvent(command.getWindGenTurbineType3aIECId()));
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
    void on(CreateWindGenTurbineType3aIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenTurbineType3aIECEvent" );
    	this.windGenTurbineType3aIECId = event.getWindGenTurbineType3aIECId();
        this.kpc = event.getKpc();
        this.tic = event.getTic();
        this.xs = event.getXs();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenTurbineType3aIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kpc = event.getKpc();
        this.tic = event.getTic();
        this.xs = event.getXs();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenTurbineType3aIECId;
    
    private String kpc;
    private String tic;
    private String xs;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3aIECAggregate.class.getName());
}
