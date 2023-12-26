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
 * Aggregate handler for ExcAC2A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC2AAggregate(CreateExcAC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC2ACommand" );
    	CreateExcAC2AEvent event = new CreateExcAC2AEvent(command.getExcAC2AId(), command.getHvgate(), command.getKa(), command.getKb(), command.getKb1(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKh(), command.getKl(), command.getKl1(), command.getKs(), command.getLvgate(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVfemax(), command.getVlr(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC2ACommand" );
    	UpdateExcAC2AEvent event = new UpdateExcAC2AEvent(command.getExcAC2AId(), command.getHvgate(), command.getKa(), command.getKb(), command.getKb1(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKh(), command.getKl(), command.getKl1(), command.getKs(), command.getLvgate(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVfemax(), command.getVlr(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC2ACommand" );
        apply(new DeleteExcAC2AEvent(command.getExcAC2AId()));
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
    void on(CreateExcAC2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC2AEvent" );
    	this.excAC2AId = event.getExcAC2AId();
        this.hvgate = event.getHvgate();
        this.ka = event.getKa();
        this.kb = event.getKb();
        this.kb1 = event.getKb1();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kh = event.getKh();
        this.kl = event.getKl();
        this.kl1 = event.getKl1();
        this.ks = event.getKs();
        this.lvgate = event.getLvgate();
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
        this.vfemax = event.getVfemax();
        this.vlr = event.getVlr();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.hvgate = event.getHvgate();
        this.ka = event.getKa();
        this.kb = event.getKb();
        this.kb1 = event.getKb1();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kh = event.getKh();
        this.kl = event.getKl();
        this.kl1 = event.getKl1();
        this.ks = event.getKs();
        this.lvgate = event.getLvgate();
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
        this.vfemax = event.getVfemax();
        this.vlr = event.getVlr();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAC2AId;
    
    private String hvgate;
    private String ka;
    private String kb;
    private String kb1;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
    private String kh;
    private String kl;
    private String kl1;
    private String ks;
    private String lvgate;
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
    private String vfemax;
    private String vlr;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC2AAggregate.class.getName());
}
