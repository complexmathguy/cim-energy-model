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
 * Aggregate handler for ExcSEXS as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcSEXS are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcSEXSAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcSEXSAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcSEXSAggregate(CreateExcSEXSCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcSEXSCommand" );
    	CreateExcSEXSEvent event = new CreateExcSEXSEvent(command.getExcSEXSId(), command.getEfdmax(), command.getEfdmin(), command.getEmax(), command.getEmin(), command.getK(), command.getKc(), command.getTatb(), command.getTb(), command.getTc(), command.getTe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcSEXSCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcSEXSCommand" );
    	UpdateExcSEXSEvent event = new UpdateExcSEXSEvent(command.getExcSEXSId(), command.getEfdmax(), command.getEfdmin(), command.getEmax(), command.getEmin(), command.getK(), command.getKc(), command.getTatb(), command.getTb(), command.getTc(), command.getTe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcSEXSCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcSEXSCommand" );
        apply(new DeleteExcSEXSEvent(command.getExcSEXSId()));
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
    void on(CreateExcSEXSEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcSEXSEvent" );
    	this.excSEXSId = event.getExcSEXSId();
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.kc = event.getKc();
        this.tatb = event.getTatb();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
    }
    
    @EventSourcingHandler
    void on(UpdateExcSEXSEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdmax = event.getEfdmax();
        this.efdmin = event.getEfdmin();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.kc = event.getKc();
        this.tatb = event.getTatb();
        this.tb = event.getTb();
        this.tc = event.getTc();
        this.te = event.getTe();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excSEXSId;
    
    private String efdmax;
    private String efdmin;
    private String emax;
    private String emin;
    private String k;
    private String kc;
    private String tatb;
    private String tb;
    private String tc;
    private String te;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSEXSAggregate.class.getName());
}
