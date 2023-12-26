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
 * Aggregate handler for GovHydroWPID as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroWPID are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroWPIDAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroWPIDAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroWPIDAggregate(CreateGovHydroWPIDCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroWPIDCommand" );
    	CreateGovHydroWPIDEvent event = new CreateGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getD(), command.getGatmax(), command.getGatmin(), command.getGv1(), command.getGv2(), command.getGv3(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPmax(), command.getPmin(), command.getReg(), command.getTa(), command.getTb(), command.getTreg(), command.getTw(), command.getVelmax(), command.getVelmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroWPIDCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroWPIDCommand" );
    	UpdateGovHydroWPIDEvent event = new UpdateGovHydroWPIDEvent(command.getGovHydroWPIDId(), command.getD(), command.getGatmax(), command.getGatmin(), command.getGv1(), command.getGv2(), command.getGv3(), command.getKd(), command.getKi(), command.getKp(), command.getMwbase(), command.getPgv1(), command.getPgv2(), command.getPgv3(), command.getPmax(), command.getPmin(), command.getReg(), command.getTa(), command.getTb(), command.getTreg(), command.getTw(), command.getVelmax(), command.getVelmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroWPIDCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroWPIDCommand" );
        apply(new DeleteGovHydroWPIDEvent(command.getGovHydroWPIDId()));
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
    void on(CreateGovHydroWPIDEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroWPIDEvent" );
    	this.govHydroWPIDId = event.getGovHydroWPIDId();
        this.d = event.getD();
        this.gatmax = event.getGatmax();
        this.gatmin = event.getGatmin();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.reg = event.getReg();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.treg = event.getTreg();
        this.tw = event.getTw();
        this.velmax = event.getVelmax();
        this.velmin = event.getVelmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroWPIDEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.d = event.getD();
        this.gatmax = event.getGatmax();
        this.gatmin = event.getGatmin();
        this.gv1 = event.getGv1();
        this.gv2 = event.getGv2();
        this.gv3 = event.getGv3();
        this.kd = event.getKd();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.mwbase = event.getMwbase();
        this.pgv1 = event.getPgv1();
        this.pgv2 = event.getPgv2();
        this.pgv3 = event.getPgv3();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.reg = event.getReg();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.treg = event.getTreg();
        this.tw = event.getTw();
        this.velmax = event.getVelmax();
        this.velmin = event.getVelmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroWPIDId;
    
    private String d;
    private String gatmax;
    private String gatmin;
    private String gv1;
    private String gv2;
    private String gv3;
    private String kd;
    private String ki;
    private String kp;
    private String mwbase;
    private String pgv1;
    private String pgv2;
    private String pgv3;
    private String pmax;
    private String pmin;
    private String reg;
    private String ta;
    private String tb;
    private String treg;
    private String tw;
    private String velmax;
    private String velmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroWPIDAggregate.class.getName());
}
