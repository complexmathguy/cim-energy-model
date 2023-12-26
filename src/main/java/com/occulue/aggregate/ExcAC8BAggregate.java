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
 * Aggregate handler for ExcAC8B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC8B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC8BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC8BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC8BAggregate(CreateExcAC8BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC8BCommand" );
    	CreateExcAC8BEvent event = new CreateExcAC8BEvent(command.getExcAC8BId(), command.getInlim(), command.getKa(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKir(), command.getKpr(), command.getKs(), command.getPidlim(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTdr(), command.getTe(), command.getTelim(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVimax(), command.getVimin(), command.getVpidmax(), command.getVpidmin(), command.getVrmax(), command.getVrmin(), command.getVtmult());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC8BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC8BCommand" );
    	UpdateExcAC8BEvent event = new UpdateExcAC8BEvent(command.getExcAC8BId(), command.getInlim(), command.getKa(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKir(), command.getKpr(), command.getKs(), command.getPidlim(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTdr(), command.getTe(), command.getTelim(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVimax(), command.getVimin(), command.getVpidmax(), command.getVpidmin(), command.getVrmax(), command.getVrmin(), command.getVtmult());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC8BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC8BCommand" );
        apply(new DeleteExcAC8BEvent(command.getExcAC8BId()));
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
    void on(CreateExcAC8BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC8BEvent" );
    	this.excAC8BId = event.getExcAC8BId();
        this.inlim = event.getInlim();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kir = event.getKir();
        this.kpr = event.getKpr();
        this.ks = event.getKs();
        this.pidlim = event.getPidlim();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tdr = event.getTdr();
        this.te = event.getTe();
        this.telim = event.getTelim();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vpidmax = event.getVpidmax();
        this.vpidmin = event.getVpidmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.vtmult = event.getVtmult();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC8BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.inlim = event.getInlim();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kir = event.getKir();
        this.kpr = event.getKpr();
        this.ks = event.getKs();
        this.pidlim = event.getPidlim();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tdr = event.getTdr();
        this.te = event.getTe();
        this.telim = event.getTelim();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vpidmax = event.getVpidmax();
        this.vpidmin = event.getVpidmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.vtmult = event.getVtmult();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAC8BId;
    
    private String inlim;
    private String ka;
    private String kc;
    private String kd;
    private String kdr;
    private String ke;
    private String kir;
    private String kpr;
    private String ks;
    private String pidlim;
    private String seve1;
    private String seve2;
    private String ta;
    private String tdr;
    private String te;
    private String telim;
    private String ve1;
    private String ve2;
    private String vemin;
    private String vfemax;
    private String vimax;
    private String vimin;
    private String vpidmax;
    private String vpidmin;
    private String vrmax;
    private String vrmin;
    private String vtmult;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC8BAggregate.class.getName());
}
