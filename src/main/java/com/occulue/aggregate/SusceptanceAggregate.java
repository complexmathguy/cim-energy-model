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
 * Aggregate handler for Susceptance as outlined for the CQRS pattern, all write responsibilities 
 * related to Susceptance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SusceptanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SusceptanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SusceptanceAggregate(CreateSusceptanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSusceptanceCommand" );
    	CreateSusceptanceEvent event = new CreateSusceptanceEvent(command.getSusceptanceId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSusceptanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSusceptanceCommand" );
    	UpdateSusceptanceEvent event = new UpdateSusceptanceEvent(command.getSusceptanceId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSusceptanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSusceptanceCommand" );
        apply(new DeleteSusceptanceEvent(command.getSusceptanceId()));
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
    void on(CreateSusceptanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateSusceptanceEvent" );
    	this.susceptanceId = event.getSusceptanceId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateSusceptanceEvent event) {
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
    private UUID susceptanceId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(SusceptanceAggregate.class.getName());
}
