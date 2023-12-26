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
 * Aggregate handler for DiagramObject as outlined for the CQRS pattern, all write responsibilities 
 * related to DiagramObject are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramObjectAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramObjectAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramObjectAggregate(CreateDiagramObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramObjectCommand" );
    	CreateDiagramObjectEvent event = new CreateDiagramObjectEvent(command.getDiagramObjectId(), command.getDrawingOrder(), command.getIsPolygon(), command.getOffsetX(), command.getOffsetY(), command.getRotation());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramObjectCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramObjectCommand" );
    	UpdateDiagramObjectEvent event = new UpdateDiagramObjectEvent(command.getDiagramObjectId(), command.getDrawingOrder(), command.getIsPolygon(), command.getOffsetX(), command.getOffsetY(), command.getRotation());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramObjectCommand" );
        apply(new DeleteDiagramObjectEvent(command.getDiagramObjectId()));
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
    void on(CreateDiagramObjectEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramObjectEvent" );
    	this.diagramObjectId = event.getDiagramObjectId();
        this.drawingOrder = event.getDrawingOrder();
        this.isPolygon = event.getIsPolygon();
        this.offsetX = event.getOffsetX();
        this.offsetY = event.getOffsetY();
        this.rotation = event.getRotation();
    }
    
    @EventSourcingHandler
    void on(UpdateDiagramObjectEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.drawingOrder = event.getDrawingOrder();
        this.isPolygon = event.getIsPolygon();
        this.offsetX = event.getOffsetX();
        this.offsetY = event.getOffsetY();
        this.rotation = event.getRotation();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID diagramObjectId;
    
    private String drawingOrder;
    private String isPolygon;
    private String offsetX;
    private String offsetY;
    private String rotation;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectAggregate.class.getName());
}
