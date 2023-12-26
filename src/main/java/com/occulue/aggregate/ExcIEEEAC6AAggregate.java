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
 * Aggregate handler for ExcIEEEAC6A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC6A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC6AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC6AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC6AAggregate(CreateExcIEEEAC6ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC6ACommand" );
    	CreateExcIEEEAC6AEvent event = new CreateExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKh(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTh(), command.getTj(), command.getTk(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVfelim(), command.getVhmax(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC6ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC6ACommand" );
    	UpdateExcIEEEAC6AEvent event = new UpdateExcIEEEAC6AEvent(command.getExcIEEEAC6AId(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKh(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTh(), command.getTj(), command.getTk(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVfelim(), command.getVhmax(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC6ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC6ACommand" );
        apply(new DeleteExcIEEEAC6AEvent(command.getExcIEEEAC6AId()));
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
    void on(CreateExcIEEEAC6AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC6AEvent" );
    	this.excIEEEAC6AId = event.getExcIEEEAC6AId();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kh = event.getKh();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.th = event.getTh();
        this.tj = event.getTj();
        this.tk = event.getTk();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vfelim = event.getVfelim();
        this.vhmax = event.getVhmax();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEAC6AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kh = event.getKh();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.th = event.getTh();
        this.tj = event.getTj();
        this.tk = event.getTk();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vfelim = event.getVfelim();
        this.vhmax = event.getVhmax();
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
    private UUID excIEEEAC6AId;
    
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kh;
    private String seve1;
    private String seve2;
    private String ta;
    private String tb;
    private String tc;
    private String te;
    private String th;
    private String tj;
    private String tk;
    private String vamax;
    private String vamin;
    private String ve1;
    private String ve2;
    private String vfelim;
    private String vhmax;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC6AAggregate.class.getName());
}
