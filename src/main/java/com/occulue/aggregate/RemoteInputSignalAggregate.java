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
 * Aggregate handler for RemoteInputSignal as outlined for the CQRS pattern, all write responsibilities 
 * related to RemoteInputSignal are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RemoteInputSignalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RemoteInputSignalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RemoteInputSignalAggregate(CreateRemoteInputSignalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRemoteInputSignalCommand" );
    	CreateRemoteInputSignalEvent event = new CreateRemoteInputSignalEvent(command.getRemoteInputSignalId(), command.getRemoteSignalType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRemoteInputSignalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRemoteInputSignalCommand" );
    	UpdateRemoteInputSignalEvent event = new UpdateRemoteInputSignalEvent(command.getRemoteInputSignalId(), command.getRemoteSignalType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRemoteInputSignalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRemoteInputSignalCommand" );
        apply(new DeleteRemoteInputSignalEvent(command.getRemoteInputSignalId()));
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
    void on(CreateRemoteInputSignalEvent event) {	
    	LOGGER.info( "Event sourcing CreateRemoteInputSignalEvent" );
    	this.remoteInputSignalId = event.getRemoteInputSignalId();
        this.remoteSignalType = event.getRemoteSignalType();
    }
    
    @EventSourcingHandler
    void on(UpdateRemoteInputSignalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.remoteSignalType = event.getRemoteSignalType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID remoteInputSignalId;
    
    private String remoteSignalType;

    private static final Logger LOGGER 	= Logger.getLogger(RemoteInputSignalAggregate.class.getName());
}
