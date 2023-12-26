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
 * Aggregate handler for PFVArType1IEEEPFController as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArType1IEEEPFController are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArType1IEEEPFControllerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArType1IEEEPFControllerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArType1IEEEPFControllerAggregate(CreatePFVArType1IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArType1IEEEPFControllerCommand" );
    	CreatePFVArType1IEEEPFControllerEvent event = new CreatePFVArType1IEEEPFControllerEvent(command.getPFVArType1IEEEPFControllerId(), command.getOvex(), command.getTpfc(), command.getVitmin(), command.getVpf(), command.getVpfcbw(), command.getVpfref(), command.getVvtmax(), command.getVvtmin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArType1IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArType1IEEEPFControllerCommand" );
    	UpdatePFVArType1IEEEPFControllerEvent event = new UpdatePFVArType1IEEEPFControllerEvent(command.getPFVArType1IEEEPFControllerId(), command.getOvex(), command.getTpfc(), command.getVitmin(), command.getVpf(), command.getVpfcbw(), command.getVpfref(), command.getVvtmax(), command.getVvtmin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArType1IEEEPFControllerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArType1IEEEPFControllerCommand" );
        apply(new DeletePFVArType1IEEEPFControllerEvent(command.getPFVArType1IEEEPFControllerId()));
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
    void on(CreatePFVArType1IEEEPFControllerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePFVArType1IEEEPFControllerEvent" );
    	this.pFVArType1IEEEPFControllerId = event.getPFVArType1IEEEPFControllerId();
        this.ovex = event.getOvex();
        this.tpfc = event.getTpfc();
        this.vitmin = event.getVitmin();
        this.vpf = event.getVpf();
        this.vpfcbw = event.getVpfcbw();
        this.vpfref = event.getVpfref();
        this.vvtmax = event.getVvtmax();
        this.vvtmin = event.getVvtmin();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArType1IEEEPFControllerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ovex = event.getOvex();
        this.tpfc = event.getTpfc();
        this.vitmin = event.getVitmin();
        this.vpf = event.getVpf();
        this.vpfcbw = event.getVpfcbw();
        this.vpfref = event.getVpfref();
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
    private UUID pFVArType1IEEEPFControllerId;
    
    private String ovex;
    private String tpfc;
    private String vitmin;
    private String vpf;
    private String vpfcbw;
    private String vpfref;
    private String vvtmax;
    private String vvtmin;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEPFControllerAggregate.class.getName());
}
