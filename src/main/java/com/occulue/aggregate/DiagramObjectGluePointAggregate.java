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
 * Aggregate handler for DiagramObjectGluePoint as outlined for the CQRS pattern, all write responsibilities 
 * related to DiagramObjectGluePoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramObjectGluePointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramObjectGluePointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramObjectGluePointAggregate(CreateDiagramObjectGluePointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramObjectGluePointCommand" );
    	CreateDiagramObjectGluePointEvent event = new CreateDiagramObjectGluePointEvent(command.getDiagramObjectGluePointId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramObjectGluePointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramObjectGluePointCommand" );
    	UpdateDiagramObjectGluePointEvent event = new UpdateDiagramObjectGluePointEvent(command.getDiagramObjectGluePointId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramObjectGluePointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramObjectGluePointCommand" );
        apply(new DeleteDiagramObjectGluePointEvent(command.getDiagramObjectGluePointId()));
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
    void on(CreateDiagramObjectGluePointEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramObjectGluePointEvent" );
    	this.diagramObjectGluePointId = event.getDiagramObjectGluePointId();
    }
    
    @EventSourcingHandler
    void on(UpdateDiagramObjectGluePointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID diagramObjectGluePointId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectGluePointAggregate.class.getName());
}
