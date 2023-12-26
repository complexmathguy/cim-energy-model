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
 * Aggregate handler for MechLoad1 as outlined for the CQRS pattern, all write responsibilities 
 * related to MechLoad1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MechLoad1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MechLoad1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MechLoad1Aggregate(CreateMechLoad1Command command) throws Exception {
    	LOGGER.info( "Handling command CreateMechLoad1Command" );
    	CreateMechLoad1Event event = new CreateMechLoad1Event(command.getMechLoad1Id(), command.getA(), command.getB(), command.getD(), command.getE());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMechLoad1Command command) throws Exception {
    	LOGGER.info( "handling command UpdateMechLoad1Command" );
    	UpdateMechLoad1Event event = new UpdateMechLoad1Event(command.getMechLoad1Id(), command.getA(), command.getB(), command.getD(), command.getE());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMechLoad1Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteMechLoad1Command" );
        apply(new DeleteMechLoad1Event(command.getMechLoad1Id()));
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
    void on(CreateMechLoad1Event event) {	
    	LOGGER.info( "Event sourcing CreateMechLoad1Event" );
    	this.mechLoad1Id = event.getMechLoad1Id();
        this.a = event.getA();
        this.b = event.getB();
        this.d = event.getD();
        this.e = event.getE();
    }
    
    @EventSourcingHandler
    void on(UpdateMechLoad1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.a = event.getA();
        this.b = event.getB();
        this.d = event.getD();
        this.e = event.getE();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID mechLoad1Id;
    
    private String a;
    private String b;
    private String d;
    private String e;

    private static final Logger LOGGER 	= Logger.getLogger(MechLoad1Aggregate.class.getName());
}
