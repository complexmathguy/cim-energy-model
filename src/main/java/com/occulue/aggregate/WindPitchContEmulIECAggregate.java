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
 * Aggregate handler for WindPitchContEmulIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindPitchContEmulIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindPitchContEmulIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindPitchContEmulIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindPitchContEmulIECAggregate(CreateWindPitchContEmulIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindPitchContEmulIECCommand" );
    	CreateWindPitchContEmulIECEvent event = new CreateWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId(), command.getKdroop(), command.getKipce(), command.getKomegaaero(), command.getKppce(), command.getOmegaref(), command.getPimax(), command.getPimin(), command.getT1(), command.getT2(), command.getTpe());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindPitchContEmulIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindPitchContEmulIECCommand" );
    	UpdateWindPitchContEmulIECEvent event = new UpdateWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId(), command.getKdroop(), command.getKipce(), command.getKomegaaero(), command.getKppce(), command.getOmegaref(), command.getPimax(), command.getPimin(), command.getT1(), command.getT2(), command.getTpe());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindPitchContEmulIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindPitchContEmulIECCommand" );
        apply(new DeleteWindPitchContEmulIECEvent(command.getWindPitchContEmulIECId()));
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
    void on(CreateWindPitchContEmulIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindPitchContEmulIECEvent" );
    	this.windPitchContEmulIECId = event.getWindPitchContEmulIECId();
        this.kdroop = event.getKdroop();
        this.kipce = event.getKipce();
        this.komegaaero = event.getKomegaaero();
        this.kppce = event.getKppce();
        this.omegaref = event.getOmegaref();
        this.pimax = event.getPimax();
        this.pimin = event.getPimin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.tpe = event.getTpe();
    }
    
    @EventSourcingHandler
    void on(UpdateWindPitchContEmulIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kdroop = event.getKdroop();
        this.kipce = event.getKipce();
        this.komegaaero = event.getKomegaaero();
        this.kppce = event.getKppce();
        this.omegaref = event.getOmegaref();
        this.pimax = event.getPimax();
        this.pimin = event.getPimin();
        this.t1 = event.getT1();
        this.t2 = event.getT2();
        this.tpe = event.getTpe();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windPitchContEmulIECId;
    
    private String kdroop;
    private String kipce;
    private String komegaaero;
    private String kppce;
    private String omegaref;
    private String pimax;
    private String pimin;
    private String t1;
    private String t2;
    private String tpe;

    private static final Logger LOGGER 	= Logger.getLogger(WindPitchContEmulIECAggregate.class.getName());
}
