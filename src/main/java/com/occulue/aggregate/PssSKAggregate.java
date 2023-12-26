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
 * Aggregate handler for PssSK as outlined for the CQRS pattern, all write responsibilities 
 * related to PssSK are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssSKAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssSKAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssSKAggregate(CreatePssSKCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePssSKCommand" );
    	CreatePssSKEvent event = new CreatePssSKEvent(command.getPssSKId(), command.getK1(), command.getK2(), command.getK3(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVsmax(), command.getVsmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssSKCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePssSKCommand" );
    	UpdatePssSKEvent event = new UpdatePssSKEvent(command.getPssSKId(), command.getK1(), command.getK2(), command.getK3(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVsmax(), command.getVsmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssSKCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePssSKCommand" );
        apply(new DeletePssSKEvent(command.getPssSKId()));
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
    void on(CreatePssSKEvent event) {	
    	LOGGER.info( "Event sourcing CreatePssSKEvent" );
    	this.pssSKId = event.getPssSKId();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssSKEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
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
    private UUID pssSKId;
    
    private String k1;
    private String k2;
    private String k3;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String vsmax;
    private String vsmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssSKAggregate.class.getName());
}
