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
 * Aggregate handler for ExcIEEEAC3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC3AAggregate(CreateExcIEEEAC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC3ACommand" );
    	CreateExcIEEEAC3AEvent event = new CreateExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getEfdn(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKn(), command.getKr(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC3ACommand" );
    	UpdateExcIEEEAC3AEvent event = new UpdateExcIEEEAC3AEvent(command.getExcIEEEAC3AId(), command.getEfdn(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getKn(), command.getKr(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC3ACommand" );
        apply(new DeleteExcIEEEAC3AEvent(command.getExcIEEEAC3AId()));
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
    void on(CreateExcIEEEAC3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC3AEvent" );
    	this.excIEEEAC3AId = event.getExcIEEEAC3AId();
        this.efdn = event.getEfdn();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kn = event.getKn();
        this.kr = event.getKr();
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
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEAC3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdn = event.getEfdn();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.kn = event.getKn();
        this.kr = event.getKr();
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
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excIEEEAC3AId;
    
    private String efdn;
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
    private String kn;
    private String kr;
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

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC3AAggregate.class.getName());
}
