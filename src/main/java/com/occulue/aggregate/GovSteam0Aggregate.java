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
 * Aggregate handler for GovSteam0 as outlined for the CQRS pattern, all write responsibilities 
 * related to GovSteam0 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovSteam0Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovSteam0Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovSteam0Aggregate(CreateGovSteam0Command command) throws Exception {
    	LOGGER.info( "Handling command CreateGovSteam0Command" );
    	CreateGovSteam0Event event = new CreateGovSteam0Event(command.getGovSteam0Id(), command.getDt(), command.getMwbase(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getVmax(), command.getVmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovSteam0Command command) throws Exception {
    	LOGGER.info( "handling command UpdateGovSteam0Command" );
    	UpdateGovSteam0Event event = new UpdateGovSteam0Event(command.getGovSteam0Id(), command.getDt(), command.getMwbase(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getVmax(), command.getVmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovSteam0Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovSteam0Command" );
        apply(new DeleteGovSteam0Event(command.getGovSteam0Id()));
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
    void on(CreateGovSteam0Event event) {	
    	LOGGER.info( "Event sourcing CreateGovSteam0Event" );
    	this.govSteam0Id = event.getGovSteam0Id();
        this.dt = event.getDt();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovSteam0Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dt = event.getDt();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
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
    private UUID govSteam0Id;
    
    private String dt;
    private String mwbase;
    private String r;
    private String t1;
    private String t2;
    private String t3;
    private String vmax;
    private String vmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam0Aggregate.class.getName());
}
