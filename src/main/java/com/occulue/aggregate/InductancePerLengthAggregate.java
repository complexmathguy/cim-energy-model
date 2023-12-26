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
 * Aggregate handler for InductancePerLength as outlined for the CQRS pattern, all write responsibilities 
 * related to InductancePerLength are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class InductancePerLengthAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public InductancePerLengthAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public InductancePerLengthAggregate(CreateInductancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateInductancePerLengthCommand" );
    	CreateInductancePerLengthEvent event = new CreateInductancePerLengthEvent(command.getInductancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateInductancePerLengthCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateInductancePerLengthCommand" );
    	UpdateInductancePerLengthEvent event = new UpdateInductancePerLengthEvent(command.getInductancePerLengthId(), command.getDenominatorMultiplier(), command.getDenominatorUnit(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteInductancePerLengthCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteInductancePerLengthCommand" );
        apply(new DeleteInductancePerLengthEvent(command.getInductancePerLengthId()));
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
    void on(CreateInductancePerLengthEvent event) {	
    	LOGGER.info( "Event sourcing CreateInductancePerLengthEvent" );
    	this.inductancePerLengthId = event.getInductancePerLengthId();
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateInductancePerLengthEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.denominatorMultiplier = event.getDenominatorMultiplier();
        this.denominatorUnit = event.getDenominatorUnit();
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
    private UUID inductancePerLengthId;
    
    private String denominatorMultiplier;
    private String denominatorUnit;
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(InductancePerLengthAggregate.class.getName());
}
