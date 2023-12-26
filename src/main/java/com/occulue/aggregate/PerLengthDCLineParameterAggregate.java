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
 * Aggregate handler for PerLengthDCLineParameter as outlined for the CQRS pattern, all write responsibilities 
 * related to PerLengthDCLineParameter are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PerLengthDCLineParameterAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PerLengthDCLineParameterAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PerLengthDCLineParameterAggregate(CreatePerLengthDCLineParameterCommand command) throws Exception {
    	LOGGER.info( "Handling command CreatePerLengthDCLineParameterCommand" );
    	CreatePerLengthDCLineParameterEvent event = new CreatePerLengthDCLineParameterEvent(command.getPerLengthDCLineParameterId(), command.getCapacitance(), command.getInductance(), command.getResistance());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePerLengthDCLineParameterCommand command) throws Exception {
    	LOGGER.info( "handling command UpdatePerLengthDCLineParameterCommand" );
    	UpdatePerLengthDCLineParameterEvent event = new UpdatePerLengthDCLineParameterEvent(command.getPerLengthDCLineParameterId(), command.getCapacitance(), command.getInductance(), command.getResistance());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePerLengthDCLineParameterCommand command) throws Exception {
    	LOGGER.info( "Handling command DeletePerLengthDCLineParameterCommand" );
        apply(new DeletePerLengthDCLineParameterEvent(command.getPerLengthDCLineParameterId()));
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
    void on(CreatePerLengthDCLineParameterEvent event) {	
    	LOGGER.info( "Event sourcing CreatePerLengthDCLineParameterEvent" );
    	this.perLengthDCLineParameterId = event.getPerLengthDCLineParameterId();
        this.capacitance = event.getCapacitance();
        this.inductance = event.getInductance();
        this.resistance = event.getResistance();
    }
    
    @EventSourcingHandler
    void on(UpdatePerLengthDCLineParameterEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.capacitance = event.getCapacitance();
        this.inductance = event.getInductance();
        this.resistance = event.getResistance();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID perLengthDCLineParameterId;
    
    private String capacitance;
    private String inductance;
    private String resistance;

    private static final Logger LOGGER 	= Logger.getLogger(PerLengthDCLineParameterAggregate.class.getName());
}
