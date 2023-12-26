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
 * Aggregate handler for BaseVoltage as outlined for the CQRS pattern, all write responsibilities 
 * related to BaseVoltage are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BaseVoltageAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BaseVoltageAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BaseVoltageAggregate(CreateBaseVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBaseVoltageCommand" );
    	CreateBaseVoltageEvent event = new CreateBaseVoltageEvent(command.getBaseVoltageId(), command.getNominalVoltage());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBaseVoltageCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBaseVoltageCommand" );
    	UpdateBaseVoltageEvent event = new UpdateBaseVoltageEvent(command.getBaseVoltageId(), command.getNominalVoltage());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBaseVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBaseVoltageCommand" );
        apply(new DeleteBaseVoltageEvent(command.getBaseVoltageId()));
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
    void on(CreateBaseVoltageEvent event) {	
    	LOGGER.info( "Event sourcing CreateBaseVoltageEvent" );
    	this.baseVoltageId = event.getBaseVoltageId();
        this.nominalVoltage = event.getNominalVoltage();
    }
    
    @EventSourcingHandler
    void on(UpdateBaseVoltageEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.nominalVoltage = event.getNominalVoltage();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID baseVoltageId;
    
    private String nominalVoltage;

    private static final Logger LOGGER 	= Logger.getLogger(BaseVoltageAggregate.class.getName());
}
