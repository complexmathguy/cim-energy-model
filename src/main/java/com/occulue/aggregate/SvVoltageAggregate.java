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
 * Aggregate handler for SvVoltage as outlined for the CQRS pattern, all write responsibilities 
 * related to SvVoltage are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SvVoltageAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SvVoltageAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SvVoltageAggregate(CreateSvVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSvVoltageCommand" );
    	CreateSvVoltageEvent event = new CreateSvVoltageEvent(command.getSvVoltageId(), command.getAngle(), command.getV());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSvVoltageCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSvVoltageCommand" );
    	UpdateSvVoltageEvent event = new UpdateSvVoltageEvent(command.getSvVoltageId(), command.getAngle(), command.getV());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSvVoltageCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSvVoltageCommand" );
        apply(new DeleteSvVoltageEvent(command.getSvVoltageId()));
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
    void on(CreateSvVoltageEvent event) {	
    	LOGGER.info( "Event sourcing CreateSvVoltageEvent" );
    	this.svVoltageId = event.getSvVoltageId();
        this.angle = event.getAngle();
        this.v = event.getV();
    }
    
    @EventSourcingHandler
    void on(UpdateSvVoltageEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.angle = event.getAngle();
        this.v = event.getV();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID svVoltageId;
    
    private String angle;
    private String v;

    private static final Logger LOGGER 	= Logger.getLogger(SvVoltageAggregate.class.getName());
}
