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
 * Aggregate handler for ProtectedSwitch as outlined for the CQRS pattern, all write responsibilities 
 * related to ProtectedSwitch are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ProtectedSwitchAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ProtectedSwitchAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ProtectedSwitchAggregate(CreateProtectedSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateProtectedSwitchCommand" );
    	CreateProtectedSwitchEvent event = new CreateProtectedSwitchEvent(command.getProtectedSwitchId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateProtectedSwitchCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateProtectedSwitchCommand" );
    	UpdateProtectedSwitchEvent event = new UpdateProtectedSwitchEvent(command.getProtectedSwitchId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteProtectedSwitchCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteProtectedSwitchCommand" );
        apply(new DeleteProtectedSwitchEvent(command.getProtectedSwitchId()));
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
    void on(CreateProtectedSwitchEvent event) {	
    	LOGGER.info( "Event sourcing CreateProtectedSwitchEvent" );
    	this.protectedSwitchId = event.getProtectedSwitchId();
    }
    
    @EventSourcingHandler
    void on(UpdateProtectedSwitchEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID protectedSwitchId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ProtectedSwitchAggregate.class.getName());
}
