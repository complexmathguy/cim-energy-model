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
 * Aggregate handler for CoordinateSystem as outlined for the CQRS pattern, all write responsibilities 
 * related to CoordinateSystem are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CoordinateSystemAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CoordinateSystemAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CoordinateSystemAggregate(CreateCoordinateSystemCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCoordinateSystemCommand" );
    	CreateCoordinateSystemEvent event = new CreateCoordinateSystemEvent(command.getCoordinateSystemId(), command.getCrsUrn());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCoordinateSystemCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCoordinateSystemCommand" );
    	UpdateCoordinateSystemEvent event = new UpdateCoordinateSystemEvent(command.getCoordinateSystemId(), command.getCrsUrn());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCoordinateSystemCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCoordinateSystemCommand" );
        apply(new DeleteCoordinateSystemEvent(command.getCoordinateSystemId()));
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
    void on(CreateCoordinateSystemEvent event) {	
    	LOGGER.info( "Event sourcing CreateCoordinateSystemEvent" );
    	this.coordinateSystemId = event.getCoordinateSystemId();
        this.crsUrn = event.getCrsUrn();
    }
    
    @EventSourcingHandler
    void on(UpdateCoordinateSystemEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.crsUrn = event.getCrsUrn();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID coordinateSystemId;
    
    private String crsUrn;

    private static final Logger LOGGER 	= Logger.getLogger(CoordinateSystemAggregate.class.getName());
}
