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
 * Aggregate handler for WindContRotorRIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContRotorRIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContRotorRIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContRotorRIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContRotorRIECAggregate(CreateWindContRotorRIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContRotorRIECCommand" );
    	CreateWindContRotorRIECEvent event = new CreateWindContRotorRIECEvent(command.getWindContRotorRIECId(), command.getKirr(), command.getKomegafilt(), command.getKpfilt(), command.getKprr(), command.getRmax(), command.getRmin(), command.getTomegafilt(), command.getTpfilt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContRotorRIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContRotorRIECCommand" );
    	UpdateWindContRotorRIECEvent event = new UpdateWindContRotorRIECEvent(command.getWindContRotorRIECId(), command.getKirr(), command.getKomegafilt(), command.getKpfilt(), command.getKprr(), command.getRmax(), command.getRmin(), command.getTomegafilt(), command.getTpfilt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContRotorRIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContRotorRIECCommand" );
        apply(new DeleteWindContRotorRIECEvent(command.getWindContRotorRIECId()));
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
    void on(CreateWindContRotorRIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContRotorRIECEvent" );
    	this.windContRotorRIECId = event.getWindContRotorRIECId();
        this.kirr = event.getKirr();
        this.komegafilt = event.getKomegafilt();
        this.kpfilt = event.getKpfilt();
        this.kprr = event.getKprr();
        this.rmax = event.getRmax();
        this.rmin = event.getRmin();
        this.tomegafilt = event.getTomegafilt();
        this.tpfilt = event.getTpfilt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContRotorRIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kirr = event.getKirr();
        this.komegafilt = event.getKomegafilt();
        this.kpfilt = event.getKpfilt();
        this.kprr = event.getKprr();
        this.rmax = event.getRmax();
        this.rmin = event.getRmin();
        this.tomegafilt = event.getTomegafilt();
        this.tpfilt = event.getTpfilt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContRotorRIECId;
    
    private String kirr;
    private String komegafilt;
    private String kpfilt;
    private String kprr;
    private String rmax;
    private String rmin;
    private String tomegafilt;
    private String tpfilt;

    private static final Logger LOGGER 	= Logger.getLogger(WindContRotorRIECAggregate.class.getName());
}
