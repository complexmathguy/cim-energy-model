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
 * Aggregate handler for GovHydroPelton as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroPelton are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroPeltonAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroPeltonAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroPeltonAggregate(CreateGovHydroPeltonCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroPeltonCommand" );
    	CreateGovHydroPeltonEvent event = new CreateGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAv0(), command.getAv1(), command.getBp(), command.getDb1(), command.getDb2(), command.getH1(), command.getH2(), command.getHn(), command.getKc(), command.getKg(), command.getQc0(), command.getQn(), command.getSimplifiedPelton(), command.getStaticCompensating(), command.getTa(), command.getTs(), command.getTv(), command.getTwnc(), command.getTwng(), command.getTx(), command.getVa(), command.getValvmax(), command.getValvmin(), command.getVav(), command.getVc(), command.getVcv(), command.getWaterTunnelSurgeChamberSimulation(), command.getZsfc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroPeltonCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroPeltonCommand" );
    	UpdateGovHydroPeltonEvent event = new UpdateGovHydroPeltonEvent(command.getGovHydroPeltonId(), command.getAv0(), command.getAv1(), command.getBp(), command.getDb1(), command.getDb2(), command.getH1(), command.getH2(), command.getHn(), command.getKc(), command.getKg(), command.getQc0(), command.getQn(), command.getSimplifiedPelton(), command.getStaticCompensating(), command.getTa(), command.getTs(), command.getTv(), command.getTwnc(), command.getTwng(), command.getTx(), command.getVa(), command.getValvmax(), command.getValvmin(), command.getVav(), command.getVc(), command.getVcv(), command.getWaterTunnelSurgeChamberSimulation(), command.getZsfc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroPeltonCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroPeltonCommand" );
        apply(new DeleteGovHydroPeltonEvent(command.getGovHydroPeltonId()));
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
    void on(CreateGovHydroPeltonEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroPeltonEvent" );
    	this.govHydroPeltonId = event.getGovHydroPeltonId();
        this.av0 = event.getAv0();
        this.av1 = event.getAv1();
        this.bp = event.getBp();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.h1 = event.getH1();
        this.h2 = event.getH2();
        this.hn = event.getHn();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.qc0 = event.getQc0();
        this.qn = event.getQn();
        this.simplifiedPelton = event.getSimplifiedPelton();
        this.staticCompensating = event.getStaticCompensating();
        this.ta = event.getTa();
        this.ts = event.getTs();
        this.tv = event.getTv();
        this.twnc = event.getTwnc();
        this.twng = event.getTwng();
        this.tx = event.getTx();
        this.va = event.getVa();
        this.valvmax = event.getValvmax();
        this.valvmin = event.getValvmin();
        this.vav = event.getVav();
        this.vc = event.getVc();
        this.vcv = event.getVcv();
        this.waterTunnelSurgeChamberSimulation = event.getWaterTunnelSurgeChamberSimulation();
        this.zsfc = event.getZsfc();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroPeltonEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.av0 = event.getAv0();
        this.av1 = event.getAv1();
        this.bp = event.getBp();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.h1 = event.getH1();
        this.h2 = event.getH2();
        this.hn = event.getHn();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.qc0 = event.getQc0();
        this.qn = event.getQn();
        this.simplifiedPelton = event.getSimplifiedPelton();
        this.staticCompensating = event.getStaticCompensating();
        this.ta = event.getTa();
        this.ts = event.getTs();
        this.tv = event.getTv();
        this.twnc = event.getTwnc();
        this.twng = event.getTwng();
        this.tx = event.getTx();
        this.va = event.getVa();
        this.valvmax = event.getValvmax();
        this.valvmin = event.getValvmin();
        this.vav = event.getVav();
        this.vc = event.getVc();
        this.vcv = event.getVcv();
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
    private UUID govHydroPeltonId;
    
    private String av0;
    private String av1;
    private String bp;
    private String db1;
    private String db2;
    private String h1;
    private String h2;
    private String hn;
    private String kc;
    private String kg;
    private String qc0;
    private String qn;
    private String simplifiedPelton;
    private String staticCompensating;
    private String ta;
    private String ts;
    private String tv;
    private String twnc;
    private String twng;
    private String tx;
    private String va;
    private String valvmax;
    private String valvmin;
    private String vav;
    private String vc;
    private String vcv;
    private String waterTunnelSurgeChamberSimulation;
    private String zsfc;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPeltonAggregate.class.getName());
}
