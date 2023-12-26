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
 * Aggregate handler for GovSteamSGO as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamSGO are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamSGOAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamSGOAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamSGOAggregate(CreateGovSteamSGOCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamSGOCommand" );
    	CreateGovSteamSGOEvent event = new CreateGovSteamSGOEvent(command.getGovSteamSGOId(), command.getK1(), command.getK2(), command.getK3(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamSGOCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamSGOCommand" );
    	UpdateGovSteamSGOEvent event = new UpdateGovSteamSGOEvent(command.getGovSteamSGOId(), command.getK1(), command.getK2(), command.getK3(), command.getMwbase(), command.getPmax(), command.getPmin(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getT5(), command.getT6());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamSGOCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamSGOCommand" );
        apply(new DeleteGovSteamSGOEvent(command.getGovSteamSGOId()));
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
    void on(CreateGovSteamSGOEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamSGOEvent" );
    	this.govSteamSGOId = event.getGovSteamSGOId();
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamSGOEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k1 = event.getK1();
        this.k2 = event.getK2();
        this.k3 = event.getK3();
        this.mwbase = event.getMwbase();
        this.pmax = event.getPmax();
        this.pmin = event.getPmin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamSGOId;
    
    private String k1;
    private String k2;
    private String k3;
    private String mwbase;
    private String pmax;
    private String pmin;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String t5;
    private String t6;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamSGOAggregate.class.getName());
}
