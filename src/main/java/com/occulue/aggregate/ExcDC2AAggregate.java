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
 * Aggregate handler for ExcDC2A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcDC2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcDC2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcDC2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcDC2AAggregate(CreateExcDC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcDC2ACommand" );
    	CreateExcDC2AEvent event = new CreateExcDC2AEvent(command.getExcDC2AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getTf1(), command.getVrmax(), command.getVrmin(), command.getVtlim());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcDC2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcDC2ACommand" );
    	UpdateExcDC2AEvent event = new UpdateExcDC2AEvent(command.getExcDC2AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getTf1(), command.getVrmax(), command.getVrmin(), command.getVtlim());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcDC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcDC2ACommand" );
        apply(new DeleteExcDC2AEvent(command.getExcDC2AId()));
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
    void on(CreateExcDC2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcDC2AEvent" );
    	this.excDC2AId = event.getExcDC2AId();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
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
        this.tf1 = event.getTf1();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.vtlim = event.getVtlim();
    }
    
    @EventSourcingHandler
    void on(UpdateExcDC2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
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
        this.tf1 = event.getTf1();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.vtlim = event.getVtlim();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excDC2AId;
    
    private String efd1;
    private String efd2;
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
    private String tf1;
    private String vrmax;
    private String vrmin;
    private String vtlim;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC2AAggregate.class.getName());
}
