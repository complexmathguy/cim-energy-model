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
 * Aggregate handler for ExcSK as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcSK are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcSKAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcSKAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcSKAggregate(CreateExcSKCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcSKCommand" );
    	CreateExcSKEvent event = new CreateExcSKEvent(command.getExcSKId(), command.getEfdmax(), command.getEfdmin(), command.getEmax(), command.getEmin(), command.getK(), command.getK1(), command.getK2(), command.getKc(), command.getKce(), command.getKd(), command.getKgob(), command.getKp(), command.getKqi(), command.getKqob(), command.getKqp(), command.getNq(), command.getQconoff(), command.getQz(), command.getRemote(), command.getSbase(), command.getTc(), command.getTe(), command.getTi(), command.getTp(), command.getTr(), command.getUimax(), command.getUimin(), command.getUrmax(), command.getUrmin(), command.getVtmax(), command.getVtmin(), command.getYp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcSKCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcSKCommand" );
    	UpdateExcSKEvent event = new UpdateExcSKEvent(command.getExcSKId(), command.getEfdmax(), command.getEfdmin(), command.getEmax(), command.getEmin(), command.getK(), command.getK1(), command.getK2(), command.getKc(), command.getKce(), command.getKd(), command.getKgob(), command.getKp(), command.getKqi(), command.getKqob(), command.getKqp(), command.getNq(), command.getQconoff(), command.getQz(), command.getRemote(), command.getSbase(), command.getTc(), command.getTe(), command.getTi(), command.getTp(), command.getTr(), command.getUimax(), command.getUimin(), command.getUrmax(), command.getUrmin(), command.getVtmax(), command.getVtmin(), command.getYp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcSKCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcSKCommand" );
        apply(new DeleteExcSKEvent(command.getExcSKId()));
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
    void on(CreateExcSKEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcSKEvent" );
    	this.excSKId = event.getExcSKId();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.kc = event.getKc();
        this.kce = event.getKce();
        this.kd = event.getKd();
        this.kgob = event.getKgob();
        this.kp = event.getKp();
        this.kqi = event.getKqi();
        this.kqob = event.getKqob();
        this.kqp = event.getKqp();
        this.nq = event.getNq();
        this.qconoff = event.getQconoff();
        this.qz = event.getQz();
        this.remote = event.getRemote();
        this.sbase = event.getSbase();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.ti = event.getTi();
        this.tp = event.getTp();
        this.tr = event.getTr();
        this.uimax = event.getUimax();
        this.uimin = event.getUimin();
        this.urmax = event.getUrmax();
        this.urmin = event.getUrmin();
        this.vtmax = event.getVtmax();
        this.vtmin = event.getVtmin();
        this.yp = event.getYp();
    }
    
    @EventSourcingHandler
    void on(UpdateExcSKEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.kc = event.getKc();
        this.kce = event.getKce();
        this.kd = event.getKd();
        this.kgob = event.getKgob();
        this.kp = event.getKp();
        this.kqi = event.getKqi();
        this.kqob = event.getKqob();
        this.kqp = event.getKqp();
        this.nq = event.getNq();
        this.qconoff = event.getQconoff();
        this.qz = event.getQz();
        this.remote = event.getRemote();
        this.sbase = event.getSbase();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.ti = event.getTi();
        this.tp = event.getTp();
        this.tr = event.getTr();
        this.uimax = event.getUimax();
        this.uimin = event.getUimin();
        this.urmax = event.getUrmax();
        this.urmin = event.getUrmin();
        this.vtmax = event.getVtmax();
        this.vtmin = event.getVtmin();
        this.yp = event.getYp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excSKId;
    
    private String efdmax;
    private String efdmin;
    private String emax;
    private String emin;
    private String k;
    private String k1;
    private String k2;
    private String kc;
    private String kce;
    private String kd;
    private String kgob;
    private String kp;
    private String kqi;
    private String kqob;
    private String kqp;
    private String nq;
    private String qconoff;
    private String qz;
    private String remote;
    private String sbase;
    private String tc;
    private String te;
    private String ti;
    private String tp;
    private String tr;
    private String uimax;
    private String uimin;
    private String urmax;
    private String urmin;
    private String vtmax;
    private String vtmin;
    private String yp;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSKAggregate.class.getName());
}
