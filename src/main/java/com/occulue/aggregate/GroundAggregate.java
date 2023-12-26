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
 * Aggregate handler for Ground as outlined for the CQRS pattern, all write responsibilities 
 * related to Ground are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GroundAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GroundAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GroundAggregate(CreateGroundCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGroundCommand" );
    	CreateGroundEvent event = new CreateGroundEvent(command.getGroundId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGroundCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGroundCommand" );
    	UpdateGroundEvent event = new UpdateGroundEvent(command.getGroundId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGroundCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGroundCommand" );
        apply(new DeleteGroundEvent(command.getGroundId()));
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
    void on(CreateGroundEvent event) {	
    	LOGGER.info( "Event sourcing CreateGroundEvent" );
    	this.groundId = event.getGroundId();
    }
    
    @EventSourcingHandler
    void on(UpdateGroundEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID groundId;
    

    private static final Logger LOGGER 	= Logger.getLogger(GroundAggregate.class.getName());
}
