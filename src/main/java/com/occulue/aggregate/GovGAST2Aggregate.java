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
 * Aggregate handler for GovGAST2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGAST2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGAST2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGAST2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGAST2Aggregate(CreateGovGAST2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGAST2Command" );
    	CreateGovGAST2Event event = new CreateGovGAST2Event(command.getGovGAST2Id(), command.getA(), command.getAf1(), command.getAf2(), command.getB(), command.getBf1(), command.getBf2(), command.getC(), command.getCf2(), command.getEcr(), command.getEtd(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getKf(), command.getMwbase(), command.getT(), command.getT3(), command.getT4(), command.getT5(), command.getTc(), command.getTcd(), command.getTf(), command.getTmax(), command.getTmin(), command.getTr(), command.getTrate(), command.getTt(), command.getW(), command.getX(), command.getY(), command.getZ());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGAST2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGAST2Command" );
    	UpdateGovGAST2Event event = new UpdateGovGAST2Event(command.getGovGAST2Id(), command.getA(), command.getAf1(), command.getAf2(), command.getB(), command.getBf1(), command.getBf2(), command.getC(), command.getCf2(), command.getEcr(), command.getEtd(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getKf(), command.getMwbase(), command.getT(), command.getT3(), command.getT4(), command.getT5(), command.getTc(), command.getTcd(), command.getTf(), command.getTmax(), command.getTmin(), command.getTr(), command.getTrate(), command.getTt(), command.getW(), command.getX(), command.getY(), command.getZ());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGAST2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGAST2Command" );
        apply(new DeleteGovGAST2Event(command.getGovGAST2Id()));
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
    void on(CreateGovGAST2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovGAST2Event" );
    	this.govGAST2Id = event.getGovGAST2Id();
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
        this.kf = event.getKf();
        this.mwbase = event.getMwbase();
        this.t = event.getT();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tc = event.getTc();
        this.tcd = event.getTcd();
        this.tf = event.getTf();
        this.tmax = event.getTmax();
        this.tmin = event.getTmin();
        this.tr = event.getTr();
        this.trate = event.getTrate();
        this.tt = event.getTt();
        this.w = event.getW();
        this.x = event.getX();
        this.y = event.getY();
        this.z = event.getZ();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGAST2Event event) {
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
        this.kf = event.getKf();
        this.mwbase = event.getMwbase();
        this.t = event.getT();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tc = event.getTc();
        this.tcd = event.getTcd();
        this.tf = event.getTf();
        this.tmax = event.getTmax();
        this.tmin = event.getTmin();
        this.tr = event.getTr();
        this.trate = event.getTrate();
        this.tt = event.getTt();
        this.w = event.getW();
        this.x = event.getX();
        this.y = event.getY();
        this.z = event.getZ();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govGAST2Id;
    
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
    private String kf;
    private String mwbase;
    private String t;
    private String t3;
    private String t4;
    private String t5;
    private String tc;
    private String tcd;
    private String tf;
    private String tmax;
    private String tmin;
    private String tr;
    private String trate;
    private String tt;
    private String w;
    private String x;
    private String y;
    private String z;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST2Aggregate.class.getName());
}
