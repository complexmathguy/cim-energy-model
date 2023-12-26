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
 * Aggregate handler for VoltageLevel as outlined for the CQRS pattern, all write responsibilities 
 * related to VoltageLevel are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VoltageLevelAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VoltageLevelAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VoltageLevelAggregate(CreateVoltageLevelCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVoltageLevelCommand" );
    	CreateVoltageLevelEvent event = new CreateVoltageLevelEvent(command.getVoltageLevelId(), command.getHighVoltageLimit(), command.getLowVoltageLimit());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVoltageLevelCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVoltageLevelCommand" );
    	UpdateVoltageLevelEvent event = new UpdateVoltageLevelEvent(command.getVoltageLevelId(), command.getHighVoltageLimit(), command.getLowVoltageLimit());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVoltageLevelCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVoltageLevelCommand" );
        apply(new DeleteVoltageLevelEvent(command.getVoltageLevelId()));
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
    void on(CreateVoltageLevelEvent event) {	
    	LOGGER.info( "Event sourcing CreateVoltageLevelEvent" );
    	this.voltageLevelId = event.getVoltageLevelId();
        this.highVoltageLimit = event.getHighVoltageLimit();
        this.lowVoltageLimit = event.getLowVoltageLimit();
    }
    
    @EventSourcingHandler
    void on(UpdateVoltageLevelEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.highVoltageLimit = event.getHighVoltageLimit();
        this.lowVoltageLimit = event.getLowVoltageLimit();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID voltageLevelId;
    
    private String highVoltageLimit;
    private String lowVoltageLimit;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageLevelAggregate.class.getName());
}
