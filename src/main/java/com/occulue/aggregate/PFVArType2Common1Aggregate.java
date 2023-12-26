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
 * Aggregate handler for PFVArType2Common1 as outlined for the CQRS pattern, all write responsibilities 
 * related to PFVArType2Common1 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class PFVArType2Common1Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public PFVArType2Common1Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public PFVArType2Common1Aggregate(CreatePFVArType2Common1Command command) throws Exception {
    	LOGGER.info( "Handling command CreatePFVArType2Common1Command" );
    	CreatePFVArType2Common1Event event = new CreatePFVArType2Common1Event(command.getPFVArType2Common1Id(), command.getJ(), command.getKi(), command.getKp(), command.getMax(), command.getRef());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdatePFVArType2Common1Command command) throws Exception {
    	LOGGER.info( "handling command UpdatePFVArType2Common1Command" );
    	UpdatePFVArType2Common1Event event = new UpdatePFVArType2Common1Event(command.getPFVArType2Common1Id(), command.getJ(), command.getKi(), command.getKp(), command.getMax(), command.getRef());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeletePFVArType2Common1Command command) throws Exception {
    	LOGGER.info( "Handling command DeletePFVArType2Common1Command" );
        apply(new DeletePFVArType2Common1Event(command.getPFVArType2Common1Id()));
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
    void on(CreatePFVArType2Common1Event event) {	
    	LOGGER.info( "Event sourcing CreatePFVArType2Common1Event" );
    	this.pFVArType2Common1Id = event.getPFVArType2Common1Id();
        this.j = event.getJ();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.max = event.getMax();
        this.ref = event.getRef();
    }
    
    @EventSourcingHandler
    void on(UpdatePFVArType2Common1Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.j = event.getJ();
        this.ki = event.getKi();
        this.kp = event.getKp();
        this.max = event.getMax();
        this.ref = event.getRef();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID pFVArType2Common1Id;
    
    private String j;
    private String ki;
    private String kp;
    private String max;
    private String ref;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2Common1Aggregate.class.getName());
}
