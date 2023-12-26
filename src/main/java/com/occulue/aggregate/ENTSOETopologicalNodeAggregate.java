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
 * Aggregate handler for ENTSOETopologicalNode as outlined for the CQRS pattern, all write responsibilities 
 * related to ENTSOETopologicalNode are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ENTSOETopologicalNodeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ENTSOETopologicalNodeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ENTSOETopologicalNodeAggregate(CreateENTSOETopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateENTSOETopologicalNodeCommand" );
    	CreateENTSOETopologicalNodeEvent event = new CreateENTSOETopologicalNodeEvent(command.getENTSOETopologicalNodeId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateENTSOETopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateENTSOETopologicalNodeCommand" );
    	UpdateENTSOETopologicalNodeEvent event = new UpdateENTSOETopologicalNodeEvent(command.getENTSOETopologicalNodeId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteENTSOETopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteENTSOETopologicalNodeCommand" );
        apply(new DeleteENTSOETopologicalNodeEvent(command.getENTSOETopologicalNodeId()));
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
    void on(CreateENTSOETopologicalNodeEvent event) {	
    	LOGGER.info( "Event sourcing CreateENTSOETopologicalNodeEvent" );
    	this.eNTSOETopologicalNodeId = event.getENTSOETopologicalNodeId();
    }
    
    @EventSourcingHandler
    void on(UpdateENTSOETopologicalNodeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID eNTSOETopologicalNodeId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOETopologicalNodeAggregate.class.getName());
}
