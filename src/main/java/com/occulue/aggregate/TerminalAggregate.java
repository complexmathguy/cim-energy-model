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
 * Aggregate handler for Terminal as outlined for the CQRS pattern, all write responsibilities 
 * related to Terminal are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TerminalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TerminalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TerminalAggregate(CreateTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTerminalCommand" );
    	CreateTerminalEvent event = new CreateTerminalEvent(command.getTerminalId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTerminalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTerminalCommand" );
    	UpdateTerminalEvent event = new UpdateTerminalEvent(command.getTerminalId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTerminalCommand" );
        apply(new DeleteTerminalEvent(command.getTerminalId()));
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
    void on(CreateTerminalEvent event) {	
    	LOGGER.info( "Event sourcing CreateTerminalEvent" );
    	this.terminalId = event.getTerminalId();
    }
    
    @EventSourcingHandler
    void on(UpdateTerminalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID terminalId;
    

    private static final Logger LOGGER 	= Logger.getLogger(TerminalAggregate.class.getName());
}
