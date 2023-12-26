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
 * Aggregate handler for WindContPType4aIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContPType4aIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContPType4aIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContPType4aIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContPType4aIECAggregate(CreateWindContPType4aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContPType4aIECCommand" );
    	CreateWindContPType4aIECEvent event = new CreateWindContPType4aIECEvent(command.getWindContPType4aIECId(), command.getDpmax(), command.getTpord(), command.getTufilt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContPType4aIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContPType4aIECCommand" );
    	UpdateWindContPType4aIECEvent event = new UpdateWindContPType4aIECEvent(command.getWindContPType4aIECId(), command.getDpmax(), command.getTpord(), command.getTufilt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContPType4aIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContPType4aIECCommand" );
        apply(new DeleteWindContPType4aIECEvent(command.getWindContPType4aIECId()));
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
    void on(CreateWindContPType4aIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContPType4aIECEvent" );
    	this.windContPType4aIECId = event.getWindContPType4aIECId();
        this.dpmax = event.getDpmax();
        this.tpord = event.getTpord();
        this.tufilt = event.getTufilt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContPType4aIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dpmax = event.getDpmax();
        this.tpord = event.getTpord();
        this.tufilt = event.getTufilt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windContPType4aIECId;
    
    private String dpmax;
    private String tpord;
    private String tufilt;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType4aIECAggregate.class.getName());
}
