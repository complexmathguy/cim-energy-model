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
 * Aggregate handler for GovSteamFV4 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamFV4 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamFV4Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamFV4Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamFV4Aggregate(CreateGovSteamFV4Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamFV4Command" );
    	CreateGovSteamFV4Event event = new CreateGovSteamFV4Event(command.getGovSteamFV4Id(), command.getCpsmn(), command.getCpsmx(), command.getCrmn(), command.getCrmx(), command.getKdc(), command.getKf1(), command.getKf3(), command.getKhp(), command.getKic(), command.getKip(), command.getKit(), command.getKmp1(), command.getKmp2(), command.getKpc(), command.getKpp(), command.getKpt(), command.getKrc(), command.getKsh(), command.getLpi(), command.getLps(), command.getMnef(), command.getMxef(), command.getPr1(), command.getPr2(), command.getPsmn(), command.getRsmimn(), command.getRsmimx(), command.getRvgmn(), command.getRvgmx(), command.getSrmn(), command.getSrmx(), command.getSrsmp(), command.getSvmn(), command.getSvmx(), command.getTa(), command.getTam(), command.getTc(), command.getTcm(), command.getTdc(), command.getTf1(), command.getTf2(), command.getThp(), command.getTmp(), command.getTrh(), command.getTv(), command.getTy(), command.getY(), command.getYhpmn(), command.getYhpmx(), command.getYmpmn(), command.getYmpmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamFV4Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamFV4Command" );
    	UpdateGovSteamFV4Event event = new UpdateGovSteamFV4Event(command.getGovSteamFV4Id(), command.getCpsmn(), command.getCpsmx(), command.getCrmn(), command.getCrmx(), command.getKdc(), command.getKf1(), command.getKf3(), command.getKhp(), command.getKic(), command.getKip(), command.getKit(), command.getKmp1(), command.getKmp2(), command.getKpc(), command.getKpp(), command.getKpt(), command.getKrc(), command.getKsh(), command.getLpi(), command.getLps(), command.getMnef(), command.getMxef(), command.getPr1(), command.getPr2(), command.getPsmn(), command.getRsmimn(), command.getRsmimx(), command.getRvgmn(), command.getRvgmx(), command.getSrmn(), command.getSrmx(), command.getSrsmp(), command.getSvmn(), command.getSvmx(), command.getTa(), command.getTam(), command.getTc(), command.getTcm(), command.getTdc(), command.getTf1(), command.getTf2(), command.getThp(), command.getTmp(), command.getTrh(), command.getTv(), command.getTy(), command.getY(), command.getYhpmn(), command.getYhpmx(), command.getYmpmn(), command.getYmpmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamFV4Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamFV4Command" );
        apply(new DeleteGovSteamFV4Event(command.getGovSteamFV4Id()));
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
    void on(CreateGovSteamFV4Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamFV4Event" );
    	this.govSteamFV4Id = event.getGovSteamFV4Id();
        this.cpsmn = event.getCpsmn();
        this.cpsmx = event.getCpsmx();
        this.crmn = event.getCrmn();
        this.crmx = event.getCrmx();
        this.kdc = event.getKdc();
        this.kf1 = event.getKf1();
        this.kf3 = event.getKf3();
        this.khp = event.getKhp();
        this.kic = event.getKic();
        this.kip = event.getKip();
        this.kit = event.getKit();
        this.kmp1 = event.getKmp1();
        this.kmp2 = event.getKmp2();
        this.kpc = event.getKpc();
        this.kpp = event.getKpp();
        this.kpt = event.getKpt();
        this.krc = event.getKrc();
        this.ksh = event.getKsh();
        this.lpi = event.getLpi();
        this.lps = event.getLps();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.pr1 = event.getPr1();
        this.pr2 = event.getPr2();
        this.psmn = event.getPsmn();
        this.rsmimn = event.getRsmimn();
        this.rsmimx = event.getRsmimx();
        this.rvgmn = event.getRvgmn();
        this.rvgmx = event.getRvgmx();
        this.srmn = event.getSrmn();
        this.srmx = event.getSrmx();
        this.srsmp = event.getSrsmp();
        this.svmn = event.getSvmn();
        this.svmx = event.getSvmx();
        this.ta = event.getTa();
        this.tam = event.getTam();
        this.tc = event.getTc();
        this.tcm = event.getTcm();
        this.tdc = event.getTdc();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.thp = event.getThp();
        this.tmp = event.getTmp();
        this.trh = event.getTrh();
        this.tv = event.getTv();
        this.ty = event.getTy();
        this.y = event.getY();
        this.yhpmn = event.getYhpmn();
        this.yhpmx = event.getYhpmx();
        this.ympmn = event.getYmpmn();
        this.ympmx = event.getYmpmx();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamFV4Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.cpsmn = event.getCpsmn();
        this.cpsmx = event.getCpsmx();
        this.crmn = event.getCrmn();
        this.crmx = event.getCrmx();
        this.kdc = event.getKdc();
        this.kf1 = event.getKf1();
        this.kf3 = event.getKf3();
        this.khp = event.getKhp();
        this.kic = event.getKic();
        this.kip = event.getKip();
        this.kit = event.getKit();
        this.kmp1 = event.getKmp1();
        this.kmp2 = event.getKmp2();
        this.kpc = event.getKpc();
        this.kpp = event.getKpp();
        this.kpt = event.getKpt();
        this.krc = event.getKrc();
        this.ksh = event.getKsh();
        this.lpi = event.getLpi();
        this.lps = event.getLps();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.pr1 = event.getPr1();
        this.pr2 = event.getPr2();
        this.psmn = event.getPsmn();
        this.rsmimn = event.getRsmimn();
        this.rsmimx = event.getRsmimx();
        this.rvgmn = event.getRvgmn();
        this.rvgmx = event.getRvgmx();
        this.srmn = event.getSrmn();
        this.srmx = event.getSrmx();
        this.srsmp = event.getSrsmp();
        this.svmn = event.getSvmn();
        this.svmx = event.getSvmx();
        this.ta = event.getTa();
        this.tam = event.getTam();
        this.tc = event.getTc();
        this.tcm = event.getTcm();
        this.tdc = event.getTdc();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.thp = event.getThp();
        this.tmp = event.getTmp();
        this.trh = event.getTrh();
        this.tv = event.getTv();
        this.ty = event.getTy();
        this.y = event.getY();
        this.yhpmn = event.getYhpmn();
        this.yhpmx = event.getYhpmx();
        this.ympmn = event.getYmpmn();
        this.ympmx = event.getYmpmx();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamFV4Id;
    
    private String cpsmn;
    private String cpsmx;
    private String crmn;
    private String crmx;
    private String kdc;
    private String kf1;
    private String kf3;
    private String khp;
    private String kic;
    private String kip;
    private String kit;
    private String kmp1;
    private String kmp2;
    private String kpc;
    private String kpp;
    private String kpt;
    private String krc;
    private String ksh;
    private String lpi;
    private String lps;
    private String mnef;
    private String mxef;
    private String pr1;
    private String pr2;
    private String psmn;
    private String rsmimn;
    private String rsmimx;
    private String rvgmn;
    private String rvgmx;
    private String srmn;
    private String srmx;
    private String srsmp;
    private String svmn;
    private String svmx;
    private String ta;
    private String tam;
    private String tc;
    private String tcm;
    private String tdc;
    private String tf1;
    private String tf2;
    private String thp;
    private String tmp;
    private String trh;
    private String tv;
    private String ty;
    private String y;
    private String yhpmn;
    private String yhpmx;
    private String ympmn;
    private String ympmx;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV4Aggregate.class.getName());
}
