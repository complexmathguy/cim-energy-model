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
 * Aggregate handler for Pss2B as outlined for the CQRS pattern, all write responsibilities 
 * related to Pss2B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Pss2BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Pss2BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Pss2BAggregate(CreatePss2BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePss2BCommand" );
    	CreatePss2BEvent event = new CreatePss2BEvent(command.getPss2BId(), command.getA(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getKs1(), command.getKs2(), command.getKs3(), command.getKs4(), command.getM(), command.getN(), command.getT1(), command.getT10(), command.getT11(), command.getT2(), command.getT3(), command.getT4(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getTa(), command.getTb(), command.getTw1(), command.getTw2(), command.getTw3(), command.getTw4(), command.getVsi1max(), command.getVsi1min(), command.getVsi2max(), command.getVsi2min(), command.getVstmax(), command.getVstmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePss2BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePss2BCommand" );
    	UpdatePss2BEvent event = new UpdatePss2BEvent(command.getPss2BId(), command.getA(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getKs1(), command.getKs2(), command.getKs3(), command.getKs4(), command.getM(), command.getN(), command.getT1(), command.getT10(), command.getT11(), command.getT2(), command.getT3(), command.getT4(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getTa(), command.getTb(), command.getTw1(), command.getTw2(), command.getTw3(), command.getTw4(), command.getVsi1max(), command.getVsi1min(), command.getVsi2max(), command.getVsi2min(), command.getVstmax(), command.getVstmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePss2BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePss2BCommand" );
        apply(new DeletePss2BEvent(command.getPss2BId()));
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
    void on(CreatePss2BEvent event) {	
    	LOGGER.info( "Event sourcing CreatePss2BEvent" );
    	this.pss2BId = event.getPss2BId();
        this.a = event.getA();
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.ks3 = event.getKs3();
        this.ks4 = event.getKs4();
        this.m = event.getM();
        this.n = event.getN();
        this.t1 = event.getT1();
        this.t10 = event.getT10();
        this.t11 = event.getT11();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
        this.tw3 = event.getTw3();
        this.tw4 = event.getTw4();
        this.vsi1max = event.getVsi1max();
        this.vsi1min = event.getVsi1min();
        this.vsi2max = event.getVsi2max();
        this.vsi2min = event.getVsi2min();
        this.vstmax = event.getVstmax();
        this.vstmin = event.getVstmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePss2BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a = event.getA();
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.ks3 = event.getKs3();
        this.ks4 = event.getKs4();
        this.m = event.getM();
        this.n = event.getN();
        this.t1 = event.getT1();
        this.t10 = event.getT10();
        this.t11 = event.getT11();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
        this.tw3 = event.getTw3();
        this.tw4 = event.getTw4();
        this.vsi1max = event.getVsi1max();
        this.vsi1min = event.getVsi1min();
        this.vsi2max = event.getVsi2max();
        this.vsi2min = event.getVsi2min();
        this.vstmax = event.getVstmax();
        this.vstmin = event.getVstmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pss2BId;
    
    private String a;
    private String inputSignal1Type;
    private String inputSignal2Type;
    private String ks1;
    private String ks2;
    private String ks3;
    private String ks4;
    private String m;
    private String n;
    private String t1;
    private String t10;
    private String t11;
    private String t2;
    private String t3;
    private String t4;
    private String t6;
    private String t7;
    private String t8;
    private String t9;
    private String ta;
    private String tb;
    private String tw1;
    private String tw2;
    private String tw3;
    private String tw4;
    private String vsi1max;
    private String vsi1min;
    private String vsi2max;
    private String vsi2min;
    private String vstmax;
    private String vstmin;

    private static final Logger LOGGER 	= Logger.getLogger(Pss2BAggregate.class.getName());
}
