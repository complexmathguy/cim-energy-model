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
 * Aggregate handler for WindGeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGeneratingUnitAggregate(CreateWindGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGeneratingUnitCommand" );
    	CreateWindGeneratingUnitEvent event = new CreateWindGeneratingUnitEvent(command.getWindGeneratingUnitId(), command.getWindGenUnitType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGeneratingUnitCommand" );
    	UpdateWindGeneratingUnitEvent event = new UpdateWindGeneratingUnitEvent(command.getWindGeneratingUnitId(), command.getWindGenUnitType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGeneratingUnitCommand" );
        apply(new DeleteWindGeneratingUnitEvent(command.getWindGeneratingUnitId()));
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
    void on(CreateWindGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGeneratingUnitEvent" );
    	this.windGeneratingUnitId = event.getWindGeneratingUnitId();
        this.windGenUnitType = event.getWindGenUnitType();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.windGenUnitType = event.getWindGenUnitType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGeneratingUnitId;
    
    private String windGenUnitType;

    private static final Logger LOGGER 	= Logger.getLogger(WindGeneratingUnitAggregate.class.getName());
}
