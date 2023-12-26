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
 * Aggregate handler for GovSteamIEEE1 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamIEEE1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamIEEE1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamIEEE1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamIEEE1Aggregate(CreateGovSteamIEEE1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamIEEE1Command" );
    	CreateGovSteamIEEE1Event event = new CreateGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getK7(), command.getK8(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getUc(), command.getUo());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamIEEE1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamIEEE1Command" );
    	UpdateGovSteamIEEE1Event event = new UpdateGovSteamIEEE1Event(command.getGovSteamIEEE1Id(), command.getK(), command.getK1(), command.getK2(), command.getK3(), command.getK4(), command.getK5(), command.getK6(), command.getK7(), command.getK8(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6(), command.getT7(), command.getUc(), command.getUo());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamIEEE1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamIEEE1Command" );
        apply(new DeleteGovSteamIEEE1Event(command.getGovSteamIEEE1Id()));
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
    void on(CreateGovSteamIEEE1Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamIEEE1Event" );
    	this.govSteamIEEE1Id = event.getGovSteamIEEE1Id();
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.k7 = event.getK7();
        this.k8 = event.getK8();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.uc = event.getUc();
        this.uo = event.getUo();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamIEEE1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k = event.getK();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.k4 = event.getK4();
        this.k5 = event.getK5();
        this.k6 = event.getK6();
        this.k7 = event.getK7();
        this.k8 = event.getK8();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
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
    private UUID govSteamIEEE1Id;
    
    private String k;
    private String k1;
    private String k2;
    private String k3;
    private String k4;
    private String k5;
    private String k6;
    private String k7;
    private String k8;
    private String mwbase;
    private String pmax;
    private String pmin;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;
    private String t7;
    private String uc;
    private String uo;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamIEEE1Aggregate.class.getName());
}
