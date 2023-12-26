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
 * Aggregate handler for LoadArea as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadArea are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadAreaAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadAreaAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadAreaAggregate(CreateLoadAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadAreaCommand" );
    	CreateLoadAreaEvent event = new CreateLoadAreaEvent(command.getLoadAreaId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadAreaCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadAreaCommand" );
    	UpdateLoadAreaEvent event = new UpdateLoadAreaEvent(command.getLoadAreaId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadAreaCommand" );
        apply(new DeleteLoadAreaEvent(command.getLoadAreaId()));
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
    void on(CreateLoadAreaEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadAreaEvent" );
    	this.loadAreaId = event.getLoadAreaId();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadAreaEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadAreaId;
    

    private static final Logger LOGGER 	= Logger.getLogger(LoadAreaAggregate.class.getName());
}
