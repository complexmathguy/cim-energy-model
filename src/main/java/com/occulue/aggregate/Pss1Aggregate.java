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
 * Aggregate handler for Pss1 as outlined for the CQRS pattern, all write responsibilities 
 * related to Pss1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Pss1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Pss1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Pss1Aggregate(CreatePss1Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePss1Command" );
    	CreatePss1Event event = new CreatePss1Event(command.getPss1Id(), command.getKf(), command.getKpe(), command.getKs(), command.getKw(), command.getPmin(), command.getT10(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getTpe(), command.getVadat(), command.getVsmn(), command.getVsmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePss1Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePss1Command" );
    	UpdatePss1Event event = new UpdatePss1Event(command.getPss1Id(), command.getKf(), command.getKpe(), command.getKs(), command.getKw(), command.getPmin(), command.getT10(), command.getT5(), command.getT6(), command.getT7(), command.getT8(), command.getT9(), command.getTpe(), command.getVadat(), command.getVsmn(), command.getVsmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePss1Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePss1Command" );
        apply(new DeletePss1Event(command.getPss1Id()));
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
    void on(CreatePss1Event event) {	
    	LOGGER.info( "Event sourcing CreatePss1Event" );
    	this.pss1Id = event.getPss1Id();
        this.kf = event.getKf();
        this.kpe = event.getKpe();
        this.ks = event.getKs();
        this.kw = event.getKw();
        this.pmin = event.getPmin();
        this.t10 = event.getT10();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.tpe = event.getTpe();
        this.vadat = event.getVadat();
        this.vsmn = event.getVsmn();
        this.vsmx = event.getVsmx();
    }
    
    @EventSourcingHandler
    void on(UpdatePss1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kf = event.getKf();
        this.kpe = event.getKpe();
        this.ks = event.getKs();
        this.kw = event.getKw();
        this.pmin = event.getPmin();
        this.t10 = event.getT10();
        this.t5 = event.getT5();
        this.t6 = event.getT6();
        this.t7 = event.getT7();
        this.t8 = event.getT8();
        this.t9 = event.getT9();
        this.tpe = event.getTpe();
        this.vadat = event.getVadat();
        this.vsmn = event.getVsmn();
        this.vsmx = event.getVsmx();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pss1Id;
    
    private String kf;
    private String kpe;
    private String ks;
    private String kw;
    private String pmin;
    private String t10;
    private String t5;
    private String t6;
    private String t7;
    private String t8;
    private String t9;
    private String tpe;
    private String vadat;
    private String vsmn;
    private String vsmx;

    private static final Logger LOGGER 	= Logger.getLogger(Pss1Aggregate.class.getName());
}
