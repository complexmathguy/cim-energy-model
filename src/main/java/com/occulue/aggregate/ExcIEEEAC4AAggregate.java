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
 * Aggregate handler for ExcIEEEAC4A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEAC4A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEAC4AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEAC4AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEAC4AAggregate(CreateExcIEEEAC4ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEAC4ACommand" );
    	CreateExcIEEEAC4AEvent event = new CreateExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getKa(), command.getKc(), command.getTa(), command.getTb(), command.getTc(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEAC4ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEAC4ACommand" );
    	UpdateExcIEEEAC4AEvent event = new UpdateExcIEEEAC4AEvent(command.getExcIEEEAC4AId(), command.getKa(), command.getKc(), command.getTa(), command.getTb(), command.getTc(), command.getVimax(), command.getVimin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEAC4ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEAC4ACommand" );
        apply(new DeleteExcIEEEAC4AEvent(command.getExcIEEEAC4AId()));
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
    void on(CreateExcIEEEAC4AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEAC4AEvent" );
    	this.excIEEEAC4AId = event.getExcIEEEAC4AId();
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
    void on(UpdateExcIEEEAC4AEvent event) {
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
    private UUID excIEEEAC4AId;
    
    private String ka;
    private String kc;
    private String ta;
    private String tb;
    private String tc;
    private String vimax;
    private String vimin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC4AAggregate.class.getName());
}
