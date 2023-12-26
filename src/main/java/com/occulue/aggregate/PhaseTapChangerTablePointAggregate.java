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
 * Aggregate handler for PhaseTapChangerTablePoint as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerTablePoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerTablePointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerTablePointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerTablePointAggregate(CreatePhaseTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerTablePointCommand" );
    	CreatePhaseTapChangerTablePointEvent event = new CreatePhaseTapChangerTablePointEvent(command.getPhaseTapChangerTablePointId(), command.getAngle());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerTablePointCommand" );
    	UpdatePhaseTapChangerTablePointEvent event = new UpdatePhaseTapChangerTablePointEvent(command.getPhaseTapChangerTablePointId(), command.getAngle());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerTablePointCommand" );
        apply(new DeletePhaseTapChangerTablePointEvent(command.getPhaseTapChangerTablePointId()));
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
    void on(CreatePhaseTapChangerTablePointEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerTablePointEvent" );
    	this.phaseTapChangerTablePointId = event.getPhaseTapChangerTablePointId();
        this.angle = event.getAngle();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerTablePointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.angle = event.getAngle();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerTablePointId;
    
    private String angle;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTablePointAggregate.class.getName());
}
