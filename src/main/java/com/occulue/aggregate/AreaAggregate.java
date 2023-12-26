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
 * Aggregate handler for Area as outlined for the CQRS pattern, all write responsibilities 
 * related to Area are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AreaAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AreaAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AreaAggregate(CreateAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAreaCommand" );
    	CreateAreaEvent event = new CreateAreaEvent(command.getAreaId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAreaCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAreaCommand" );
    	UpdateAreaEvent event = new UpdateAreaEvent(command.getAreaId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAreaCommand" );
        apply(new DeleteAreaEvent(command.getAreaId()));
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
    void on(CreateAreaEvent event) {	
    	LOGGER.info( "Event sourcing CreateAreaEvent" );
    	this.areaId = event.getAreaId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateAreaEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID areaId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(AreaAggregate.class.getName());
}
