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
 * Aggregate handler for AsynchronousMachine as outlined for the CQRS pattern, all write responsibilities 
 * related to AsynchronousMachine are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AsynchronousMachineAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AsynchronousMachineAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AsynchronousMachineAggregate(CreateAsynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAsynchronousMachineCommand" );
    	CreateAsynchronousMachineEvent event = new CreateAsynchronousMachineEvent(command.getAsynchronousMachineId(), command.getConverterFedDrive(), command.getEfficiency(), command.getIaIrRatio(), command.getNominalFrequency(), command.getNominalSpeed(), command.getPolePairNumber(), command.getRatedMechanicalPower(), command.getReversible(), command.getRxLockedRotorRatio());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAsynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAsynchronousMachineCommand" );
    	UpdateAsynchronousMachineEvent event = new UpdateAsynchronousMachineEvent(command.getAsynchronousMachineId(), command.getConverterFedDrive(), command.getEfficiency(), command.getIaIrRatio(), command.getNominalFrequency(), command.getNominalSpeed(), command.getPolePairNumber(), command.getRatedMechanicalPower(), command.getReversible(), command.getRxLockedRotorRatio());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAsynchronousMachineCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAsynchronousMachineCommand" );
        apply(new DeleteAsynchronousMachineEvent(command.getAsynchronousMachineId()));
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
    void on(CreateAsynchronousMachineEvent event) {	
    	LOGGER.info( "Event sourcing CreateAsynchronousMachineEvent" );
    	this.asynchronousMachineId = event.getAsynchronousMachineId();
        this.converterFedDrive = event.getConverterFedDrive();
        this.efficiency = event.getEfficiency();
        this.iaIrRatio = event.getIaIrRatio();
        this.nominalFrequency = event.getNominalFrequency();
        this.nominalSpeed = event.getNominalSpeed();
        this.polePairNumber = event.getPolePairNumber();
        this.ratedMechanicalPower = event.getRatedMechanicalPower();
        this.reversible = event.getReversible();
        this.rxLockedRotorRatio = event.getRxLockedRotorRatio();
    }
    
    @EventSourcingHandler
    void on(UpdateAsynchronousMachineEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.converterFedDrive = event.getConverterFedDrive();
        this.efficiency = event.getEfficiency();
        this.iaIrRatio = event.getIaIrRatio();
        this.nominalFrequency = event.getNominalFrequency();
        this.nominalSpeed = event.getNominalSpeed();
        this.polePairNumber = event.getPolePairNumber();
        this.ratedMechanicalPower = event.getRatedMechanicalPower();
        this.reversible = event.getReversible();
        this.rxLockedRotorRatio = event.getRxLockedRotorRatio();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID asynchronousMachineId;
    
    private String converterFedDrive;
    private String efficiency;
    private String iaIrRatio;
    private String nominalFrequency;
    private String nominalSpeed;
    private String polePairNumber;
    private String ratedMechanicalPower;
    private String reversible;
    private String rxLockedRotorRatio;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineAggregate.class.getName());
}
