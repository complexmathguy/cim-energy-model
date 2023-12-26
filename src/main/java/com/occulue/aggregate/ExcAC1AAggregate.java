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
 * Aggregate handler for ExcAC1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC1AAggregate(CreateExcAC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC1ACommand" );
    	CreateExcAC1AEvent event = new CreateExcAC1AEvent(command.getExcAC1AId(), command.getHvlvgates(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKf1(), command.getKf2(), command.getKs(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC1ACommand" );
    	UpdateExcAC1AEvent event = new UpdateExcAC1AEvent(command.getExcAC1AId(), command.getHvlvgates(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKf1(), command.getKf2(), command.getKs(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC1ACommand" );
        apply(new DeleteExcAC1AEvent(command.getExcAC1AId()));
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
    void on(CreateExcAC1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC1AEvent" );
    	this.excAC1AId = event.getExcAC1AId();
        this.hvlvgates = event.getHvlvgates();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
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
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.hvlvgates = event.getHvlvgates();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
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
    private UUID excAC1AId;
    
    private String hvlvgates;
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
    private String kf1;
    private String kf2;
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
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC1AAggregate.class.getName());
}
