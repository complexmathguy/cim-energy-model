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
 * Aggregate handler for PFVArType1IEEEVArController as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArType1IEEEVArController are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArType1IEEEVArControllerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArType1IEEEVArControllerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArType1IEEEVArControllerAggregate(CreatePFVArType1IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArType1IEEEVArControllerCommand" );
    	CreatePFVArType1IEEEVArControllerEvent event = new CreatePFVArType1IEEEVArControllerEvent(command.getPFVArType1IEEEVArControllerId(), command.getTvarc(), command.getVvar(), command.getVvarcbw(), command.getVvarref(), command.getVvtmax(), command.getVvtmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArType1IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArType1IEEEVArControllerCommand" );
    	UpdatePFVArType1IEEEVArControllerEvent event = new UpdatePFVArType1IEEEVArControllerEvent(command.getPFVArType1IEEEVArControllerId(), command.getTvarc(), command.getVvar(), command.getVvarcbw(), command.getVvarref(), command.getVvtmax(), command.getVvtmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArType1IEEEVArControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArType1IEEEVArControllerCommand" );
        apply(new DeletePFVArType1IEEEVArControllerEvent(command.getPFVArType1IEEEVArControllerId()));
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
    void on(CreatePFVArType1IEEEVArControllerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArType1IEEEVArControllerEvent" );
    	this.pFVArType1IEEEVArControllerId = event.getPFVArType1IEEEVArControllerId();
        this.tvarc = event.getTvarc();
        this.vvar = event.getVvar();
        this.vvarcbw = event.getVvarcbw();
        this.vvarref = event.getVvarref();
        this.vvtmax = event.getVvtmax();
        this.vvtmin = event.getVvtmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArType1IEEEVArControllerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.tvarc = event.getTvarc();
        this.vvar = event.getVvar();
        this.vvarcbw = event.getVvarcbw();
        this.vvarref = event.getVvarref();
        this.vvtmax = event.getVvtmax();
        this.vvtmin = event.getVvtmin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pFVArType1IEEEVArControllerId;
    
    private String tvarc;
    private String vvar;
    private String vvarcbw;
    private String vvarref;
    private String vvtmax;
    private String vvtmin;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEVArControllerAggregate.class.getName());
}
