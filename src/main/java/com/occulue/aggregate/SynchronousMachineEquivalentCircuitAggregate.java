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
 * Aggregate handler for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineEquivalentCircuit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineEquivalentCircuitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineEquivalentCircuitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineEquivalentCircuitAggregate(CreateSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineEquivalentCircuitCommand" );
    	CreateSynchronousMachineEquivalentCircuitEvent event = new CreateSynchronousMachineEquivalentCircuitEvent(command.getSynchronousMachineEquivalentCircuitId(), command.getR1d(), command.getR1q(), command.getR2q(), command.getRfd(), command.getX1d(), command.getX1q(), command.getX2q(), command.getXad(), command.getXaq(), command.getXf1d(), command.getXfd());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineEquivalentCircuitCommand" );
    	UpdateSynchronousMachineEquivalentCircuitEvent event = new UpdateSynchronousMachineEquivalentCircuitEvent(command.getSynchronousMachineEquivalentCircuitId(), command.getR1d(), command.getR1q(), command.getR2q(), command.getRfd(), command.getX1d(), command.getX1q(), command.getX2q(), command.getXad(), command.getXaq(), command.getXf1d(), command.getXfd());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineEquivalentCircuitCommand" );
        apply(new DeleteSynchronousMachineEquivalentCircuitEvent(command.getSynchronousMachineEquivalentCircuitId()));
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
    void on(CreateSynchronousMachineEquivalentCircuitEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineEquivalentCircuitEvent" );
    	this.synchronousMachineEquivalentCircuitId = event.getSynchronousMachineEquivalentCircuitId();
        this.r1d = event.getR1d();
        this.r1q = event.getR1q();
        this.r2q = event.getR2q();
        this.rfd = event.getRfd();
        this.x1d = event.getX1d();
        this.x1q = event.getX1q();
        this.x2q = event.getX2q();
        this.xad = event.getXad();
        this.xaq = event.getXaq();
        this.xf1d = event.getXf1d();
        this.xfd = event.getXfd();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.r1d = event.getR1d();
        this.r1q = event.getR1q();
        this.r2q = event.getR2q();
        this.rfd = event.getRfd();
        this.x1d = event.getX1d();
        this.x1q = event.getX1q();
        this.x2q = event.getX2q();
        this.xad = event.getXad();
        this.xaq = event.getXaq();
        this.xf1d = event.getXf1d();
        this.xfd = event.getXfd();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineEquivalentCircuitId;
    
    private String r1d;
    private String r1q;
    private String r2q;
    private String rfd;
    private String x1d;
    private String x1q;
    private String x2q;
    private String xad;
    private String xaq;
    private String xf1d;
    private String xfd;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineEquivalentCircuitAggregate.class.getName());
}
