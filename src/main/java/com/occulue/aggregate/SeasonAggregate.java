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
 * Aggregate handler for Season as outlined for the CQRS pattern, all write responsibilities 
 * related to Season are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SeasonAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SeasonAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SeasonAggregate(CreateSeasonCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSeasonCommand" );
    	CreateSeasonEvent event = new CreateSeasonEvent(command.getSeasonId(), command.getEndDate(), command.getStartDate());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSeasonCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSeasonCommand" );
    	UpdateSeasonEvent event = new UpdateSeasonEvent(command.getSeasonId(), command.getEndDate(), command.getStartDate());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSeasonCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSeasonCommand" );
        apply(new DeleteSeasonEvent(command.getSeasonId()));
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
    void on(CreateSeasonEvent event) {	
    	LOGGER.info( "Event sourcing CreateSeasonEvent" );
    	this.seasonId = event.getSeasonId();
        this.endDate = event.getEndDate();
        this.startDate = event.getStartDate();
    }
    
    @EventSourcingHandler
    void on(UpdateSeasonEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.endDate = event.getEndDate();
        this.startDate = event.getStartDate();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID seasonId;
    
    private String endDate;
    private String startDate;

    private static final Logger LOGGER 	= Logger.getLogger(SeasonAggregate.class.getName());
}
