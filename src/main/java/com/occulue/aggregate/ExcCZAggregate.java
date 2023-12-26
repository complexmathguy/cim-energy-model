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
 * Aggregate handler for ExcCZ as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcCZ are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcCZAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcCZAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcCZAggregate(CreateExcCZCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcCZCommand" );
    	CreateExcCZEvent event = new CreateExcCZEvent(command.getExcCZId(), command.getEfdmax(), command.getEfdmin(), command.getKa(), command.getKe(), command.getKp(), command.getTa(), command.getTc(), command.getTe(), command.getVrmax(), command.getVrmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcCZCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcCZCommand" );
    	UpdateExcCZEvent event = new UpdateExcCZEvent(command.getExcCZId(), command.getEfdmax(), command.getEfdmin(), command.getKa(), command.getKe(), command.getKp(), command.getTa(), command.getTc(), command.getTe(), command.getVrmax(), command.getVrmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcCZCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcCZCommand" );
        apply(new DeleteExcCZEvent(command.getExcCZId()));
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
    void on(CreateExcCZEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcCZEvent" );
    	this.excCZId = event.getExcCZId();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tc = event.getTc();
        this.te = event.getTe();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
    }
    
    @EventSourcingHandler
    void on(UpdateExcCZEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.ka = event.getKa();
        this.ke = event.getKe();
        this.kp = event.getKp();
        this.ta = event.getTa();
        this.tc = event.getTc();
        this.te = event.getTe();
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
    private UUID excCZId;
    
    private String efdmax;
    private String efdmin;
    private String ka;
    private String ke;
    private String kp;
    private String ta;
    private String tc;
    private String te;
    private String vrmax;
    private String vrmin;

    private static final Logger LOGGER 	= Logger.getLogger(ExcCZAggregate.class.getName());
}
