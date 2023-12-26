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
 * Aggregate handler for ExcAVR5 as outlined for the CQRS pattern, all write responsibilities 
 * related to ExcAVR5 are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExcAVR5Aggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExcAVR5Aggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExcAVR5Aggregate(CreateExcAVR5Command command) throws Exception {
    	LOGGER.info( "Handling command CreateExcAVR5Command" );
    	CreateExcAVR5Event event = new CreateExcAVR5Event(command.getExcAVR5Id(), command.getKa(), command.getRex(), command.getTa());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExcAVR5Command command) throws Exception {
    	LOGGER.info( "handling command UpdateExcAVR5Command" );
    	UpdateExcAVR5Event event = new UpdateExcAVR5Event(command.getExcAVR5Id(), command.getKa(), command.getRex(), command.getTa());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExcAVR5Command command) throws Exception {
    	LOGGER.info( "Handling command DeleteExcAVR5Command" );
        apply(new DeleteExcAVR5Event(command.getExcAVR5Id()));
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
    void on(CreateExcAVR5Event event) {	
    	LOGGER.info( "Event sourcing CreateExcAVR5Event" );
    	this.excAVR5Id = event.getExcAVR5Id();
        this.ka = event.getKa();
        this.rex = event.getRex();
        this.ta = event.getTa();
    }
    
    @EventSourcingHandler
    void on(UpdateExcAVR5Event event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.ka = event.getKa();
        this.rex = event.getRex();
        this.ta = event.getTa();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID excAVR5Id;
    
    private String ka;
    private String rex;
    private String ta;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR5Aggregate.class.getName());
}
