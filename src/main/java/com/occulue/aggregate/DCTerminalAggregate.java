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
 * Aggregate handler for DCTerminal as outlined for the CQRS pattern, all write responsibilities 
 * related to DCTerminal are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCTerminalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCTerminalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCTerminalAggregate(CreateDCTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCTerminalCommand" );
    	CreateDCTerminalEvent event = new CreateDCTerminalEvent(command.getDCTerminalId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCTerminalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCTerminalCommand" );
    	UpdateDCTerminalEvent event = new UpdateDCTerminalEvent(command.getDCTerminalId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCTerminalCommand" );
        apply(new DeleteDCTerminalEvent(command.getDCTerminalId()));
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
    void on(CreateDCTerminalEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCTerminalEvent" );
    	this.dCTerminalId = event.getDCTerminalId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCTerminalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCTerminalId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCTerminalAggregate.class.getName());
}
