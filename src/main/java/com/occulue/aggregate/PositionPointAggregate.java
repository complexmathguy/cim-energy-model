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
 * Aggregate handler for PositionPoint as outlined for the CQRS pattern, all write responsibilities 
 * related to PositionPoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PositionPointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PositionPointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PositionPointAggregate(CreatePositionPointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePositionPointCommand" );
    	CreatePositionPointEvent event = new CreatePositionPointEvent(command.getPositionPointId(), command.getSequenceNumber(), command.getXPosition(), command.getYPosition(), command.getZPosition());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePositionPointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePositionPointCommand" );
    	UpdatePositionPointEvent event = new UpdatePositionPointEvent(command.getPositionPointId(), command.getSequenceNumber(), command.getXPosition(), command.getYPosition(), command.getZPosition());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePositionPointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePositionPointCommand" );
        apply(new DeletePositionPointEvent(command.getPositionPointId()));
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
    void on(CreatePositionPointEvent event) {	
    	LOGGER.info( "Event sourcing CreatePositionPointEvent" );
    	this.positionPointId = event.getPositionPointId();
        this.sequenceNumber = event.getSequenceNumber();
        this.xPosition = event.getXPosition();
        this.yPosition = event.getYPosition();
        this.zPosition = event.getZPosition();
    }
    
    @EventSourcingHandler
    void on(UpdatePositionPointEvent event) {
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
    private UUID positionPointId;
    
    private String sequenceNumber;
    private String xPosition;
    private String yPosition;
    private String zPosition;

    private static final Logger LOGGER 	= Logger.getLogger(PositionPointAggregate.class.getName());
}
