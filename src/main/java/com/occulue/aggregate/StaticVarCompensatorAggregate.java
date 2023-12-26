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
 * Aggregate handler for StaticVarCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to StaticVarCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class StaticVarCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public StaticVarCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public StaticVarCompensatorAggregate(CreateStaticVarCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateStaticVarCompensatorCommand" );
    	CreateStaticVarCompensatorEvent event = new CreateStaticVarCompensatorEvent(command.getStaticVarCompensatorId(), command.getCapacitiveRating(), command.getInductiveRating(), command.getSlope(), command.getSVCControlMode(), command.getVoltageSetPoint());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateStaticVarCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateStaticVarCompensatorCommand" );
    	UpdateStaticVarCompensatorEvent event = new UpdateStaticVarCompensatorEvent(command.getStaticVarCompensatorId(), command.getCapacitiveRating(), command.getInductiveRating(), command.getSlope(), command.getSVCControlMode(), command.getVoltageSetPoint());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteStaticVarCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteStaticVarCompensatorCommand" );
        apply(new DeleteStaticVarCompensatorEvent(command.getStaticVarCompensatorId()));
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
    void on(CreateStaticVarCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateStaticVarCompensatorEvent" );
    	this.staticVarCompensatorId = event.getStaticVarCompensatorId();
        this.capacitiveRating = event.getCapacitiveRating();
        this.inductiveRating = event.getInductiveRating();
        this.slope = event.getSlope();
        this.sVCControlMode = event.getSVCControlMode();
        this.voltageSetPoint = event.getVoltageSetPoint();
    }
    
    @EventSourcingHandler
    void on(UpdateStaticVarCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.capacitiveRating = event.getCapacitiveRating();
        this.inductiveRating = event.getInductiveRating();
        this.slope = event.getSlope();
        this.sVCControlMode = event.getSVCControlMode();
        this.voltageSetPoint = event.getVoltageSetPoint();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID staticVarCompensatorId;
    
    private String capacitiveRating;
    private String inductiveRating;
    private String slope;
    private String sVCControlMode;
    private String voltageSetPoint;

    private static final Logger LOGGER 	= Logger.getLogger(StaticVarCompensatorAggregate.class.getName());
}
