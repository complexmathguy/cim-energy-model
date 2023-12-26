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
 * Aggregate handler for DiscExcContIEEEDEC3A as outlined for the CQRS pattern, all write responsibilities 
 * related to DiscExcContIEEEDEC3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscExcContIEEEDEC3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscExcContIEEEDEC3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscExcContIEEEDEC3AAggregate(CreateDiscExcContIEEEDEC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscExcContIEEEDEC3ACommand" );
    	CreateDiscExcContIEEEDEC3AEvent event = new CreateDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId(), command.getTdr(), command.getVtmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscExcContIEEEDEC3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscExcContIEEEDEC3ACommand" );
    	UpdateDiscExcContIEEEDEC3AEvent event = new UpdateDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId(), command.getTdr(), command.getVtmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscExcContIEEEDEC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscExcContIEEEDEC3ACommand" );
        apply(new DeleteDiscExcContIEEEDEC3AEvent(command.getDiscExcContIEEEDEC3AId()));
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
    void on(CreateDiscExcContIEEEDEC3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscExcContIEEEDEC3AEvent" );
    	this.discExcContIEEEDEC3AId = event.getDiscExcContIEEEDEC3AId();
        this.tdr = event.getTdr();
        this.vtmin = event.getVtmin();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscExcContIEEEDEC3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.tdr = event.getTdr();
        this.vtmin = event.getVtmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID discExcContIEEEDEC3AId;
    
    private String tdr;
    private String vtmin;

    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC3AAggregate.class.getName());
}
