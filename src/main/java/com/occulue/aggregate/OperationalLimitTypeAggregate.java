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
 * Aggregate handler for OperationalLimitType as outlined for the CQRS pattern, all write responsibilities 
 * related to OperationalLimitType are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class OperationalLimitTypeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public OperationalLimitTypeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public OperationalLimitTypeAggregate(CreateOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateOperationalLimitTypeCommand" );
    	CreateOperationalLimitTypeEvent event = new CreateOperationalLimitTypeEvent(command.getOperationalLimitTypeId(), command.getAcceptableDuration(), command.getDirection(), command.getLimitType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateOperationalLimitTypeCommand" );
    	UpdateOperationalLimitTypeEvent event = new UpdateOperationalLimitTypeEvent(command.getOperationalLimitTypeId(), command.getAcceptableDuration(), command.getDirection(), command.getLimitType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteOperationalLimitTypeCommand" );
        apply(new DeleteOperationalLimitTypeEvent(command.getOperationalLimitTypeId()));
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
    void on(CreateOperationalLimitTypeEvent event) {	
    	LOGGER.info( "Event sourcing CreateOperationalLimitTypeEvent" );
    	this.operationalLimitTypeId = event.getOperationalLimitTypeId();
        this.acceptableDuration = event.getAcceptableDuration();
        this.direction = event.getDirection();
        this.limitType = event.getLimitType();
    }
    
    @EventSourcingHandler
    void on(UpdateOperationalLimitTypeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.acceptableDuration = event.getAcceptableDuration();
        this.direction = event.getDirection();
        this.limitType = event.getLimitType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID operationalLimitTypeId;
    
    private String acceptableDuration;
    private String direction;
    private String limitType;

    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitTypeAggregate.class.getName());
}
