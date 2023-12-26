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
 * Aggregate handler for PhaseTapChanger as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChanger are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerAggregate(CreatePhaseTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerCommand" );
    	CreatePhaseTapChangerEvent event = new CreatePhaseTapChangerEvent(command.getPhaseTapChangerId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerCommand" );
    	UpdatePhaseTapChangerEvent event = new UpdatePhaseTapChangerEvent(command.getPhaseTapChangerId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerCommand" );
        apply(new DeletePhaseTapChangerEvent(command.getPhaseTapChangerId()));
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
    void on(CreatePhaseTapChangerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerEvent" );
    	this.phaseTapChangerId = event.getPhaseTapChangerId();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerAggregate.class.getName());
}
