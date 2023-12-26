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
 * Aggregate handler for ExcIEEEDC2A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEDC2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEDC2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEDC2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEDC2AAggregate(CreateExcIEEEDC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEDC2ACommand" );
    	CreateExcIEEEDC2AEvent event = new CreateExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEDC2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEDC2ACommand" );
    	UpdateExcIEEEDC2AEvent event = new UpdateExcIEEEDC2AEvent(command.getExcIEEEDC2AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEDC2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEDC2ACommand" );
        apply(new DeleteExcIEEEDC2AEvent(command.getExcIEEEDC2AId()));
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
    void on(CreateExcIEEEDC2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEDC2AEvent" );
    	this.excIEEEDC2AId = event.getExcIEEEDC2AId();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEDC2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.exclim = event.getExclim();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
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
    private UUID excIEEEDC2AId;
    
    private String efd1;
    private String efd2;
    private String exclim;
    private String ka;
    private String ke;
    private String kf;
    private String seefd1;
    private String seefd2;
    private String ta;
    private String tb;
    private String tc;
    private String te;
    private String tf;
    private String uelin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC2AAggregate.class.getName());
}
