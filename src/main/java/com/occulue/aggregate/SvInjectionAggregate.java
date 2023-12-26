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
 * Aggregate handler for SvInjection as outlined for the CQRS pattern, all write responsibilities 
 * related to SvInjection are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SvInjectionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SvInjectionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SvInjectionAggregate(CreateSvInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSvInjectionCommand" );
    	CreateSvInjectionEvent event = new CreateSvInjectionEvent(command.getSvInjectionId(), command.getPInjection(), command.getQInjection());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSvInjectionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSvInjectionCommand" );
    	UpdateSvInjectionEvent event = new UpdateSvInjectionEvent(command.getSvInjectionId(), command.getPInjection(), command.getQInjection());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSvInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSvInjectionCommand" );
        apply(new DeleteSvInjectionEvent(command.getSvInjectionId()));
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
    void on(CreateSvInjectionEvent event) {	
    	LOGGER.info( "Event sourcing CreateSvInjectionEvent" );
    	this.svInjectionId = event.getSvInjectionId();
        this.pInjection = event.getPInjection();
        this.qInjection = event.getQInjection();
    }
    
    @EventSourcingHandler
    void on(UpdateSvInjectionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.pInjection = event.getPInjection();
        this.qInjection = event.getQInjection();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID svInjectionId;
    
    private String pInjection;
    private String qInjection;

    private static final Logger LOGGER 	= Logger.getLogger(SvInjectionAggregate.class.getName());
}
