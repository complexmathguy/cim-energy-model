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
 * Aggregate handler for RatioTapChanger as outlined for the CQRS pattern, all write responsibilities 
 * related to RatioTapChanger are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RatioTapChangerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RatioTapChangerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RatioTapChangerAggregate(CreateRatioTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRatioTapChangerCommand" );
    	CreateRatioTapChangerEvent event = new CreateRatioTapChangerEvent(command.getRatioTapChangerId(), command.getStepVoltageIncrement(), command.getTculControlMode());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRatioTapChangerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRatioTapChangerCommand" );
    	UpdateRatioTapChangerEvent event = new UpdateRatioTapChangerEvent(command.getRatioTapChangerId(), command.getStepVoltageIncrement(), command.getTculControlMode());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRatioTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRatioTapChangerCommand" );
        apply(new DeleteRatioTapChangerEvent(command.getRatioTapChangerId()));
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
    void on(CreateRatioTapChangerEvent event) {	
    	LOGGER.info( "Event sourcing CreateRatioTapChangerEvent" );
    	this.ratioTapChangerId = event.getRatioTapChangerId();
        this.stepVoltageIncrement = event.getStepVoltageIncrement();
        this.tculControlMode = event.getTculControlMode();
    }
    
    @EventSourcingHandler
    void on(UpdateRatioTapChangerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.stepVoltageIncrement = event.getStepVoltageIncrement();
        this.tculControlMode = event.getTculControlMode();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID ratioTapChangerId;
    
    private String stepVoltageIncrement;
    private String tculControlMode;

    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerAggregate.class.getName());
}
