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
 * Aggregate handler for Junction as outlined for the CQRS pattern, all write responsibilities 
 * related to Junction are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class JunctionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public JunctionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public JunctionAggregate(CreateJunctionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateJunctionCommand" );
    	CreateJunctionEvent event = new CreateJunctionEvent(command.getJunctionId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateJunctionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateJunctionCommand" );
    	UpdateJunctionEvent event = new UpdateJunctionEvent(command.getJunctionId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteJunctionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteJunctionCommand" );
        apply(new DeleteJunctionEvent(command.getJunctionId()));
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
    void on(CreateJunctionEvent event) {	
    	LOGGER.info( "Event sourcing CreateJunctionEvent" );
    	this.junctionId = event.getJunctionId();
    }
    
    @EventSourcingHandler
    void on(UpdateJunctionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID junctionId;
    

    private static final Logger LOGGER 	= Logger.getLogger(JunctionAggregate.class.getName());
}
