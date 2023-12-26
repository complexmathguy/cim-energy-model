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
 * Aggregate handler for ENTSOEConnectivityNode as outlined for the CQRS pattern, all write responsibilities 
 * related to ENTSOEConnectivityNode are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ENTSOEConnectivityNodeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ENTSOEConnectivityNodeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ENTSOEConnectivityNodeAggregate(CreateENTSOEConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateENTSOEConnectivityNodeCommand" );
    	CreateENTSOEConnectivityNodeEvent event = new CreateENTSOEConnectivityNodeEvent(command.getENTSOEConnectivityNodeId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateENTSOEConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateENTSOEConnectivityNodeCommand" );
    	UpdateENTSOEConnectivityNodeEvent event = new UpdateENTSOEConnectivityNodeEvent(command.getENTSOEConnectivityNodeId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteENTSOEConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteENTSOEConnectivityNodeCommand" );
        apply(new DeleteENTSOEConnectivityNodeEvent(command.getENTSOEConnectivityNodeId()));
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
    void on(CreateENTSOEConnectivityNodeEvent event) {	
    	LOGGER.info( "Event sourcing CreateENTSOEConnectivityNodeEvent" );
    	this.eNTSOEConnectivityNodeId = event.getENTSOEConnectivityNodeId();
    }
    
    @EventSourcingHandler
    void on(UpdateENTSOEConnectivityNodeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID eNTSOEConnectivityNodeId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEConnectivityNodeAggregate.class.getName());
}
