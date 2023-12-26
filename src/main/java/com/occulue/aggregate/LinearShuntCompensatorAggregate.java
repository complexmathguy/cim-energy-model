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
 * Aggregate handler for LinearShuntCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to LinearShuntCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class LinearShuntCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public LinearShuntCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public LinearShuntCompensatorAggregate(CreateLinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateLinearShuntCompensatorCommand" );
    	CreateLinearShuntCompensatorEvent event = new CreateLinearShuntCompensatorEvent(command.getLinearShuntCompensatorId(), command.getB0PerSection(), command.getBPerSection(), command.getG0PerSection(), command.getGPerSection());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateLinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateLinearShuntCompensatorCommand" );
    	UpdateLinearShuntCompensatorEvent event = new UpdateLinearShuntCompensatorEvent(command.getLinearShuntCompensatorId(), command.getB0PerSection(), command.getBPerSection(), command.getG0PerSection(), command.getGPerSection());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteLinearShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteLinearShuntCompensatorCommand" );
        apply(new DeleteLinearShuntCompensatorEvent(command.getLinearShuntCompensatorId()));
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
    void on(CreateLinearShuntCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateLinearShuntCompensatorEvent" );
    	this.linearShuntCompensatorId = event.getLinearShuntCompensatorId();
        this.b0PerSection = event.getB0PerSection();
        this.bPerSection = event.getBPerSection();
        this.g0PerSection = event.getG0PerSection();
        this.gPerSection = event.getGPerSection();
    }
    
    @EventSourcingHandler
    void on(UpdateLinearShuntCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b0PerSection = event.getB0PerSection();
        this.bPerSection = event.getBPerSection();
        this.g0PerSection = event.getG0PerSection();
        this.gPerSection = event.getGPerSection();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID linearShuntCompensatorId;
    
    private String b0PerSection;
    private String bPerSection;
    private String g0PerSection;
    private String gPerSection;

    private static final Logger LOGGER 	= Logger.getLogger(LinearShuntCompensatorAggregate.class.getName());
}
