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
 * Aggregate handler for DomainVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to DomainVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DomainVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DomainVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DomainVersionAggregate(CreateDomainVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDomainVersionCommand" );
    	CreateDomainVersionEvent event = new CreateDomainVersionEvent(command.getDomainVersionId(), command.getBaseUML(), command.getDate(), command.getEntsoeUML(), command.getVersion());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDomainVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDomainVersionCommand" );
    	UpdateDomainVersionEvent event = new UpdateDomainVersionEvent(command.getDomainVersionId(), command.getBaseUML(), command.getDate(), command.getEntsoeUML(), command.getVersion());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDomainVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDomainVersionCommand" );
        apply(new DeleteDomainVersionEvent(command.getDomainVersionId()));
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
    void on(CreateDomainVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateDomainVersionEvent" );
    	this.domainVersionId = event.getDomainVersionId();
        this.baseUML = event.getBaseUML();
        this.date = event.getDate();
        this.entsoeUML = event.getEntsoeUML();
        this.version = event.getVersion();
    }
    
    @EventSourcingHandler
    void on(UpdateDomainVersionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.baseUML = event.getBaseUML();
        this.date = event.getDate();
        this.entsoeUML = event.getEntsoeUML();
        this.version = event.getVersion();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID domainVersionId;
    
    private String baseUML;
    private String date;
    private String entsoeUML;
    private String version;

    private static final Logger LOGGER 	= Logger.getLogger(DomainVersionAggregate.class.getName());
}
