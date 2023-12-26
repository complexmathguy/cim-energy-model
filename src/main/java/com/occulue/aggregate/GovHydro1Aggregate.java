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
 * Aggregate handler for GovHydro1 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovHydro1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovHydro1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovHydro1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovHydro1Aggregate(CreateGovHydro1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovHydro1Command" );
    	CreateGovHydro1Event event = new CreateGovHydro1Event(command.getGovHydro1Id(), command.getAt(), command.getDturb(), command.getGmax(), command.getGmin(), command.getHdam(), command.getMwbase(), command.getQnl(), command.getRperm(), command.getRtemp(), command.getTf(), command.getTg(), command.getTr(), command.getTw(), command.getVelm());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovHydro1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovHydro1Command" );
    	UpdateGovHydro1Event event = new UpdateGovHydro1Event(command.getGovHydro1Id(), command.getAt(), command.getDturb(), command.getGmax(), command.getGmin(), command.getHdam(), command.getMwbase(), command.getQnl(), command.getRperm(), command.getRtemp(), command.getTf(), command.getTg(), command.getTr(), command.getTw(), command.getVelm());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovHydro1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovHydro1Command" );
        apply(new DeleteGovHydro1Event(command.getGovHydro1Id()));
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
    void on(CreateGovHydro1Event event) {	
    	LOGGER.info( "Event sourcing CreateGovHydro1Event" );
    	this.govHydro1Id = event.getGovHydro1Id();
        this.at = event.getAt();
        this.dturb = event.getDturb();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.hdam = event.getHdam();
        this.mwbase = event.getMwbase();
        this.qnl = event.getQnl();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tf = event.getTf();
        this.tg = event.getTg();
        this.tr = event.getTr();
        this.tw = event.getTw();
        this.velm = event.getVelm();
    }
    
    @EventSourcingHandler
    void on(UpdateGovHydro1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.at = event.getAt();
        this.dturb = event.getDturb();
        this.gmax = event.getGmax();
        this.gmin = event.getGmin();
        this.hdam = event.getHdam();
        this.mwbase = event.getMwbase();
        this.qnl = event.getQnl();
        this.rperm = event.getRperm();
        this.rtemp = event.getRtemp();
        this.tf = event.getTf();
        this.tg = event.getTg();
        this.tr = event.getTr();
        this.tw = event.getTw();
        this.velm = event.getVelm();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID govHydro1Id;
    
    private String at;
    private String dturb;
    private String gmax;
    private String gmin;
    private String hdam;
    private String mwbase;
    private String qnl;
    private String rperm;
    private String rtemp;
    private String tf;
    private String tg;
    private String tr;
    private String tw;
    private String velm;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro1Aggregate.class.getName());
}
