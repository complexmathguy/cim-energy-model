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
 * Aggregate handler for ExcIEEEST2A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcIEEEST2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcIEEEST2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcIEEEST2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcIEEEST2AAggregate(CreateExcIEEEST2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcIEEEST2ACommand" );
    	CreateExcIEEEST2AEvent event = new CreateExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getEfdmax(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcIEEEST2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcIEEEST2ACommand" );
    	UpdateExcIEEEST2AEvent event = new UpdateExcIEEEST2AEvent(command.getExcIEEEST2AId(), command.getEfdmax(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcIEEEST2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcIEEEST2ACommand" );
        apply(new DeleteExcIEEEST2AEvent(command.getExcIEEEST2AId()));
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
    void on(CreateExcIEEEST2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcIEEEST2AEvent" );
    	this.excIEEEST2AId = event.getExcIEEEST2AId();
        this.efdmax = event.getEfdmax();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcIEEEST2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
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
    private UUID excIEEEST2AId;
    
    private String efdmax;
    private String ka;
    private String kc;
    private String ke;
    private String kf;
    private String ki;
    private String kp;
    private String ta;
    private String te;
    private String tf;
    private String uelin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST2AAggregate.class.getName());
}
