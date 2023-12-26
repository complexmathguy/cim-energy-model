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
 * Aggregate handler for ExcIEEEDC3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEDC3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEDC3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEDC3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEDC3AAggregate(CreateExcIEEEDC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEDC3ACommand" );
    	CreateExcIEEEDC3AEvent event = new CreateExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKe(), command.getKv(), command.getSeefd1(), command.getSeefd2(), command.getTe(), command.getTrh(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEDC3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEDC3ACommand" );
    	UpdateExcIEEEDC3AEvent event = new UpdateExcIEEEDC3AEvent(command.getExcIEEEDC3AId(), command.getEfd1(), command.getEfd2(), command.getExclim(), command.getKe(), command.getKv(), command.getSeefd1(), command.getSeefd2(), command.getTe(), command.getTrh(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEDC3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEDC3ACommand" );
        apply(new DeleteExcIEEEDC3AEvent(command.getExcIEEEDC3AId()));
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
    void on(CreateExcIEEEDC3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEDC3AEvent" );
    	this.excIEEEDC3AId = event.getExcIEEEDC3AId();
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.exclim = event.getExclim();
        this.ke = event.getKe();
        this.kv = event.getKv();
        this.seefd1 = event.getSeefd1();
        this.seefd2 = event.getSeefd2();
        this.te = event.getTe();
        this.trh = event.getTrh();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEDC3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efd1 = event.getEfd1();
        this.efd2 = event.getEfd2();
        this.exclim = event.getExclim();
        this.ke = event.getKe();
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
    private UUID excIEEEDC3AId;
    
    private String efd1;
    private String efd2;
    private String exclim;
    private String ke;
    private String kv;
    private String seefd1;
    private String seefd2;
    private String te;
    private String trh;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC3AAggregate.class.getName());
}
