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
 * Aggregate handler for ExcIEEEAC1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC1AAggregate(CreateExcIEEEAC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC1ACommand" );
    	CreateExcIEEEAC1AEvent event = new CreateExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC1ACommand" );
    	UpdateExcIEEEAC1AEvent event = new UpdateExcIEEEAC1AEvent(command.getExcIEEEAC1AId(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVamax(), command.getVamin(), command.getVe1(), command.getVe2(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC1ACommand" );
        apply(new DeleteExcIEEEAC1AEvent(command.getExcIEEEAC1AId()));
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
    void on(CreateExcIEEEAC1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC1AEvent" );
    	this.excIEEEAC1AId = event.getExcIEEEAC1AId();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
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
    void on(UpdateExcIEEEAC1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
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
    private UUID excIEEEAC1AId;
    
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
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

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC1AAggregate.class.getName());
}
