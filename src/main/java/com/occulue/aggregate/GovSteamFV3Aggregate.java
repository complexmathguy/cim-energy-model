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
 * Aggregate handler for GovSteamFV3 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamFV3 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamFV3Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamFV3Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamFV3Aggregate(CreateGovSteamFV3Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamFV3Command" );
    	CreateGovSteamFV3Event event = new CreateGovSteamFV3Event(command.getGovSteamFV3Id(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getPrmax(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTa(), command.getTb(), command.getTc(), command.getUc(), command.getUo());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamFV3Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamFV3Command" );
    	UpdateGovSteamFV3Event event = new UpdateGovSteamFV3Event(command.getGovSteamFV3Id(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getPrmax(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getTa(), command.getTb(), command.getTc(), command.getUc(), command.getUo());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamFV3Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamFV3Command" );
        apply(new DeleteGovSteamFV3Event(command.getGovSteamFV3Id()));
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
    void on(CreateGovSteamFV3Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamFV3Event" );
    	this.govSteamFV3Id = event.getGovSteamFV3Id();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.prmax = event.getPrmax();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamFV3Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.prmax = event.getPrmax();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamFV3Id;
    
    private String k;
    private String k1;
    private String k2;
    private String k3;
    private String mwbase;
    private String pmax;
    private String pmin;
    private String prmax;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String ta;
    private String tb;
    private String tc;
    private String uc;
    private String uo;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV3Aggregate.class.getName());
}
