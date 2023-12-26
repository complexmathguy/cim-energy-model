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
 * Aggregate handler for ProprietaryParameterDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to ProprietaryParameterDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ProprietaryParameterDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ProprietaryParameterDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ProprietaryParameterDynamicsAggregate(CreateProprietaryParameterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateProprietaryParameterDynamicsCommand" );
    	CreateProprietaryParameterDynamicsEvent event = new CreateProprietaryParameterDynamicsEvent(command.getProprietaryParameterDynamicsId(), command.getBooleanParameterValue(), command.getFloatParameterValue(), command.getIntegerParameterValue(), command.getParameterNumber());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateProprietaryParameterDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateProprietaryParameterDynamicsCommand" );
    	UpdateProprietaryParameterDynamicsEvent event = new UpdateProprietaryParameterDynamicsEvent(command.getProprietaryParameterDynamicsId(), command.getBooleanParameterValue(), command.getFloatParameterValue(), command.getIntegerParameterValue(), command.getParameterNumber());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteProprietaryParameterDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteProprietaryParameterDynamicsCommand" );
        apply(new DeleteProprietaryParameterDynamicsEvent(command.getProprietaryParameterDynamicsId()));
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
    void on(CreateProprietaryParameterDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateProprietaryParameterDynamicsEvent" );
    	this.proprietaryParameterDynamicsId = event.getProprietaryParameterDynamicsId();
        this.booleanParameterValue = event.getBooleanParameterValue();
        this.floatParameterValue = event.getFloatParameterValue();
        this.integerParameterValue = event.getIntegerParameterValue();
        this.parameterNumber = event.getParameterNumber();
    }
    
    @EventSourcingHandler
    void on(UpdateProprietaryParameterDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.booleanParameterValue = event.getBooleanParameterValue();
        this.floatParameterValue = event.getFloatParameterValue();
        this.integerParameterValue = event.getIntegerParameterValue();
        this.parameterNumber = event.getParameterNumber();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID proprietaryParameterDynamicsId;
    
    private String booleanParameterValue;
    private String floatParameterValue;
    private String integerParameterValue;
    private String parameterNumber;

    private static final Logger LOGGER 	= Logger.getLogger(ProprietaryParameterDynamicsAggregate.class.getName());
}
