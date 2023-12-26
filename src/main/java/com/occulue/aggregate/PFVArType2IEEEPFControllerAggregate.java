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
 * Aggregate handler for PFVArType2IEEEPFController as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArType2IEEEPFController are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArType2IEEEPFControllerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArType2IEEEPFControllerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArType2IEEEPFControllerAggregate(CreatePFVArType2IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArType2IEEEPFControllerCommand" );
    	CreatePFVArType2IEEEPFControllerEvent event = new CreatePFVArType2IEEEPFControllerEvent(command.getPFVArType2IEEEPFControllerId(), command.getExlon(), command.getKi(), command.getKp(), command.getPfref(), command.getVclmt(), command.getVref(), command.getVs());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArType2IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArType2IEEEPFControllerCommand" );
    	UpdatePFVArType2IEEEPFControllerEvent event = new UpdatePFVArType2IEEEPFControllerEvent(command.getPFVArType2IEEEPFControllerId(), command.getExlon(), command.getKi(), command.getKp(), command.getPfref(), command.getVclmt(), command.getVref(), command.getVs());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArType2IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArType2IEEEPFControllerCommand" );
        apply(new DeletePFVArType2IEEEPFControllerEvent(command.getPFVArType2IEEEPFControllerId()));
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
    void on(CreatePFVArType2IEEEPFControllerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArType2IEEEPFControllerEvent" );
    	this.pFVArType2IEEEPFControllerId = event.getPFVArType2IEEEPFControllerId();
        this.exlon = event.getExlon();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.pfref = event.getPfref();
        this.vclmt = event.getVclmt();
        this.vref = event.getVref();
        this.vs = event.getVs();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArType2IEEEPFControllerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.exlon = event.getExlon();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.pfref = event.getPfref();
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
    private UUID pFVArType2IEEEPFControllerId;
    
    private String exlon;
    private String ki;
    private String kp;
    private String pfref;
    private String vclmt;
    private String vref;
    private String vs;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEPFControllerAggregate.class.getName());
}
