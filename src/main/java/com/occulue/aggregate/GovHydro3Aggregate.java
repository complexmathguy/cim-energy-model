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
 * Aggregate handler for GovHydro3 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydro3 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydro3Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydro3Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydro3Aggregate(CreateGovHydro3Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydro3Command" );
    	CreateGovHydro3Event event = new CreateGovHydro3Event(command.getGovHydro3Id(), command.getAt(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGovernorControl(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getH0(), command.getK1(), command.getK2(), command.getKg(), command.getKi(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getQnl(), command.getRelec(), command.getRgate(), command.getTd(), command.getTf(), command.getTp(), command.getTt(), command.getTw(), command.getVelcl(), command.getVelop());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydro3Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydro3Command" );
    	UpdateGovHydro3Event event = new UpdateGovHydro3Event(command.getGovHydro3Id(), command.getAt(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGovernorControl(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getH0(), command.getK1(), command.getK2(), command.getKg(), command.getKi(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getQnl(), command.getRelec(), command.getRgate(), command.getTd(), command.getTf(), command.getTp(), command.getTt(), command.getTw(), command.getVelcl(), command.getVelop());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydro3Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydro3Command" );
        apply(new DeleteGovHydro3Event(command.getGovHydro3Id()));
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
    void on(CreateGovHydro3Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydro3Event" );
    	this.govHydro3Id = event.getGovHydro3Id();
        this.at = event.getAt();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.governorControl = event.getGovernorControl();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.h0 = event.getH0();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
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
        this.relec = event.getRelec();
        this.rgate = event.getRgate();
        this.td = event.getTd();
        this.tf = event.getTf();
        this.tp = event.getTp();
        this.tt = event.getTt();
        this.tw = event.getTw();
        this.velcl = event.getVelcl();
        this.velop = event.getVelop();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydro3Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.at = event.getAt();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.governorControl = event.getGovernorControl();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.h0 = event.getH0();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
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
        this.relec = event.getRelec();
        this.rgate = event.getRgate();
        this.td = event.getTd();
        this.tf = event.getTf();
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
    private UUID govHydro3Id;
    
    private String at;
    private String db1;
    private String db2;
    private String dturb;
    private String eps;
    private String governorControl;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String h0;
    private String k1;
    private String k2;
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
    private String relec;
    private String rgate;
    private String td;
    private String tf;
    private String tp;
    private String tt;
    private String tw;
    private String velcl;
    private String velop;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro3Aggregate.class.getName());
}
