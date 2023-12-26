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
 * Aggregate handler for PssPTIST1 as outlined for the CQRS pattern, all write responsibilities 
 * related to PssPTIST1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssPTIST1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssPTIST1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssPTIST1Aggregate(CreatePssPTIST1Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePssPTIST1Command" );
    	CreatePssPTIST1Event event = new CreatePssPTIST1Event(command.getPssPTIST1Id(), command.getDtc(), command.getDtf(), command.getDtp(), command.getK(), command.getM(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTf(), command.getTp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssPTIST1Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePssPTIST1Command" );
    	UpdatePssPTIST1Event event = new UpdatePssPTIST1Event(command.getPssPTIST1Id(), command.getDtc(), command.getDtf(), command.getDtp(), command.getK(), command.getM(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTf(), command.getTp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssPTIST1Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePssPTIST1Command" );
        apply(new DeletePssPTIST1Event(command.getPssPTIST1Id()));
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
    void on(CreatePssPTIST1Event event) {	
    	LOGGER.info( "Event sourcing CreatePssPTIST1Event" );
    	this.pssPTIST1Id = event.getPssPTIST1Id();
        this.dtc = event.getDtc();
        this.dtf = event.getDtf();
        this.dtp = event.getDtp();
        this.k = event.getK();
        this.m = event.getM();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.tf = event.getTf();
        this.tp = event.getTp();
    }
    
    @EventSourcingHandler
    void on(UpdatePssPTIST1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dtc = event.getDtc();
        this.dtf = event.getDtf();
        this.dtp = event.getDtp();
        this.k = event.getK();
        this.m = event.getM();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.tf = event.getTf();
        this.tp = event.getTp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssPTIST1Id;
    
    private String dtc;
    private String dtf;
    private String dtp;
    private String k;
    private String m;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String tf;
    private String tp;

    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST1Aggregate.class.getName());
}
