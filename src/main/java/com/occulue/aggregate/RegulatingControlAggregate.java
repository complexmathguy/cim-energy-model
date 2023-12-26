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
 * Aggregate handler for RegulatingControl as outlined for the CQRS pattern, all write responsibilities 
 * related to RegulatingControl are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RegulatingControlAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RegulatingControlAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RegulatingControlAggregate(CreateRegulatingControlCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRegulatingControlCommand" );
    	CreateRegulatingControlEvent event = new CreateRegulatingControlEvent(command.getRegulatingControlId(), command.getMode());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRegulatingControlCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRegulatingControlCommand" );
    	UpdateRegulatingControlEvent event = new UpdateRegulatingControlEvent(command.getRegulatingControlId(), command.getMode());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRegulatingControlCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRegulatingControlCommand" );
        apply(new DeleteRegulatingControlEvent(command.getRegulatingControlId()));
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
    void on(CreateRegulatingControlEvent event) {	
    	LOGGER.info( "Event sourcing CreateRegulatingControlEvent" );
    	this.regulatingControlId = event.getRegulatingControlId();
        this.mode = event.getMode();
    }
    
    @EventSourcingHandler
    void on(UpdateRegulatingControlEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.mode = event.getMode();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID regulatingControlId;
    
    private String mode;

    private static final Logger LOGGER 	= Logger.getLogger(RegulatingControlAggregate.class.getName());
}
