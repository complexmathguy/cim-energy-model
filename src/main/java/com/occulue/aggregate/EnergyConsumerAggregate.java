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
 * Aggregate handler for EnergyConsumer as outlined for the CQRS pattern, all write responsibilities 
 * related to EnergyConsumer are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EnergyConsumerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EnergyConsumerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EnergyConsumerAggregate(CreateEnergyConsumerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEnergyConsumerCommand" );
    	CreateEnergyConsumerEvent event = new CreateEnergyConsumerEvent(command.getEnergyConsumerId(), command.getPfixed(), command.getPfixedPct(), command.getQfixed(), command.getQfixedPct());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEnergyConsumerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEnergyConsumerCommand" );
    	UpdateEnergyConsumerEvent event = new UpdateEnergyConsumerEvent(command.getEnergyConsumerId(), command.getPfixed(), command.getPfixedPct(), command.getQfixed(), command.getQfixedPct());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEnergyConsumerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEnergyConsumerCommand" );
        apply(new DeleteEnergyConsumerEvent(command.getEnergyConsumerId()));
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
    void on(CreateEnergyConsumerEvent event) {	
    	LOGGER.info( "Event sourcing CreateEnergyConsumerEvent" );
    	this.energyConsumerId = event.getEnergyConsumerId();
        this.pfixed = event.getPfixed();
        this.pfixedPct = event.getPfixedPct();
        this.qfixed = event.getQfixed();
        this.qfixedPct = event.getQfixedPct();
    }
    
    @EventSourcingHandler
    void on(UpdateEnergyConsumerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.pfixed = event.getPfixed();
        this.pfixedPct = event.getPfixedPct();
        this.qfixed = event.getQfixed();
        this.qfixedPct = event.getQfixedPct();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID energyConsumerId;
    
    private String pfixed;
    private String pfixedPct;
    private String qfixed;
    private String qfixedPct;

    private static final Logger LOGGER 	= Logger.getLogger(EnergyConsumerAggregate.class.getName());
}
