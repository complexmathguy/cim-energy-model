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
 * Aggregate handler for PFVArType2IEEEVArController as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArType2IEEEVArController are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArType2IEEEVArControllerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArType2IEEEVArControllerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArType2IEEEVArControllerAggregate(CreatePFVArType2IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArType2IEEEVArControllerCommand" );
    	CreatePFVArType2IEEEVArControllerEvent event = new CreatePFVArType2IEEEVArControllerEvent(command.getPFVArType2IEEEVArControllerId(), command.getExlon(), command.getKi(), command.getKp(), command.getQref(), command.getVclmt(), command.getVref(), command.getVs());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArType2IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArType2IEEEVArControllerCommand" );
    	UpdatePFVArType2IEEEVArControllerEvent event = new UpdatePFVArType2IEEEVArControllerEvent(command.getPFVArType2IEEEVArControllerId(), command.getExlon(), command.getKi(), command.getKp(), command.getQref(), command.getVclmt(), command.getVref(), command.getVs());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArType2IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArType2IEEEVArControllerCommand" );
        apply(new DeletePFVArType2IEEEVArControllerEvent(command.getPFVArType2IEEEVArControllerId()));
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
    void on(CreatePFVArType2IEEEVArControllerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArType2IEEEVArControllerEvent" );
    	this.pFVArType2IEEEVArControllerId = event.getPFVArType2IEEEVArControllerId();
        this.exlon = event.getExlon();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.qref = event.getQref();
        this.vclmt = event.getVclmt();
        this.vref = event.getVref();
        this.vs = event.getVs();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArType2IEEEVArControllerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.exlon = event.getExlon();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.qref = event.getQref();
        this.vclmt = event.getVclmt();
        this.vref = event.getVref();
        this.vs = event.getVs();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pFVArType2IEEEVArControllerId;
    
    private String exlon;
    private String ki;
    private String kp;
    private String qref;
    private String vclmt;
    private String vref;
    private String vs;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEVArControllerAggregate.class.getName());
}
