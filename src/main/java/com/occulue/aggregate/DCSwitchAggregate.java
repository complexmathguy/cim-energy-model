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
 * Aggregate handler for DCSwitch as outlined for the CQRS pattern, all write responsibilities 
 * related to DCSwitch are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCSwitchAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCSwitchAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCSwitchAggregate(CreateDCSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCSwitchCommand" );
    	CreateDCSwitchEvent event = new CreateDCSwitchEvent(command.getDCSwitchId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCSwitchCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCSwitchCommand" );
    	UpdateDCSwitchEvent event = new UpdateDCSwitchEvent(command.getDCSwitchId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCSwitchCommand" );
        apply(new DeleteDCSwitchEvent(command.getDCSwitchId()));
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
    void on(CreateDCSwitchEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCSwitchEvent" );
    	this.dCSwitchId = event.getDCSwitchId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCSwitchEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCSwitchId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCSwitchAggregate.class.getName());
}
