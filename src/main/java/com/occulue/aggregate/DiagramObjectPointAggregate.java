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
 * Aggregate handler for DiagramObjectPoint as outlined for the CQRS pattern, all write responsibilities 
 * related to DiagramObjectPoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramObjectPointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramObjectPointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramObjectPointAggregate(CreateDiagramObjectPointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramObjectPointCommand" );
    	CreateDiagramObjectPointEvent event = new CreateDiagramObjectPointEvent(command.getDiagramObjectPointId(), command.getSequenceNumber(), command.getXPosition(), command.getYPosition(), command.getZPosition());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramObjectPointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramObjectPointCommand" );
    	UpdateDiagramObjectPointEvent event = new UpdateDiagramObjectPointEvent(command.getDiagramObjectPointId(), command.getSequenceNumber(), command.getXPosition(), command.getYPosition(), command.getZPosition());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramObjectPointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramObjectPointCommand" );
        apply(new DeleteDiagramObjectPointEvent(command.getDiagramObjectPointId()));
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
    void on(CreateDiagramObjectPointEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramObjectPointEvent" );
    	this.diagramObjectPointId = event.getDiagramObjectPointId();
        this.sequenceNumber = event.getSequenceNumber();
        this.xPosition = event.getXPosition();
        this.yPosition = event.getYPosition();
        this.zPosition = event.getZPosition();
    }
    
    @EventSourcingHandler
    void on(UpdateDiagramObjectPointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.sequenceNumber = event.getSequenceNumber();
        this.xPosition = event.getXPosition();
        this.yPosition = event.getYPosition();
        this.zPosition = event.getZPosition();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID diagramObjectPointId;
    
    private String sequenceNumber;
    private String xPosition;
    private String yPosition;
    private String zPosition;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectPointAggregate.class.getName());
}
