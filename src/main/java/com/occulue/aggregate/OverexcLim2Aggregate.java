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
 * Aggregate handler for OverexcLim2 as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcLim2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcLim2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcLim2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcLim2Aggregate(CreateOverexcLim2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcLim2Command" );
    	CreateOverexcLim2Event event = new CreateOverexcLim2Event(command.getOverexcLim2Id(), command.getIfdlim(), command.getKoi(), command.getVoimax(), command.getVoimin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcLim2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcLim2Command" );
    	UpdateOverexcLim2Event event = new UpdateOverexcLim2Event(command.getOverexcLim2Id(), command.getIfdlim(), command.getKoi(), command.getVoimax(), command.getVoimin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcLim2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcLim2Command" );
        apply(new DeleteOverexcLim2Event(command.getOverexcLim2Id()));
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
    void on(CreateOverexcLim2Event event) {	
    	LOGGER.info( "Event sourcing CreateOverexcLim2Event" );
    	this.overexcLim2Id = event.getOverexcLim2Id();
        this.ifdlim = event.getIfdlim();
        this.koi = event.getKoi();
        this.voimax = event.getVoimax();
        this.voimin = event.getVoimin();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcLim2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ifdlim = event.getIfdlim();
        this.koi = event.getKoi();
        this.voimax = event.getVoimax();
        this.voimin = event.getVoimin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID overexcLim2Id;
    
    private String ifdlim;
    private String koi;
    private String voimax;
    private String voimin;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLim2Aggregate.class.getName());
}
