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
 * Aggregate handler for DiscExcContIEEEDEC2A as outlined for the CQRS pattern, all write responsibilities 
 * related to DiscExcContIEEEDEC2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiscExcContIEEEDEC2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiscExcContIEEEDEC2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiscExcContIEEEDEC2AAggregate(CreateDiscExcContIEEEDEC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiscExcContIEEEDEC2ACommand" );
    	CreateDiscExcContIEEEDEC2AEvent event = new CreateDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId(), command.getTd1(), command.getTd2(), command.getVdmax(), command.getVdmin(), command.getVk());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiscExcContIEEEDEC2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiscExcContIEEEDEC2ACommand" );
    	UpdateDiscExcContIEEEDEC2AEvent event = new UpdateDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId(), command.getTd1(), command.getTd2(), command.getVdmax(), command.getVdmin(), command.getVk());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiscExcContIEEEDEC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiscExcContIEEEDEC2ACommand" );
        apply(new DeleteDiscExcContIEEEDEC2AEvent(command.getDiscExcContIEEEDEC2AId()));
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
    void on(CreateDiscExcContIEEEDEC2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiscExcContIEEEDEC2AEvent" );
    	this.discExcContIEEEDEC2AId = event.getDiscExcContIEEEDEC2AId();
        this.td1 = event.getTd1();
        this.td2 = event.getTd2();
        this.vdmax = event.getVdmax();
        this.vdmin = event.getVdmin();
        this.vk = event.getVk();
    }
    
    @EventSourcingHandler
    void on(UpdateDiscExcContIEEEDEC2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.td1 = event.getTd1();
        this.td2 = event.getTd2();
        this.vdmax = event.getVdmax();
        this.vdmin = event.getVdmin();
        this.vk = event.getVk();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID discExcContIEEEDEC2AId;
    
    private String td1;
    private String td2;
    private String vdmax;
    private String vdmin;
    private String vk;

    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC2AAggregate.class.getName());
}
