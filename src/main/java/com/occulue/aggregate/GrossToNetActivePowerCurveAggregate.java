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
 * Aggregate handler for GrossToNetActivePowerCurve as outlined for the CQRS pattern, all write responsibilities 
 * related to GrossToNetActivePowerCurve are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GrossToNetActivePowerCurveAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GrossToNetActivePowerCurveAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GrossToNetActivePowerCurveAggregate(CreateGrossToNetActivePowerCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGrossToNetActivePowerCurveCommand" );
    	CreateGrossToNetActivePowerCurveEvent event = new CreateGrossToNetActivePowerCurveEvent(command.getGrossToNetActivePowerCurveId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGrossToNetActivePowerCurveCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGrossToNetActivePowerCurveCommand" );
    	UpdateGrossToNetActivePowerCurveEvent event = new UpdateGrossToNetActivePowerCurveEvent(command.getGrossToNetActivePowerCurveId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGrossToNetActivePowerCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGrossToNetActivePowerCurveCommand" );
        apply(new DeleteGrossToNetActivePowerCurveEvent(command.getGrossToNetActivePowerCurveId()));
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
    void on(CreateGrossToNetActivePowerCurveEvent event) {	
    	LOGGER.info( "Event sourcing CreateGrossToNetActivePowerCurveEvent" );
    	this.grossToNetActivePowerCurveId = event.getGrossToNetActivePowerCurveId();
    }
    
    @EventSourcingHandler
    void on(UpdateGrossToNetActivePowerCurveEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID grossToNetActivePowerCurveId;
    

    private static final Logger LOGGER 	= Logger.getLogger(GrossToNetActivePowerCurveAggregate.class.getName());
}
