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
 * Aggregate handler for DCLine as outlined for the CQRS pattern, all write responsibilities 
 * related to DCLine are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCLineAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCLineAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCLineAggregate(CreateDCLineCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCLineCommand" );
    	CreateDCLineEvent event = new CreateDCLineEvent(command.getDCLineId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCLineCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCLineCommand" );
    	UpdateDCLineEvent event = new UpdateDCLineEvent(command.getDCLineId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCLineCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCLineCommand" );
        apply(new DeleteDCLineEvent(command.getDCLineId()));
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
    void on(CreateDCLineEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCLineEvent" );
    	this.dCLineId = event.getDCLineId();
    }
    
    @EventSourcingHandler
    void on(UpdateDCLineEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCLineId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DCLineAggregate.class.getName());
}
