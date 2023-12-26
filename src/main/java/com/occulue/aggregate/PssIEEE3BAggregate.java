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
 * Aggregate handler for PssIEEE3B as outlined for the CQRS pattern, all write responsibilities 
 * related to PssIEEE3B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssIEEE3BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssIEEE3BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssIEEE3BAggregate(CreatePssIEEE3BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssIEEE3BCommand" );
    	CreatePssIEEE3BEvent event = new CreatePssIEEE3BEvent(command.getPssIEEE3BId(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getA7(), command.getA8(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getKs1(), command.getKs2(), command.getT1(), command.getT2(), command.getTw1(), command.getTw2(), command.getTw3(), command.getVstmax(), command.getVstmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssIEEE3BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssIEEE3BCommand" );
    	UpdatePssIEEE3BEvent event = new UpdatePssIEEE3BEvent(command.getPssIEEE3BId(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getA7(), command.getA8(), command.getInputSignal1Type(), command.getInputSignal2Type(), command.getKs1(), command.getKs2(), command.getT1(), command.getT2(), command.getTw1(), command.getTw2(), command.getTw3(), command.getVstmax(), command.getVstmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssIEEE3BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssIEEE3BCommand" );
        apply(new DeletePssIEEE3BEvent(command.getPssIEEE3BId()));
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
    void on(CreatePssIEEE3BEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssIEEE3BEvent" );
    	this.pssIEEE3BId = event.getPssIEEE3BId();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.a7 = event.getA7();
        this.a8 = event.getA8();
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
        this.tw3 = event.getTw3();
        this.vstmax = event.getVstmax();
        this.vstmin = event.getVstmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssIEEE3BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.a7 = event.getA7();
        this.a8 = event.getA8();
        this.inputSignal1Type = event.getInputSignal1Type();
        this.inputSignal2Type = event.getInputSignal2Type();
        this.ks1 = event.getKs1();
        this.ks2 = event.getKs2();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
        this.tw3 = event.getTw3();
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
    private UUID pssIEEE3BId;
    
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String inputSignal1Type;
    private String inputSignal2Type;
    private String ks1;
    private String ks2;
    private String t1;
    private String t2;
    private String tw1;
    private String tw2;
    private String tw3;
    private String vstmax;
    private String vstmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE3BAggregate.class.getName());
}
