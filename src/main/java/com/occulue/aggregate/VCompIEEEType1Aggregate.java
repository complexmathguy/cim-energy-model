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
 * Aggregate handler for VCompIEEEType1 as outlined for the CQRS pattern, all write responsibilities 
 * related to VCompIEEEType1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VCompIEEEType1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VCompIEEEType1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VCompIEEEType1Aggregate(CreateVCompIEEEType1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateVCompIEEEType1Command" );
    	CreateVCompIEEEType1Event event = new CreateVCompIEEEType1Event(command.getVCompIEEEType1Id(), command.getRc(), command.getTr(), command.getXc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVCompIEEEType1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateVCompIEEEType1Command" );
    	UpdateVCompIEEEType1Event event = new UpdateVCompIEEEType1Event(command.getVCompIEEEType1Id(), command.getRc(), command.getTr(), command.getXc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVCompIEEEType1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteVCompIEEEType1Command" );
        apply(new DeleteVCompIEEEType1Event(command.getVCompIEEEType1Id()));
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
    void on(CreateVCompIEEEType1Event event) {	
    	LOGGER.info( "Event sourcing CreateVCompIEEEType1Event" );
    	this.vCompIEEEType1Id = event.getVCompIEEEType1Id();
        this.rc = event.getRc();
        this.tr = event.getTr();
        this.xc = event.getXc();
    }
    
    @EventSourcingHandler
    void on(UpdateVCompIEEEType1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.rc = event.getRc();
        this.tr = event.getTr();
        this.xc = event.getXc();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID vCompIEEEType1Id;
    
    private String rc;
    private String tr;
    private String xc;

    private static final Logger LOGGER 	= Logger.getLogger(VCompIEEEType1Aggregate.class.getName());
}
