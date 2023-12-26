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
 * Aggregate handler for NuclearGeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to NuclearGeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class NuclearGeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public NuclearGeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public NuclearGeneratingUnitAggregate(CreateNuclearGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateNuclearGeneratingUnitCommand" );
    	CreateNuclearGeneratingUnitEvent event = new CreateNuclearGeneratingUnitEvent(command.getNuclearGeneratingUnitId());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateNuclearGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateNuclearGeneratingUnitCommand" );
    	UpdateNuclearGeneratingUnitEvent event = new UpdateNuclearGeneratingUnitEvent(command.getNuclearGeneratingUnitId());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteNuclearGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteNuclearGeneratingUnitCommand" );
        apply(new DeleteNuclearGeneratingUnitEvent(command.getNuclearGeneratingUnitId()));
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
    void on(CreateNuclearGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateNuclearGeneratingUnitEvent" );
    	this.nuclearGeneratingUnitId = event.getNuclearGeneratingUnitId();
    }
    
    @EventSourcingHandler
    void on(UpdateNuclearGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID nuclearGeneratingUnitId;
    

    private static final Logger LOGGER 	= Logger.getLogger(NuclearGeneratingUnitAggregate.class.getName());
}
