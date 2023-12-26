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
 * Aggregate handler for NonlinearShuntCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to NonlinearShuntCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class NonlinearShuntCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public NonlinearShuntCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public NonlinearShuntCompensatorAggregate(CreateNonlinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateNonlinearShuntCompensatorCommand" );
    	CreateNonlinearShuntCompensatorEvent event = new CreateNonlinearShuntCompensatorEvent(command.getNonlinearShuntCompensatorId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateNonlinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateNonlinearShuntCompensatorCommand" );
    	UpdateNonlinearShuntCompensatorEvent event = new UpdateNonlinearShuntCompensatorEvent(command.getNonlinearShuntCompensatorId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteNonlinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteNonlinearShuntCompensatorCommand" );
        apply(new DeleteNonlinearShuntCompensatorEvent(command.getNonlinearShuntCompensatorId()));
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
    void on(CreateNonlinearShuntCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateNonlinearShuntCompensatorEvent" );
    	this.nonlinearShuntCompensatorId = event.getNonlinearShuntCompensatorId();
    }
    
    @EventSourcingHandler
    void on(UpdateNonlinearShuntCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID nonlinearShuntCompensatorId;
    

    private static final Logger LOGGER 	= Logger.getLogger(NonlinearShuntCompensatorAggregate.class.getName());
}
