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
 * Aggregate handler for SubLoadArea as outlined for the CQRS pattern, all write responsibilities 
 * related to SubLoadArea are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SubLoadAreaAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SubLoadAreaAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SubLoadAreaAggregate(CreateSubLoadAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSubLoadAreaCommand" );
    	CreateSubLoadAreaEvent event = new CreateSubLoadAreaEvent(command.getSubLoadAreaId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSubLoadAreaCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSubLoadAreaCommand" );
    	UpdateSubLoadAreaEvent event = new UpdateSubLoadAreaEvent(command.getSubLoadAreaId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSubLoadAreaCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSubLoadAreaCommand" );
        apply(new DeleteSubLoadAreaEvent(command.getSubLoadAreaId()));
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
    void on(CreateSubLoadAreaEvent event) {	
    	LOGGER.info( "Event sourcing CreateSubLoadAreaEvent" );
    	this.subLoadAreaId = event.getSubLoadAreaId();
    }
    
    @EventSourcingHandler
    void on(UpdateSubLoadAreaEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID subLoadAreaId;
    

    private static final Logger LOGGER 	= Logger.getLogger(SubLoadAreaAggregate.class.getName());
}
