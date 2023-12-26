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
 * Aggregate handler for DiagramStyle as outlined for the CQRS pattern, all write responsibilities 
 * related to DiagramStyle are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramStyleAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramStyleAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramStyleAggregate(CreateDiagramStyleCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramStyleCommand" );
    	CreateDiagramStyleEvent event = new CreateDiagramStyleEvent(command.getDiagramStyleId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramStyleCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramStyleCommand" );
    	UpdateDiagramStyleEvent event = new UpdateDiagramStyleEvent(command.getDiagramStyleId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramStyleCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramStyleCommand" );
        apply(new DeleteDiagramStyleEvent(command.getDiagramStyleId()));
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
    void on(CreateDiagramStyleEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramStyleEvent" );
    	this.diagramStyleId = event.getDiagramStyleId();
    }
    
    @EventSourcingHandler
    void on(UpdateDiagramStyleEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID diagramStyleId;
    

    private static final Logger LOGGER 	= Logger.getLogger(DiagramStyleAggregate.class.getName());
}
