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
 * Aggregate handler for PhaseTapChangerTable as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerTable are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerTableAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerTableAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerTableAggregate(CreatePhaseTapChangerTableCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerTableCommand" );
    	CreatePhaseTapChangerTableEvent event = new CreatePhaseTapChangerTableEvent(command.getPhaseTapChangerTableId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerTableCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerTableCommand" );
    	UpdatePhaseTapChangerTableEvent event = new UpdatePhaseTapChangerTableEvent(command.getPhaseTapChangerTableId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerTableCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerTableCommand" );
        apply(new DeletePhaseTapChangerTableEvent(command.getPhaseTapChangerTableId()));
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
    void on(CreatePhaseTapChangerTableEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerTableEvent" );
    	this.phaseTapChangerTableId = event.getPhaseTapChangerTableId();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerTableEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerTableId;
    

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTableAggregate.class.getName());
}
