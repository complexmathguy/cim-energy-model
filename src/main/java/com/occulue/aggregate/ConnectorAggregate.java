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
 * Aggregate handler for Connector as outlined for the CQRS pattern, all write responsibilities 
 * related to Connector are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConnectorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConnectorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConnectorAggregate(CreateConnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConnectorCommand" );
    	CreateConnectorEvent event = new CreateConnectorEvent(command.getConnectorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConnectorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConnectorCommand" );
    	UpdateConnectorEvent event = new UpdateConnectorEvent(command.getConnectorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConnectorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConnectorCommand" );
        apply(new DeleteConnectorEvent(command.getConnectorId()));
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
    void on(CreateConnectorEvent event) {	
    	LOGGER.info( "Event sourcing CreateConnectorEvent" );
    	this.connectorId = event.getConnectorId();
    }
    
    @EventSourcingHandler
    void on(UpdateConnectorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID connectorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(ConnectorAggregate.class.getName());
}
