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
 * Aggregate handler for DynamicsFunctionBlock as outlined for the CQRS pattern, all write responsibilities 
 * related to DynamicsFunctionBlock are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DynamicsFunctionBlockAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DynamicsFunctionBlockAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DynamicsFunctionBlockAggregate(CreateDynamicsFunctionBlockCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDynamicsFunctionBlockCommand" );
    	CreateDynamicsFunctionBlockEvent event = new CreateDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId(), command.getEnabled());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDynamicsFunctionBlockCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDynamicsFunctionBlockCommand" );
    	UpdateDynamicsFunctionBlockEvent event = new UpdateDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId(), command.getEnabled());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDynamicsFunctionBlockCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDynamicsFunctionBlockCommand" );
        apply(new DeleteDynamicsFunctionBlockEvent(command.getDynamicsFunctionBlockId()));
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
    void on(CreateDynamicsFunctionBlockEvent event) {	
    	LOGGER.info( "Event sourcing CreateDynamicsFunctionBlockEvent" );
    	this.dynamicsFunctionBlockId = event.getDynamicsFunctionBlockId();
        this.enabled = event.getEnabled();
    }
    
    @EventSourcingHandler
    void on(UpdateDynamicsFunctionBlockEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.enabled = event.getEnabled();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dynamicsFunctionBlockId;
    
    private String enabled;

    private static final Logger LOGGER 	= Logger.getLogger(DynamicsFunctionBlockAggregate.class.getName());
}
