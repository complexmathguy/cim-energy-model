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
 * Aggregate handler for GovHydroWEH as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroWEH are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroWEHAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroWEHAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroWEHAggregate(CreateGovHydroWEHCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroWEHCommand" );
    	CreateGovHydroWEHEvent event = new CreateGovHydroWEHEvent(command.getGovHydroWEHId(), command.getDb(), command.getDicn(), command.getDpv(), command.getDturb(), command.getFeedbackSignal(), command.getFl1(), command.getFl2(), command.getFl3(), command.getFl4(), command.getFl5(), command.getFp1(), command.getFp10(), command.getFp2(), command.getFp3(), command.getFp4(), command.getFp5(), command.getFp6(), command.getFp7(), command.getFp8(), command.getFp9(), command.getGmax(), command.getGmin(), command.getGtmxcl(), command.getGtmxop(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getPmss1(), command.getPmss10(), command.getPmss2(), command.getPmss3(), command.getPmss4(), command.getPmss5(), command.getPmss6(), command.getPmss7(), command.getPmss8(), command.getPmss9(), command.getRpg(), command.getRpp(), command.getTd(), command.getTdv(), command.getTg(), command.getTp(), command.getTpe(), command.getTw());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroWEHCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroWEHCommand" );
    	UpdateGovHydroWEHEvent event = new UpdateGovHydroWEHEvent(command.getGovHydroWEHId(), command.getDb(), command.getDicn(), command.getDpv(), command.getDturb(), command.getFeedbackSignal(), command.getFl1(), command.getFl2(), command.getFl3(), command.getFl4(), command.getFl5(), command.getFp1(), command.getFp10(), command.getFp2(), command.getFp3(), command.getFp4(), command.getFp5(), command.getFp6(), command.getFp7(), command.getFp8(), command.getFp9(), command.getGmax(), command.getGmin(), command.getGtmxcl(), command.getGtmxop(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getPmss1(), command.getPmss10(), command.getPmss2(), command.getPmss3(), command.getPmss4(), command.getPmss5(), command.getPmss6(), command.getPmss7(), command.getPmss8(), command.getPmss9(), command.getRpg(), command.getRpp(), command.getTd(), command.getTdv(), command.getTg(), command.getTp(), command.getTpe(), command.getTw());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroWEHCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroWEHCommand" );
        apply(new DeleteGovHydroWEHEvent(command.getGovHydroWEHId()));
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
    void on(CreateGovHydroWEHEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroWEHEvent" );
    	this.govHydroWEHId = event.getGovHydroWEHId();
        this.db = event.getDb();
        this.dicn = event.getDicn();
        this.dpv = event.getDpv();
        this.dturb = event.getDturb();
        this.feedbackSignal = event.getFeedbackSignal();
        this.fl1 = event.getFl1();
        this.fl2 = event.getFl2();
        this.fl3 = event.getFl3();
        this.fl4 = event.getFl4();
        this.fl5 = event.getFl5();
        this.fp1 = event.getFp1();
        this.fp10 = event.getFp10();
        this.fp2 = event.getFp2();
        this.fp3 = event.getFp3();
        this.fp4 = event.getFp4();
        this.fp5 = event.getFp5();
        this.fp6 = event.getFp6();
        this.fp7 = event.getFp7();
        this.fp8 = event.getFp8();
        this.fp9 = event.getFp9();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gtmxcl = event.getGtmxcl();
        this.gtmxop = event.getGtmxop();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pmss1 = event.getPmss1();
        this.pmss10 = event.getPmss10();
        this.pmss2 = event.getPmss2();
        this.pmss3 = event.getPmss3();
        this.pmss4 = event.getPmss4();
        this.pmss5 = event.getPmss5();
        this.pmss6 = event.getPmss6();
        this.pmss7 = event.getPmss7();
        this.pmss8 = event.getPmss8();
        this.pmss9 = event.getPmss9();
        this.rpg = event.getRpg();
        this.rpp = event.getRpp();
        this.td = event.getTd();
        this.tdv = event.getTdv();
        this.tg = event.getTg();
        this.tp = event.getTp();
        this.tpe = event.getTpe();
        this.tw = event.getTw();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroWEHEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.db = event.getDb();
        this.dicn = event.getDicn();
        this.dpv = event.getDpv();
        this.dturb = event.getDturb();
        this.feedbackSignal = event.getFeedbackSignal();
        this.fl1 = event.getFl1();
        this.fl2 = event.getFl2();
        this.fl3 = event.getFl3();
        this.fl4 = event.getFl4();
        this.fl5 = event.getFl5();
        this.fp1 = event.getFp1();
        this.fp10 = event.getFp10();
        this.fp2 = event.getFp2();
        this.fp3 = event.getFp3();
        this.fp4 = event.getFp4();
        this.fp5 = event.getFp5();
        this.fp6 = event.getFp6();
        this.fp7 = event.getFp7();
        this.fp8 = event.getFp8();
        this.fp9 = event.getFp9();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gtmxcl = event.getGtmxcl();
        this.gtmxop = event.getGtmxop();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pmss1 = event.getPmss1();
        this.pmss10 = event.getPmss10();
        this.pmss2 = event.getPmss2();
        this.pmss3 = event.getPmss3();
        this.pmss4 = event.getPmss4();
        this.pmss5 = event.getPmss5();
        this.pmss6 = event.getPmss6();
        this.pmss7 = event.getPmss7();
        this.pmss8 = event.getPmss8();
        this.pmss9 = event.getPmss9();
        this.rpg = event.getRpg();
        this.rpp = event.getRpp();
        this.td = event.getTd();
        this.tdv = event.getTdv();
        this.tg = event.getTg();
        this.tp = event.getTp();
        this.tpe = event.getTpe();
        this.tw = event.getTw();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroWEHId;
    
    private String db;
    private String dicn;
    private String dpv;
    private String dturb;
    private String feedbackSignal;
    private String fl1;
    private String fl2;
    private String fl3;
    private String fl4;
    private String fl5;
    private String fp1;
    private String fp10;
    private String fp2;
    private String fp3;
    private String fp4;
    private String fp5;
    private String fp6;
    private String fp7;
    private String fp8;
    private String fp9;
    private String gmax;
    private String gmin;
    private String gtmxcl;
    private String gtmxop;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String kd;
    private String ki;
    private String kp;
    private String mwbase;
    private String pmss1;
    private String pmss10;
    private String pmss2;
    private String pmss3;
    private String pmss4;
    private String pmss5;
    private String pmss6;
    private String pmss7;
    private String pmss8;
    private String pmss9;
    private String rpg;
    private String rpp;
    private String td;
    private String tdv;
    private String tg;
    private String tp;
    private String tpe;
    private String tw;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroWEHAggregate.class.getName());
}
