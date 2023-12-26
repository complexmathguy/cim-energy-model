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
 * Aggregate handler for ExcOEX3T as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcOEX3T are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcOEX3TAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcOEX3TAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcOEX3TAggregate(CreateExcOEX3TCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcOEX3TCommand" );
    	CreateExcOEX3TEvent event = new CreateExcOEX3TEvent(command.getExcOEX3TId(), command.getE1(), command.getE2(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getSee1(), command.getSee2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTe(), command.getTf(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcOEX3TCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcOEX3TCommand" );
    	UpdateExcOEX3TEvent event = new UpdateExcOEX3TEvent(command.getExcOEX3TId(), command.getE1(), command.getE2(), command.getKa(), command.getKc(), command.getKd(), command.getKe(), command.getKf(), command.getSee1(), command.getSee2(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTe(), command.getTf(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcOEX3TCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcOEX3TCommand" );
        apply(new DeleteExcOEX3TEvent(command.getExcOEX3TId()));
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
    void on(CreateExcOEX3TEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcOEX3TEvent" );
    	this.excOEX3TId = event.getExcOEX3TId();
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.see1 = event.getSee1();
        this.see2 = event.getSee2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcOEX3TEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.e1 = event.getE1();
        this.e2 = event.getE2();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kd = event.getKd();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.see1 = event.getSee1();
        this.see2 = event.getSee2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.te = event.getTe();
        this.tf = event.getTf();
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
    private UUID excOEX3TId;
    
    private String e1;
    private String e2;
    private String ka;
    private String kc;
    private String kd;
    private String ke;
    private String kf;
    private String see1;
    private String see2;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String te;
    private String tf;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcOEX3TAggregate.class.getName());
}
