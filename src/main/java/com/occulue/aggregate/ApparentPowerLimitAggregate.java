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
 * Aggregate handler for ApparentPowerLimit as outlined for the CQRS pattern, all write responsibilities 
 * related to ApparentPowerLimit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ApparentPowerLimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ApparentPowerLimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ApparentPowerLimitAggregate(CreateApparentPowerLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateApparentPowerLimitCommand" );
    	CreateApparentPowerLimitEvent event = new CreateApparentPowerLimitEvent(command.getApparentPowerLimitId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateApparentPowerLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateApparentPowerLimitCommand" );
    	UpdateApparentPowerLimitEvent event = new UpdateApparentPowerLimitEvent(command.getApparentPowerLimitId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteApparentPowerLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteApparentPowerLimitCommand" );
        apply(new DeleteApparentPowerLimitEvent(command.getApparentPowerLimitId()));
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
    void on(CreateApparentPowerLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateApparentPowerLimitEvent" );
    	this.apparentPowerLimitId = event.getApparentPowerLimitId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateApparentPowerLimitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID apparentPowerLimitId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(ApparentPowerLimitAggregate.class.getName());
}
