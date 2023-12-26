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
 * Aggregate handler for ExcST3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST3AAggregate(CreateExcST3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST3ACommand" );
    	CreateExcST3AEvent event = new CreateExcST3AEvent(command.getExcST3AId(), command.getEfdmax(), command.getKc(), command.getKg(), command.getKi(), command.getKj(), command.getKm(), command.getKp(), command.getKs(), command.getKs1(), command.getTb(), command.getTc(), command.getThetap(), command.getTm(), command.getVbmax(), command.getVgmax(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin(), command.getXl());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST3ACommand" );
    	UpdateExcST3AEvent event = new UpdateExcST3AEvent(command.getExcST3AId(), command.getEfdmax(), command.getKc(), command.getKg(), command.getKi(), command.getKj(), command.getKm(), command.getKp(), command.getKs(), command.getKs1(), command.getTb(), command.getTc(), command.getThetap(), command.getTm(), command.getVbmax(), command.getVgmax(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin(), command.getXl());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST3ACommand" );
        apply(new DeleteExcST3AEvent(command.getExcST3AId()));
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
    void on(CreateExcST3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST3AEvent" );
    	this.excST3AId = event.getExcST3AId();
        this.efdmax = event.getEfdmax();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kj = event.getKj();
        this.km = event.getKm();
        this.kp = event.getKp();
        this.ks = event.getKs();
        this.ks1 = event.getKs1();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.thetap = event.getThetap();
        this.tm = event.getTm();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xl = event.getXl();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kj = event.getKj();
        this.km = event.getKm();
        this.kp = event.getKp();
        this.ks = event.getKs();
        this.ks1 = event.getKs1();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.thetap = event.getThetap();
        this.tm = event.getTm();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xl = event.getXl();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excST3AId;
    
    private String efdmax;
    private String kc;
    private String kg;
    private String ki;
    private String kj;
    private String km;
    private String kp;
    private String ks;
    private String ks1;
    private String tb;
    private String tc;
    private String thetap;
    private String tm;
    private String vbmax;
    private String vgmax;
    private String vimax;
    private String vimin;
    private String vrmax;
    private String vrmin;
    private String xl;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST3AAggregate.class.getName());
}
