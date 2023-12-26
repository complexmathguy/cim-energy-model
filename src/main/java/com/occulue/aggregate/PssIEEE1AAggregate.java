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
 * Aggregate handler for PssIEEE1A as outlined for the CQRS pattern, all write responsibilities 
 * related to PssIEEE1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssIEEE1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssIEEE1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssIEEE1AAggregate(CreatePssIEEE1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssIEEE1ACommand" );
    	CreatePssIEEE1AEvent event = new CreatePssIEEE1AEvent(command.getPssIEEE1AId(), command.getA1(), command.getA2(), command.getInputSignalType(), command.getKs(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssIEEE1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssIEEE1ACommand" );
    	UpdatePssIEEE1AEvent event = new UpdatePssIEEE1AEvent(command.getPssIEEE1AId(), command.getA1(), command.getA2(), command.getInputSignalType(), command.getKs(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssIEEE1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssIEEE1ACommand" );
        apply(new DeletePssIEEE1AEvent(command.getPssIEEE1AId()));
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
    void on(CreatePssIEEE1AEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssIEEE1AEvent" );
    	this.pssIEEE1AId = event.getPssIEEE1AId();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.inputSignalType = event.getInputSignalType();
        this.ks = event.getKs();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssIEEE1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.inputSignalType = event.getInputSignalType();
        this.ks = event.getKs();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
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
    private UUID pssIEEE1AId;
    
    private String a1;
    private String a2;
    private String inputSignalType;
    private String ks;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE1AAggregate.class.getName());
}
