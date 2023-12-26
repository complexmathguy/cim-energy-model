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
 * Aggregate handler for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern, all write responsibilities 
 * related to AsynchronousMachineTimeConstantReactance are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AsynchronousMachineTimeConstantReactanceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AsynchronousMachineTimeConstantReactanceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AsynchronousMachineTimeConstantReactanceAggregate(CreateAsynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAsynchronousMachineTimeConstantReactanceCommand" );
    	CreateAsynchronousMachineTimeConstantReactanceEvent event = new CreateAsynchronousMachineTimeConstantReactanceEvent(command.getAsynchronousMachineTimeConstantReactanceId(), command.getTpo(), command.getTppo(), command.getXp(), command.getXpp(), command.getXs());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAsynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAsynchronousMachineTimeConstantReactanceCommand" );
    	UpdateAsynchronousMachineTimeConstantReactanceEvent event = new UpdateAsynchronousMachineTimeConstantReactanceEvent(command.getAsynchronousMachineTimeConstantReactanceId(), command.getTpo(), command.getTppo(), command.getXp(), command.getXpp(), command.getXs());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAsynchronousMachineTimeConstantReactanceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAsynchronousMachineTimeConstantReactanceCommand" );
        apply(new DeleteAsynchronousMachineTimeConstantReactanceEvent(command.getAsynchronousMachineTimeConstantReactanceId()));
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
    void on(CreateAsynchronousMachineTimeConstantReactanceEvent event) {	
    	LOGGER.info( "Event sourcing CreateAsynchronousMachineTimeConstantReactanceEvent" );
    	this.asynchronousMachineTimeConstantReactanceId = event.getAsynchronousMachineTimeConstantReactanceId();
        this.tpo = event.getTpo();
        this.tppo = event.getTppo();
        this.xp = event.getXp();
        this.xpp = event.getXpp();
        this.xs = event.getXs();
    }
    
    @EventSourcingHandler
    void on(UpdateAsynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.tpo = event.getTpo();
        this.tppo = event.getTppo();
        this.xp = event.getXp();
        this.xpp = event.getXpp();
        this.xs = event.getXs();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID asynchronousMachineTimeConstantReactanceId;
    
    private String tpo;
    private String tppo;
    private String xp;
    private String xpp;
    private String xs;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineTimeConstantReactanceAggregate.class.getName());
}
