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
 * Aggregate handler for EarthFaultCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to EarthFaultCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EarthFaultCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EarthFaultCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EarthFaultCompensatorAggregate(CreateEarthFaultCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEarthFaultCompensatorCommand" );
    	CreateEarthFaultCompensatorEvent event = new CreateEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId(), command.getR());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEarthFaultCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEarthFaultCompensatorCommand" );
    	UpdateEarthFaultCompensatorEvent event = new UpdateEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId(), command.getR());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEarthFaultCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEarthFaultCompensatorCommand" );
        apply(new DeleteEarthFaultCompensatorEvent(command.getEarthFaultCompensatorId()));
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
    void on(CreateEarthFaultCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateEarthFaultCompensatorEvent" );
    	this.earthFaultCompensatorId = event.getEarthFaultCompensatorId();
        this.r = event.getR();
    }
    
    @EventSourcingHandler
    void on(UpdateEarthFaultCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.r = event.getR();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID earthFaultCompensatorId;
    
    private String r;

    private static final Logger LOGGER 	= Logger.getLogger(EarthFaultCompensatorAggregate.class.getName());
}
