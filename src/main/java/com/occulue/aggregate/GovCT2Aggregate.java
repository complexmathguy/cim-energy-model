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
 * Aggregate handler for GovCT2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovCT2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovCT2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovCT2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovCT2Aggregate(CreateGovCT2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovCT2Command" );
    	CreateGovCT2Event event = new CreateGovCT2Event(command.getGovCT2Id(), command.getAset(), command.getDb(), command.getDm(), command.getFlim1(), command.getFlim10(), command.getFlim2(), command.getFlim3(), command.getFlim4(), command.getFlim5(), command.getFlim6(), command.getFlim7(), command.getFlim8(), command.getFlim9(), command.getKa(), command.getKdgov(), command.getKigov(), command.getKiload(), command.getKimw(), command.getKpgov(), command.getKpload(), command.getKturb(), command.getLdref(), command.getMaxerr(), command.getMinerr(), command.getMwbase(), command.getPlim1(), command.getPlim10(), command.getPlim2(), command.getPlim3(), command.getPlim4(), command.getPlim5(), command.getPlim6(), command.getPlim7(), command.getPlim8(), command.getPlim9(), command.getPrate(), command.getR(), command.getRclose(), command.getRdown(), command.getRopen(), command.getRselect(), command.getRup(), command.getTa(), command.getTact(), command.getTb(), command.getTc(), command.getTdgov(), command.getTeng(), command.getTfload(), command.getTpelec(), command.getTsa(), command.getTsb(), command.getVmax(), command.getVmin(), command.getWfnl(), command.getWfspd());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovCT2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovCT2Command" );
    	UpdateGovCT2Event event = new UpdateGovCT2Event(command.getGovCT2Id(), command.getAset(), command.getDb(), command.getDm(), command.getFlim1(), command.getFlim10(), command.getFlim2(), command.getFlim3(), command.getFlim4(), command.getFlim5(), command.getFlim6(), command.getFlim7(), command.getFlim8(), command.getFlim9(), command.getKa(), command.getKdgov(), command.getKigov(), command.getKiload(), command.getKimw(), command.getKpgov(), command.getKpload(), command.getKturb(), command.getLdref(), command.getMaxerr(), command.getMinerr(), command.getMwbase(), command.getPlim1(), command.getPlim10(), command.getPlim2(), command.getPlim3(), command.getPlim4(), command.getPlim5(), command.getPlim6(), command.getPlim7(), command.getPlim8(), command.getPlim9(), command.getPrate(), command.getR(), command.getRclose(), command.getRdown(), command.getRopen(), command.getRselect(), command.getRup(), command.getTa(), command.getTact(), command.getTb(), command.getTc(), command.getTdgov(), command.getTeng(), command.getTfload(), command.getTpelec(), command.getTsa(), command.getTsb(), command.getVmax(), command.getVmin(), command.getWfnl(), command.getWfspd());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovCT2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovCT2Command" );
        apply(new DeleteGovCT2Event(command.getGovCT2Id()));
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
    void on(CreateGovCT2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovCT2Event" );
    	this.govCT2Id = event.getGovCT2Id();
        this.aset = event.getAset();
        this.db = event.getDb();
        this.dm = event.getDm();
        this.flim1 = event.getFlim1();
        this.flim10 = event.getFlim10();
        this.flim2 = event.getFlim2();
        this.flim3 = event.getFlim3();
        this.flim4 = event.getFlim4();
        this.flim5 = event.getFlim5();
        this.flim6 = event.getFlim6();
        this.flim7 = event.getFlim7();
        this.flim8 = event.getFlim8();
        this.flim9 = event.getFlim9();
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
        this.plim1 = event.getPlim1();
        this.plim10 = event.getPlim10();
        this.plim2 = event.getPlim2();
        this.plim3 = event.getPlim3();
        this.plim4 = event.getPlim4();
        this.plim5 = event.getPlim5();
        this.plim6 = event.getPlim6();
        this.plim7 = event.getPlim7();
        this.plim8 = event.getPlim8();
        this.plim9 = event.getPlim9();
        this.prate = event.getPrate();
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
    void on(UpdateGovCT2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.aset = event.getAset();
        this.db = event.getDb();
        this.dm = event.getDm();
        this.flim1 = event.getFlim1();
        this.flim10 = event.getFlim10();
        this.flim2 = event.getFlim2();
        this.flim3 = event.getFlim3();
        this.flim4 = event.getFlim4();
        this.flim5 = event.getFlim5();
        this.flim6 = event.getFlim6();
        this.flim7 = event.getFlim7();
        this.flim8 = event.getFlim8();
        this.flim9 = event.getFlim9();
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
        this.plim1 = event.getPlim1();
        this.plim10 = event.getPlim10();
        this.plim2 = event.getPlim2();
        this.plim3 = event.getPlim3();
        this.plim4 = event.getPlim4();
        this.plim5 = event.getPlim5();
        this.plim6 = event.getPlim6();
        this.plim7 = event.getPlim7();
        this.plim8 = event.getPlim8();
        this.plim9 = event.getPlim9();
        this.prate = event.getPrate();
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
    private UUID govCT2Id;
    
    private String aset;
    private String db;
    private String dm;
    private String flim1;
    private String flim10;
    private String flim2;
    private String flim3;
    private String flim4;
    private String flim5;
    private String flim6;
    private String flim7;
    private String flim8;
    private String flim9;
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
    private String plim1;
    private String plim10;
    private String plim2;
    private String plim3;
    private String plim4;
    private String plim5;
    private String plim6;
    private String plim7;
    private String plim8;
    private String plim9;
    private String prate;
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

    private static final Logger LOGGER 	= Logger.getLogger(GovCT2Aggregate.class.getName());
}
