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
 * Aggregate handler for GovHydroR as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroR are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroRAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroRAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroRAggregate(CreateGovHydroRCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroRCommand" );
    	CreateGovHydroREvent event = new CreateGovHydroREvent(command.getGovHydroRId(), command.getAt(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGmax(), command.getGmin(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getH0(), command.getInputSignal(), command.getKg(), command.getKi(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getQnl(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getTd(), command.getTp(), command.getTt(), command.getTw(), command.getVelcl(), command.getVelop());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroRCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroRCommand" );
    	UpdateGovHydroREvent event = new UpdateGovHydroREvent(command.getGovHydroRId(), command.getAt(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGmax(), command.getGmin(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getH0(), command.getInputSignal(), command.getKg(), command.getKi(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getQnl(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getTd(), command.getTp(), command.getTt(), command.getTw(), command.getVelcl(), command.getVelop());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroRCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroRCommand" );
        apply(new DeleteGovHydroREvent(command.getGovHydroRId()));
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
    void on(CreateGovHydroREvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroREvent" );
    	this.govHydroRId = event.getGovHydroRId();
        this.at = event.getAt();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.h0 = event.getH0();
        this.inputSignal = event.getInputSignal();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.qnl = event.getQnl();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.td = event.getTd();
        this.tp = event.getTp();
        this.tt = event.getTt();
        this.tw = event.getTw();
        this.velcl = event.getVelcl();
        this.velop = event.getVelop();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroREvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.at = event.getAt();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.h0 = event.getH0();
        this.inputSignal = event.getInputSignal();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.qnl = event.getQnl();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.td = event.getTd();
        this.tp = event.getTp();
        this.tt = event.getTt();
        this.tw = event.getTw();
        this.velcl = event.getVelcl();
        this.velop = event.getVelop();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroRId;
    
    private String at;
    private String db1;
    private String db2;
    private String dturb;
    private String eps;
    private String gmax;
    private String gmin;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String h0;
    private String inputSignal;
    private String kg;
    private String ki;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String pgv6;
    private String pmax;
    private String pmin;
    private String qnl;
    private String r;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String t7;
    private String t8;
    private String td;
    private String tp;
    private String tt;
    private String tw;
    private String velcl;
    private String velop;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroRAggregate.class.getName());
}
