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
 * Aggregate handler for UnderexcLimX1 as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcLimX1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcLimX1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcLimX1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcLimX1Aggregate(CreateUnderexcLimX1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcLimX1Command" );
    	CreateUnderexcLimX1Event event = new CreateUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getK(), command.getKf2(), command.getKm(), command.getMelmax(), command.getTf2(), command.getTm());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcLimX1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcLimX1Command" );
    	UpdateUnderexcLimX1Event event = new UpdateUnderexcLimX1Event(command.getUnderexcLimX1Id(), command.getK(), command.getKf2(), command.getKm(), command.getMelmax(), command.getTf2(), command.getTm());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcLimX1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcLimX1Command" );
        apply(new DeleteUnderexcLimX1Event(command.getUnderexcLimX1Id()));
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
    void on(CreateUnderexcLimX1Event event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcLimX1Event" );
    	this.underexcLimX1Id = event.getUnderexcLimX1Id();
        this.k = event.getK();
        this.kf2 = event.getKf2();
        this.km = event.getKm();
        this.melmax = event.getMelmax();
        this.tf2 = event.getTf2();
        this.tm = event.getTm();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcLimX1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.k = event.getK();
        this.kf2 = event.getKf2();
        this.km = event.getKm();
        this.melmax = event.getMelmax();
        this.tf2 = event.getTf2();
        this.tm = event.getTm();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID underexcLimX1Id;
    
    private String k;
    private String kf2;
    private String km;
    private String melmax;
    private String tf2;
    private String tm;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimX1Aggregate.class.getName());
}
