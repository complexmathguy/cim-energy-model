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
 * Aggregate handler for GovGASTWD as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGASTWD are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGASTWDAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGASTWDAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGASTWDAggregate(CreateGovGASTWDCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGASTWDCommand" );
    	CreateGovGASTWDEvent event = new CreateGovGASTWDEvent(command.getGovGASTWDId(), command.getA(), command.getAf1(), command.getAf2(), command.getB(), command.getBf1(), command.getBf2(), command.getC(), command.getCf2(), command.getEcr(), command.getEtd(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getKd(), command.getKdroop(), command.getKf(), command.getKi(), command.getKp(), command.getMwbase(), command.getT(), command.getT3(), command.getT4(), command.getT5(), command.getTc(), command.getTcd(), command.getTd(), command.getTf(), command.getTmax(), command.getTmin(), command.getTr(), command.getTrate(), command.getTt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGASTWDCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGASTWDCommand" );
    	UpdateGovGASTWDEvent event = new UpdateGovGASTWDEvent(command.getGovGASTWDId(), command.getA(), command.getAf1(), command.getAf2(), command.getB(), command.getBf1(), command.getBf2(), command.getC(), command.getCf2(), command.getEcr(), command.getEtd(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getKd(), command.getKdroop(), command.getKf(), command.getKi(), command.getKp(), command.getMwbase(), command.getT(), command.getT3(), command.getT4(), command.getT5(), command.getTc(), command.getTcd(), command.getTd(), command.getTf(), command.getTmax(), command.getTmin(), command.getTr(), command.getTrate(), command.getTt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGASTWDCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGASTWDCommand" );
        apply(new DeleteGovGASTWDEvent(command.getGovGASTWDId()));
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
    void on(CreateGovGASTWDEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovGASTWDEvent" );
    	this.govGASTWDId = event.getGovGASTWDId();
        this.a = event.getA();
        this.af1 = event.getAf1();
        this.af2 = event.getAf2();
        this.b = event.getB();
        this.bf1 = event.getBf1();
        this.bf2 = event.getBf2();
        this.c = event.getC();
        this.cf2 = event.getCf2();
        this.ecr = event.getEcr();
        this.etd = event.getEtd();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.kd = event.getKd();
        this.kdroop = event.getKdroop();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.t = event.getT();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tc = event.getTc();
        this.tcd = event.getTcd();
        this.td = event.getTd();
        this.tf = event.getTf();
        this.tmax = event.getTmax();
        this.tmin = event.getTmin();
        this.tr = event.getTr();
        this.trate = event.getTrate();
        this.tt = event.getTt();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGASTWDEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a = event.getA();
        this.af1 = event.getAf1();
        this.af2 = event.getAf2();
        this.b = event.getB();
        this.bf1 = event.getBf1();
        this.bf2 = event.getBf2();
        this.c = event.getC();
        this.cf2 = event.getCf2();
        this.ecr = event.getEcr();
        this.etd = event.getEtd();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.kd = event.getKd();
        this.kdroop = event.getKdroop();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.t = event.getT();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tc = event.getTc();
        this.tcd = event.getTcd();
        this.td = event.getTd();
        this.tf = event.getTf();
        this.tmax = event.getTmax();
        this.tmin = event.getTmin();
        this.tr = event.getTr();
        this.trate = event.getTrate();
        this.tt = event.getTt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govGASTWDId;
    
    private String a;
    private String af1;
    private String af2;
    private String b;
    private String bf1;
    private String bf2;
    private String c;
    private String cf2;
    private String ecr;
    private String etd;
    private String k3;
    private String k4;
    private String k5;
    private String k6;
    private String kd;
    private String kdroop;
    private String kf;
    private String ki;
    private String kp;
    private String mwbase;
    private String t;
    private String t3;
    private String t4;
    private String t5;
    private String tc;
    private String tcd;
    private String td;
    private String tf;
    private String tmax;
    private String tmin;
    private String tr;
    private String trate;
    private String tt;

    private static final Logger LOGGER 	= Logger.getLogger(GovGASTWDAggregate.class.getName());
}
