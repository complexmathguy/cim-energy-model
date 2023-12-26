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
 * Aggregate handler for GovHydroFrancis as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroFrancis are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroFrancisAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroFrancisAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroFrancisAggregate(CreateGovHydroFrancisCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroFrancisCommand" );
    	CreateGovHydroFrancisEvent event = new CreateGovHydroFrancisEvent(command.getGovHydroFrancisId(), command.getAm(), command.getAv0(), command.getAv1(), command.getBp(), command.getDb1(), command.getEtamax(), command.getGovernorControl(), command.getH1(), command.getH2(), command.getHn(), command.getKc(), command.getKg(), command.getKt(), command.getQc0(), command.getQn(), command.getTa(), command.getTd(), command.getTs(), command.getTwnc(), command.getTwng(), command.getTx(), command.getVa(), command.getValvmax(), command.getValvmin(), command.getVc(), command.getWaterTunnelSurgeChamberSimulation(), command.getZsfc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroFrancisCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroFrancisCommand" );
    	UpdateGovHydroFrancisEvent event = new UpdateGovHydroFrancisEvent(command.getGovHydroFrancisId(), command.getAm(), command.getAv0(), command.getAv1(), command.getBp(), command.getDb1(), command.getEtamax(), command.getGovernorControl(), command.getH1(), command.getH2(), command.getHn(), command.getKc(), command.getKg(), command.getKt(), command.getQc0(), command.getQn(), command.getTa(), command.getTd(), command.getTs(), command.getTwnc(), command.getTwng(), command.getTx(), command.getVa(), command.getValvmax(), command.getValvmin(), command.getVc(), command.getWaterTunnelSurgeChamberSimulation(), command.getZsfc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroFrancisCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroFrancisCommand" );
        apply(new DeleteGovHydroFrancisEvent(command.getGovHydroFrancisId()));
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
    void on(CreateGovHydroFrancisEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroFrancisEvent" );
    	this.govHydroFrancisId = event.getGovHydroFrancisId();
        this.am = event.getAm();
        this.av0 = event.getAv0();
        this.av1 = event.getAv1();
        this.bp = event.getBp();
        this.db1 = event.getDb1();
        this.etamax = event.getEtamax();
        this.governorControl = event.getGovernorControl();
        this.h1 = event.getH1();
        this.h2 = event.getH2();
        this.hn = event.getHn();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.kt = event.getKt();
        this.qc0 = event.getQc0();
        this.qn = event.getQn();
        this.ta = event.getTa();
        this.td = event.getTd();
        this.ts = event.getTs();
        this.twnc = event.getTwnc();
        this.twng = event.getTwng();
        this.tx = event.getTx();
        this.va = event.getVa();
        this.valvmax = event.getValvmax();
        this.valvmin = event.getValvmin();
        this.vc = event.getVc();
        this.waterTunnelSurgeChamberSimulation = event.getWaterTunnelSurgeChamberSimulation();
        this.zsfc = event.getZsfc();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroFrancisEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.am = event.getAm();
        this.av0 = event.getAv0();
        this.av1 = event.getAv1();
        this.bp = event.getBp();
        this.db1 = event.getDb1();
        this.etamax = event.getEtamax();
        this.governorControl = event.getGovernorControl();
        this.h1 = event.getH1();
        this.h2 = event.getH2();
        this.hn = event.getHn();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.kt = event.getKt();
        this.qc0 = event.getQc0();
        this.qn = event.getQn();
        this.ta = event.getTa();
        this.td = event.getTd();
        this.ts = event.getTs();
        this.twnc = event.getTwnc();
        this.twng = event.getTwng();
        this.tx = event.getTx();
        this.va = event.getVa();
        this.valvmax = event.getValvmax();
        this.valvmin = event.getValvmin();
        this.vc = event.getVc();
        this.waterTunnelSurgeChamberSimulation = event.getWaterTunnelSurgeChamberSimulation();
        this.zsfc = event.getZsfc();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroFrancisId;
    
    private String am;
    private String av0;
    private String av1;
    private String bp;
    private String db1;
    private String etamax;
    private String governorControl;
    private String h1;
    private String h2;
    private String hn;
    private String kc;
    private String kg;
    private String kt;
    private String qc0;
    private String qn;
    private String ta;
    private String td;
    private String ts;
    private String twnc;
    private String twng;
    private String tx;
    private String va;
    private String valvmax;
    private String valvmin;
    private String vc;
    private String waterTunnelSurgeChamberSimulation;
    private String zsfc;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroFrancisAggregate.class.getName());
}
