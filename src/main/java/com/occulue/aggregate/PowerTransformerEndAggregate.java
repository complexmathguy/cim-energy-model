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
 * Aggregate handler for PowerTransformerEnd as outlined for the CQRS pattern, all write responsibilities 
 * related to PowerTransformerEnd are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PowerTransformerEndAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PowerTransformerEndAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PowerTransformerEndAggregate(CreatePowerTransformerEndCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePowerTransformerEndCommand" );
    	CreatePowerTransformerEndEvent event = new CreatePowerTransformerEndEvent(command.getPowerTransformerEndId(), command.getB(), command.getB0(), command.getConnectionKind(), command.getG(), command.getG0(), command.getPhaseAngleClock(), command.getR(), command.getR0(), command.getRatedS(), command.getRatedU(), command.getX(), command.getX0());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePowerTransformerEndCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePowerTransformerEndCommand" );
    	UpdatePowerTransformerEndEvent event = new UpdatePowerTransformerEndEvent(command.getPowerTransformerEndId(), command.getB(), command.getB0(), command.getConnectionKind(), command.getG(), command.getG0(), command.getPhaseAngleClock(), command.getR(), command.getR0(), command.getRatedS(), command.getRatedU(), command.getX(), command.getX0());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePowerTransformerEndCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePowerTransformerEndCommand" );
        apply(new DeletePowerTransformerEndEvent(command.getPowerTransformerEndId()));
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
    void on(CreatePowerTransformerEndEvent event) {	
    	LOGGER.info( "Event sourcing CreatePowerTransformerEndEvent" );
    	this.powerTransformerEndId = event.getPowerTransformerEndId();
        this.b = event.getB();
        this.b0 = event.getB0();
        this.connectionKind = event.getConnectionKind();
        this.g = event.getG();
        this.g0 = event.getG0();
        this.phaseAngleClock = event.getPhaseAngleClock();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.ratedS = event.getRatedS();
        this.ratedU = event.getRatedU();
        this.x = event.getX();
        this.x0 = event.getX0();
    }
    
    @EventSourcingHandler
    void on(UpdatePowerTransformerEndEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b = event.getB();
        this.b0 = event.getB0();
        this.connectionKind = event.getConnectionKind();
        this.g = event.getG();
        this.g0 = event.getG0();
        this.phaseAngleClock = event.getPhaseAngleClock();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.ratedS = event.getRatedS();
        this.ratedU = event.getRatedU();
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
    private UUID powerTransformerEndId;
    
    private String b;
    private String b0;
    private String connectionKind;
    private String g;
    private String g0;
    private String phaseAngleClock;
    private String r;
    private String r0;
    private String ratedS;
    private String ratedU;
    private String x;
    private String x0;

    private static final Logger LOGGER 	= Logger.getLogger(PowerTransformerEndAggregate.class.getName());
}
