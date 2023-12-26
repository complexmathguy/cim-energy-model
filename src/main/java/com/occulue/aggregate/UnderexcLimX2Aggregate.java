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
 * Aggregate handler for UnderexcLimX2 as outlined for the CQRS pattern, all write responsibilities 
 * related to UnderexcLimX2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class UnderexcLimX2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public UnderexcLimX2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public UnderexcLimX2Aggregate(CreateUnderexcLimX2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateUnderexcLimX2Command" );
    	CreateUnderexcLimX2Event event = new CreateUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getKf2(), command.getKm(), command.getMelmax(), command.getQo(), command.getR(), command.getTf2(), command.getTm());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateUnderexcLimX2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateUnderexcLimX2Command" );
    	UpdateUnderexcLimX2Event event = new UpdateUnderexcLimX2Event(command.getUnderexcLimX2Id(), command.getKf2(), command.getKm(), command.getMelmax(), command.getQo(), command.getR(), command.getTf2(), command.getTm());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteUnderexcLimX2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteUnderexcLimX2Command" );
        apply(new DeleteUnderexcLimX2Event(command.getUnderexcLimX2Id()));
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
    void on(CreateUnderexcLimX2Event event) {	
    	LOGGER.info( "Event sourcing CreateUnderexcLimX2Event" );
    	this.underexcLimX2Id = event.getUnderexcLimX2Id();
        this.kf2 = event.getKf2();
        this.km = event.getKm();
        this.melmax = event.getMelmax();
        this.qo = event.getQo();
        this.r = event.getR();
        this.tf2 = event.getTf2();
        this.tm = event.getTm();
    }
    
    @EventSourcingHandler
    void on(UpdateUnderexcLimX2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.kf2 = event.getKf2();
        this.km = event.getKm();
        this.melmax = event.getMelmax();
        this.qo = event.getQo();
        this.r = event.getR();
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
    private UUID underexcLimX2Id;
    
    private String kf2;
    private String km;
    private String melmax;
    private String qo;
    private String r;
    private String tf2;
    private String tm;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimX2Aggregate.class.getName());
}
