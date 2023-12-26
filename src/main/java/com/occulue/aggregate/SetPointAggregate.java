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
 * Aggregate handler for SetPoint as outlined for the CQRS pattern, all write responsibilities 
 * related to SetPoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SetPointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SetPointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SetPointAggregate(CreateSetPointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSetPointCommand" );
    	CreateSetPointEvent event = new CreateSetPointEvent(command.getSetPointId(), command.getNormalValue(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSetPointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSetPointCommand" );
    	UpdateSetPointEvent event = new UpdateSetPointEvent(command.getSetPointId(), command.getNormalValue(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSetPointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSetPointCommand" );
        apply(new DeleteSetPointEvent(command.getSetPointId()));
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
    void on(CreateSetPointEvent event) {	
    	LOGGER.info( "Event sourcing CreateSetPointEvent" );
    	this.setPointId = event.getSetPointId();
        this.normalValue = event.getNormalValue();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateSetPointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.normalValue = event.getNormalValue();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID setPointId;
    
    private String normalValue;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(SetPointAggregate.class.getName());
}
