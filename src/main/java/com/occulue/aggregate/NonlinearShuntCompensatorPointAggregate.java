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
 * Aggregate handler for NonlinearShuntCompensatorPoint as outlined for the CQRS pattern, all write responsibilities 
 * related to NonlinearShuntCompensatorPoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class NonlinearShuntCompensatorPointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public NonlinearShuntCompensatorPointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public NonlinearShuntCompensatorPointAggregate(CreateNonlinearShuntCompensatorPointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateNonlinearShuntCompensatorPointCommand" );
    	CreateNonlinearShuntCompensatorPointEvent event = new CreateNonlinearShuntCompensatorPointEvent(command.getNonlinearShuntCompensatorPointId(), command.getB(), command.getB0(), command.getG(), command.getG0(), command.getSectionNumber());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateNonlinearShuntCompensatorPointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateNonlinearShuntCompensatorPointCommand" );
    	UpdateNonlinearShuntCompensatorPointEvent event = new UpdateNonlinearShuntCompensatorPointEvent(command.getNonlinearShuntCompensatorPointId(), command.getB(), command.getB0(), command.getG(), command.getG0(), command.getSectionNumber());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteNonlinearShuntCompensatorPointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteNonlinearShuntCompensatorPointCommand" );
        apply(new DeleteNonlinearShuntCompensatorPointEvent(command.getNonlinearShuntCompensatorPointId()));
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
    void on(CreateNonlinearShuntCompensatorPointEvent event) {	
    	LOGGER.info( "Event sourcing CreateNonlinearShuntCompensatorPointEvent" );
    	this.nonlinearShuntCompensatorPointId = event.getNonlinearShuntCompensatorPointId();
        this.b = event.getB();
        this.b0 = event.getB0();
        this.g = event.getG();
        this.g0 = event.getG0();
        this.sectionNumber = event.getSectionNumber();
    }
    
    @EventSourcingHandler
    void on(UpdateNonlinearShuntCompensatorPointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b = event.getB();
        this.b0 = event.getB0();
        this.g = event.getG();
        this.g0 = event.getG0();
        this.sectionNumber = event.getSectionNumber();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID nonlinearShuntCompensatorPointId;
    
    private String b;
    private String b0;
    private String g;
    private String g0;
    private String sectionNumber;

    private static final Logger LOGGER 	= Logger.getLogger(NonlinearShuntCompensatorPointAggregate.class.getName());
}
