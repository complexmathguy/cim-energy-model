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
 * Aggregate handler for PssWECC as outlined for the CQRS pattern, all write responsibilities 
 * related to PssWECC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssWECCAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssWECCAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssWECCAggregate(CreatePssWECCCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssWECCCommand" );
    	CreatePssWECCEvent event = new CreatePssWECCEvent(command.getPssWECCId(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getK1(), command.getK2(), command.getT1(), command.getT10(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getVcl(), command.getVcu(), command.getVsmax(), command.getVsmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssWECCCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssWECCCommand" );
    	UpdatePssWECCEvent event = new UpdatePssWECCEvent(command.getPssWECCId(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getK1(), command.getK2(), command.getT1(), command.getT10(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getVcl(), command.getVcu(), command.getVsmax(), command.getVsmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssWECCCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssWECCCommand" );
        apply(new DeletePssWECCEvent(command.getPssWECCId()));
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
    void on(CreatePssWECCEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssWECCEvent" );
    	this.pssWECCId = event.getPssWECCId();
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.t1 = event.getT1();
        this.t10 = event.getT10();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.vcl = event.getVcl();
        this.vcu = event.getVcu();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssWECCEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.t1 = event.getT1();
        this.t10 = event.getT10();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.vcl = event.getVcl();
        this.vcu = event.getVcu();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssWECCId;
    
    private String inputSignal1Type;
    private String inputSignal2Type;
    private String k1;
    private String k2;
    private String t1;
    private String t10;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String t7;
    private String t8;
    private String t9;
    private String vcl;
    private String vcu;
    private String vsmax;
    private String vsmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssWECCAggregate.class.getName());
}
