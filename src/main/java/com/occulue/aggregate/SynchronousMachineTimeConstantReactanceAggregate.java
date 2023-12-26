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
 * Aggregate handler for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineTimeConstantReactance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineTimeConstantReactanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineTimeConstantReactanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineTimeConstantReactanceAggregate(CreateSynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineTimeConstantReactanceCommand" );
    	CreateSynchronousMachineTimeConstantReactanceEvent event = new CreateSynchronousMachineTimeConstantReactanceEvent(command.getSynchronousMachineTimeConstantReactanceId(), command.getKs(), command.getModelType(), command.getRotorType(), command.getTc(), command.getTpdo(), command.getTppdo(), command.getTppqo(), command.getTpqo(), command.getXDirectSubtrans(), command.getXDirectSync(), command.getXDirectTrans(), command.getXQuadSubtrans(), command.getXQuadSync(), command.getXQuadTrans());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineTimeConstantReactanceCommand" );
    	UpdateSynchronousMachineTimeConstantReactanceEvent event = new UpdateSynchronousMachineTimeConstantReactanceEvent(command.getSynchronousMachineTimeConstantReactanceId(), command.getKs(), command.getModelType(), command.getRotorType(), command.getTc(), command.getTpdo(), command.getTppdo(), command.getTppqo(), command.getTpqo(), command.getXDirectSubtrans(), command.getXDirectSync(), command.getXDirectTrans(), command.getXQuadSubtrans(), command.getXQuadSync(), command.getXQuadTrans());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineTimeConstantReactanceCommand" );
        apply(new DeleteSynchronousMachineTimeConstantReactanceEvent(command.getSynchronousMachineTimeConstantReactanceId()));
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
    void on(CreateSynchronousMachineTimeConstantReactanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineTimeConstantReactanceEvent" );
    	this.synchronousMachineTimeConstantReactanceId = event.getSynchronousMachineTimeConstantReactanceId();
        this.ks = event.getKs();
        this.modelType = event.getModelType();
        this.rotorType = event.getRotorType();
        this.tc = event.getTc();
        this.tpdo = event.getTpdo();
        this.tppdo = event.getTppdo();
        this.tppqo = event.getTppqo();
        this.tpqo = event.getTpqo();
        this.xDirectSubtrans = event.getXDirectSubtrans();
        this.xDirectSync = event.getXDirectSync();
        this.xDirectTrans = event.getXDirectTrans();
        this.xQuadSubtrans = event.getXQuadSubtrans();
        this.xQuadSync = event.getXQuadSync();
        this.xQuadTrans = event.getXQuadTrans();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ks = event.getKs();
        this.modelType = event.getModelType();
        this.rotorType = event.getRotorType();
        this.tc = event.getTc();
        this.tpdo = event.getTpdo();
        this.tppdo = event.getTppdo();
        this.tppqo = event.getTppqo();
        this.tpqo = event.getTpqo();
        this.xDirectSubtrans = event.getXDirectSubtrans();
        this.xDirectSync = event.getXDirectSync();
        this.xDirectTrans = event.getXDirectTrans();
        this.xQuadSubtrans = event.getXQuadSubtrans();
        this.xQuadSync = event.getXQuadSync();
        this.xQuadTrans = event.getXQuadTrans();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineTimeConstantReactanceId;
    
    private String ks;
    private String modelType;
    private String rotorType;
    private String tc;
    private String tpdo;
    private String tppdo;
    private String tppqo;
    private String tpqo;
    private String xDirectSubtrans;
    private String xDirectSync;
    private String xDirectTrans;
    private String xQuadSubtrans;
    private String xQuadSync;
    private String xQuadTrans;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineTimeConstantReactanceAggregate.class.getName());
}
