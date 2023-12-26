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
 * Aggregate handler for ConnectivityNodeContainer as outlined for the CQRS pattern, all write responsibilities 
 * related to ConnectivityNodeContainer are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConnectivityNodeContainerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConnectivityNodeContainerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConnectivityNodeContainerAggregate(CreateConnectivityNodeContainerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConnectivityNodeContainerCommand" );
    	CreateConnectivityNodeContainerEvent event = new CreateConnectivityNodeContainerEvent(command.getConnectivityNodeContainerId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConnectivityNodeContainerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConnectivityNodeContainerCommand" );
    	UpdateConnectivityNodeContainerEvent event = new UpdateConnectivityNodeContainerEvent(command.getConnectivityNodeContainerId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConnectivityNodeContainerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConnectivityNodeContainerCommand" );
        apply(new DeleteConnectivityNodeContainerEvent(command.getConnectivityNodeContainerId()));
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
    void on(CreateConnectivityNodeContainerEvent event) {	
    	LOGGER.info( "Event sourcing CreateConnectivityNodeContainerEvent" );
    	this.connectivityNodeContainerId = event.getConnectivityNodeContainerId();
    }
    
    @EventSourcingHandler
    void on(UpdateConnectivityNodeContainerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID connectivityNodeContainerId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ConnectivityNodeContainerAggregate.class.getName());
}
