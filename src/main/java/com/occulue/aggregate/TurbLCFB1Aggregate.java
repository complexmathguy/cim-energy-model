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
 * Aggregate handler for TurbLCFB1 as outlined for the CQRS pattern, all write responsibilities 
 * related to TurbLCFB1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TurbLCFB1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TurbLCFB1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TurbLCFB1Aggregate(CreateTurbLCFB1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateTurbLCFB1Command" );
    	CreateTurbLCFB1Event event = new CreateTurbLCFB1Event(command.getTurbLCFB1Id(), command.getDb(), command.getEmax(), command.getFb(), command.getFbf(), command.getIrmax(), command.getKi(), command.getKp(), command.getMwbase(), command.getPbf(), command.getPmwset(), command.getSpeedReferenceGovernor(), command.getTpelec());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTurbLCFB1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateTurbLCFB1Command" );
    	UpdateTurbLCFB1Event event = new UpdateTurbLCFB1Event(command.getTurbLCFB1Id(), command.getDb(), command.getEmax(), command.getFb(), command.getFbf(), command.getIrmax(), command.getKi(), command.getKp(), command.getMwbase(), command.getPbf(), command.getPmwset(), command.getSpeedReferenceGovernor(), command.getTpelec());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTurbLCFB1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteTurbLCFB1Command" );
        apply(new DeleteTurbLCFB1Event(command.getTurbLCFB1Id()));
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
    void on(CreateTurbLCFB1Event event) {	
    	LOGGER.info( "Event sourcing CreateTurbLCFB1Event" );
    	this.turbLCFB1Id = event.getTurbLCFB1Id();
        this.db = event.getDb();
        this.emax = event.getEmax();
        this.fb = event.getFb();
        this.fbf = event.getFbf();
        this.irmax = event.getIrmax();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pbf = event.getPbf();
        this.pmwset = event.getPmwset();
        this.speedReferenceGovernor = event.getSpeedReferenceGovernor();
        this.tpelec = event.getTpelec();
    }
    
    @EventSourcingHandler
    void on(UpdateTurbLCFB1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.db = event.getDb();
        this.emax = event.getEmax();
        this.fb = event.getFb();
        this.fbf = event.getFbf();
        this.irmax = event.getIrmax();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pbf = event.getPbf();
        this.pmwset = event.getPmwset();
        this.speedReferenceGovernor = event.getSpeedReferenceGovernor();
        this.tpelec = event.getTpelec();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID turbLCFB1Id;
    
    private String db;
    private String emax;
    private String fb;
    private String fbf;
    private String irmax;
    private String ki;
    private String kp;
    private String mwbase;
    private String pbf;
    private String pmwset;
    private String speedReferenceGovernor;
    private String tpelec;

    private static final Logger LOGGER 	= Logger.getLogger(TurbLCFB1Aggregate.class.getName());
}
