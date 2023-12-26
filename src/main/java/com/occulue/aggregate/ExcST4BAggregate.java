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
 * Aggregate handler for ExcST4B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST4B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST4BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST4BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST4BAggregate(CreateExcST4BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST4BCommand" );
    	CreateExcST4BEvent event = new CreateExcST4BEvent(command.getExcST4BId(), command.getKc(), command.getKg(), command.getKi(), command.getKim(), command.getKir(), command.getKp(), command.getKpm(), command.getKpr(), command.getLvgate(), command.getTa(), command.getThetap(), command.getUel(), command.getVbmax(), command.getVgmax(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST4BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST4BCommand" );
    	UpdateExcST4BEvent event = new UpdateExcST4BEvent(command.getExcST4BId(), command.getKc(), command.getKg(), command.getKi(), command.getKim(), command.getKir(), command.getKp(), command.getKpm(), command.getKpr(), command.getLvgate(), command.getTa(), command.getThetap(), command.getUel(), command.getVbmax(), command.getVgmax(), command.getVmmax(), command.getVmmin(), command.getVrmax(), command.getVrmin(), command.getXl());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST4BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST4BCommand" );
        apply(new DeleteExcST4BEvent(command.getExcST4BId()));
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
    void on(CreateExcST4BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST4BEvent" );
    	this.excST4BId = event.getExcST4BId();
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kim = event.getKim();
        this.kir = event.getKir();
        this.kp = event.getKp();
        this.kpm = event.getKpm();
        this.kpr = event.getKpr();
        this.lvgate = event.getLvgate();
        this.ta = event.getTa();
        this.thetap = event.getThetap();
        this.uel = event.getUel();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
        this.vmmax = event.getVmmax();
        this.vmmin = event.getVmmin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xl = event.getXl();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST4BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kc = event.getKc();
        this.kg = event.getKg();
        this.ki = event.getKi();
        this.kim = event.getKim();
        this.kir = event.getKir();
        this.kp = event.getKp();
        this.kpm = event.getKpm();
        this.kpr = event.getKpr();
        this.lvgate = event.getLvgate();
        this.ta = event.getTa();
        this.thetap = event.getThetap();
        this.uel = event.getUel();
        this.vbmax = event.getVbmax();
        this.vgmax = event.getVgmax();
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
    private UUID excST4BId;
    
    private String kc;
    private String kg;
    private String ki;
    private String kim;
    private String kir;
    private String kp;
    private String kpm;
    private String kpr;
    private String lvgate;
    private String ta;
    private String thetap;
    private String uel;
    private String vbmax;
    private String vgmax;
    private String vmmax;
    private String vmmin;
    private String vrmax;
    private String vrmin;
    private String xl;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST4BAggregate.class.getName());
}
