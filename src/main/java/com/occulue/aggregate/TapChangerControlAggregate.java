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
 * Aggregate handler for TapChangerControl as outlined for the CQRS pattern, all write responsibilities 
 * related to TapChangerControl are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TapChangerControlAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TapChangerControlAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TapChangerControlAggregate(CreateTapChangerControlCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTapChangerControlCommand" );
    	CreateTapChangerControlEvent event = new CreateTapChangerControlEvent(command.getTapChangerControlId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTapChangerControlCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTapChangerControlCommand" );
    	UpdateTapChangerControlEvent event = new UpdateTapChangerControlEvent(command.getTapChangerControlId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTapChangerControlCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTapChangerControlCommand" );
        apply(new DeleteTapChangerControlEvent(command.getTapChangerControlId()));
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
    void on(CreateTapChangerControlEvent event) {	
    	LOGGER.info( "Event sourcing CreateTapChangerControlEvent" );
    	this.tapChangerControlId = event.getTapChangerControlId();
    }
    
    @EventSourcingHandler
    void on(UpdateTapChangerControlEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID tapChangerControlId;
    

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerControlAggregate.class.getName());
}
