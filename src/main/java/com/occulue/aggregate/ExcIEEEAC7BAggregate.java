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
 * Aggregate handler for ExcIEEEAC7B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC7B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC7BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC7BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC7BAggregate(CreateExcIEEEAC7BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC7BCommand" );
    	CreateExcIEEEAC7BEvent event = new CreateExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKf1(), command.getKf2(), command.getKf3(), command.getKia(), command.getKir(), command.getKl(), command.getKp(), command.getKpa(), command.getKpr(), command.getSeve1(), command.getSeve2(), command.getTdr(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC7BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC7BCommand" );
    	UpdateExcIEEEAC7BEvent event = new UpdateExcIEEEAC7BEvent(command.getExcIEEEAC7BId(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKf1(), command.getKf2(), command.getKf3(), command.getKia(), command.getKir(), command.getKl(), command.getKp(), command.getKpa(), command.getKpr(), command.getSeve1(), command.getSeve2(), command.getTdr(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC7BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC7BCommand" );
        apply(new DeleteExcIEEEAC7BEvent(command.getExcIEEEAC7BId()));
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
    void on(CreateExcIEEEAC7BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC7BEvent" );
    	this.excIEEEAC7BId = event.getExcIEEEAC7BId();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
        this.kf3 = event.getKf3();
        this.kia = event.getKia();
        this.kir = event.getKir();
        this.kl = event.getKl();
        this.kp = event.getKp();
        this.kpa = event.getKpa();
        this.kpr = event.getKpr();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.tdr = event.getTdr();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEAC7BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kf1 = event.getKf1();
        this.kf2 = event.getKf2();
        this.kf3 = event.getKf3();
        this.kia = event.getKia();
        this.kir = event.getKir();
        this.kl = event.getKl();
        this.kp = event.getKp();
        this.kpa = event.getKpa();
        this.kpr = event.getKpr();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.tdr = event.getTdr();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
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
    private UUID excIEEEAC7BId;
    
    private String kc;
    private String kd;
    private String kdr;
    private String ke;
    private String kf1;
    private String kf2;
    private String kf3;
    private String kia;
    private String kir;
    private String kl;
    private String kp;
    private String kpa;
    private String kpr;
    private String seve1;
    private String seve2;
    private String tdr;
    private String te;
    private String tf;
    private String vamax;
    private String vamin;
    private String ve1;
    private String ve2;
    private String vemin;
    private String vfemax;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC7BAggregate.class.getName());
}
