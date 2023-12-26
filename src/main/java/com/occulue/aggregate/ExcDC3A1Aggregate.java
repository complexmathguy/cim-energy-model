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
 * Aggregate handler for ExcDC3A1 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcDC3A1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcDC3A1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcDC3A1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcDC3A1Aggregate(CreateExcDC3A1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcDC3A1Command" );
    	CreateExcDC3A1Event event = new CreateExcDC3A1Event(command.getExcDC3A1Id(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTe(), command.getTf(), command.getVb1max(), command.getVblim(), command.getVbmax(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcDC3A1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcDC3A1Command" );
    	UpdateExcDC3A1Event event = new UpdateExcDC3A1Event(command.getExcDC3A1Id(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTe(), command.getTf(), command.getVb1max(), command.getVblim(), command.getVbmax(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcDC3A1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcDC3A1Command" );
        apply(new DeleteExcDC3A1Event(command.getExcDC3A1Id()));
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
    void on(CreateExcDC3A1Event event) {	
    	LOGGER.info( "Event sourcing CreateExcDC3A1Event" );
    	this.excDC3A1Id = event.getExcDC3A1Id();
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vb1max = event.getVb1max();
        this.vblim = event.getVblim();
        this.vbmax = event.getVbmax();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcDC3A1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vb1max = event.getVb1max();
        this.vblim = event.getVblim();
        this.vbmax = event.getVbmax();
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
    private UUID excDC3A1Id;
    
    private String exclim;
    private String ka;
    private String ke;
    private String kf;
    private String ki;
    private String kp;
    private String ta;
    private String te;
    private String tf;
    private String vb1max;
    private String vblim;
    private String vbmax;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC3A1Aggregate.class.getName());
}
