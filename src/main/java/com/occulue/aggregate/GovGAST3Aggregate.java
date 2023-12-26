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
 * Aggregate handler for GovGAST3 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGAST3 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGAST3Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGAST3Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGAST3Aggregate(CreateGovGAST3Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGAST3Command" );
    	CreateGovGAST3Event event = new CreateGovGAST3Event(command.getGovGAST3Id(), command.getBca(), command.getBp(), command.getDtc(), command.getKa(), command.getKac(), command.getKca(), command.getKsi(), command.getKy(), command.getMnef(), command.getMxef(), command.getRcmn(), command.getRcmx(), command.getTac(), command.getTc(), command.getTd(), command.getTfen(), command.getTg(), command.getTsi(), command.getTt(), command.getTtc(), command.getTy());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGAST3Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGAST3Command" );
    	UpdateGovGAST3Event event = new UpdateGovGAST3Event(command.getGovGAST3Id(), command.getBca(), command.getBp(), command.getDtc(), command.getKa(), command.getKac(), command.getKca(), command.getKsi(), command.getKy(), command.getMnef(), command.getMxef(), command.getRcmn(), command.getRcmx(), command.getTac(), command.getTc(), command.getTd(), command.getTfen(), command.getTg(), command.getTsi(), command.getTt(), command.getTtc(), command.getTy());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGAST3Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGAST3Command" );
        apply(new DeleteGovGAST3Event(command.getGovGAST3Id()));
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
    void on(CreateGovGAST3Event event) {	
    	LOGGER.info( "Event sourcing CreateGovGAST3Event" );
    	this.govGAST3Id = event.getGovGAST3Id();
        this.bca = event.getBca();
        this.bp = event.getBp();
        this.dtc = event.getDtc();
        this.ka = event.getKa();
        this.kac = event.getKac();
        this.kca = event.getKca();
        this.ksi = event.getKsi();
        this.ky = event.getKy();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.rcmn = event.getRcmn();
        this.rcmx = event.getRcmx();
        this.tac = event.getTac();
        this.tc = event.getTc();
        this.td = event.getTd();
        this.tfen = event.getTfen();
        this.tg = event.getTg();
        this.tsi = event.getTsi();
        this.tt = event.getTt();
        this.ttc = event.getTtc();
        this.ty = event.getTy();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGAST3Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.bca = event.getBca();
        this.bp = event.getBp();
        this.dtc = event.getDtc();
        this.ka = event.getKa();
        this.kac = event.getKac();
        this.kca = event.getKca();
        this.ksi = event.getKsi();
        this.ky = event.getKy();
        this.mnef = event.getMnef();
        this.mxef = event.getMxef();
        this.rcmn = event.getRcmn();
        this.rcmx = event.getRcmx();
        this.tac = event.getTac();
        this.tc = event.getTc();
        this.td = event.getTd();
        this.tfen = event.getTfen();
        this.tg = event.getTg();
        this.tsi = event.getTsi();
        this.tt = event.getTt();
        this.ttc = event.getTtc();
        this.ty = event.getTy();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govGAST3Id;
    
    private String bca;
    private String bp;
    private String dtc;
    private String ka;
    private String kac;
    private String kca;
    private String ksi;
    private String ky;
    private String mnef;
    private String mxef;
    private String rcmn;
    private String rcmx;
    private String tac;
    private String tc;
    private String td;
    private String tfen;
    private String tg;
    private String tsi;
    private String tt;
    private String ttc;
    private String ty;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST3Aggregate.class.getName());
}
