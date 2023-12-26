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
 * Aggregate handler for ExcAC5A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC5A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC5AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC5AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC5AAggregate(CreateExcAC5ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC5ACommand" );
    	CreateExcAC5AEvent event = new CreateExcAC5AEvent(command.getExcAC5AId(), command.getA(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf1(), command.getTf2(), command.getTf3(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC5ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC5ACommand" );
    	UpdateExcAC5AEvent event = new UpdateExcAC5AEvent(command.getExcAC5AId(), command.getA(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKe(), command.getKf(), command.getKs(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf1(), command.getTf2(), command.getTf3(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC5ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC5ACommand" );
        apply(new DeleteExcAC5AEvent(command.getExcAC5AId()));
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
    void on(CreateExcAC5AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC5AEvent" );
    	this.excAC5AId = event.getExcAC5AId();
        this.a = event.getA();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
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
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.tf3 = event.getTf3();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC5AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a = event.getA();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
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
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.tf3 = event.getTf3();
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
    private UUID excAC5AId;
    
    private String a;
    private String efd1;
    private String efd2;
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
    private String tf1;
    private String tf2;
    private String tf3;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC5AAggregate.class.getName());
}
