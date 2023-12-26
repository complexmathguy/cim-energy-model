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
 * Aggregate handler for GovHydro4 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydro4 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydro4Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydro4Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydro4Aggregate(CreateGovHydro4Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydro4Command" );
    	CreateGovHydro4Event event = new CreateGovHydro4Event(command.getGovHydro4Id(), command.getAt(), command.getBgv0(), command.getBgv1(), command.getBgv2(), command.getBgv3(), command.getBgv4(), command.getBgv5(), command.getBmax(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGmax(), command.getGmin(), command.getGv0(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getHdam(), command.getMwbase(), command.getPgv0(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getQn1(), command.getRperm(), command.getRtemp(), command.getTblade(), command.getTg(), command.getTp(), command.getTr(), command.getTw(), command.getUc(), command.getUo());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydro4Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydro4Command" );
    	UpdateGovHydro4Event event = new UpdateGovHydro4Event(command.getGovHydro4Id(), command.getAt(), command.getBgv0(), command.getBgv1(), command.getBgv2(), command.getBgv3(), command.getBgv4(), command.getBgv5(), command.getBmax(), command.getDb1(), command.getDb2(), command.getDturb(), command.getEps(), command.getGmax(), command.getGmin(), command.getGv0(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getHdam(), command.getMwbase(), command.getPgv0(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getQn1(), command.getRperm(), command.getRtemp(), command.getTblade(), command.getTg(), command.getTp(), command.getTr(), command.getTw(), command.getUc(), command.getUo());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydro4Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydro4Command" );
        apply(new DeleteGovHydro4Event(command.getGovHydro4Id()));
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
    void on(CreateGovHydro4Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydro4Event" );
    	this.govHydro4Id = event.getGovHydro4Id();
        this.at = event.getAt();
        this.bgv0 = event.getBgv0();
        this.bgv1 = event.getBgv1();
        this.bgv2 = event.getBgv2();
        this.bgv3 = event.getBgv3();
        this.bgv4 = event.getBgv4();
        this.bgv5 = event.getBgv5();
        this.bmax = event.getBmax();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gv0 = event.getGv0();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.hdam = event.getHdam();
        this.mwbase = event.getMwbase();
        this.pgv0 = event.getPgv0();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.qn1 = event.getQn1();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tblade = event.getTblade();
        this.tg = event.getTg();
        this.tp = event.getTp();
        this.tr = event.getTr();
        this.tw = event.getTw();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydro4Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.at = event.getAt();
        this.bgv0 = event.getBgv0();
        this.bgv1 = event.getBgv1();
        this.bgv2 = event.getBgv2();
        this.bgv3 = event.getBgv3();
        this.bgv4 = event.getBgv4();
        this.bgv5 = event.getBgv5();
        this.bmax = event.getBmax();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.dturb = event.getDturb();
        this.eps = event.getEps();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.gv0 = event.getGv0();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.hdam = event.getHdam();
        this.mwbase = event.getMwbase();
        this.pgv0 = event.getPgv0();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.qn1 = event.getQn1();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tblade = event.getTblade();
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
    private UUID govHydro4Id;
    
    private String at;
    private String bgv0;
    private String bgv1;
    private String bgv2;
    private String bgv3;
    private String bgv4;
    private String bgv5;
    private String bmax;
    private String db1;
    private String db2;
    private String dturb;
    private String eps;
    private String gmax;
    private String gmin;
    private String gv0;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String hdam;
    private String mwbase;
    private String pgv0;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String qn1;
    private String rperm;
    private String rtemp;
    private String tblade;
    private String tg;
    private String tp;
    private String tr;
    private String tw;
    private String uc;
    private String uo;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro4Aggregate.class.getName());
}
