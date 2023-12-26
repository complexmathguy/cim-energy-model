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
 * Aggregate handler for ExcDC1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcDC1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcDC1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcDC1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcDC1AAggregate(CreateExcDC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcDC1ACommand" );
    	CreateExcDC1AEvent event = new CreateExcDC1AEvent(command.getExcDC1AId(), command.getEdfmax(), command.getEfd1(), command.getEfd2(), command.getEfdmin(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcDC1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcDC1ACommand" );
    	UpdateExcDC1AEvent event = new UpdateExcDC1AEvent(command.getExcDC1AId(), command.getEdfmax(), command.getEfd1(), command.getEfd2(), command.getEfdmin(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcDC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcDC1ACommand" );
        apply(new DeleteExcDC1AEvent(command.getExcDC1AId()));
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
    void on(CreateExcDC1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcDC1AEvent" );
    	this.excDC1AId = event.getExcDC1AId();
        this.edfmax = event.getEdfmax();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efdmin = event.getEfdmin();
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ks = event.getKs();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcDC1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.edfmax = event.getEdfmax();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efdmin = event.getEfdmin();
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ks = event.getKs();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
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
    private UUID excDC1AId;
    
    private String edfmax;
    private String efd1;
    private String efd2;
    private String efdmin;
    private String exclim;
    private String ka;
    private String ke;
    private String kf;
    private String ks;
    private String seefd1;
    private String seefd2;
    private String ta;
    private String tb;
    private String tc;
    private String te;
    private String tf;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC1AAggregate.class.getName());
}
