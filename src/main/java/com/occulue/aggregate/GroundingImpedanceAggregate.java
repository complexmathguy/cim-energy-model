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
 * Aggregate handler for GroundingImpedance as outlined for the CQRS pattern, all write responsibilities 
 * related to GroundingImpedance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GroundingImpedanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GroundingImpedanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GroundingImpedanceAggregate(CreateGroundingImpedanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGroundingImpedanceCommand" );
    	CreateGroundingImpedanceEvent event = new CreateGroundingImpedanceEvent(command.getGroundingImpedanceId(), command.getX());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGroundingImpedanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGroundingImpedanceCommand" );
    	UpdateGroundingImpedanceEvent event = new UpdateGroundingImpedanceEvent(command.getGroundingImpedanceId(), command.getX());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGroundingImpedanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGroundingImpedanceCommand" );
        apply(new DeleteGroundingImpedanceEvent(command.getGroundingImpedanceId()));
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
    void on(CreateGroundingImpedanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateGroundingImpedanceEvent" );
    	this.groundingImpedanceId = event.getGroundingImpedanceId();
        this.x = event.getX();
    }
    
    @EventSourcingHandler
    void on(UpdateGroundingImpedanceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.x = event.getX();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID groundingImpedanceId;
    
    private String x;

    private static final Logger LOGGER 	= Logger.getLogger(GroundingImpedanceAggregate.class.getName());
}
