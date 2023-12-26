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
 * Aggregate handler for SwitchProxy as outlined for the CQRS pattern, all write responsibilities 
 * related to SwitchProxy are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SwitchProxyAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SwitchProxyAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SwitchProxyAggregate(CreateSwitchProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSwitchProxyCommand" );
    	CreateSwitchProxyEvent event = new CreateSwitchProxyEvent(command.getSwitchProxyId(), command.getNormalOpen(), command.getRatedCurrent(), command.getRetained());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSwitchProxyCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSwitchProxyCommand" );
    	UpdateSwitchProxyEvent event = new UpdateSwitchProxyEvent(command.getSwitchProxyId(), command.getNormalOpen(), command.getRatedCurrent(), command.getRetained());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSwitchProxyCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSwitchProxyCommand" );
        apply(new DeleteSwitchProxyEvent(command.getSwitchProxyId()));
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
    void on(CreateSwitchProxyEvent event) {	
    	LOGGER.info( "Event sourcing CreateSwitchProxyEvent" );
    	this.switchProxyId = event.getSwitchProxyId();
        this.normalOpen = event.getNormalOpen();
        this.ratedCurrent = event.getRatedCurrent();
        this.retained = event.getRetained();
    }
    
    @EventSourcingHandler
    void on(UpdateSwitchProxyEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.normalOpen = event.getNormalOpen();
        this.ratedCurrent = event.getRatedCurrent();
        this.retained = event.getRetained();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID switchProxyId;
    
    private String normalOpen;
    private String ratedCurrent;
    private String retained;

    private static final Logger LOGGER 	= Logger.getLogger(SwitchProxyAggregate.class.getName());
}
