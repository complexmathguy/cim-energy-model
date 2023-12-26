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
 * Aggregate handler for ExcAVR7 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR7 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR7Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR7Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR7Aggregate(CreateExcAVR7Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR7Command" );
    	CreateExcAVR7Event event = new CreateExcAVR7Event(command.getExcAVR7Id(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getK1(), command.getK3(), command.getK5(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVmax1(), command.getVmax3(), command.getVmax5(), command.getVmin1(), command.getVmin3(), command.getVmin5());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR7Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR7Command" );
    	UpdateExcAVR7Event event = new UpdateExcAVR7Event(command.getExcAVR7Id(), command.getA1(), command.getA2(), command.getA3(), command.getA4(), command.getA5(), command.getA6(), command.getK1(), command.getK3(), command.getK5(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getVmax1(), command.getVmax3(), command.getVmax5(), command.getVmin1(), command.getVmin3(), command.getVmin5());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR7Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR7Command" );
        apply(new DeleteExcAVR7Event(command.getExcAVR7Id()));
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
    void on(CreateExcAVR7Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR7Event" );
    	this.excAVR7Id = event.getExcAVR7Id();
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.k1 = event.getK1();
        this.k3 = event.getK3();
        this.k5 = event.getK5();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.vmax1 = event.getVmax1();
        this.vmax3 = event.getVmax3();
        this.vmax5 = event.getVmax5();
        this.vmin1 = event.getVmin1();
        this.vmin3 = event.getVmin3();
        this.vmin5 = event.getVmin5();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR7Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a1 = event.getA1();
        this.a2 = event.getA2();
        this.a3 = event.getA3();
        this.a4 = event.getA4();
        this.a5 = event.getA5();
        this.a6 = event.getA6();
        this.k1 = event.getK1();
        this.k3 = event.getK3();
        this.k5 = event.getK5();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.vmax1 = event.getVmax1();
        this.vmax3 = event.getVmax3();
        this.vmax5 = event.getVmax5();
        this.vmin1 = event.getVmin1();
        this.vmin3 = event.getVmin3();
        this.vmin5 = event.getVmin5();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAVR7Id;
    
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String k1;
    private String k3;
    private String k5;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String vmax1;
    private String vmax3;
    private String vmax5;
    private String vmin1;
    private String vmin3;
    private String vmin5;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR7Aggregate.class.getName());
}
