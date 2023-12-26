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
 * Aggregate handler for ExcIEEEAC5A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC5A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC5AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC5AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC5AAggregate(CreateExcIEEEAC5ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC5ACommand" );
    	CreateExcIEEEAC5AEvent event = new CreateExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTe(), command.getTf1(), command.getTf2(), command.getTf3(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC5ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC5ACommand" );
    	UpdateExcIEEEAC5AEvent event = new UpdateExcIEEEAC5AEvent(command.getExcIEEEAC5AId(), command.getEfd1(), command.getEfd2(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTe(), command.getTf1(), command.getTf2(), command.getTf3(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC5ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC5ACommand" );
        apply(new DeleteExcIEEEAC5AEvent(command.getExcIEEEAC5AId()));
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
    void on(CreateExcIEEEAC5AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC5AEvent" );
    	this.excIEEEAC5AId = event.getExcIEEEAC5AId();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.te = event.getTe();
        this.tf1 = event.getTf1();
        this.tf2 = event.getTf2();
        this.tf3 = event.getTf3();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEAC5AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
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
    private UUID excIEEEAC5AId;
    
    private String efd1;
    private String efd2;
    private String ka;
    private String ke;
    private String kf;
    private String seefd1;
    private String seefd2;
    private String ta;
    private String te;
    private String tf1;
    private String tf2;
    private String tf3;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC5AAggregate.class.getName());
}
