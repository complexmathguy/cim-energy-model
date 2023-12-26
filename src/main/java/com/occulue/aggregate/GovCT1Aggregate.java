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
 * Aggregate handler for GovCT1 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovCT1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovCT1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovCT1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovCT1Aggregate(CreateGovCT1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovCT1Command" );
    	CreateGovCT1Event event = new CreateGovCT1Event(command.getGovCT1Id(), command.getAset(), command.getDb(), command.getDm(), command.getKa(), command.getKdgov(), command.getKigov(), command.getKiload(), command.getKimw(), command.getKpgov(), command.getKpload(), command.getKturb(), command.getLdref(), command.getMaxerr(), command.getMinerr(), command.getMwbase(), command.getR(), command.getRclose(), command.getRdown(), command.getRopen(), command.getRselect(), command.getRup(), command.getTa(), command.getTact(), command.getTb(), command.getTc(), command.getTdgov(), command.getTeng(), command.getTfload(), command.getTpelec(), command.getTsa(), command.getTsb(), command.getVmax(), command.getVmin(), command.getWfnl(), command.getWfspd());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovCT1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovCT1Command" );
    	UpdateGovCT1Event event = new UpdateGovCT1Event(command.getGovCT1Id(), command.getAset(), command.getDb(), command.getDm(), command.getKa(), command.getKdgov(), command.getKigov(), command.getKiload(), command.getKimw(), command.getKpgov(), command.getKpload(), command.getKturb(), command.getLdref(), command.getMaxerr(), command.getMinerr(), command.getMwbase(), command.getR(), command.getRclose(), command.getRdown(), command.getRopen(), command.getRselect(), command.getRup(), command.getTa(), command.getTact(), command.getTb(), command.getTc(), command.getTdgov(), command.getTeng(), command.getTfload(), command.getTpelec(), command.getTsa(), command.getTsb(), command.getVmax(), command.getVmin(), command.getWfnl(), command.getWfspd());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovCT1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovCT1Command" );
        apply(new DeleteGovCT1Event(command.getGovCT1Id()));
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
    void on(CreateGovCT1Event event) {	
    	LOGGER.info( "Event sourcing CreateGovCT1Event" );
    	this.govCT1Id = event.getGovCT1Id();
        this.aset = event.getAset();
        this.db = event.getDb();
        this.dm = event.getDm();
        this.ka = event.getKa();
        this.kdgov = event.getKdgov();
        this.kigov = event.getKigov();
        this.kiload = event.getKiload();
        this.kimw = event.getKimw();
        this.kpgov = event.getKpgov();
        this.kpload = event.getKpload();
        this.kturb = event.getKturb();
        this.ldref = event.getLdref();
        this.maxerr = event.getMaxerr();
        this.minerr = event.getMinerr();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.rclose = event.getRclose();
        this.rdown = event.getRdown();
        this.ropen = event.getRopen();
        this.rselect = event.getRselect();
        this.rup = event.getRup();
        this.ta = event.getTa();
        this.tact = event.getTact();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.tdgov = event.getTdgov();
        this.teng = event.getTeng();
        this.tfload = event.getTfload();
        this.tpelec = event.getTpelec();
        this.tsa = event.getTsa();
        this.tsb = event.getTsb();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
        this.wfnl = event.getWfnl();
        this.wfspd = event.getWfspd();
    }
    
    @EventSourcingHandler
    void on(UpdateGovCT1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.aset = event.getAset();
        this.db = event.getDb();
        this.dm = event.getDm();
        this.ka = event.getKa();
        this.kdgov = event.getKdgov();
        this.kigov = event.getKigov();
        this.kiload = event.getKiload();
        this.kimw = event.getKimw();
        this.kpgov = event.getKpgov();
        this.kpload = event.getKpload();
        this.kturb = event.getKturb();
        this.ldref = event.getLdref();
        this.maxerr = event.getMaxerr();
        this.minerr = event.getMinerr();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.rclose = event.getRclose();
        this.rdown = event.getRdown();
        this.ropen = event.getRopen();
        this.rselect = event.getRselect();
        this.rup = event.getRup();
        this.ta = event.getTa();
        this.tact = event.getTact();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.tdgov = event.getTdgov();
        this.teng = event.getTeng();
        this.tfload = event.getTfload();
        this.tpelec = event.getTpelec();
        this.tsa = event.getTsa();
        this.tsb = event.getTsb();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
        this.wfnl = event.getWfnl();
        this.wfspd = event.getWfspd();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govCT1Id;
    
    private String aset;
    private String db;
    private String dm;
    private String ka;
    private String kdgov;
    private String kigov;
    private String kiload;
    private String kimw;
    private String kpgov;
    private String kpload;
    private String kturb;
    private String ldref;
    private String maxerr;
    private String minerr;
    private String mwbase;
    private String r;
    private String rclose;
    private String rdown;
    private String ropen;
    private String rselect;
    private String rup;
    private String ta;
    private String tact;
    private String tb;
    private String tc;
    private String tdgov;
    private String teng;
    private String tfload;
    private String tpelec;
    private String tsa;
    private String tsb;
    private String vmax;
    private String vmin;
    private String wfnl;
    private String wfspd;

    private static final Logger LOGGER 	= Logger.getLogger(GovCT1Aggregate.class.getName());
}
