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
 * Aggregate handler for OverexcLimIEEE as outlined for the CQRS pattern, all write responsibilities 
 * related to OverexcLimIEEE are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OverexcLimIEEEAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OverexcLimIEEEAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OverexcLimIEEEAggregate(CreateOverexcLimIEEECommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOverexcLimIEEECommand" );
    	CreateOverexcLimIEEEEvent event = new CreateOverexcLimIEEEEvent(command.getOverexcLimIEEEId(), command.getHyst(), command.getIfdlim(), command.getIfdmax(), command.getItfpu(), command.getKcd(), command.getKramp());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOverexcLimIEEECommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOverexcLimIEEECommand" );
    	UpdateOverexcLimIEEEEvent event = new UpdateOverexcLimIEEEEvent(command.getOverexcLimIEEEId(), command.getHyst(), command.getIfdlim(), command.getIfdmax(), command.getItfpu(), command.getKcd(), command.getKramp());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOverexcLimIEEECommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOverexcLimIEEECommand" );
        apply(new DeleteOverexcLimIEEEEvent(command.getOverexcLimIEEEId()));
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
    void on(CreateOverexcLimIEEEEvent event) {	
    	LOGGER.info( "Event sourcing CreateOverexcLimIEEEEvent" );
    	this.overexcLimIEEEId = event.getOverexcLimIEEEId();
        this.hyst = event.getHyst();
        this.ifdlim = event.getIfdlim();
        this.ifdmax = event.getIfdmax();
        this.itfpu = event.getItfpu();
        this.kcd = event.getKcd();
        this.kramp = event.getKramp();
    }
    
    @EventSourcingHandler
    void on(UpdateOverexcLimIEEEEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.hyst = event.getHyst();
        this.ifdlim = event.getIfdlim();
        this.ifdmax = event.getIfdmax();
        this.itfpu = event.getItfpu();
        this.kcd = event.getKcd();
        this.kramp = event.getKramp();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID overexcLimIEEEId;
    
    private String hyst;
    private String ifdlim;
    private String ifdmax;
    private String itfpu;
    private String kcd;
    private String kramp;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimIEEEAggregate.class.getName());
}
