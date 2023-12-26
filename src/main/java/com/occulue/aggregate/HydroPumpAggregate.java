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
 * Aggregate handler for HydroPump as outlined for the CQRS pattern, all write responsibilities 
 * related to HydroPump are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class HydroPumpAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public HydroPumpAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public HydroPumpAggregate(CreateHydroPumpCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateHydroPumpCommand" );
    	CreateHydroPumpEvent event = new CreateHydroPumpEvent(command.getHydroPumpId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateHydroPumpCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateHydroPumpCommand" );
    	UpdateHydroPumpEvent event = new UpdateHydroPumpEvent(command.getHydroPumpId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteHydroPumpCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteHydroPumpCommand" );
        apply(new DeleteHydroPumpEvent(command.getHydroPumpId()));
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
    void on(CreateHydroPumpEvent event) {	
    	LOGGER.info( "Event sourcing CreateHydroPumpEvent" );
    	this.hydroPumpId = event.getHydroPumpId();
    }
    
    @EventSourcingHandler
    void on(UpdateHydroPumpEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID hydroPumpId;
    

    private static final Logger LOGGER 	= Logger.getLogger(HydroPumpAggregate.class.getName());
}
