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
 * Aggregate handler for GovSteamEU as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamEU are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamEUAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamEUAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamEUAggregate(CreateGovSteamEUCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamEUCommand" );
    	CreateGovSteamEUEvent event = new CreateGovSteamEUEvent(command.getGovSteamEUId(), command.getChc(), command.getCho(), command.getCic(), command.getCio(), command.getDb1(), command.getDb2(), command.getHhpmax(), command.getKe(), command.getKfcor(), command.getKhp(), command.getKlp(), command.getKwcor(), command.getMwbase(), command.getPmax(), command.getPrhmax(), command.getSimx(), command.getTb(), command.getTdp(), command.getTen(), command.getTf(), command.getTfp(), command.getThp(), command.getTip(), command.getTlp(), command.getTp(), command.getTrh(), command.getTvhp(), command.getTvip(), command.getTw(), command.getWfmax(), command.getWfmin(), command.getWmax1(), command.getWmax2(), command.getWwmax(), command.getWwmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamEUCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamEUCommand" );
    	UpdateGovSteamEUEvent event = new UpdateGovSteamEUEvent(command.getGovSteamEUId(), command.getChc(), command.getCho(), command.getCic(), command.getCio(), command.getDb1(), command.getDb2(), command.getHhpmax(), command.getKe(), command.getKfcor(), command.getKhp(), command.getKlp(), command.getKwcor(), command.getMwbase(), command.getPmax(), command.getPrhmax(), command.getSimx(), command.getTb(), command.getTdp(), command.getTen(), command.getTf(), command.getTfp(), command.getThp(), command.getTip(), command.getTlp(), command.getTp(), command.getTrh(), command.getTvhp(), command.getTvip(), command.getTw(), command.getWfmax(), command.getWfmin(), command.getWmax1(), command.getWmax2(), command.getWwmax(), command.getWwmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamEUCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamEUCommand" );
        apply(new DeleteGovSteamEUEvent(command.getGovSteamEUId()));
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
    void on(CreateGovSteamEUEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamEUEvent" );
    	this.govSteamEUId = event.getGovSteamEUId();
        this.chc = event.getChc();
        this.cho = event.getCho();
        this.cic = event.getCic();
        this.cio = event.getCio();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.hhpmax = event.getHhpmax();
        this.ke = event.getKe();
        this.kfcor = event.getKfcor();
        this.khp = event.getKhp();
        this.klp = event.getKlp();
        this.kwcor = event.getKwcor();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.prhmax = event.getPrhmax();
        this.simx = event.getSimx();
        this.tb = event.getTb();
        this.tdp = event.getTdp();
        this.ten = event.getTen();
        this.tf = event.getTf();
        this.tfp = event.getTfp();
        this.thp = event.getThp();
        this.tip = event.getTip();
        this.tlp = event.getTlp();
        this.tp = event.getTp();
        this.trh = event.getTrh();
        this.tvhp = event.getTvhp();
        this.tvip = event.getTvip();
        this.tw = event.getTw();
        this.wfmax = event.getWfmax();
        this.wfmin = event.getWfmin();
        this.wmax1 = event.getWmax1();
        this.wmax2 = event.getWmax2();
        this.wwmax = event.getWwmax();
        this.wwmin = event.getWwmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamEUEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.chc = event.getChc();
        this.cho = event.getCho();
        this.cic = event.getCic();
        this.cio = event.getCio();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.hhpmax = event.getHhpmax();
        this.ke = event.getKe();
        this.kfcor = event.getKfcor();
        this.khp = event.getKhp();
        this.klp = event.getKlp();
        this.kwcor = event.getKwcor();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.prhmax = event.getPrhmax();
        this.simx = event.getSimx();
        this.tb = event.getTb();
        this.tdp = event.getTdp();
        this.ten = event.getTen();
        this.tf = event.getTf();
        this.tfp = event.getTfp();
        this.thp = event.getThp();
        this.tip = event.getTip();
        this.tlp = event.getTlp();
        this.tp = event.getTp();
        this.trh = event.getTrh();
        this.tvhp = event.getTvhp();
        this.tvip = event.getTvip();
        this.tw = event.getTw();
        this.wfmax = event.getWfmax();
        this.wfmin = event.getWfmin();
        this.wmax1 = event.getWmax1();
        this.wmax2 = event.getWmax2();
        this.wwmax = event.getWwmax();
        this.wwmin = event.getWwmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamEUId;
    
    private String chc;
    private String cho;
    private String cic;
    private String cio;
    private String db1;
    private String db2;
    private String hhpmax;
    private String ke;
    private String kfcor;
    private String khp;
    private String klp;
    private String kwcor;
    private String mwbase;
    private String pmax;
    private String prhmax;
    private String simx;
    private String tb;
    private String tdp;
    private String ten;
    private String tf;
    private String tfp;
    private String thp;
    private String tip;
    private String tlp;
    private String tp;
    private String trh;
    private String tvhp;
    private String tvip;
    private String tw;
    private String wfmax;
    private String wfmin;
    private String wmax1;
    private String wmax2;
    private String wwmax;
    private String wwmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamEUAggregate.class.getName());
}
