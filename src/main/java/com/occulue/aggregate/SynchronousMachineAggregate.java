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
 * Aggregate handler for SynchronousMachine as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachine are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineAggregate(CreateSynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineCommand" );
    	CreateSynchronousMachineEvent event = new CreateSynchronousMachineEvent(command.getSynchronousMachineId(), command.getEarthing(), command.getEarthingStarPointR(), command.getEarthingStarPointX(), command.getIkk(), command.getMaxQ(), command.getMinQ(), command.getMu(), command.getQPercent(), command.getR(), command.getR0(), command.getR2(), command.getSatDirectSubtransX(), command.getSatDirectSyncX(), command.getSatDirectTransX(), command.getShortCircuitRotorType(), command.getType(), command.getVoltageRegulationRange(), command.getX0(), command.getX2());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineCommand" );
    	UpdateSynchronousMachineEvent event = new UpdateSynchronousMachineEvent(command.getSynchronousMachineId(), command.getEarthing(), command.getEarthingStarPointR(), command.getEarthingStarPointX(), command.getIkk(), command.getMaxQ(), command.getMinQ(), command.getMu(), command.getQPercent(), command.getR(), command.getR0(), command.getR2(), command.getSatDirectSubtransX(), command.getSatDirectSyncX(), command.getSatDirectTransX(), command.getShortCircuitRotorType(), command.getType(), command.getVoltageRegulationRange(), command.getX0(), command.getX2());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineCommand" );
        apply(new DeleteSynchronousMachineEvent(command.getSynchronousMachineId()));
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
    void on(CreateSynchronousMachineEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineEvent" );
    	this.synchronousMachineId = event.getSynchronousMachineId();
        this.earthing = event.getEarthing();
        this.earthingStarPointR = event.getEarthingStarPointR();
        this.earthingStarPointX = event.getEarthingStarPointX();
        this.ikk = event.getIkk();
        this.maxQ = event.getMaxQ();
        this.minQ = event.getMinQ();
        this.mu = event.getMu();
        this.qPercent = event.getQPercent();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.r2 = event.getR2();
        this.satDirectSubtransX = event.getSatDirectSubtransX();
        this.satDirectSyncX = event.getSatDirectSyncX();
        this.satDirectTransX = event.getSatDirectTransX();
        this.shortCircuitRotorType = event.getShortCircuitRotorType();
        this.type = event.getType();
        this.voltageRegulationRange = event.getVoltageRegulationRange();
        this.x0 = event.getX0();
        this.x2 = event.getX2();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.earthing = event.getEarthing();
        this.earthingStarPointR = event.getEarthingStarPointR();
        this.earthingStarPointX = event.getEarthingStarPointX();
        this.ikk = event.getIkk();
        this.maxQ = event.getMaxQ();
        this.minQ = event.getMinQ();
        this.mu = event.getMu();
        this.qPercent = event.getQPercent();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.r2 = event.getR2();
        this.satDirectSubtransX = event.getSatDirectSubtransX();
        this.satDirectSyncX = event.getSatDirectSyncX();
        this.satDirectTransX = event.getSatDirectTransX();
        this.shortCircuitRotorType = event.getShortCircuitRotorType();
        this.type = event.getType();
        this.voltageRegulationRange = event.getVoltageRegulationRange();
        this.x0 = event.getX0();
        this.x2 = event.getX2();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineId;
    
    private String earthing;
    private String earthingStarPointR;
    private String earthingStarPointX;
    private String ikk;
    private String maxQ;
    private String minQ;
    private String mu;
    private String qPercent;
    private String r;
    private String r0;
    private String r2;
    private String satDirectSubtransX;
    private String satDirectSyncX;
    private String satDirectTransX;
    private String shortCircuitRotorType;
    private String type;
    private String voltageRegulationRange;
    private String x0;
    private String x2;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineAggregate.class.getName());
}
