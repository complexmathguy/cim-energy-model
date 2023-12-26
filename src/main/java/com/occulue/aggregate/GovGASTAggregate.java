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
 * Aggregate handler for GovGAST as outlined for the CQRS pattern, all write responsibilities 
 * related to GovGAST are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GovGASTAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GovGASTAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GovGASTAggregate(CreateGovGASTCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGovGASTCommand" );
    	CreateGovGASTEvent event = new CreateGovGASTEvent(command.getGovGASTId(), command.getAt(), command.getDturb(), command.getKt(), command.getMwbase(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getVmax(), command.getVmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGovGASTCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGovGASTCommand" );
    	UpdateGovGASTEvent event = new UpdateGovGASTEvent(command.getGovGASTId(), command.getAt(), command.getDturb(), command.getKt(), command.getMwbase(), command.getR(), command.getT1(), command.getT2(), command.getT3(), command.getVmax(), command.getVmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGovGASTCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGovGASTCommand" );
        apply(new DeleteGovGASTEvent(command.getGovGASTId()));
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
    void on(CreateGovGASTEvent event) {	
    	LOGGER.info( "Event sourcing CreateGovGASTEvent" );
    	this.govGASTId = event.getGovGASTId();
        this.at = event.getAt();
        this.dturb = event.getDturb();
        this.kt = event.getKt();
        this.mwbase = event.getMwbase();
        this.r = event.getR();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.vmax = event.getVmax();
        this.vmin = event.getVmin();
    }
    
    @EventSourcingHandler
    void on(UpdateGovGASTEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.at = event.getAt();
        this.dturb = event.getDturb();
        this.kt = event.getKt();
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
    private UUID govGASTId;
    
    private String at;
    private String dturb;
    private String kt;
    private String mwbase;
    private String r;
    private String t1;
    private String t2;
    private String t3;
    private String vmax;
    private String vmin;

    private static final Logger LOGGER 	= Logger.getLogger(GovGASTAggregate.class.getName());
}
