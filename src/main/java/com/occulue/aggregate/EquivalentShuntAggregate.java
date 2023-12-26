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
 * Aggregate handler for EquivalentShunt as outlined for the CQRS pattern, all write responsibilities 
 * related to EquivalentShunt are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquivalentShuntAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquivalentShuntAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquivalentShuntAggregate(CreateEquivalentShuntCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquivalentShuntCommand" );
    	CreateEquivalentShuntEvent event = new CreateEquivalentShuntEvent(command.getEquivalentShuntId(), command.getB(), command.getG());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquivalentShuntCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquivalentShuntCommand" );
    	UpdateEquivalentShuntEvent event = new UpdateEquivalentShuntEvent(command.getEquivalentShuntId(), command.getB(), command.getG());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquivalentShuntCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquivalentShuntCommand" );
        apply(new DeleteEquivalentShuntEvent(command.getEquivalentShuntId()));
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
    void on(CreateEquivalentShuntEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquivalentShuntEvent" );
    	this.equivalentShuntId = event.getEquivalentShuntId();
        this.b = event.getB();
        this.g = event.getG();
    }
    
    @EventSourcingHandler
    void on(UpdateEquivalentShuntEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b = event.getB();
        this.g = event.getG();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID equivalentShuntId;
    
    private String b;
    private String g;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentShuntAggregate.class.getName());
}
