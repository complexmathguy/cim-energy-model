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
 * Aggregate handler for WindDynamicsLookupTable as outlined for the CQRS pattern, all write responsibilities 
 * related to WindDynamicsLookupTable are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindDynamicsLookupTableAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindDynamicsLookupTableAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindDynamicsLookupTableAggregate(CreateWindDynamicsLookupTableCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindDynamicsLookupTableCommand" );
    	CreateWindDynamicsLookupTableEvent event = new CreateWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId(), command.getInput(), command.getLookupTableFunctionType(), command.getOutput(), command.getSequence());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindDynamicsLookupTableCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindDynamicsLookupTableCommand" );
    	UpdateWindDynamicsLookupTableEvent event = new UpdateWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId(), command.getInput(), command.getLookupTableFunctionType(), command.getOutput(), command.getSequence());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindDynamicsLookupTableCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindDynamicsLookupTableCommand" );
        apply(new DeleteWindDynamicsLookupTableEvent(command.getWindDynamicsLookupTableId()));
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
    void on(CreateWindDynamicsLookupTableEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindDynamicsLookupTableEvent" );
    	this.windDynamicsLookupTableId = event.getWindDynamicsLookupTableId();
        this.input = event.getInput();
        this.lookupTableFunctionType = event.getLookupTableFunctionType();
        this.output = event.getOutput();
        this.sequence = event.getSequence();
    }
    
    @EventSourcingHandler
    void on(UpdateWindDynamicsLookupTableEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.input = event.getInput();
        this.lookupTableFunctionType = event.getLookupTableFunctionType();
        this.output = event.getOutput();
        this.sequence = event.getSequence();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windDynamicsLookupTableId;
    
    private String input;
    private String lookupTableFunctionType;
    private String output;
    private String sequence;

    private static final Logger LOGGER 	= Logger.getLogger(WindDynamicsLookupTableAggregate.class.getName());
}
