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
 * Aggregate handler for ExcAC4A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAC4A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAC4AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAC4AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAC4AAggregate(CreateExcAC4ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAC4ACommand" );
    	CreateExcAC4AEvent event = new CreateExcAC4AEvent(command.getExcAC4AId(), command.getKa(), command.getKc(), command.getTa(), command.getTb(), command.getTc(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAC4ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAC4ACommand" );
    	UpdateExcAC4AEvent event = new UpdateExcAC4AEvent(command.getExcAC4AId(), command.getKa(), command.getKc(), command.getTa(), command.getTb(), command.getTc(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAC4ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAC4ACommand" );
        apply(new DeleteExcAC4AEvent(command.getExcAC4AId()));
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
    void on(CreateExcAC4AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcAC4AEvent" );
    	this.excAC4AId = event.getExcAC4AId();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAC4AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.vimax = event.getVimax();
        this.vimin = event.getVimin();
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
    private UUID excAC4AId;
    
    private String ka;
    private String kc;
    private String ta;
    private String tb;
    private String tc;
    private String vimax;
    private String vimin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC4AAggregate.class.getName());
}
