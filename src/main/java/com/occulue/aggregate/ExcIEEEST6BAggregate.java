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
 * Aggregate handler for ExcIEEEST6B as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST6B are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST6BAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST6BAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST6BAggregate(CreateExcIEEEST6BCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST6BCommand" );
    	CreateExcIEEEST6BEvent event = new CreateExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getIlr(), command.getKci(), command.getKff(), command.getKg(), command.getKia(), command.getKlr(), command.getKm(), command.getKpa(), command.getOelin(), command.getTg(), command.getVamax(), command.getVamin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST6BCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST6BCommand" );
    	UpdateExcIEEEST6BEvent event = new UpdateExcIEEEST6BEvent(command.getExcIEEEST6BId(), command.getIlr(), command.getKci(), command.getKff(), command.getKg(), command.getKia(), command.getKlr(), command.getKm(), command.getKpa(), command.getOelin(), command.getTg(), command.getVamax(), command.getVamin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST6BCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST6BCommand" );
        apply(new DeleteExcIEEEST6BEvent(command.getExcIEEEST6BId()));
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
    void on(CreateExcIEEEST6BEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST6BEvent" );
    	this.excIEEEST6BId = event.getExcIEEEST6BId();
        this.ilr = event.getIlr();
        this.kci = event.getKci();
        this.kff = event.getKff();
        this.kg = event.getKg();
        this.kia = event.getKia();
        this.klr = event.getKlr();
        this.km = event.getKm();
        this.kpa = event.getKpa();
        this.oelin = event.getOelin();
        this.tg = event.getTg();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST6BEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ilr = event.getIlr();
        this.kci = event.getKci();
        this.kff = event.getKff();
        this.kg = event.getKg();
        this.kia = event.getKia();
        this.klr = event.getKlr();
        this.km = event.getKm();
        this.kpa = event.getKpa();
        this.oelin = event.getOelin();
        this.tg = event.getTg();
        this.vamax = event.getVamax();
        this.vamin = event.getVamin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excIEEEST6BId;
    
    private String ilr;
    private String kci;
    private String kff;
    private String kg;
    private String kia;
    private String klr;
    private String km;
    private String kpa;
    private String oelin;
    private String tg;
    private String vamax;
    private String vamin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST6BAggregate.class.getName());
}
