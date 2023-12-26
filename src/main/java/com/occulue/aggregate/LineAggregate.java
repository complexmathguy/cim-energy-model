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
 * Aggregate handler for Line as outlined for the CQRS pattern, all write responsibilities 
 * related to Line are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LineAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LineAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LineAggregate(CreateLineCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLineCommand" );
    	CreateLineEvent event = new CreateLineEvent(command.getLineId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLineCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLineCommand" );
    	UpdateLineEvent event = new UpdateLineEvent(command.getLineId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLineCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLineCommand" );
        apply(new DeleteLineEvent(command.getLineId()));
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
    void on(CreateLineEvent event) {	
    	LOGGER.info( "Event sourcing CreateLineEvent" );
    	this.lineId = event.getLineId();
    }
    
    @EventSourcingHandler
    void on(UpdateLineEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID lineId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LineAggregate.class.getName());
}
