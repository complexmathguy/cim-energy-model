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
 * Aggregate handler for Pss1A as outlined for the CQRS pattern, all write responsibilities 
 * related to Pss1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Pss1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Pss1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Pss1AAggregate(CreatePss1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePss1ACommand" );
    	CreatePss1AEvent event = new CreatePss1AEvent(command.getPss1AId(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getA7(), command.getA8(), command.getInputSignalType(), command.getKd(), command.getKs(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTdelay(), command.getVcl(), command.getVcu(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePss1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePss1ACommand" );
    	UpdatePss1AEvent event = new UpdatePss1AEvent(command.getPss1AId(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getA7(), command.getA8(), command.getInputSignalType(), command.getKd(), command.getKs(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTdelay(), command.getVcl(), command.getVcu(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePss1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePss1ACommand" );
        apply(new DeletePss1AEvent(command.getPss1AId()));
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
    void on(CreatePss1AEvent event) {	
    	LOGGER.info( "Event sourcing CreatePss1AEvent" );
    	this.pss1AId = event.getPss1AId();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.a7 = event.getA7();
        this.a8 = event.getA8();
        this.inputSignalType = event.getInputSignalType();
        this.kd = event.getKd();
        this.ks = event.getKs();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.tdelay = event.getTdelay();
        this.vcl = event.getVcl();
        this.vcu = event.getVcu();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePss1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.a7 = event.getA7();
        this.a8 = event.getA8();
        this.inputSignalType = event.getInputSignalType();
        this.kd = event.getKd();
        this.ks = event.getKs();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.tdelay = event.getTdelay();
        this.vcl = event.getVcl();
        this.vcu = event.getVcu();
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
    private UUID pss1AId;
    
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String inputSignalType;
    private String kd;
    private String ks;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String tdelay;
    private String vcl;
    private String vcu;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(Pss1AAggregate.class.getName());
}
