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
 * Aggregate handler for LoadBreakSwitch as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadBreakSwitch are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadBreakSwitchAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadBreakSwitchAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadBreakSwitchAggregate(CreateLoadBreakSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadBreakSwitchCommand" );
    	CreateLoadBreakSwitchEvent event = new CreateLoadBreakSwitchEvent(command.getLoadBreakSwitchId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadBreakSwitchCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadBreakSwitchCommand" );
    	UpdateLoadBreakSwitchEvent event = new UpdateLoadBreakSwitchEvent(command.getLoadBreakSwitchId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadBreakSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadBreakSwitchCommand" );
        apply(new DeleteLoadBreakSwitchEvent(command.getLoadBreakSwitchId()));
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
    void on(CreateLoadBreakSwitchEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadBreakSwitchEvent" );
    	this.loadBreakSwitchId = event.getLoadBreakSwitchId();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadBreakSwitchEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadBreakSwitchId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LoadBreakSwitchAggregate.class.getName());
}
