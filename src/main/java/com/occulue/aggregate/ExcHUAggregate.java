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
 * Aggregate handler for ExcHU as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcHU are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcHUAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcHUAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcHUAggregate(CreateExcHUCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcHUCommand" );
    	CreateExcHUEvent event = new CreateExcHUEvent(command.getExcHUId(), command.getAe(), command.getAi(), command.getAtr(), command.getEmax(), command.getEmin(), command.getImax(), command.getImin(), command.getKe(), command.getKi(), command.getTe(), command.getTi(), command.getTr());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcHUCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcHUCommand" );
    	UpdateExcHUEvent event = new UpdateExcHUEvent(command.getExcHUId(), command.getAe(), command.getAi(), command.getAtr(), command.getEmax(), command.getEmin(), command.getImax(), command.getImin(), command.getKe(), command.getKi(), command.getTe(), command.getTi(), command.getTr());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcHUCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcHUCommand" );
        apply(new DeleteExcHUEvent(command.getExcHUId()));
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
    void on(CreateExcHUEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcHUEvent" );
    	this.excHUId = event.getExcHUId();
        this.ae = event.getAe();
        this.ai = event.getAi();
        this.atr = event.getAtr();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.imax = event.getImax();
        this.imin = event.getImin();
        this.ke = event.getKe();
        this.ki = event.getKi();
        this.te = event.getTe();
        this.ti = event.getTi();
        this.tr = event.getTr();
    }
    
    @EventSourcingHandler
    void on(UpdateExcHUEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ae = event.getAe();
        this.ai = event.getAi();
        this.atr = event.getAtr();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.imax = event.getImax();
        this.imin = event.getImin();
        this.ke = event.getKe();
        this.ki = event.getKi();
        this.te = event.getTe();
        this.ti = event.getTi();
        this.tr = event.getTr();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excHUId;
    
    private String ae;
    private String ai;
    private String atr;
    private String emax;
    private String emin;
    private String imax;
    private String imin;
    private String ke;
    private String ki;
    private String te;
    private String ti;
    private String tr;

    private static final Logger LOGGER 	= Logger.getLogger(ExcHUAggregate.class.getName());
}
