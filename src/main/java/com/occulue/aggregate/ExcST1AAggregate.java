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
 * Aggregate handler for ExcST1A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST1A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST1AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST1AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST1AAggregate(CreateExcST1ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST1ACommand" );
    	CreateExcST1AEvent event = new CreateExcST1AEvent(command.getExcST1AId(), command.getIlr(), command.getKa(), command.getKc(), command.getKf(), command.getKlr(), command.getTa(), command.getTb(), command.getTb1(), command.getTc(), command.getTc1(), command.getTf(), command.getVamax(), command.getVamin(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin(), command.getXe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST1ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST1ACommand" );
    	UpdateExcST1AEvent event = new UpdateExcST1AEvent(command.getExcST1AId(), command.getIlr(), command.getKa(), command.getKc(), command.getKf(), command.getKlr(), command.getTa(), command.getTb(), command.getTb1(), command.getTc(), command.getTc1(), command.getTf(), command.getVamax(), command.getVamin(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin(), command.getXe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST1ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST1ACommand" );
        apply(new DeleteExcST1AEvent(command.getExcST1AId()));
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
    void on(CreateExcST1AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST1AEvent" );
    	this.excST1AId = event.getExcST1AId();
        this.ilr = event.getIlr();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kf = event.getKf();
        this.klr = event.getKlr();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tb1 = event.getTb1();
        this.tc = event.getTc();
        this.tc1 = event.getTc1();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xe = event.getXe();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST1AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ilr = event.getIlr();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.kf = event.getKf();
        this.klr = event.getKlr();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tb1 = event.getTb1();
        this.tc = event.getTc();
        this.tc1 = event.getTc1();
        this.tf = event.getTf();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xe = event.getXe();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excST1AId;
    
    private String ilr;
    private String ka;
    private String kc;
    private String kf;
    private String klr;
    private String ta;
    private String tb;
    private String tb1;
    private String tc;
    private String tc1;
    private String tf;
    private String vamax;
    private String vamin;
    private String vimax;
    private String vimin;
    private String vrmax;
    private String vrmin;
    private String xe;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST1AAggregate.class.getName());
}
