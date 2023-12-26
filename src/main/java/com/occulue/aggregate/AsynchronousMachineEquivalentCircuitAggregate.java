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
 * Aggregate handler for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern, all write responsibilities 
 * related to AsynchronousMachineEquivalentCircuit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class AsynchronousMachineEquivalentCircuitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public AsynchronousMachineEquivalentCircuitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public AsynchronousMachineEquivalentCircuitAggregate(CreateAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateAsynchronousMachineEquivalentCircuitCommand" );
    	CreateAsynchronousMachineEquivalentCircuitEvent event = new CreateAsynchronousMachineEquivalentCircuitEvent(command.getAsynchronousMachineEquivalentCircuitId(), command.getRr1(), command.getRr2(), command.getXlr1(), command.getXlr2(), command.getXm());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateAsynchronousMachineEquivalentCircuitCommand" );
    	UpdateAsynchronousMachineEquivalentCircuitEvent event = new UpdateAsynchronousMachineEquivalentCircuitEvent(command.getAsynchronousMachineEquivalentCircuitId(), command.getRr1(), command.getRr2(), command.getXlr1(), command.getXlr2(), command.getXm());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteAsynchronousMachineEquivalentCircuitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteAsynchronousMachineEquivalentCircuitCommand" );
        apply(new DeleteAsynchronousMachineEquivalentCircuitEvent(command.getAsynchronousMachineEquivalentCircuitId()));
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
    void on(CreateAsynchronousMachineEquivalentCircuitEvent event) {	
    	LOGGER.info( "Event sourcing CreateAsynchronousMachineEquivalentCircuitEvent" );
    	this.asynchronousMachineEquivalentCircuitId = event.getAsynchronousMachineEquivalentCircuitId();
        this.rr1 = event.getRr1();
        this.rr2 = event.getRr2();
        this.xlr1 = event.getXlr1();
        this.xlr2 = event.getXlr2();
        this.xm = event.getXm();
    }
    
    @EventSourcingHandler
    void on(UpdateAsynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.rr1 = event.getRr1();
        this.rr2 = event.getRr2();
        this.xlr1 = event.getXlr1();
        this.xlr2 = event.getXlr2();
        this.xm = event.getXm();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID asynchronousMachineEquivalentCircuitId;
    
    private String rr1;
    private String rr2;
    private String xlr1;
    private String xlr2;
    private String xm;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineEquivalentCircuitAggregate.class.getName());
}
