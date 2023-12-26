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
 * Aggregate handler for GovHydroPID2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroPID2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroPID2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroPID2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroPID2Aggregate(CreateGovHydroPID2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroPID2Command" );
    	CreateGovHydroPID2Event event = new CreateGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAtw(), command.getD(), command.getFeedbackSignal(), command.getG0(), command.getG1(), command.getG2(), command.getGmax(), command.getGmin(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getP1(), command.getP2(), command.getP3(), command.getRperm(), command.getTa(), command.getTb(), command.getTreg(), command.getTw(), command.getVelmax(), command.getVelmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroPID2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroPID2Command" );
    	UpdateGovHydroPID2Event event = new UpdateGovHydroPID2Event(command.getGovHydroPID2Id(), command.getAtw(), command.getD(), command.getFeedbackSignal(), command.getG0(), command.getG1(), command.getG2(), command.getGmax(), command.getGmin(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getP1(), command.getP2(), command.getP3(), command.getRperm(), command.getTa(), command.getTb(), command.getTreg(), command.getTw(), command.getVelmax(), command.getVelmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroPID2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroPID2Command" );
        apply(new DeleteGovHydroPID2Event(command.getGovHydroPID2Id()));
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
    void on(CreateGovHydroPID2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroPID2Event" );
    	this.govHydroPID2Id = event.getGovHydroPID2Id();
        this.atw = event.getAtw();
        this.d = event.getD();
        this.feedbackSignal = event.getFeedbackSignal();
        this.g0 = event.getG0();
        this.g1 = event.getG1();
        this.g2 = event.getG2();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.p1 = event.getP1();
        this.p2 = event.getP2();
        this.p3 = event.getP3();
        this.rperm = event.getRperm();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.treg = event.getTreg();
        this.tw = event.getTw();
        this.velmax = event.getVelmax();
        this.velmin = event.getVelmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroPID2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.atw = event.getAtw();
        this.d = event.getD();
        this.feedbackSignal = event.getFeedbackSignal();
        this.g0 = event.getG0();
        this.g1 = event.getG1();
        this.g2 = event.getG2();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.p1 = event.getP1();
        this.p2 = event.getP2();
        this.p3 = event.getP3();
        this.rperm = event.getRperm();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.treg = event.getTreg();
        this.tw = event.getTw();
        this.velmax = event.getVelmax();
        this.velmin = event.getVelmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroPID2Id;
    
    private String atw;
    private String d;
    private String feedbackSignal;
    private String g0;
    private String g1;
    private String g2;
    private String gmax;
    private String gmin;
    private String kd;
    private String ki;
    private String kp;
    private String mwbase;
    private String p1;
    private String p2;
    private String p3;
    private String rperm;
    private String ta;
    private String tb;
    private String treg;
    private String tw;
    private String velmax;
    private String velmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPID2Aggregate.class.getName());
}
