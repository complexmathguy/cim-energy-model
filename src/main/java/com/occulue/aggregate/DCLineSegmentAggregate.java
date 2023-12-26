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
 * Aggregate handler for DCLineSegment as outlined for the CQRS pattern, all write responsibilities 
 * related to DCLineSegment are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCLineSegmentAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCLineSegmentAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCLineSegmentAggregate(CreateDCLineSegmentCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCLineSegmentCommand" );
    	CreateDCLineSegmentEvent event = new CreateDCLineSegmentEvent(command.getDCLineSegmentId(), command.getCapacitance(), command.getInductance(), command.getLength(), command.getResistance());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCLineSegmentCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCLineSegmentCommand" );
    	UpdateDCLineSegmentEvent event = new UpdateDCLineSegmentEvent(command.getDCLineSegmentId(), command.getCapacitance(), command.getInductance(), command.getLength(), command.getResistance());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCLineSegmentCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCLineSegmentCommand" );
        apply(new DeleteDCLineSegmentEvent(command.getDCLineSegmentId()));
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
    void on(CreateDCLineSegmentEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCLineSegmentEvent" );
    	this.dCLineSegmentId = event.getDCLineSegmentId();
        this.capacitance = event.getCapacitance();
        this.inductance = event.getInductance();
        this.length = event.getLength();
        this.resistance = event.getResistance();
    }
    
    @EventSourcingHandler
    void on(UpdateDCLineSegmentEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.capacitance = event.getCapacitance();
        this.inductance = event.getInductance();
        this.length = event.getLength();
        this.resistance = event.getResistance();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCLineSegmentId;
    
    private String capacitance;
    private String inductance;
    private String length;
    private String resistance;

    private static final Logger LOGGER 	= Logger.getLogger(DCLineSegmentAggregate.class.getName());
}
