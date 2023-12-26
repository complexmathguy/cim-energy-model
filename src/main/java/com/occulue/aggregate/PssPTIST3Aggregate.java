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
 * Aggregate handler for PssPTIST3 as outlined for the CQRS pattern, all write responsibilities 
 * related to PssPTIST3 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssPTIST3Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssPTIST3Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssPTIST3Aggregate(CreatePssPTIST3Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePssPTIST3Command" );
    	CreatePssPTIST3Event event = new CreatePssPTIST3Event(command.getPssPTIST3Id(), command.getA0(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getAl(), command.getAthres(), command.getB0(), command.getB1(), command.getB2(), command.getB3(), command.getB4(), command.getB5(), command.getDl(), command.getDtc(), command.getDtf(), command.getDtp(), command.getIsw(), command.getK(), command.getLthres(), command.getM(), command.getNav(), command.getNcl(), command.getNcr(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTf(), command.getTp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssPTIST3Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePssPTIST3Command" );
    	UpdatePssPTIST3Event event = new UpdatePssPTIST3Event(command.getPssPTIST3Id(), command.getA0(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getAl(), command.getAthres(), command.getB0(), command.getB1(), command.getB2(), command.getB3(), command.getB4(), command.getB5(), command.getDl(), command.getDtc(), command.getDtf(), command.getDtp(), command.getIsw(), command.getK(), command.getLthres(), command.getM(), command.getNav(), command.getNcl(), command.getNcr(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTf(), command.getTp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssPTIST3Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePssPTIST3Command" );
        apply(new DeletePssPTIST3Event(command.getPssPTIST3Id()));
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
    void on(CreatePssPTIST3Event event) {	
    	LOGGER.info( "Event sourcing CreatePssPTIST3Event" );
    	this.pssPTIST3Id = event.getPssPTIST3Id();
        this.a0 = event.getA0();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.al = event.getAl();
        this.athres = event.getAthres();
        this.b0 = event.getB0();
        this.b1 = event.getB1();
        this.b2 = event.getB2();
        this.b3 = event.getB3();
        this.b4 = event.getB4();
        this.b5 = event.getB5();
        this.dl = event.getDl();
        this.dtc = event.getDtc();
        this.dtf = event.getDtf();
        this.dtp = event.getDtp();
        this.isw = event.getIsw();
        this.k = event.getK();
        this.lthres = event.getLthres();
        this.m = event.getM();
        this.nav = event.getNav();
        this.ncl = event.getNcl();
        this.ncr = event.getNcr();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.tf = event.getTf();
        this.tp = event.getTp();
    }
    
    @EventSourcingHandler
    void on(UpdatePssPTIST3Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a0 = event.getA0();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.al = event.getAl();
        this.athres = event.getAthres();
        this.b0 = event.getB0();
        this.b1 = event.getB1();
        this.b2 = event.getB2();
        this.b3 = event.getB3();
        this.b4 = event.getB4();
        this.b5 = event.getB5();
        this.dl = event.getDl();
        this.dtc = event.getDtc();
        this.dtf = event.getDtf();
        this.dtp = event.getDtp();
        this.isw = event.getIsw();
        this.k = event.getK();
        this.lthres = event.getLthres();
        this.m = event.getM();
        this.nav = event.getNav();
        this.ncl = event.getNcl();
        this.ncr = event.getNcr();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.tf = event.getTf();
        this.tp = event.getTp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssPTIST3Id;
    
    private String a0;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String al;
    private String athres;
    private String b0;
    private String b1;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String dl;
    private String dtc;
    private String dtf;
    private String dtp;
    private String isw;
    private String k;
    private String lthres;
    private String m;
    private String nav;
    private String ncl;
    private String ncr;
    private String pmin;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String tf;
    private String tp;

    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST3Aggregate.class.getName());
}
