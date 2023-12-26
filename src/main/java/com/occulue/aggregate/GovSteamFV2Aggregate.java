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
 * Aggregate handler for GovSteamFV2 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamFV2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamFV2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamFV2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamFV2Aggregate(CreateGovSteamFV2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamFV2Command" );
    	CreateGovSteamFV2Event event = new CreateGovSteamFV2Event(command.getGovSteamFV2Id(), command.getDt(), command.getK(), command.getMwbase(), command.getR(), command.getT1(), command.getT3(), command.getTa(), command.getTb(), command.getTc(), command.getTi(), command.getTt(), command.getVmax(), command.getVmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamFV2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamFV2Command" );
    	UpdateGovSteamFV2Event event = new UpdateGovSteamFV2Event(command.getGovSteamFV2Id(), command.getDt(), command.getK(), command.getMwbase(), command.getR(), command.getT1(), command.getT3(), command.getTa(), command.getTb(), command.getTc(), command.getTi(), command.getTt(), command.getVmax(), command.getVmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamFV2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamFV2Command" );
        apply(new DeleteGovSteamFV2Event(command.getGovSteamFV2Id()));
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
    void on(CreateGovSteamFV2Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamFV2Event" );
    	this.govSteamFV2Id = event.getGovSteamFV2Id();
        this.dt = event.getDt();
        this.k = event.getK();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t3 = event.getT3();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.ti = event.getTi();
        this.tt = event.getTt();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamFV2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dt = event.getDt();
        this.k = event.getK();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t3 = event.getT3();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.ti = event.getTi();
        this.tt = event.getTt();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamFV2Id;
    
    private String dt;
    private String k;
    private String mwbase;
    private String r;
    private String t1;
    private String t3;
    private String ta;
    private String tb;
    private String tc;
    private String ti;
    private String tt;
    private String vmax;
    private String vmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV2Aggregate.class.getName());
}
