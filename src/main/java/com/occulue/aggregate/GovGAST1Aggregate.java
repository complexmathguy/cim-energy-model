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
 * Aggregate handler for GovGAST1 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGAST1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGAST1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGAST1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGAST1Aggregate(CreateGovGAST1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGAST1Command" );
    	CreateGovGAST1Event event = new CreateGovGAST1Event(command.getGovGAST1Id(), command.getA(), command.getB(), command.getDb1(), command.getDb2(), command.getEps(), command.getFidle(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getKa(), command.getKt(), command.getLmax(), command.getLoadinc(), command.getLtrate(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getR(), command.getRmax(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getTltr(), command.getVmax(), command.getVmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGAST1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGAST1Command" );
    	UpdateGovGAST1Event event = new UpdateGovGAST1Event(command.getGovGAST1Id(), command.getA(), command.getB(), command.getDb1(), command.getDb2(), command.getEps(), command.getFidle(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getKa(), command.getKt(), command.getLmax(), command.getLoadinc(), command.getLtrate(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getR(), command.getRmax(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getTltr(), command.getVmax(), command.getVmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGAST1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGAST1Command" );
        apply(new DeleteGovGAST1Event(command.getGovGAST1Id()));
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
    void on(CreateGovGAST1Event event) {	
    	LOGGER.info( "Event sourcing CreateGovGAST1Event" );
    	this.govGAST1Id = event.getGovGAST1Id();
        this.a = event.getA();
        this.b = event.getB();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.fidle = event.getFidle();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.ka = event.getKa();
        this.kt = event.getKt();
        this.lmax = event.getLmax();
        this.loadinc = event.getLoadinc();
        this.ltrate = event.getLtrate();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.r = event.getR();
        this.rmax = event.getRmax();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tltr = event.getTltr();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGAST1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a = event.getA();
        this.b = event.getB();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.fidle = event.getFidle();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.ka = event.getKa();
        this.kt = event.getKt();
        this.lmax = event.getLmax();
        this.loadinc = event.getLoadinc();
        this.ltrate = event.getLtrate();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.r = event.getR();
        this.rmax = event.getRmax();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.tltr = event.getTltr();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govGAST1Id;
    
    private String a;
    private String b;
    private String db1;
    private String db2;
    private String eps;
    private String fidle;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String ka;
    private String kt;
    private String lmax;
    private String loadinc;
    private String ltrate;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String pgv6;
    private String r;
    private String rmax;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String tltr;
    private String vmax;
    private String vmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST1Aggregate.class.getName());
}
