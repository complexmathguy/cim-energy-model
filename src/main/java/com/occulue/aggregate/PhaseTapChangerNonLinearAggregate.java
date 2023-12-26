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
 * Aggregate handler for PhaseTapChangerNonLinear as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerNonLinear are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerNonLinearAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerNonLinearAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerNonLinearAggregate(CreatePhaseTapChangerNonLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerNonLinearCommand" );
    	CreatePhaseTapChangerNonLinearEvent event = new CreatePhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId(), command.getVoltageStepIncrement(), command.getXMax(), command.getXMin());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerNonLinearCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerNonLinearCommand" );
    	UpdatePhaseTapChangerNonLinearEvent event = new UpdatePhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId(), command.getVoltageStepIncrement(), command.getXMax(), command.getXMin());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerNonLinearCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerNonLinearCommand" );
        apply(new DeletePhaseTapChangerNonLinearEvent(command.getPhaseTapChangerNonLinearId()));
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
    void on(CreatePhaseTapChangerNonLinearEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerNonLinearEvent" );
    	this.phaseTapChangerNonLinearId = event.getPhaseTapChangerNonLinearId();
        this.voltageStepIncrement = event.getVoltageStepIncrement();
        this.xMax = event.getXMax();
        this.xMin = event.getXMin();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerNonLinearEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.voltageStepIncrement = event.getVoltageStepIncrement();
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
    private UUID phaseTapChangerNonLinearId;
    
    private String voltageStepIncrement;
    private String xMax;
    private String xMin;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerNonLinearAggregate.class.getName());
}
