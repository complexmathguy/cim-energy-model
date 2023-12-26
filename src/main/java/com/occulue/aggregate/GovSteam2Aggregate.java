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
 * Aggregate handler for GovSteam2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteam2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteam2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteam2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteam2Aggregate(CreateGovSteam2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteam2Command" );
    	CreateGovSteam2Event event = new CreateGovSteam2Event(command.getGovSteam2Id(), command.getDbf(), command.getK(), command.getMnef(), command.getMxef(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteam2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteam2Command" );
    	UpdateGovSteam2Event event = new UpdateGovSteam2Event(command.getGovSteam2Id(), command.getDbf(), command.getK(), command.getMnef(), command.getMxef(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteam2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteam2Command" );
        apply(new DeleteGovSteam2Event(command.getGovSteam2Id()));
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
    void on(CreateGovSteam2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteam2Event" );
    	this.govSteam2Id = event.getGovSteam2Id();
        this.dbf = event.getDbf();
        this.k = event.getK();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteam2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dbf = event.getDbf();
        this.k = event.getK();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteam2Id;
    
    private String dbf;
    private String k;
    private String mnef;
    private String mxef;
    private String pmax;
    private String pmin;
    private String t1;
    private String t2;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam2Aggregate.class.getName());
}
