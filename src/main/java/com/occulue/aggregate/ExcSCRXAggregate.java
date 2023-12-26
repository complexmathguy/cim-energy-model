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
 * Aggregate handler for ExcSCRX as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcSCRX are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcSCRXAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcSCRXAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcSCRXAggregate(CreateExcSCRXCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExcSCRXCommand" );
    	CreateExcSCRXEvent event = new CreateExcSCRXEvent(command.getExcSCRXId(), command.getCswitch(), command.getEmax(), command.getEmin(), command.getK(), command.getRcrfd(), command.getTatb(), command.getTb(), command.getTe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcSCRXCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExcSCRXCommand" );
    	UpdateExcSCRXEvent event = new UpdateExcSCRXEvent(command.getExcSCRXId(), command.getCswitch(), command.getEmax(), command.getEmin(), command.getK(), command.getRcrfd(), command.getTatb(), command.getTb(), command.getTe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcSCRXCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcSCRXCommand" );
        apply(new DeleteExcSCRXEvent(command.getExcSCRXId()));
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
    void on(CreateExcSCRXEvent event) {	
    	LOGGER.info( "Event sourcing CreateExcSCRXEvent" );
    	this.excSCRXId = event.getExcSCRXId();
        this.cswitch = event.getCswitch();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.rcrfd = event.getRcrfd();
        this.tatb = event.getTatb();
        this.tb = event.getTb();
        this.te = event.getTe();
    }
    
    @EventSourcingHandler
    void on(UpdateExcSCRXEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.cswitch = event.getCswitch();
        this.emax = event.getEmax();
        this.emin = event.getEmin();
        this.k = event.getK();
        this.rcrfd = event.getRcrfd();
        this.tatb = event.getTatb();
        this.tb = event.getTb();
        this.te = event.getTe();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excSCRXId;
    
    private String cswitch;
    private String emax;
    private String emin;
    private String k;
    private String rcrfd;
    private String tatb;
    private String tb;
    private String te;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSCRXAggregate.class.getName());
}
