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
 * Aggregate handler for ENTSOEJunction as outlined for the CQRS pattern, all write responsibilities 
 * related to ENTSOEJunction are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ENTSOEJunctionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ENTSOEJunctionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ENTSOEJunctionAggregate(CreateENTSOEJunctionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateENTSOEJunctionCommand" );
    	CreateENTSOEJunctionEvent event = new CreateENTSOEJunctionEvent(command.getENTSOEJunctionId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateENTSOEJunctionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateENTSOEJunctionCommand" );
    	UpdateENTSOEJunctionEvent event = new UpdateENTSOEJunctionEvent(command.getENTSOEJunctionId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteENTSOEJunctionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteENTSOEJunctionCommand" );
        apply(new DeleteENTSOEJunctionEvent(command.getENTSOEJunctionId()));
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
    void on(CreateENTSOEJunctionEvent event) {	
    	LOGGER.info( "Event sourcing CreateENTSOEJunctionEvent" );
    	this.eNTSOEJunctionId = event.getENTSOEJunctionId();
    }
    
    @EventSourcingHandler
    void on(UpdateENTSOEJunctionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID eNTSOEJunctionId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEJunctionAggregate.class.getName());
}
