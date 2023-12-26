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
 * Aggregate handler for DCShunt as outlined for the CQRS pattern, all write responsibilities 
 * related to DCShunt are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCShuntAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCShuntAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCShuntAggregate(CreateDCShuntCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCShuntCommand" );
    	CreateDCShuntEvent event = new CreateDCShuntEvent(command.getDCShuntId(), command.getCapacitance(), command.getRatedUdc(), command.getResistance());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCShuntCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCShuntCommand" );
    	UpdateDCShuntEvent event = new UpdateDCShuntEvent(command.getDCShuntId(), command.getCapacitance(), command.getRatedUdc(), command.getResistance());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCShuntCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCShuntCommand" );
        apply(new DeleteDCShuntEvent(command.getDCShuntId()));
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
    void on(CreateDCShuntEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCShuntEvent" );
    	this.dCShuntId = event.getDCShuntId();
        this.capacitance = event.getCapacitance();
        this.ratedUdc = event.getRatedUdc();
        this.resistance = event.getResistance();
    }
    
    @EventSourcingHandler
    void on(UpdateDCShuntEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.capacitance = event.getCapacitance();
        this.ratedUdc = event.getRatedUdc();
        this.resistance = event.getResistance();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID dCShuntId;
    
    private String capacitance;
    private String ratedUdc;
    private String resistance;

    private static final Logger LOGGER 	= Logger.getLogger(DCShuntAggregate.class.getName());
}
