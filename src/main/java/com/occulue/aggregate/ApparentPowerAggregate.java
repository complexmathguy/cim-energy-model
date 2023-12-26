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
 * Aggregate handler for ApparentPower as outlined for the CQRS pattern, all write responsibilities 
 * related to ApparentPower are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ApparentPowerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ApparentPowerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ApparentPowerAggregate(CreateApparentPowerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateApparentPowerCommand" );
    	CreateApparentPowerEvent event = new CreateApparentPowerEvent(command.getApparentPowerId(), command.getMultiplier(), command.getUnit(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateApparentPowerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateApparentPowerCommand" );
    	UpdateApparentPowerEvent event = new UpdateApparentPowerEvent(command.getApparentPowerId(), command.getMultiplier(), command.getUnit(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteApparentPowerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteApparentPowerCommand" );
        apply(new DeleteApparentPowerEvent(command.getApparentPowerId()));
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
    void on(CreateApparentPowerEvent event) {	
    	LOGGER.info( "Event sourcing CreateApparentPowerEvent" );
    	this.apparentPowerId = event.getApparentPowerId();
        this.multiplier = event.getMultiplier();
        this.unit = event.getUnit();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateApparentPowerEvent event) {
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
    private UUID apparentPowerId;
    
    private String multiplier;
    private String unit;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ApparentPowerAggregate.class.getName());
}
