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
 * Aggregate handler for BusNameMarker as outlined for the CQRS pattern, all write responsibilities 
 * related to BusNameMarker are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BusNameMarkerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BusNameMarkerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BusNameMarkerAggregate(CreateBusNameMarkerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBusNameMarkerCommand" );
    	CreateBusNameMarkerEvent event = new CreateBusNameMarkerEvent(command.getBusNameMarkerId(), command.getPriority());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBusNameMarkerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBusNameMarkerCommand" );
    	UpdateBusNameMarkerEvent event = new UpdateBusNameMarkerEvent(command.getBusNameMarkerId(), command.getPriority());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBusNameMarkerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBusNameMarkerCommand" );
        apply(new DeleteBusNameMarkerEvent(command.getBusNameMarkerId()));
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
    void on(CreateBusNameMarkerEvent event) {	
    	LOGGER.info( "Event sourcing CreateBusNameMarkerEvent" );
    	this.busNameMarkerId = event.getBusNameMarkerId();
        this.priority = event.getPriority();
    }
    
    @EventSourcingHandler
    void on(UpdateBusNameMarkerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.priority = event.getPriority();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID busNameMarkerId;
    
    private String priority;

    private static final Logger LOGGER 	= Logger.getLogger(BusNameMarkerAggregate.class.getName());
}
