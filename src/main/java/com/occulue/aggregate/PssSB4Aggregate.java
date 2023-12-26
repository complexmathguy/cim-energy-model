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
 * Aggregate handler for PssSB4 as outlined for the CQRS pattern, all write responsibilities 
 * related to PssSB4 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PssSB4Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PssSB4Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PssSB4Aggregate(CreatePssSB4Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePssSB4Command" );
    	CreatePssSB4Event event = new CreatePssSB4Event(command.getPssSB4Id(), command.getKx(), command.getTa(), command.getTb(), command.getTc(), command.getTd(), command.getTe(), command.getTt(), command.getTx1(), command.getTx2(), command.getVsmax(), command.getVsmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePssSB4Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePssSB4Command" );
    	UpdatePssSB4Event event = new UpdatePssSB4Event(command.getPssSB4Id(), command.getKx(), command.getTa(), command.getTb(), command.getTc(), command.getTd(), command.getTe(), command.getTt(), command.getTx1(), command.getTx2(), command.getVsmax(), command.getVsmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePssSB4Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePssSB4Command" );
        apply(new DeletePssSB4Event(command.getPssSB4Id()));
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
    void on(CreatePssSB4Event event) {	
    	LOGGER.info( "Event sourcing CreatePssSB4Event" );
    	this.pssSB4Id = event.getPssSB4Id();
        this.kx = event.getKx();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.td = event.getTd();
        this.te = event.getTe();
        this.tt = event.getTt();
        this.tx1 = event.getTx1();
        this.tx2 = event.getTx2();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePssSB4Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kx = event.getKx();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.td = event.getTd();
        this.te = event.getTe();
        this.tt = event.getTt();
        this.tx1 = event.getTx1();
        this.tx2 = event.getTx2();
        this.vsmax = event.getVsmax();
        this.vsmin = event.getVsmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pssSB4Id;
    
    private String kx;
    private String ta;
    private String tb;
    private String tc;
    private String td;
    private String te;
    private String tt;
    private String tx1;
    private String tx2;
    private String vsmax;
    private String vsmin;

    private static final Logger LOGGER 	= Logger.getLogger(PssSB4Aggregate.class.getName());
}
