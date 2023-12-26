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
 * Aggregate handler for Staticpowersystemmodel as outlined for the CQRS pattern, all write responsibilities 
 * related to Staticpowersystemmodel are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StaticpowersystemmodelAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StaticpowersystemmodelAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StaticpowersystemmodelAggregate(CreateStaticpowersystemmodelCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStaticpowersystemmodelCommand" );
    	CreateStaticpowersystemmodelEvent event = new CreateStaticpowersystemmodelEvent(command.getStaticpowersystemmodelId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStaticpowersystemmodelCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStaticpowersystemmodelCommand" );
    	UpdateStaticpowersystemmodelEvent event = new UpdateStaticpowersystemmodelEvent(command.getStaticpowersystemmodelId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStaticpowersystemmodelCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStaticpowersystemmodelCommand" );
        apply(new DeleteStaticpowersystemmodelEvent(command.getStaticpowersystemmodelId()));
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
    void on(CreateStaticpowersystemmodelEvent event) {	
    	LOGGER.info( "Event sourcing CreateStaticpowersystemmodelEvent" );
    	this.staticpowersystemmodelId = event.getStaticpowersystemmodelId();
    }
    
    @EventSourcingHandler
    void on(UpdateStaticpowersystemmodelEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID staticpowersystemmodelId;
    

    private static final Logger LOGGER 	= Logger.getLogger(StaticpowersystemmodelAggregate.class.getName());
}
