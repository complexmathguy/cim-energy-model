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
 * Aggregate handler for PhaseTapChangerSymmetrical as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerSymmetrical are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerSymmetricalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerSymmetricalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerSymmetricalAggregate(CreatePhaseTapChangerSymmetricalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerSymmetricalCommand" );
    	CreatePhaseTapChangerSymmetricalEvent event = new CreatePhaseTapChangerSymmetricalEvent(command.getPhaseTapChangerSymmetricalId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerSymmetricalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerSymmetricalCommand" );
    	UpdatePhaseTapChangerSymmetricalEvent event = new UpdatePhaseTapChangerSymmetricalEvent(command.getPhaseTapChangerSymmetricalId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerSymmetricalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerSymmetricalCommand" );
        apply(new DeletePhaseTapChangerSymmetricalEvent(command.getPhaseTapChangerSymmetricalId()));
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
    void on(CreatePhaseTapChangerSymmetricalEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerSymmetricalEvent" );
    	this.phaseTapChangerSymmetricalId = event.getPhaseTapChangerSymmetricalId();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerSymmetricalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerSymmetricalId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerSymmetricalAggregate.class.getName());
}
