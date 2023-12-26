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
 * Aggregate handler for PowerTransformer as outlined for the CQRS pattern, all write responsibilities 
 * related to PowerTransformer are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PowerTransformerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PowerTransformerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PowerTransformerAggregate(CreatePowerTransformerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePowerTransformerCommand" );
    	CreatePowerTransformerEvent event = new CreatePowerTransformerEvent(command.getPowerTransformerId(), command.getBeforeShCircuitHighestOperatingCurrent(), command.getBeforeShCircuitHighestOperatingVoltage(), command.getBeforeShortCircuitAnglePf(), command.getHighSideMinOperatingU(), command.getIsPartOfGeneratorUnit(), command.getOperationalValuesConsidered());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePowerTransformerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePowerTransformerCommand" );
    	UpdatePowerTransformerEvent event = new UpdatePowerTransformerEvent(command.getPowerTransformerId(), command.getBeforeShCircuitHighestOperatingCurrent(), command.getBeforeShCircuitHighestOperatingVoltage(), command.getBeforeShortCircuitAnglePf(), command.getHighSideMinOperatingU(), command.getIsPartOfGeneratorUnit(), command.getOperationalValuesConsidered());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePowerTransformerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePowerTransformerCommand" );
        apply(new DeletePowerTransformerEvent(command.getPowerTransformerId()));
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
    void on(CreatePowerTransformerEvent event) {	
    	LOGGER.info( "Event sourcing CreatePowerTransformerEvent" );
    	this.powerTransformerId = event.getPowerTransformerId();
        this.beforeShCircuitHighestOperatingCurrent = event.getBeforeShCircuitHighestOperatingCurrent();
        this.beforeShCircuitHighestOperatingVoltage = event.getBeforeShCircuitHighestOperatingVoltage();
        this.beforeShortCircuitAnglePf = event.getBeforeShortCircuitAnglePf();
        this.highSideMinOperatingU = event.getHighSideMinOperatingU();
        this.isPartOfGeneratorUnit = event.getIsPartOfGeneratorUnit();
        this.operationalValuesConsidered = event.getOperationalValuesConsidered();
    }
    
    @EventSourcingHandler
    void on(UpdatePowerTransformerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.beforeShCircuitHighestOperatingCurrent = event.getBeforeShCircuitHighestOperatingCurrent();
        this.beforeShCircuitHighestOperatingVoltage = event.getBeforeShCircuitHighestOperatingVoltage();
        this.beforeShortCircuitAnglePf = event.getBeforeShortCircuitAnglePf();
        this.highSideMinOperatingU = event.getHighSideMinOperatingU();
        this.isPartOfGeneratorUnit = event.getIsPartOfGeneratorUnit();
        this.operationalValuesConsidered = event.getOperationalValuesConsidered();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID powerTransformerId;
    
    private String beforeShCircuitHighestOperatingCurrent;
    private String beforeShCircuitHighestOperatingVoltage;
    private String beforeShortCircuitAnglePf;
    private String highSideMinOperatingU;
    private String isPartOfGeneratorUnit;
    private String operationalValuesConsidered;

    private static final Logger LOGGER 	= Logger.getLogger(PowerTransformerAggregate.class.getName());
}
