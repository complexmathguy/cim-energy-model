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
 * Aggregate handler for ExcBBC as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcBBC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcBBCAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcBBCAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcBBCAggregate(CreateExcBBCCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcBBCCommand" );
    	CreateExcBBCEvent event = new CreateExcBBCEvent(command.getExcBBCId(), command.getEfdmax(), command.getEfdmin(), command.getK(), command.getSwitchIt(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getVrmax(), command.getVrmin(), command.getXe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcBBCCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcBBCCommand" );
    	UpdateExcBBCEvent event = new UpdateExcBBCEvent(command.getExcBBCId(), command.getEfdmax(), command.getEfdmin(), command.getK(), command.getSwitchIt(), command.getT1(), command.getT2(), command.getT3(), command.getT4(), command.getVrmax(), command.getVrmin(), command.getXe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcBBCCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcBBCCommand" );
        apply(new DeleteExcBBCEvent(command.getExcBBCId()));
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
    void on(CreateExcBBCEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcBBCEvent" );
    	this.excBBCId = event.getExcBBCId();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.k = event.getK();
        this.switchIt = event.getSwitchIt();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
        this.vrmax = event.getVrmax();
        this.vrmin = event.getVrmin();
        this.xe = event.getXe();
    }
    
    @EventSourcingHandler
    void on(UpdateExcBBCEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.k = event.getK();
        this.switchIt = event.getSwitchIt();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.t3 = event.getT3();
        this.t4 = event.getT4();
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
    private UUID excBBCId;
    
    private String efdmax;
    private String efdmin;
    private String k;
    private String switchIt;
    private String t1;
    private String t2;
    private String t3;
    private String t4;
    private String vrmax;
    private String vrmin;
    private String xe;

    private static final Logger LOGGER 	= Logger.getLogger(ExcBBCAggregate.class.getName());
}
