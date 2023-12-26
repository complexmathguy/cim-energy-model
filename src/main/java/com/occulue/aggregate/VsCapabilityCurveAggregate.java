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
 * Aggregate handler for VsCapabilityCurve as outlined for the CQRS pattern, all write responsibilities 
 * related to VsCapabilityCurve are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VsCapabilityCurveAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VsCapabilityCurveAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VsCapabilityCurveAggregate(CreateVsCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVsCapabilityCurveCommand" );
    	CreateVsCapabilityCurveEvent event = new CreateVsCapabilityCurveEvent(command.getVsCapabilityCurveId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVsCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVsCapabilityCurveCommand" );
    	UpdateVsCapabilityCurveEvent event = new UpdateVsCapabilityCurveEvent(command.getVsCapabilityCurveId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVsCapabilityCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVsCapabilityCurveCommand" );
        apply(new DeleteVsCapabilityCurveEvent(command.getVsCapabilityCurveId()));
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
    void on(CreateVsCapabilityCurveEvent event) {	
    	LOGGER.info( "Event sourcing CreateVsCapabilityCurveEvent" );
    	this.vsCapabilityCurveId = event.getVsCapabilityCurveId();
    }
    
    @EventSourcingHandler
    void on(UpdateVsCapabilityCurveEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID vsCapabilityCurveId;
    

    private static final Logger LOGGER 	= Logger.getLogger(VsCapabilityCurveAggregate.class.getName());
}
