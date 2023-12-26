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
 * Aggregate handler for Diagram as outlined for the CQRS pattern, all write responsibilities 
 * related to Diagram are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramAggregate(CreateDiagramCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramCommand" );
    	CreateDiagramEvent event = new CreateDiagramEvent(command.getDiagramId(), command.getOrientation(), command.getX1InitialView(), command.getX2InitialView(), command.getY1InitialView(), command.getY2InitialView());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramCommand" );
    	UpdateDiagramEvent event = new UpdateDiagramEvent(command.getDiagramId(), command.getOrientation(), command.getX1InitialView(), command.getX2InitialView(), command.getY1InitialView(), command.getY2InitialView());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramCommand" );
        apply(new DeleteDiagramEvent(command.getDiagramId()));
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
    void on(CreateDiagramEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramEvent" );
    	this.diagramId = event.getDiagramId();
        this.orientation = event.getOrientation();
        this.x1InitialView = event.getX1InitialView();
        this.x2InitialView = event.getX2InitialView();
        this.y1InitialView = event.getY1InitialView();
        this.y2InitialView = event.getY2InitialView();
    }
    
    @EventSourcingHandler
    void on(UpdateDiagramEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.orientation = event.getOrientation();
        this.x1InitialView = event.getX1InitialView();
        this.x2InitialView = event.getX2InitialView();
        this.y1InitialView = event.getY1InitialView();
        this.y2InitialView = event.getY2InitialView();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID diagramId;
    
    private String orientation;
    private String x1InitialView;
    private String x2InitialView;
    private String y1InitialView;
    private String y2InitialView;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramAggregate.class.getName());
}
