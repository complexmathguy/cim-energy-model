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
 * Aggregate handler for GovHydroIEEE2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroIEEE2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroIEEE2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroIEEE2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroIEEE2Aggregate(CreateGovHydroIEEE2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroIEEE2Command" );
    	CreateGovHydroIEEE2Event event = new CreateGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAturb(), command.getBturb(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getKturb(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getRperm(), command.getRtemp(), command.getTg(), command.getTp(), command.getTr(), command.getTw(), command.getUc(), command.getUo());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroIEEE2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroIEEE2Command" );
    	UpdateGovHydroIEEE2Event event = new UpdateGovHydroIEEE2Event(command.getGovHydroIEEE2Id(), command.getAturb(), command.getBturb(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getKturb(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getRperm(), command.getRtemp(), command.getTg(), command.getTp(), command.getTr(), command.getTw(), command.getUc(), command.getUo());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroIEEE2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroIEEE2Command" );
        apply(new DeleteGovHydroIEEE2Event(command.getGovHydroIEEE2Id()));
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
    void on(CreateGovHydroIEEE2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroIEEE2Event" );
    	this.govHydroIEEE2Id = event.getGovHydroIEEE2Id();
        this.aturb = event.getAturb();
        this.bturb = event.getBturb();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.kturb = event.getKturb();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tg = event.getTg();
        this.tp = event.getTp();
        this.tr = event.getTr();
        this.tw = event.getTw();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroIEEE2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.aturb = event.getAturb();
        this.bturb = event.getBturb();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.kturb = event.getKturb();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tg = event.getTg();
        this.tp = event.getTp();
        this.tr = event.getTr();
        this.tw = event.getTw();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroIEEE2Id;
    
    private String aturb;
    private String bturb;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String kturb;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String pgv6;
    private String pmax;
    private String pmin;
    private String rperm;
    private String rtemp;
    private String tg;
    private String tp;
    private String tr;
    private String tw;
    private String uc;
    private String uo;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE2Aggregate.class.getName());
}
