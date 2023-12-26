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
 * Aggregate handler for VisibilityLayer as outlined for the CQRS pattern, all write responsibilities 
 * related to VisibilityLayer are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VisibilityLayerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VisibilityLayerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VisibilityLayerAggregate(CreateVisibilityLayerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVisibilityLayerCommand" );
    	CreateVisibilityLayerEvent event = new CreateVisibilityLayerEvent(command.getVisibilityLayerId(), command.getDrawingOrder());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVisibilityLayerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVisibilityLayerCommand" );
    	UpdateVisibilityLayerEvent event = new UpdateVisibilityLayerEvent(command.getVisibilityLayerId(), command.getDrawingOrder());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVisibilityLayerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVisibilityLayerCommand" );
        apply(new DeleteVisibilityLayerEvent(command.getVisibilityLayerId()));
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
    void on(CreateVisibilityLayerEvent event) {	
    	LOGGER.info( "Event sourcing CreateVisibilityLayerEvent" );
    	this.visibilityLayerId = event.getVisibilityLayerId();
        this.drawingOrder = event.getDrawingOrder();
    }
    
    @EventSourcingHandler
    void on(UpdateVisibilityLayerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.drawingOrder = event.getDrawingOrder();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID visibilityLayerId;
    
    private String drawingOrder;

    private static final Logger LOGGER 	= Logger.getLogger(VisibilityLayerAggregate.class.getName());
}
