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
 * Aggregate handler for GovGAST4 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGAST4 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGAST4Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGAST4Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGAST4Aggregate(CreateGovGAST4Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGAST4Command" );
    	CreateGovGAST4Event event = new CreateGovGAST4Event(command.getGovGAST4Id(), command.getBp(), command.getKtm(), command.getMnef(), command.getMxef(), command.getRymn(), command.getRymx(), command.getTa(), command.getTc(), command.getTcm(), command.getTm(), command.getTv());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGAST4Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGAST4Command" );
    	UpdateGovGAST4Event event = new UpdateGovGAST4Event(command.getGovGAST4Id(), command.getBp(), command.getKtm(), command.getMnef(), command.getMxef(), command.getRymn(), command.getRymx(), command.getTa(), command.getTc(), command.getTcm(), command.getTm(), command.getTv());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGAST4Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGAST4Command" );
        apply(new DeleteGovGAST4Event(command.getGovGAST4Id()));
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
    void on(CreateGovGAST4Event event) {	
    	LOGGER.info( "Event sourcing CreateGovGAST4Event" );
    	this.govGAST4Id = event.getGovGAST4Id();
        this.bp = event.getBp();
        this.ktm = event.getKtm();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.rymn = event.getRymn();
        this.rymx = event.getRymx();
        this.ta = event.getTa();
        this.tc = event.getTc();
        this.tcm = event.getTcm();
        this.tm = event.getTm();
        this.tv = event.getTv();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGAST4Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.bp = event.getBp();
        this.ktm = event.getKtm();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.rymn = event.getRymn();
        this.rymx = event.getRymx();
        this.ta = event.getTa();
        this.tc = event.getTc();
        this.tcm = event.getTcm();
        this.tm = event.getTm();
        this.tv = event.getTv();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govGAST4Id;
    
    private String bp;
    private String ktm;
    private String mnef;
    private String mxef;
    private String rymn;
    private String rymx;
    private String ta;
    private String tc;
    private String tcm;
    private String tm;
    private String tv;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST4Aggregate.class.getName());
}
