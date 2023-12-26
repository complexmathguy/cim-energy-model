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
 * Aggregate handler for DCSeriesDevice as outlined for the CQRS pattern, all write responsibilities 
 * related to DCSeriesDevice are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DCSeriesDeviceAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DCSeriesDeviceAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DCSeriesDeviceAggregate(CreateDCSeriesDeviceCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDCSeriesDeviceCommand" );
    	CreateDCSeriesDeviceEvent event = new CreateDCSeriesDeviceEvent(command.getDCSeriesDeviceId(), command.getInductance(), command.getRatedUdc(), command.getResistance());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDCSeriesDeviceCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDCSeriesDeviceCommand" );
    	UpdateDCSeriesDeviceEvent event = new UpdateDCSeriesDeviceEvent(command.getDCSeriesDeviceId(), command.getInductance(), command.getRatedUdc(), command.getResistance());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDCSeriesDeviceCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDCSeriesDeviceCommand" );
        apply(new DeleteDCSeriesDeviceEvent(command.getDCSeriesDeviceId()));
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
    void on(CreateDCSeriesDeviceEvent event) {	
    	LOGGER.info( "Event sourcing CreateDCSeriesDeviceEvent" );
    	this.dCSeriesDeviceId = event.getDCSeriesDeviceId();
        this.inductance = event.getInductance();
        this.ratedUdc = event.getRatedUdc();
        this.resistance = event.getResistance();
    }
    
    @EventSourcingHandler
    void on(UpdateDCSeriesDeviceEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.inductance = event.getInductance();
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
    private UUID dCSeriesDeviceId;
    
    private String inductance;
    private String ratedUdc;
    private String resistance;

    private static final Logger LOGGER 	= Logger.getLogger(DCSeriesDeviceAggregate.class.getName());
}
