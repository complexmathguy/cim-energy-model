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
 * Aggregate handler for Pss5 as outlined for the CQRS pattern, all write responsibilities 
 * related to Pss5 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Pss5Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Pss5Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Pss5Aggregate(CreatePss5Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePss5Command" );
    	CreatePss5Event event = new CreatePss5Event(command.getPss5Id(), command.getCtw2(), command.getDeadband(), command.getIsfreq(), command.getKf(), command.getKpe(), command.getKpss(), command.getPmm(), command.getTl1(), command.getTl2(), command.getTl3(), command.getTl4(), command.getTpe(), command.getTw1(), command.getTw2(), command.getVadat(), command.getVsmn(), command.getVsmx());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePss5Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePss5Command" );
    	UpdatePss5Event event = new UpdatePss5Event(command.getPss5Id(), command.getCtw2(), command.getDeadband(), command.getIsfreq(), command.getKf(), command.getKpe(), command.getKpss(), command.getPmm(), command.getTl1(), command.getTl2(), command.getTl3(), command.getTl4(), command.getTpe(), command.getTw1(), command.getTw2(), command.getVadat(), command.getVsmn(), command.getVsmx());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePss5Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePss5Command" );
        apply(new DeletePss5Event(command.getPss5Id()));
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
    void on(CreatePss5Event event) {	
    	LOGGER.info( "Event sourcing CreatePss5Event" );
    	this.pss5Id = event.getPss5Id();
        this.ctw2 = event.getCtw2();
        this.deadband = event.getDeadband();
        this.isfreq = event.getIsfreq();
        this.kf = event.getKf();
        this.kpe = event.getKpe();
        this.kpss = event.getKpss();
        this.pmm = event.getPmm();
        this.tl1 = event.getTl1();
        this.tl2 = event.getTl2();
        this.tl3 = event.getTl3();
        this.tl4 = event.getTl4();
        this.tpe = event.getTpe();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
        this.vadat = event.getVadat();
        this.vsmn = event.getVsmn();
        this.vsmx = event.getVsmx();
    }
    
    @EventSourcingHandler
    void on(UpdatePss5Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ctw2 = event.getCtw2();
        this.deadband = event.getDeadband();
        this.isfreq = event.getIsfreq();
        this.kf = event.getKf();
        this.kpe = event.getKpe();
        this.kpss = event.getKpss();
        this.pmm = event.getPmm();
        this.tl1 = event.getTl1();
        this.tl2 = event.getTl2();
        this.tl3 = event.getTl3();
        this.tl4 = event.getTl4();
        this.tpe = event.getTpe();
        this.tw1 = event.getTw1();
        this.tw2 = event.getTw2();
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
    private UUID pss5Id;
    
    private String ctw2;
    private String deadband;
    private String isfreq;
    private String kf;
    private String kpe;
    private String kpss;
    private String pmm;
    private String tl1;
    private String tl2;
    private String tl3;
    private String tl4;
    private String tpe;
    private String tw1;
    private String tw2;
    private String vadat;
    private String vsmn;
    private String vsmx;

    private static final Logger LOGGER 	= Logger.getLogger(Pss5Aggregate.class.getName());
}
