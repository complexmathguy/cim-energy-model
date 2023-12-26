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
 * Aggregate handler for VoltageLimit as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltageLimit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageLimitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageLimitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageLimitAggregate(CreateVoltageLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageLimitCommand" );
    	CreateVoltageLimitEvent event = new CreateVoltageLimitEvent(command.getVoltageLimitId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageLimitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageLimitCommand" );
    	UpdateVoltageLimitEvent event = new UpdateVoltageLimitEvent(command.getVoltageLimitId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageLimitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageLimitCommand" );
        apply(new DeleteVoltageLimitEvent(command.getVoltageLimitId()));
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
    void on(CreateVoltageLimitEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageLimitEvent" );
    	this.voltageLimitId = event.getVoltageLimitId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageLimitEvent event) {
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
    private UUID voltageLimitId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageLimitAggregate.class.getName());
}
