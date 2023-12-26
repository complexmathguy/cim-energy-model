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
 * Aggregate handler for PhaseTapChangerAsymmetrical as outlined for the CQRS pattern, all write responsibilities 
 * related to PhaseTapChangerAsymmetrical are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PhaseTapChangerAsymmetricalAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PhaseTapChangerAsymmetricalAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PhaseTapChangerAsymmetricalAggregate(CreatePhaseTapChangerAsymmetricalCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePhaseTapChangerAsymmetricalCommand" );
    	CreatePhaseTapChangerAsymmetricalEvent event = new CreatePhaseTapChangerAsymmetricalEvent(command.getPhaseTapChangerAsymmetricalId(), command.getWindingConnectionAngle());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePhaseTapChangerAsymmetricalCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePhaseTapChangerAsymmetricalCommand" );
    	UpdatePhaseTapChangerAsymmetricalEvent event = new UpdatePhaseTapChangerAsymmetricalEvent(command.getPhaseTapChangerAsymmetricalId(), command.getWindingConnectionAngle());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePhaseTapChangerAsymmetricalCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePhaseTapChangerAsymmetricalCommand" );
        apply(new DeletePhaseTapChangerAsymmetricalEvent(command.getPhaseTapChangerAsymmetricalId()));
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
    void on(CreatePhaseTapChangerAsymmetricalEvent event) {	
    	LOGGER.info( "Event sourcing CreatePhaseTapChangerAsymmetricalEvent" );
    	this.phaseTapChangerAsymmetricalId = event.getPhaseTapChangerAsymmetricalId();
        this.windingConnectionAngle = event.getWindingConnectionAngle();
    }
    
    @EventSourcingHandler
    void on(UpdatePhaseTapChangerAsymmetricalEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.windingConnectionAngle = event.getWindingConnectionAngle();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID phaseTapChangerAsymmetricalId;
    
    private String windingConnectionAngle;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerAsymmetricalAggregate.class.getName());
}
