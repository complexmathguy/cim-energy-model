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
 * Aggregate handler for GovHydroIEEE0 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydroIEEE0 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydroIEEE0Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydroIEEE0Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydroIEEE0Aggregate(CreateGovHydroIEEE0Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydroIEEE0Command" );
    	CreateGovHydroIEEE0Event event = new CreateGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getK(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydroIEEE0Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydroIEEE0Command" );
    	UpdateGovHydroIEEE0Event event = new UpdateGovHydroIEEE0Event(command.getGovHydroIEEE0Id(), command.getK(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydroIEEE0Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydroIEEE0Command" );
        apply(new DeleteGovHydroIEEE0Event(command.getGovHydroIEEE0Id()));
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
    void on(CreateGovHydroIEEE0Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydroIEEE0Event" );
    	this.govHydroIEEE0Id = event.getGovHydroIEEE0Id();
        this.k = event.getK();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydroIEEE0Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k = event.getK();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydroIEEE0Id;
    
    private String k;
    private String mwbase;
    private String pmax;
    private String pmin;
    private String t1;
    private String t2;
    private String t3;
    private String t4;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE0Aggregate.class.getName());
}
