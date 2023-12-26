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
 * Aggregate handler for RegulatingCondEq as outlined for the CQRS pattern, all write responsibilities 
 * related to RegulatingCondEq are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RegulatingCondEqAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RegulatingCondEqAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RegulatingCondEqAggregate(CreateRegulatingCondEqCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRegulatingCondEqCommand" );
    	CreateRegulatingCondEqEvent event = new CreateRegulatingCondEqEvent(command.getRegulatingCondEqId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRegulatingCondEqCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRegulatingCondEqCommand" );
    	UpdateRegulatingCondEqEvent event = new UpdateRegulatingCondEqEvent(command.getRegulatingCondEqId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRegulatingCondEqCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRegulatingCondEqCommand" );
        apply(new DeleteRegulatingCondEqEvent(command.getRegulatingCondEqId()));
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
    void on(CreateRegulatingCondEqEvent event) {	
    	LOGGER.info( "Event sourcing CreateRegulatingCondEqEvent" );
    	this.regulatingCondEqId = event.getRegulatingCondEqId();
    }
    
    @EventSourcingHandler
    void on(UpdateRegulatingCondEqEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID regulatingCondEqId;
    

    private static final Logger LOGGER 	= Logger.getLogger(RegulatingCondEqAggregate.class.getName());
}
