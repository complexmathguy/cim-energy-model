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
 * Aggregate handler for LoadMotor as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadMotor are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadMotorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadMotorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadMotorAggregate(CreateLoadMotorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadMotorCommand" );
    	CreateLoadMotorEvent event = new CreateLoadMotorEvent(command.getLoadMotorId(), command.getD(), command.getH(), command.getLfac(), command.getLp(), command.getLpp(), command.getLs(), command.getPfrac(), command.getRa(), command.getTbkr(), command.getTpo(), command.getTppo(), command.getTv(), command.getVt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadMotorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadMotorCommand" );
    	UpdateLoadMotorEvent event = new UpdateLoadMotorEvent(command.getLoadMotorId(), command.getD(), command.getH(), command.getLfac(), command.getLp(), command.getLpp(), command.getLs(), command.getPfrac(), command.getRa(), command.getTbkr(), command.getTpo(), command.getTppo(), command.getTv(), command.getVt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadMotorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadMotorCommand" );
        apply(new DeleteLoadMotorEvent(command.getLoadMotorId()));
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
    void on(CreateLoadMotorEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadMotorEvent" );
    	this.loadMotorId = event.getLoadMotorId();
        this.d = event.getD();
        this.h = event.getH();
        this.lfac = event.getLfac();
        this.lp = event.getLp();
        this.lpp = event.getLpp();
        this.ls = event.getLs();
        this.pfrac = event.getPfrac();
        this.ra = event.getRa();
        this.tbkr = event.getTbkr();
        this.tpo = event.getTpo();
        this.tppo = event.getTppo();
        this.tv = event.getTv();
        this.vt = event.getVt();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadMotorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.d = event.getD();
        this.h = event.getH();
        this.lfac = event.getLfac();
        this.lp = event.getLp();
        this.lpp = event.getLpp();
        this.ls = event.getLs();
        this.pfrac = event.getPfrac();
        this.ra = event.getRa();
        this.tbkr = event.getTbkr();
        this.tpo = event.getTpo();
        this.tppo = event.getTppo();
        this.tv = event.getTv();
        this.vt = event.getVt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadMotorId;
    
    private String d;
    private String h;
    private String lfac;
    private String lp;
    private String lpp;
    private String ls;
    private String pfrac;
    private String ra;
    private String tbkr;
    private String tpo;
    private String tppo;
    private String tv;
    private String vt;

    private static final Logger LOGGER 	= Logger.getLogger(LoadMotorAggregate.class.getName());
}
