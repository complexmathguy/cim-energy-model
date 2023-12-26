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
 * Aggregate handler for ENTSOEOperationalLimitType as outlined for the CQRS pattern, all write responsibilities 
 * related to ENTSOEOperationalLimitType are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ENTSOEOperationalLimitTypeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ENTSOEOperationalLimitTypeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ENTSOEOperationalLimitTypeAggregate(CreateENTSOEOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateENTSOEOperationalLimitTypeCommand" );
    	CreateENTSOEOperationalLimitTypeEvent event = new CreateENTSOEOperationalLimitTypeEvent(command.getENTSOEOperationalLimitTypeId(), command.getLimitType());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateENTSOEOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateENTSOEOperationalLimitTypeCommand" );
    	UpdateENTSOEOperationalLimitTypeEvent event = new UpdateENTSOEOperationalLimitTypeEvent(command.getENTSOEOperationalLimitTypeId(), command.getLimitType());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteENTSOEOperationalLimitTypeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteENTSOEOperationalLimitTypeCommand" );
        apply(new DeleteENTSOEOperationalLimitTypeEvent(command.getENTSOEOperationalLimitTypeId()));
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
    void on(CreateENTSOEOperationalLimitTypeEvent event) {	
    	LOGGER.info( "Event sourcing CreateENTSOEOperationalLimitTypeEvent" );
    	this.eNTSOEOperationalLimitTypeId = event.getENTSOEOperationalLimitTypeId();
        this.limitType = event.getLimitType();
    }
    
    @EventSourcingHandler
    void on(UpdateENTSOEOperationalLimitTypeEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.limitType = event.getLimitType();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID eNTSOEOperationalLimitTypeId;
    
    private String limitType;

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEOperationalLimitTypeAggregate.class.getName());
}
