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
 * Aggregate handler for BusbarSection as outlined for the CQRS pattern, all write responsibilities 
 * related to BusbarSection are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BusbarSectionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BusbarSectionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BusbarSectionAggregate(CreateBusbarSectionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBusbarSectionCommand" );
    	CreateBusbarSectionEvent event = new CreateBusbarSectionEvent(command.getBusbarSectionId(), command.getIpMax());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBusbarSectionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBusbarSectionCommand" );
    	UpdateBusbarSectionEvent event = new UpdateBusbarSectionEvent(command.getBusbarSectionId(), command.getIpMax());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBusbarSectionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBusbarSectionCommand" );
        apply(new DeleteBusbarSectionEvent(command.getBusbarSectionId()));
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
    void on(CreateBusbarSectionEvent event) {	
    	LOGGER.info( "Event sourcing CreateBusbarSectionEvent" );
    	this.busbarSectionId = event.getBusbarSectionId();
        this.ipMax = event.getIpMax();
    }
    
    @EventSourcingHandler
    void on(UpdateBusbarSectionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ipMax = event.getIpMax();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID busbarSectionId;
    
    private String ipMax;

    private static final Logger LOGGER 	= Logger.getLogger(BusbarSectionAggregate.class.getName());
}
