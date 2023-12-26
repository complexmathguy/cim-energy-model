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
 * Aggregate handler for PhaseTapChangerTabular as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerTabular are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerTabularAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerTabularAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerTabularAggregate(CreatePhaseTapChangerTabularCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerTabularCommand" );
    	CreatePhaseTapChangerTabularEvent event = new CreatePhaseTapChangerTabularEvent(command.getPhaseTapChangerTabularId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerTabularCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerTabularCommand" );
    	UpdatePhaseTapChangerTabularEvent event = new UpdatePhaseTapChangerTabularEvent(command.getPhaseTapChangerTabularId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerTabularCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerTabularCommand" );
        apply(new DeletePhaseTapChangerTabularEvent(command.getPhaseTapChangerTabularId()));
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
    void on(CreatePhaseTapChangerTabularEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerTabularEvent" );
    	this.phaseTapChangerTabularId = event.getPhaseTapChangerTabularId();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerTabularEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerTabularId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTabularAggregate.class.getName());
}
