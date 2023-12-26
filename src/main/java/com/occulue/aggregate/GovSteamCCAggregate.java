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
 * Aggregate handler for GovSteamCC as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteamCC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteamCCAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteamCCAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteamCCAggregate(CreateGovSteamCCCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteamCCCommand" );
    	CreateGovSteamCCEvent event = new CreateGovSteamCCEvent(command.getGovSteamCCId(), command.getDhp(), command.getDlp(), command.getFhp(), command.getFlp(), command.getMwbase(), command.getPmaxhp(), command.getPmaxlp(), command.getRhp(), command.getRlp(), command.getT1hp(), command.getT1lp(), command.getT3hp(), command.getT3lp(), command.getT4hp(), command.getT4lp(), command.getT5hp(), command.getT5lp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteamCCCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteamCCCommand" );
    	UpdateGovSteamCCEvent event = new UpdateGovSteamCCEvent(command.getGovSteamCCId(), command.getDhp(), command.getDlp(), command.getFhp(), command.getFlp(), command.getMwbase(), command.getPmaxhp(), command.getPmaxlp(), command.getRhp(), command.getRlp(), command.getT1hp(), command.getT1lp(), command.getT3hp(), command.getT3lp(), command.getT4hp(), command.getT4lp(), command.getT5hp(), command.getT5lp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteamCCCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteamCCCommand" );
        apply(new DeleteGovSteamCCEvent(command.getGovSteamCCId()));
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
    void on(CreateGovSteamCCEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovSteamCCEvent" );
    	this.govSteamCCId = event.getGovSteamCCId();
        this.dhp = event.getDhp();
        this.dlp = event.getDlp();
        this.fhp = event.getFhp();
        this.flp = event.getFlp();
        this.mwbase = event.getMwbase();
        this.pmaxhp = event.getPmaxhp();
        this.pmaxlp = event.getPmaxlp();
        this.rhp = event.getRhp();
        this.rlp = event.getRlp();
        this.t1hp = event.getT1hp();
        this.t1lp = event.getT1lp();
        this.t3hp = event.getT3hp();
        this.t3lp = event.getT3lp();
        this.t4hp = event.getT4hp();
        this.t4lp = event.getT4lp();
        this.t5hp = event.getT5hp();
        this.t5lp = event.getT5lp();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteamCCEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dhp = event.getDhp();
        this.dlp = event.getDlp();
        this.fhp = event.getFhp();
        this.flp = event.getFlp();
        this.mwbase = event.getMwbase();
        this.pmaxhp = event.getPmaxhp();
        this.pmaxlp = event.getPmaxlp();
        this.rhp = event.getRhp();
        this.rlp = event.getRlp();
        this.t1hp = event.getT1hp();
        this.t1lp = event.getT1lp();
        this.t3hp = event.getT3hp();
        this.t3lp = event.getT3lp();
        this.t4hp = event.getT4hp();
        this.t4lp = event.getT4lp();
        this.t5hp = event.getT5hp();
        this.t5lp = event.getT5lp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govSteamCCId;
    
    private String dhp;
    private String dlp;
    private String fhp;
    private String flp;
    private String mwbase;
    private String pmaxhp;
    private String pmaxlp;
    private String rhp;
    private String rlp;
    private String t1hp;
    private String t1lp;
    private String t3hp;
    private String t3lp;
    private String t4hp;
    private String t4lp;
    private String t5hp;
    private String t5lp;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamCCAggregate.class.getName());
}
