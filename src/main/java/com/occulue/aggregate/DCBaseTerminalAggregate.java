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
 * Aggregate handler for DCBaseTerminal as outlined for the CQRS pattern, all write responsibilities 
 * related to DCBaseTerminal are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCBaseTerminalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCBaseTerminalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCBaseTerminalAggregate(CreateDCBaseTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCBaseTerminalCommand" );
    	CreateDCBaseTerminalEvent event = new CreateDCBaseTerminalEvent(command.getDCBaseTerminalId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCBaseTerminalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCBaseTerminalCommand" );
    	UpdateDCBaseTerminalEvent event = new UpdateDCBaseTerminalEvent(command.getDCBaseTerminalId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCBaseTerminalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCBaseTerminalCommand" );
        apply(new DeleteDCBaseTerminalEvent(command.getDCBaseTerminalId()));
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
    void on(CreateDCBaseTerminalEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCBaseTerminalEvent" );
    	this.dCBaseTerminalId = event.getDCBaseTerminalId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCBaseTerminalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCBaseTerminalId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCBaseTerminalAggregate.class.getName());
}
