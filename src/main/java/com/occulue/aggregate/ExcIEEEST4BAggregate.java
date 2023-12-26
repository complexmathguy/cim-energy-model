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
 * Aggregate handler for ExcIEEEST4B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST4B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST4BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST4BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST4BAggregate(CreateExcIEEEST4BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST4BCommand" );
    	CreateExcIEEEST4BEvent event = new CreateExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getKc(), command.getKg(), command.getKi(), command.getKim(), command.getKir(), command.getKp(), command.getKpm(), command.getKpr(), command.getTa(), command.getThetap(), command.getVbmax(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST4BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST4BCommand" );
    	UpdateExcIEEEST4BEvent event = new UpdateExcIEEEST4BEvent(command.getExcIEEEST4BId(), command.getKc(), command.getKg(), command.getKi(), command.getKim(), command.getKir(), command.getKp(), command.getKpm(), command.getKpr(), command.getTa(), command.getThetap(), command.getVbmax(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST4BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST4BCommand" );
        apply(new DeleteExcIEEEST4BEvent(command.getExcIEEEST4BId()));
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
    void on(CreateExcIEEEST4BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST4BEvent" );
    	this.excIEEEST4BId = event.getExcIEEEST4BId();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kim = event.getKim();
        this.kir = event.getKir();
        this.kp = event.getKp();
        this.kpm = event.getKpm();
        this.kpr = event.getKpr();
        this.ta = event.getTa();
        this.thetap = event.getThetap();
        this.vbmax = event.getVbmax();
        this.vmmax = event.getVmmax();
        this.vmmin = event.getVmmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xl = event.getXl();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST4BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kim = event.getKim();
        this.kir = event.getKir();
        this.kp = event.getKp();
        this.kpm = event.getKpm();
        this.kpr = event.getKpr();
        this.ta = event.getTa();
        this.thetap = event.getThetap();
        this.vbmax = event.getVbmax();
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
    private UUID excIEEEST4BId;
    
    private String kc;
    private String kg;
    private String ki;
    private String kim;
    private String kir;
    private String kp;
    private String kpm;
    private String kpr;
    private String ta;
    private String thetap;
    private String vbmax;
    private String vmmax;
    private String vmmin;
    private String vrmax;
    private String vrmin;
    private String xl;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST4BAggregate.class.getName());
}
