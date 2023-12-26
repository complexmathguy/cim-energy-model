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
 * Aggregate handler for WindContPType4bIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindContPType4bIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindContPType4bIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindContPType4bIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindContPType4bIECAggregate(CreateWindContPType4bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindContPType4bIECCommand" );
    	CreateWindContPType4bIECEvent event = new CreateWindContPType4bIECEvent(command.getWindContPType4bIECId(), command.getDpmax(), command.getTpaero(), command.getTpord(), command.getTufilt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindContPType4bIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindContPType4bIECCommand" );
    	UpdateWindContPType4bIECEvent event = new UpdateWindContPType4bIECEvent(command.getWindContPType4bIECId(), command.getDpmax(), command.getTpaero(), command.getTpord(), command.getTufilt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindContPType4bIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindContPType4bIECCommand" );
        apply(new DeleteWindContPType4bIECEvent(command.getWindContPType4bIECId()));
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
    void on(CreateWindContPType4bIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindContPType4bIECEvent" );
    	this.windContPType4bIECId = event.getWindContPType4bIECId();
        this.dpmax = event.getDpmax();
        this.tpaero = event.getTpaero();
        this.tpord = event.getTpord();
        this.tufilt = event.getTufilt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindContPType4bIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dpmax = event.getDpmax();
        this.tpaero = event.getTpaero();
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
    private UUID windContPType4bIECId;
    
    private String dpmax;
    private String tpaero;
    private String tpord;
    private String tufilt;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType4bIECAggregate.class.getName());
}
