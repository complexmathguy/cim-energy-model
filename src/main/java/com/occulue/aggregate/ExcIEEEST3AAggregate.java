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
 * Aggregate handler for ExcIEEEST3A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST3A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST3AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST3AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST3AAggregate(CreateExcIEEEST3ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST3ACommand" );
    	CreateExcIEEEST3AEvent event = new CreateExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getKa(), command.getKc(), command.getKg(), command.getKi(), command.getKm(), command.getKp(), command.getTa(), command.getTb(), command.getTc(), command.getThetap(), command.getTm(), command.getVbmax(), command.getVgmax(), command.getVimax(), command.getVimin(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST3ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST3ACommand" );
    	UpdateExcIEEEST3AEvent event = new UpdateExcIEEEST3AEvent(command.getExcIEEEST3AId(), command.getKa(), command.getKc(), command.getKg(), command.getKi(), command.getKm(), command.getKp(), command.getTa(), command.getTb(), command.getTc(), command.getThetap(), command.getTm(), command.getVbmax(), command.getVgmax(), command.getVimax(), command.getVimin(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST3ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST3ACommand" );
        apply(new DeleteExcIEEEST3AEvent(command.getExcIEEEST3AId()));
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
    void on(CreateExcIEEEST3AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST3AEvent" );
    	this.excIEEEST3AId = event.getExcIEEEST3AId();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.km = event.getKm();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.thetap = event.getThetap();
        this.tm = event.getTm();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vmmax = event.getVmmax();
        this.vmmin = event.getVmmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xl = event.getXl();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST3AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.km = event.getKm();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.thetap = event.getThetap();
        this.tm = event.getTm();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vmmax = event.getVmmax();
        this.vmmin = event.getVmmin();
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
    private UUID excIEEEST3AId;
    
    private String ka;
    private String kc;
    private String kg;
    private String ki;
    private String km;
    private String kp;
    private String ta;
    private String tb;
    private String tc;
    private String thetap;
    private String tm;
    private String vbmax;
    private String vgmax;
    private String vimax;
    private String vimin;
    private String vmmax;
    private String vmmin;
    private String vrmax;
    private String vrmin;
    private String xl;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST3AAggregate.class.getName());
}
