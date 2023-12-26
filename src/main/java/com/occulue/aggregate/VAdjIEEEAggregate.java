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
 * Aggregate handler for VAdjIEEE as outlined for the CQRS pattern, all write responsibilities 
 * related to VAdjIEEE are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VAdjIEEEAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VAdjIEEEAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VAdjIEEEAggregate(CreateVAdjIEEECommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVAdjIEEECommand" );
    	CreateVAdjIEEEEvent event = new CreateVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAdjslew(), command.getTaoff(), command.getTaon(), command.getVadjf(), command.getVadjmax(), command.getVadjmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVAdjIEEECommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVAdjIEEECommand" );
    	UpdateVAdjIEEEEvent event = new UpdateVAdjIEEEEvent(command.getVAdjIEEEId(), command.getAdjslew(), command.getTaoff(), command.getTaon(), command.getVadjf(), command.getVadjmax(), command.getVadjmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVAdjIEEECommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVAdjIEEECommand" );
        apply(new DeleteVAdjIEEEEvent(command.getVAdjIEEEId()));
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
    void on(CreateVAdjIEEEEvent event) {	
    	LOGGER.info( "Event sourcing CreateVAdjIEEEEvent" );
    	this.vAdjIEEEId = event.getVAdjIEEEId();
        this.adjslew = event.getAdjslew();
        this.taoff = event.getTaoff();
        this.taon = event.getTaon();
        this.vadjf = event.getVadjf();
        this.vadjmax = event.getVadjmax();
        this.vadjmin = event.getVadjmin();
    }
    
    @EventSourcingHandler
    void on(UpdateVAdjIEEEEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.adjslew = event.getAdjslew();
        this.taoff = event.getTaoff();
        this.taon = event.getTaon();
        this.vadjf = event.getVadjf();
        this.vadjmax = event.getVadjmax();
        this.vadjmin = event.getVadjmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID vAdjIEEEId;
    
    private String adjslew;
    private String taoff;
    private String taon;
    private String vadjf;
    private String vadjmax;
    private String vadjmin;

    private static final Logger LOGGER 	= Logger.getLogger(VAdjIEEEAggregate.class.getName());
}
