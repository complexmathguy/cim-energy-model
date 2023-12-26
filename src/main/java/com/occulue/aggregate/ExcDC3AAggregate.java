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
 * Aggregate handler for ExcDC3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcDC3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcDC3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcDC3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcDC3AAggregate(CreateExcDC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcDC3ACommand" );
    	CreateExcDC3AEvent event = new CreateExcDC3AEvent(command.getExcDC3AId(), command.getEdfmax(), command.getEfd1(), command.getEfd2(), command.getEfdlim(), command.getEfdmin(), command.getExclim(), command.getKe(), command.getKr(), command.getKs(), command.getKv(), command.getSeefd1(), command.getSeefd2(), command.getTe(), command.getTrh(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcDC3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcDC3ACommand" );
    	UpdateExcDC3AEvent event = new UpdateExcDC3AEvent(command.getExcDC3AId(), command.getEdfmax(), command.getEfd1(), command.getEfd2(), command.getEfdlim(), command.getEfdmin(), command.getExclim(), command.getKe(), command.getKr(), command.getKs(), command.getKv(), command.getSeefd1(), command.getSeefd2(), command.getTe(), command.getTrh(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcDC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcDC3ACommand" );
        apply(new DeleteExcDC3AEvent(command.getExcDC3AId()));
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
    void on(CreateExcDC3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcDC3AEvent" );
    	this.excDC3AId = event.getExcDC3AId();
        this.edfmax = event.getEdfmax();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efdlim = event.getEfdlim();
        this.efdmin = event.getEfdmin();
        this.exclim = event.getExclim();
        this.ke = event.getKe();
        this.kr = event.getKr();
        this.ks = event.getKs();
        this.kv = event.getKv();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.te = event.getTe();
        this.trh = event.getTrh();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcDC3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.edfmax = event.getEdfmax();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.efdlim = event.getEfdlim();
        this.efdmin = event.getEfdmin();
        this.exclim = event.getExclim();
        this.ke = event.getKe();
        this.kr = event.getKr();
        this.ks = event.getKs();
        this.kv = event.getKv();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.te = event.getTe();
        this.trh = event.getTrh();
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
    private UUID excDC3AId;
    
    private String edfmax;
    private String efd1;
    private String efd2;
    private String efdlim;
    private String efdmin;
    private String exclim;
    private String ke;
    private String kr;
    private String ks;
    private String kv;
    private String seefd1;
    private String seefd2;
    private String te;
    private String trh;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC3AAggregate.class.getName());
}
