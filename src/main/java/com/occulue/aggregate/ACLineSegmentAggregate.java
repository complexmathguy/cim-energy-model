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
 * Aggregate handler for ACLineSegment as outlined for the CQRS pattern, all write responsibilities 
 * related to ACLineSegment are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ACLineSegmentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ACLineSegmentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ACLineSegmentAggregate(CreateACLineSegmentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateACLineSegmentCommand" );
    	CreateACLineSegmentEvent event = new CreateACLineSegmentEvent(command.getACLineSegmentId(), command.getB0ch(), command.getBch(), command.getG0ch(), command.getGch(), command.getR(), command.getR0(), command.getShortCircuitEndTemperature(), command.getX(), command.getX0());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateACLineSegmentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateACLineSegmentCommand" );
    	UpdateACLineSegmentEvent event = new UpdateACLineSegmentEvent(command.getACLineSegmentId(), command.getB0ch(), command.getBch(), command.getG0ch(), command.getGch(), command.getR(), command.getR0(), command.getShortCircuitEndTemperature(), command.getX(), command.getX0());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteACLineSegmentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteACLineSegmentCommand" );
        apply(new DeleteACLineSegmentEvent(command.getACLineSegmentId()));
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
    void on(CreateACLineSegmentEvent event) {	
    	LOGGER.info( "Event sourcing CreateACLineSegmentEvent" );
    	this.aCLineSegmentId = event.getACLineSegmentId();
        this.b0ch = event.getB0ch();
        this.bch = event.getBch();
        this.g0ch = event.getG0ch();
        this.gch = event.getGch();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.shortCircuitEndTemperature = event.getShortCircuitEndTemperature();
        this.x = event.getX();
        this.x0 = event.getX0();
    }
    
    @EventSourcingHandler
    void on(UpdateACLineSegmentEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b0ch = event.getB0ch();
        this.bch = event.getBch();
        this.g0ch = event.getG0ch();
        this.gch = event.getGch();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.shortCircuitEndTemperature = event.getShortCircuitEndTemperature();
        this.x = event.getX();
        this.x0 = event.getX0();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID aCLineSegmentId;
    
    private String b0ch;
    private String bch;
    private String g0ch;
    private String gch;
    private String r;
    private String r0;
    private String shortCircuitEndTemperature;
    private String x;
    private String x0;

    private static final Logger LOGGER 	= Logger.getLogger(ACLineSegmentAggregate.class.getName());
}
