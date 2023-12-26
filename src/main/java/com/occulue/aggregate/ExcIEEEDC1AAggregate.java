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
 * Aggregate handler for ExcIEEEDC1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEDC1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEDC1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEDC1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEDC1AAggregate(CreateExcIEEEDC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEDC1ACommand" );
    	CreateExcIEEEDC1AEvent event = new CreateExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEDC1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEDC1ACommand" );
    	UpdateExcIEEEDC1AEvent event = new UpdateExcIEEEDC1AEvent(command.getExcIEEEDC1AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKa(), command.getKe(), command.getKf(), command.getSeefd1(), command.getSeefd2(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEDC1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEDC1ACommand" );
        apply(new DeleteExcIEEEDC1AEvent(command.getExcIEEEDC1AId()));
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
    void on(CreateExcIEEEDC1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEDC1AEvent" );
    	this.excIEEEDC1AId = event.getExcIEEEDC1AId();
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
    void on(UpdateExcIEEEDC1AEvent event) {
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
    private UUID excIEEEDC1AId;
    
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

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC1AAggregate.class.getName());
}
