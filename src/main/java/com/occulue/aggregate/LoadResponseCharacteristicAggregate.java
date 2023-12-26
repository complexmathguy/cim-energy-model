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
 * Aggregate handler for LoadResponseCharacteristic as outlined for the CQRS pattern, all write responsibilities 
 * related to LoadResponseCharacteristic are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LoadResponseCharacteristicAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LoadResponseCharacteristicAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LoadResponseCharacteristicAggregate(CreateLoadResponseCharacteristicCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLoadResponseCharacteristicCommand" );
    	CreateLoadResponseCharacteristicEvent event = new CreateLoadResponseCharacteristicEvent(command.getLoadResponseCharacteristicId(), command.getExponentModel(), command.getPConstantCurrent(), command.getPConstantImpedance(), command.getPConstantPower(), command.getPFrequencyExponent(), command.getPVoltageExponent(), command.getQConstantCurrent(), command.getQConstantImpedance(), command.getQConstantPower(), command.getQFrequencyExponent(), command.getQVoltageExponent());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLoadResponseCharacteristicCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLoadResponseCharacteristicCommand" );
    	UpdateLoadResponseCharacteristicEvent event = new UpdateLoadResponseCharacteristicEvent(command.getLoadResponseCharacteristicId(), command.getExponentModel(), command.getPConstantCurrent(), command.getPConstantImpedance(), command.getPConstantPower(), command.getPFrequencyExponent(), command.getPVoltageExponent(), command.getQConstantCurrent(), command.getQConstantImpedance(), command.getQConstantPower(), command.getQFrequencyExponent(), command.getQVoltageExponent());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLoadResponseCharacteristicCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLoadResponseCharacteristicCommand" );
        apply(new DeleteLoadResponseCharacteristicEvent(command.getLoadResponseCharacteristicId()));
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
    void on(CreateLoadResponseCharacteristicEvent event) {	
    	LOGGER.info( "Event sourcing CreateLoadResponseCharacteristicEvent" );
    	this.loadResponseCharacteristicId = event.getLoadResponseCharacteristicId();
        this.exponentModel = event.getExponentModel();
        this.pConstantCurrent = event.getPConstantCurrent();
        this.pConstantImpedance = event.getPConstantImpedance();
        this.pConstantPower = event.getPConstantPower();
        this.pFrequencyExponent = event.getPFrequencyExponent();
        this.pVoltageExponent = event.getPVoltageExponent();
        this.qConstantCurrent = event.getQConstantCurrent();
        this.qConstantImpedance = event.getQConstantImpedance();
        this.qConstantPower = event.getQConstantPower();
        this.qFrequencyExponent = event.getQFrequencyExponent();
        this.qVoltageExponent = event.getQVoltageExponent();
    }
    
    @EventSourcingHandler
    void on(UpdateLoadResponseCharacteristicEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.exponentModel = event.getExponentModel();
        this.pConstantCurrent = event.getPConstantCurrent();
        this.pConstantImpedance = event.getPConstantImpedance();
        this.pConstantPower = event.getPConstantPower();
        this.pFrequencyExponent = event.getPFrequencyExponent();
        this.pVoltageExponent = event.getPVoltageExponent();
        this.qConstantCurrent = event.getQConstantCurrent();
        this.qConstantImpedance = event.getQConstantImpedance();
        this.qConstantPower = event.getQConstantPower();
        this.qFrequencyExponent = event.getQFrequencyExponent();
        this.qVoltageExponent = event.getQVoltageExponent();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID loadResponseCharacteristicId;
    
    private String exponentModel;
    private String pConstantCurrent;
    private String pConstantImpedance;
    private String pConstantPower;
    private String pFrequencyExponent;
    private String pVoltageExponent;
    private String qConstantCurrent;
    private String qConstantImpedance;
    private String qConstantPower;
    private String qFrequencyExponent;
    private String qVoltageExponent;

    private static final Logger LOGGER 	= Logger.getLogger(LoadResponseCharacteristicAggregate.class.getName());
}
