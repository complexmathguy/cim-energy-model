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
 * Aggregate handler for ExcIEEEAC8B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC8B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC8BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC8BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC8BAggregate(CreateExcIEEEAC8BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC8BCommand" );
    	CreateExcIEEEAC8BEvent event = new CreateExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getKa(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKir(), command.getKpr(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTdr(), command.getTe(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC8BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC8BCommand" );
    	UpdateExcIEEEAC8BEvent event = new UpdateExcIEEEAC8BEvent(command.getExcIEEEAC8BId(), command.getKa(), command.getKc(), command.getKd(), command.getKdr(), command.getKe(), command.getKir(), command.getKpr(), command.getSeve1(), command.getSeve2(), command.getTa(), command.getTdr(), command.getTe(), command.getVe1(), command.getVe2(), command.getVemin(), command.getVfemax(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC8BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC8BCommand" );
        apply(new DeleteExcIEEEAC8BEvent(command.getExcIEEEAC8BId()));
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
    void on(CreateExcIEEEAC8BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC8BEvent" );
    	this.excIEEEAC8BId = event.getExcIEEEAC8BId();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kir = event.getKir();
        this.kpr = event.getKpr();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tdr = event.getTdr();
        this.te = event.getTe();
        this.ve1 = event.getVe1();
        this.ve2 = event.getVe2();
        this.vemin = event.getVemin();
        this.vfemax = event.getVfemax();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEAC8BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.kdr = event.getKdr();
        this.ke = event.getKe();
        this.kir = event.getKir();
        this.kpr = event.getKpr();
        this.seve1 = event.getSeve1();
        this.seve2 = event.getSeve2();
        this.ta = event.getTa();
        this.tdr = event.getTdr();
        this.te = event.getTe();
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
    private UUID excIEEEAC8BId;
    
    private String ka;
    private String kc;
    private String kd;
    private String kdr;
    private String ke;
    private String kir;
    private String kpr;
    private String seve1;
    private String seve2;
    private String ta;
    private String tdr;
    private String te;
    private String ve1;
    private String ve2;
    private String vemin;
    private String vfemax;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC8BAggregate.class.getName());
}
