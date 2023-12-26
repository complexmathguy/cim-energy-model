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
 * Aggregate handler for PhaseTapChangerLinear as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerLinear are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerLinearAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerLinearAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerLinearAggregate(CreatePhaseTapChangerLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerLinearCommand" );
    	CreatePhaseTapChangerLinearEvent event = new CreatePhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId(), command.getStepPhaseShiftIncrement(), command.getXMax(), command.getXMin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerLinearCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerLinearCommand" );
    	UpdatePhaseTapChangerLinearEvent event = new UpdatePhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId(), command.getStepPhaseShiftIncrement(), command.getXMax(), command.getXMin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerLinearCommand" );
        apply(new DeletePhaseTapChangerLinearEvent(command.getPhaseTapChangerLinearId()));
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
    void on(CreatePhaseTapChangerLinearEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerLinearEvent" );
    	this.phaseTapChangerLinearId = event.getPhaseTapChangerLinearId();
        this.stepPhaseShiftIncrement = event.getStepPhaseShiftIncrement();
        this.xMax = event.getXMax();
        this.xMin = event.getXMin();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerLinearEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.stepPhaseShiftIncrement = event.getStepPhaseShiftIncrement();
        this.xMax = event.getXMax();
        this.xMin = event.getXMin();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerLinearId;
    
    private String stepPhaseShiftIncrement;
    private String xMax;
    private String xMin;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerLinearAggregate.class.getName());
}
