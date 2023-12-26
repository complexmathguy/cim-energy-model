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
 * Aggregate handler for Simple_Float as outlined for the CQRS pattern, all write responsibilities 
 * related to Simple_Float are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class Simple_FloatAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public Simple_FloatAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public Simple_FloatAggregate(CreateSimple_FloatCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSimple_FloatCommand" );
    	CreateSimple_FloatEvent event = new CreateSimple_FloatEvent(command.getSimple_FloatId(), command.getValue());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSimple_FloatCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSimple_FloatCommand" );
    	UpdateSimple_FloatEvent event = new UpdateSimple_FloatEvent(command.getSimple_FloatId(), command.getValue());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSimple_FloatCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSimple_FloatCommand" );
        apply(new DeleteSimple_FloatEvent(command.getSimple_FloatId()));
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
    void on(CreateSimple_FloatEvent event) {	
    	LOGGER.info( "Event sourcing CreateSimple_FloatEvent" );
    	this.simple_FloatId = event.getSimple_FloatId();
        this.value = event.getValue();
    }
    
    @EventSourcingHandler
    void on(UpdateSimple_FloatEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.value = event.getValue();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID simple_FloatId;
    
    private String value;

    private static final Logger LOGGER 	= Logger.getLogger(Simple_FloatAggregate.class.getName());
}
