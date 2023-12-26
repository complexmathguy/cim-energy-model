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
 * Aggregate handler for MutualCoupling as outlined for the CQRS pattern, all write responsibilities 
 * related to MutualCoupling are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class MutualCouplingAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public MutualCouplingAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public MutualCouplingAggregate(CreateMutualCouplingCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateMutualCouplingCommand" );
    	CreateMutualCouplingEvent event = new CreateMutualCouplingEvent(command.getMutualCouplingId(), command.getB0ch(), command.getDistance11(), command.getDistance12(), command.getDistance21(), command.getDistance22(), command.getG0ch(), command.getR0(), command.getX0());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateMutualCouplingCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateMutualCouplingCommand" );
    	UpdateMutualCouplingEvent event = new UpdateMutualCouplingEvent(command.getMutualCouplingId(), command.getB0ch(), command.getDistance11(), command.getDistance12(), command.getDistance21(), command.getDistance22(), command.getG0ch(), command.getR0(), command.getX0());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteMutualCouplingCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteMutualCouplingCommand" );
        apply(new DeleteMutualCouplingEvent(command.getMutualCouplingId()));
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
    void on(CreateMutualCouplingEvent event) {	
    	LOGGER.info( "Event sourcing CreateMutualCouplingEvent" );
    	this.mutualCouplingId = event.getMutualCouplingId();
        this.b0ch = event.getB0ch();
        this.distance11 = event.getDistance11();
        this.distance12 = event.getDistance12();
        this.distance21 = event.getDistance21();
        this.distance22 = event.getDistance22();
        this.g0ch = event.getG0ch();
        this.r0 = event.getR0();
        this.x0 = event.getX0();
    }
    
    @EventSourcingHandler
    void on(UpdateMutualCouplingEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b0ch = event.getB0ch();
        this.distance11 = event.getDistance11();
        this.distance12 = event.getDistance12();
        this.distance21 = event.getDistance21();
        this.distance22 = event.getDistance22();
        this.g0ch = event.getG0ch();
        this.r0 = event.getR0();
        this.x0 = event.getX0();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID mutualCouplingId;
    
    private String b0ch;
    private String distance11;
    private String distance12;
    private String distance21;
    private String distance22;
    private String g0ch;
    private String r0;
    private String x0;

    private static final Logger LOGGER 	= Logger.getLogger(MutualCouplingAggregate.class.getName());
}
