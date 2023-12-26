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
 * Aggregate handler for VsConverter as outlined for the CQRS pattern, all write responsibilities 
 * related to VsConverter are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class VsConverterAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public VsConverterAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public VsConverterAggregate(CreateVsConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateVsConverterCommand" );
    	CreateVsConverterEvent event = new CreateVsConverterEvent(command.getVsConverterId(), command.getMaxModulationIndex(), command.getMaxValveCurrent());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateVsConverterCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateVsConverterCommand" );
    	UpdateVsConverterEvent event = new UpdateVsConverterEvent(command.getVsConverterId(), command.getMaxModulationIndex(), command.getMaxValveCurrent());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteVsConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteVsConverterCommand" );
        apply(new DeleteVsConverterEvent(command.getVsConverterId()));
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
    void on(CreateVsConverterEvent event) {	
    	LOGGER.info( "Event sourcing CreateVsConverterEvent" );
    	this.vsConverterId = event.getVsConverterId();
        this.maxModulationIndex = event.getMaxModulationIndex();
        this.maxValveCurrent = event.getMaxValveCurrent();
    }
    
    @EventSourcingHandler
    void on(UpdateVsConverterEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.maxModulationIndex = event.getMaxModulationIndex();
        this.maxValveCurrent = event.getMaxValveCurrent();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID vsConverterId;
    
    private String maxModulationIndex;
    private String maxValveCurrent;

    private static final Logger LOGGER 	= Logger.getLogger(VsConverterAggregate.class.getName());
}
