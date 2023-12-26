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
 * Aggregate handler for PssSH as outlined for the CQRS pattern, all write responsibilities 
 * related to PssSH are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssSHAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssSHAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssSHAggregate(CreatePssSHCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssSHCommand" );
    	CreatePssSHEvent event = new CreatePssSHEvent(command.getPssSHId(), command.getK(), command.getK0(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTd(), command.getVsmax(), command.getVsmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssSHCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssSHCommand" );
    	UpdatePssSHEvent event = new UpdatePssSHEvent(command.getPssSHId(), command.getK(), command.getK0(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getTd(), command.getVsmax(), command.getVsmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssSHCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssSHCommand" );
        apply(new DeletePssSHEvent(command.getPssSHId()));
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
    void on(CreatePssSHEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssSHEvent" );
    	this.pssSHId = event.getPssSHId();
        this.k = event.getK();
        this.k0 = event.getK0();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.td = event.getTd();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssSHEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k = event.getK();
        this.k0 = event.getK0();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.td = event.getTd();
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
    private UUID pssSHId;
    
    private String k;
    private String k0;
    private String k1;
    private String k2;
    private String k3;
    private String k4;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String td;
    private String vsmax;
    private String vsmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssSHAggregate.class.getName());
}
