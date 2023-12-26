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
 * Aggregate handler for ExcST2A as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcST2A are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcST2AAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcST2AAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcST2AAggregate(CreateExcST2ACommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcST2ACommand" );
    	CreateExcST2AEvent event = new CreateExcST2AEvent(command.getExcST2AId(), command.getEfdmax(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcST2ACommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcST2ACommand" );
    	UpdateExcST2AEvent event = new UpdateExcST2AEvent(command.getExcST2AId(), command.getEfdmax(), command.getKa(), command.getKc(), command.getKe(), command.getKf(), command.getKi(), command.getKp(), command.getTa(), command.getTb(), command.getTc(), command.getTe(), command.getTf(), command.getUelin(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcST2ACommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcST2ACommand" );
        apply(new DeleteExcST2AEvent(command.getExcST2AId()));
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
    void on(CreateExcST2AEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcST2AEvent" );
    	this.excST2AId = event.getExcST2AId();
        this.efdmax = event.getEfdmax();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.tf = event.getTf();
        this.uelin = event.getUelin();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcST2AEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.ka = event.getKa();
        this.kc = event.getKc();
        this.ke = event.getKe();
        this.kf = event.getKf();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tb = event.getTb();
        this.tc = event.getTc();
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
    private UUID excST2AId;
    
    private String efdmax;
    private String ka;
    private String kc;
    private String ke;
    private String kf;
    private String ki;
    private String kp;
    private String ta;
    private String tb;
    private String tc;
    private String te;
    private String tf;
    private String uelin;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST2AAggregate.class.getName());
}
