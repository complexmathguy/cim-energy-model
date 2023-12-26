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
 * Aggregate handler for ExcAC3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC3AAggregate(CreateExcAC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC3ACommand" );
    	CreateExcAC3AEvent event = new CreateExcAC3AEvent(command.getExcAC3AId(), command.getEfdn(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKf1(), command.getKf2(), command.getKlv(), command.getKn(), command.getKr(), command.getKs(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVlv());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC3ACommand" );
    	UpdateExcAC3AEvent event = new UpdateExcAC3AEvent(command.getExcAC3AId(), command.getEfdn(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKf1(), command.getKf2(), command.getKlv(), command.getKn(), command.getKr(), command.getKs(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVlv());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC3ACommand" );
        apply(new DeleteExcAC3AEvent(command.getExcAC3AId()));
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
    void on(CreateExcAC3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC3AEvent" );
    	this.excAC3AId = event.getExcAC3AId();
        this.efdn = event.getEfdn();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
        this.klv = event.getKlv();
        this.kn = event.getKn();
        this.kr = event.getKr();
        this.ks = event.getKs();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vlv = event.getVlv();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdn = event.getEfdn();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
        this.klv = event.getKlv();
        this.kn = event.getKn();
        this.kr = event.getKr();
        this.ks = event.getKs();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vlv = event.getVlv();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAC3AId;
    
    private String efdn;
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
    private String kf1;
    private String kf2;
    private String klv;
    private String kn;
    private String kr;
    private String ks;
    private String seve1;
    private String seve2;
    private String ta;
    private String tb;
    private String tc;
    private String te;
    private String tf;
    private String vamax;
    private String vamin;
    private String ve1;
    private String ve2;
    private String vemin;
    private String vfemax;
    private String vlv;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC3AAggregate.class.getName());
}
