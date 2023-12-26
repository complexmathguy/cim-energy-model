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
 * Aggregate handler for WindGenTurbineType3bIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenTurbineType3bIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenTurbineType3bIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenTurbineType3bIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenTurbineType3bIECAggregate(CreateWindGenTurbineType3bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenTurbineType3bIECCommand" );
    	CreateWindGenTurbineType3bIECEvent event = new CreateWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId(), command.getFducw(), command.getMwtcwp(), command.getTg(), command.getTwo(), command.getXs());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenTurbineType3bIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenTurbineType3bIECCommand" );
    	UpdateWindGenTurbineType3bIECEvent event = new UpdateWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId(), command.getFducw(), command.getMwtcwp(), command.getTg(), command.getTwo(), command.getXs());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenTurbineType3bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenTurbineType3bIECCommand" );
        apply(new DeleteWindGenTurbineType3bIECEvent(command.getWindGenTurbineType3bIECId()));
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
    void on(CreateWindGenTurbineType3bIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenTurbineType3bIECEvent" );
    	this.windGenTurbineType3bIECId = event.getWindGenTurbineType3bIECId();
        this.fducw = event.getFducw();
        this.mwtcwp = event.getMwtcwp();
        this.tg = event.getTg();
        this.two = event.getTwo();
        this.xs = event.getXs();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenTurbineType3bIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.fducw = event.getFducw();
        this.mwtcwp = event.getMwtcwp();
        this.tg = event.getTg();
        this.two = event.getTwo();
        this.xs = event.getXs();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenTurbineType3bIECId;
    
    private String fducw;
    private String mwtcwp;
    private String tg;
    private String two;
    private String xs;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3bIECAggregate.class.getName());
}
