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
 * Aggregate handler for TopologicalIsland as outlined for the CQRS pattern, all write responsibilities 
 * related to TopologicalIsland are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TopologicalIslandAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TopologicalIslandAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TopologicalIslandAggregate(CreateTopologicalIslandCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTopologicalIslandCommand" );
    	CreateTopologicalIslandEvent event = new CreateTopologicalIslandEvent(command.getTopologicalIslandId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTopologicalIslandCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTopologicalIslandCommand" );
    	UpdateTopologicalIslandEvent event = new UpdateTopologicalIslandEvent(command.getTopologicalIslandId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTopologicalIslandCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTopologicalIslandCommand" );
        apply(new DeleteTopologicalIslandEvent(command.getTopologicalIslandId()));
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
    void on(CreateTopologicalIslandEvent event) {	
    	LOGGER.info( "Event sourcing CreateTopologicalIslandEvent" );
    	this.topologicalIslandId = event.getTopologicalIslandId();
    }
    
    @EventSourcingHandler
    void on(UpdateTopologicalIslandEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID topologicalIslandId;
    

    private static final Logger LOGGER 	= Logger.getLogger(TopologicalIslandAggregate.class.getName());
}
