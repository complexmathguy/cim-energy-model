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
 * Aggregate handler for ExtensionVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to ExtensionVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExtensionVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExtensionVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExtensionVersionAggregate(CreateExtensionVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExtensionVersionCommand" );
    	CreateExtensionVersionEvent event = new CreateExtensionVersionEvent(command.getExtensionVersionId(), command.getDate(), command.getNamespaceURI());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExtensionVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExtensionVersionCommand" );
    	UpdateExtensionVersionEvent event = new UpdateExtensionVersionEvent(command.getExtensionVersionId(), command.getDate(), command.getNamespaceURI());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExtensionVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExtensionVersionCommand" );
        apply(new DeleteExtensionVersionEvent(command.getExtensionVersionId()));
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
    void on(CreateExtensionVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateExtensionVersionEvent" );
    	this.extensionVersionId = event.getExtensionVersionId();
        this.date = event.getDate();
        this.namespaceURI = event.getNamespaceURI();
    }
    
    @EventSourcingHandler
    void on(UpdateExtensionVersionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.date = event.getDate();
        this.namespaceURI = event.getNamespaceURI();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID extensionVersionId;
    
    private String date;
    private String namespaceURI;

    private static final Logger LOGGER 	= Logger.getLogger(ExtensionVersionAggregate.class.getName());
}
