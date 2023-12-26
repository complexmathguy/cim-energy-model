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
 * Aggregate handler for Command as outlined for the CQRS pattern, all write responsibilities 
 * related to Command are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CommandAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CommandAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CommandAggregate(CreateCommandCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCommandCommand" );
    	CreateCommandEvent event = new CreateCommandEvent(command.getCommandId(), command.getNormalValue(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCommandCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCommandCommand" );
    	UpdateCommandEvent event = new UpdateCommandEvent(command.getCommandId(), command.getNormalValue(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCommandCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCommandCommand" );
        apply(new DeleteCommandEvent(command.getCommandId()));
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
    void on(CreateCommandEvent event) {	
    	LOGGER.info( "Event sourcing CreateCommandEvent" );
    	this.commandId = event.getCommandId();
        this.normalValue = event.getNormalValue();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateCommandEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.normalValue = event.getNormalValue();
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID commandId;
    
    private String normalValue;
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(CommandAggregate.class.getName());
}
