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
 * Aggregate handler for SynchronousMachineDetailed as outlined for the CQRS pattern, all write responsibilities 
 * related to SynchronousMachineDetailed are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SynchronousMachineDetailedAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SynchronousMachineDetailedAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SynchronousMachineDetailedAggregate(CreateSynchronousMachineDetailedCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSynchronousMachineDetailedCommand" );
    	CreateSynchronousMachineDetailedEvent event = new CreateSynchronousMachineDetailedEvent(command.getSynchronousMachineDetailedId(), command.getEfdBaseRatio(), command.getIfdBaseType(), command.getIfdBaseValue(), command.getSaturationFactor120QAxis(), command.getSaturationFactorQAxis());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSynchronousMachineDetailedCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSynchronousMachineDetailedCommand" );
    	UpdateSynchronousMachineDetailedEvent event = new UpdateSynchronousMachineDetailedEvent(command.getSynchronousMachineDetailedId(), command.getEfdBaseRatio(), command.getIfdBaseType(), command.getIfdBaseValue(), command.getSaturationFactor120QAxis(), command.getSaturationFactorQAxis());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSynchronousMachineDetailedCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSynchronousMachineDetailedCommand" );
        apply(new DeleteSynchronousMachineDetailedEvent(command.getSynchronousMachineDetailedId()));
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
    void on(CreateSynchronousMachineDetailedEvent event) {	
    	LOGGER.info( "Event sourcing CreateSynchronousMachineDetailedEvent" );
    	this.synchronousMachineDetailedId = event.getSynchronousMachineDetailedId();
        this.efdBaseRatio = event.getEfdBaseRatio();
        this.ifdBaseType = event.getIfdBaseType();
        this.ifdBaseValue = event.getIfdBaseValue();
        this.saturationFactor120QAxis = event.getSaturationFactor120QAxis();
        this.saturationFactorQAxis = event.getSaturationFactorQAxis();
    }
    
    @EventSourcingHandler
    void on(UpdateSynchronousMachineDetailedEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.efdBaseRatio = event.getEfdBaseRatio();
        this.ifdBaseType = event.getIfdBaseType();
        this.ifdBaseValue = event.getIfdBaseValue();
        this.saturationFactor120QAxis = event.getSaturationFactor120QAxis();
        this.saturationFactorQAxis = event.getSaturationFactorQAxis();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID synchronousMachineDetailedId;
    
    private String efdBaseRatio;
    private String ifdBaseType;
    private String ifdBaseValue;
    private String saturationFactor120QAxis;
    private String saturationFactorQAxis;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineDetailedAggregate.class.getName());
}
