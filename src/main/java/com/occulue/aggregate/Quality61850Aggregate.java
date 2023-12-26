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
 * Aggregate handler for Quality61850 as outlined for the CQRS pattern, all write responsibilities 
 * related to Quality61850 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Quality61850Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Quality61850Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Quality61850Aggregate(CreateQuality61850Command command) throws Exception {
    	LOGGER.info( "Handling command CreateQuality61850Command" );
    	CreateQuality61850Event event = new CreateQuality61850Event(command.getQuality61850Id(), command.getBadReference(), command.getEstimatorReplaced(), command.getFailure(), command.getOldData(), command.getOperatorBlocked(), command.getOscillatory(), command.getOutOfRange(), command.getOverFlow(), command.getSource(), command.getSuspect(), command.getTest(), command.getValidity());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateQuality61850Command command) throws Exception {
    	LOGGER.info( "handling command UpdateQuality61850Command" );
    	UpdateQuality61850Event event = new UpdateQuality61850Event(command.getQuality61850Id(), command.getBadReference(), command.getEstimatorReplaced(), command.getFailure(), command.getOldData(), command.getOperatorBlocked(), command.getOscillatory(), command.getOutOfRange(), command.getOverFlow(), command.getSource(), command.getSuspect(), command.getTest(), command.getValidity());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteQuality61850Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteQuality61850Command" );
        apply(new DeleteQuality61850Event(command.getQuality61850Id()));
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
    void on(CreateQuality61850Event event) {	
    	LOGGER.info( "Event sourcing CreateQuality61850Event" );
    	this.quality61850Id = event.getQuality61850Id();
        this.badReference = event.getBadReference();
        this.estimatorReplaced = event.getEstimatorReplaced();
        this.failure = event.getFailure();
        this.oldData = event.getOldData();
        this.operatorBlocked = event.getOperatorBlocked();
        this.oscillatory = event.getOscillatory();
        this.outOfRange = event.getOutOfRange();
        this.overFlow = event.getOverFlow();
        this.source = event.getSource();
        this.suspect = event.getSuspect();
        this.test = event.getTest();
        this.validity = event.getValidity();
    }
    
    @EventSourcingHandler
    void on(UpdateQuality61850Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.badReference = event.getBadReference();
        this.estimatorReplaced = event.getEstimatorReplaced();
        this.failure = event.getFailure();
        this.oldData = event.getOldData();
        this.operatorBlocked = event.getOperatorBlocked();
        this.oscillatory = event.getOscillatory();
        this.outOfRange = event.getOutOfRange();
        this.overFlow = event.getOverFlow();
        this.source = event.getSource();
        this.suspect = event.getSuspect();
        this.test = event.getTest();
        this.validity = event.getValidity();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID quality61850Id;
    
    private String badReference;
    private String estimatorReplaced;
    private String failure;
    private String oldData;
    private String operatorBlocked;
    private String oscillatory;
    private String outOfRange;
    private String overFlow;
    private String source;
    private String suspect;
    private String test;
    private String validity;

    private static final Logger LOGGER 	= Logger.getLogger(Quality61850Aggregate.class.getName());
}
