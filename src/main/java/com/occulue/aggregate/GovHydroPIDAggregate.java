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
 * Aggregate handler for GovHydroPID as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroPID are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroPIDAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroPIDAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroPIDAggregate(CreateGovHydroPIDCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroPIDCommand" );
    	CreateGovHydroPIDEvent event = new CreateGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAturb(), command.getBturb(), command.getDb1(), command.getDb2(), command.getEps(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getInputSignal(), command.getKd(), command.getKg(), command.getKi(), command.getKp(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getR(), command.getTd(), command.getTf(), command.getTp(), command.getTt(), command.getTturb(), command.getVelcl(), command.getVelop());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroPIDCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroPIDCommand" );
    	UpdateGovHydroPIDEvent event = new UpdateGovHydroPIDEvent(command.getGovHydroPIDId(), command.getAturb(), command.getBturb(), command.getDb1(), command.getDb2(), command.getEps(), command.getGv1(), command.getGv2(), command.getGv3(), command.getGv4(), command.getGv5(), command.getGv6(), command.getInputSignal(), command.getKd(), command.getKg(), command.getKi(), command.getKp(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPgv4(), command.getPgv5(), command.getPgv6(), command.getPmax(), command.getPmin(), command.getR(), command.getTd(), command.getTf(), command.getTp(), command.getTt(), command.getTturb(), command.getVelcl(), command.getVelop());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroPIDCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroPIDCommand" );
        apply(new DeleteGovHydroPIDEvent(command.getGovHydroPIDId()));
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
    void on(CreateGovHydroPIDEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroPIDEvent" );
    	this.govHydroPIDId = event.getGovHydroPIDId();
        this.aturb = event.getAturb();
        this.bturb = event.getBturb();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.inputSignal = event.getInputSignal();
        this.kd = event.getKd();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.r = event.getR();
        this.td = event.getTd();
        this.tf = event.getTf();
        this.tp = event.getTp();
        this.tt = event.getTt();
        this.tturb = event.getTturb();
        this.velcl = event.getVelcl();
        this.velop = event.getVelop();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroPIDEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.aturb = event.getAturb();
        this.bturb = event.getBturb();
        this.db1 = event.getDb1();
        this.db2 = event.getDb2();
        this.eps = event.getEps();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.gv4 = event.getGv4();
        this.gv5 = event.getGv5();
        this.gv6 = event.getGv6();
        this.inputSignal = event.getInputSignal();
        this.kd = event.getKd();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pgv4 = event.getPgv4();
        this.pgv5 = event.getPgv5();
        this.pgv6 = event.getPgv6();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.r = event.getR();
        this.td = event.getTd();
        this.tf = event.getTf();
        this.tp = event.getTp();
        this.tt = event.getTt();
        this.tturb = event.getTturb();
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
    private UUID govHydroPIDId;
    
    private String aturb;
    private String bturb;
    private String db1;
    private String db2;
    private String eps;
    private String gv1;
    private String gv2;
    private String gv3;
    private String gv4;
    private String gv5;
    private String gv6;
    private String inputSignal;
    private String kd;
    private String kg;
    private String ki;
    private String kp;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pgv4;
    private String pgv5;
    private String pgv6;
    private String pmax;
    private String pmin;
    private String r;
    private String td;
    private String tf;
    private String tp;
    private String tt;
    private String tturb;
    private String velcl;
    private String velop;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPIDAggregate.class.getName());
}
