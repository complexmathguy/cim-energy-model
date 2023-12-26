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
 * Aggregate handler for VCompIEEEType2 as outlined for the CQRS pattern, all write responsibilities 
 * related to VCompIEEEType2 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VCompIEEEType2Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VCompIEEEType2Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VCompIEEEType2Aggregate(CreateVCompIEEEType2Command command) throws Exception {
    	LOGGER.info( "Handling command CreateVCompIEEEType2Command" );
    	CreateVCompIEEEType2Event event = new CreateVCompIEEEType2Event(command.getVCompIEEEType2Id(), command.getTr());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVCompIEEEType2Command command) throws Exception {
    	LOGGER.info( "handling command UpdateVCompIEEEType2Command" );
    	UpdateVCompIEEEType2Event event = new UpdateVCompIEEEType2Event(command.getVCompIEEEType2Id(), command.getTr());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVCompIEEEType2Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteVCompIEEEType2Command" );
        apply(new DeleteVCompIEEEType2Event(command.getVCompIEEEType2Id()));
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
    void on(CreateVCompIEEEType2Event event) {	
    	LOGGER.info( "Event sourcing CreateVCompIEEEType2Event" );
    	this.vCompIEEEType2Id = event.getVCompIEEEType2Id();
        this.tr = event.getTr();
    }
    
    @EventSourcingHandler
    void on(UpdateVCompIEEEType2Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.tr = event.getTr();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID vCompIEEEType2Id;
    
    private String tr;

    private static final Logger LOGGER 	= Logger.getLogger(VCompIEEEType2Aggregate.class.getName());
}
