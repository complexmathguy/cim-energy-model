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
 * Aggregate handler for ExcAVR4 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR4 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR4Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR4Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR4Aggregate(CreateExcAVR4Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR4Command" );
    	CreateExcAVR4Event event = new CreateExcAVR4Event(command.getExcAVR4Id(), command.getImul(), command.getKa(), command.getKe(), command.getKif(), command.getT1(), command.getT1if(), command.getT2(), command.getT3(), command.getT4(), command.getTif(), command.getVfmn(), command.getVfmx(), command.getVrmn(), command.getVrmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR4Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR4Command" );
    	UpdateExcAVR4Event event = new UpdateExcAVR4Event(command.getExcAVR4Id(), command.getImul(), command.getKa(), command.getKe(), command.getKif(), command.getT1(), command.getT1if(), command.getT2(), command.getT3(), command.getT4(), command.getTif(), command.getVfmn(), command.getVfmx(), command.getVrmn(), command.getVrmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR4Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR4Command" );
        apply(new DeleteExcAVR4Event(command.getExcAVR4Id()));
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
    void on(CreateExcAVR4Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR4Event" );
    	this.excAVR4Id = event.getExcAVR4Id();
        this.imul = event.getImul();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kif = event.getKif();
        this.t1 = event.getT1();
        this.t1if = event.getT1if();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.tif = event.getTif();
        this.vfmn = event.getVfmn();
        this.vfmx = event.getVfmx();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR4Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.imul = event.getImul();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kif = event.getKif();
        this.t1 = event.getT1();
        this.t1if = event.getT1if();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.tif = event.getTif();
        this.vfmn = event.getVfmn();
        this.vfmx = event.getVfmx();
        this.vrmn = event.getVrmn();
        this.vrmx = event.getVrmx();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAVR4Id;
    
    private String imul;
    private String ka;
    private String ke;
    private String kif;
    private String t1;
    private String t1if;
    private String t2;
    private String t3;
    private String t4;
    private String tif;
    private String vfmn;
    private String vfmx;
    private String vrmn;
    private String vrmx;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR4Aggregate.class.getName());
}
