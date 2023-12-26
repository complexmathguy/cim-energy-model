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
 * Aggregate handler for GovSteam1 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteam1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteam1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteam1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteam1Aggregate(CreateGovSteam1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteam1Command" );
    	CreateGovSteam1Event event = new CreateGovSteam1Event(command.getGovSteam1Id(), command.getDb1(), command.getDb2(), command.getEps(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getK7(), command.getK8(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getSdb1(), command.getSdb2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getUc(), command.getUo(), command.getValve());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteam1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteam1Command" );
    	UpdateGovSteam1Event event = new UpdateGovSteam1Event(command.getGovSteam1Id(), command.getDb1(), command.getDb2(), command.getEps(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getK7(), command.getK8(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getSdb1(), command.getSdb2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getUc(), command.getUo(), command.getValve());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteam1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteam1Command" );
        apply(new DeleteGovSteam1Event(command.getGovSteam1Id()));
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
    void on(CreateGovSteam1Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteam1Event" );
    	this.govSteam1Id = event.getGovSteam1Id();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.k7 = event.getK7();
        this.k8 = event.getK8();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.sdb1 = event.getSdb1();
        this.sdb2 = event.getSdb2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.uc = event.getUc();
        this.uo = event.getUo();
        this.valve = event.getValve();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteam1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.k7 = event.getK7();
        this.k8 = event.getK8();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.sdb1 = event.getSdb1();
        this.sdb2 = event.getSdb2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.uc = event.getUc();
        this.uo = event.getUo();
        this.valve = event.getValve();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteam1Id;
    
    private String db1;
    private String db2;
    private String eps;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String k;
    private String k1;
    private String k2;
    private String k3;
    private String k4;
    private String k5;
    private String k6;
    private String k7;
    private String k8;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String pgv6;
    private String pmax;
    private String pmin;
    private String sdb1;
    private String sdb2;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String t7;
    private String uc;
    private String uo;
    private String valve;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam1Aggregate.class.getName());
}
