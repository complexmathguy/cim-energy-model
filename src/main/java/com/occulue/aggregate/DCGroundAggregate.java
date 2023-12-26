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
 * Aggregate handler for DCGround as outlined for the CQRS pattern, all write responsibilities 
 * related to DCGround are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCGroundAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCGroundAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCGroundAggregate(CreateDCGroundCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCGroundCommand" );
    	CreateDCGroundEvent event = new CreateDCGroundEvent(command.getDCGroundId(), command.getInductance(), command.getR());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCGroundCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCGroundCommand" );
    	UpdateDCGroundEvent event = new UpdateDCGroundEvent(command.getDCGroundId(), command.getInductance(), command.getR());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCGroundCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCGroundCommand" );
        apply(new DeleteDCGroundEvent(command.getDCGroundId()));
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
    void on(CreateDCGroundEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCGroundEvent" );
    	this.dCGroundId = event.getDCGroundId();
        this.inductance = event.getInductance();
        this.r = event.getR();
    }
    
    @EventSourcingHandler
    void on(UpdateDCGroundEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.inductance = event.getInductance();
        this.r = event.getR();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCGroundId;
    
    private String inductance;
    private String r;

    private static final Logger LOGGER 	= Logger.getLogger(DCGroundAggregate.class.getName());
}
