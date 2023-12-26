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
 * Aggregate handler for SvTapStep as outlined for the CQRS pattern, all write responsibilities 
 * related to SvTapStep are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SvTapStepAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SvTapStepAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SvTapStepAggregate(CreateSvTapStepCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSvTapStepCommand" );
    	CreateSvTapStepEvent event = new CreateSvTapStepEvent(command.getSvTapStepId(), command.getPosition());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSvTapStepCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSvTapStepCommand" );
    	UpdateSvTapStepEvent event = new UpdateSvTapStepEvent(command.getSvTapStepId(), command.getPosition());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSvTapStepCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSvTapStepCommand" );
        apply(new DeleteSvTapStepEvent(command.getSvTapStepId()));
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
    void on(CreateSvTapStepEvent event) {	
    	LOGGER.info( "Event sourcing CreateSvTapStepEvent" );
    	this.svTapStepId = event.getSvTapStepId();
        this.position = event.getPosition();
    }
    
    @EventSourcingHandler
    void on(UpdateSvTapStepEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.position = event.getPosition();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID svTapStepId;
    
    private String position;

    private static final Logger LOGGER 	= Logger.getLogger(SvTapStepAggregate.class.getName());
}
