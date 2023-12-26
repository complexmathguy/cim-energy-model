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
 * Aggregate handler for SvPowerFlow as outlined for the CQRS pattern, all write responsibilities 
 * related to SvPowerFlow are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SvPowerFlowAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SvPowerFlowAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SvPowerFlowAggregate(CreateSvPowerFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSvPowerFlowCommand" );
    	CreateSvPowerFlowEvent event = new CreateSvPowerFlowEvent(command.getSvPowerFlowId(), command.getP(), command.getQ());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSvPowerFlowCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSvPowerFlowCommand" );
    	UpdateSvPowerFlowEvent event = new UpdateSvPowerFlowEvent(command.getSvPowerFlowId(), command.getP(), command.getQ());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSvPowerFlowCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSvPowerFlowCommand" );
        apply(new DeleteSvPowerFlowEvent(command.getSvPowerFlowId()));
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
    void on(CreateSvPowerFlowEvent event) {	
    	LOGGER.info( "Event sourcing CreateSvPowerFlowEvent" );
    	this.svPowerFlowId = event.getSvPowerFlowId();
        this.p = event.getP();
        this.q = event.getQ();
    }
    
    @EventSourcingHandler
    void on(UpdateSvPowerFlowEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.p = event.getP();
        this.q = event.getQ();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID svPowerFlowId;
    
    private String p;
    private String q;

    private static final Logger LOGGER 	= Logger.getLogger(SvPowerFlowAggregate.class.getName());
}
