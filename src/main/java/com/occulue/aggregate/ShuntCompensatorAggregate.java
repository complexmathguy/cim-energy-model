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
 * Aggregate handler for ShuntCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to ShuntCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ShuntCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ShuntCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ShuntCompensatorAggregate(CreateShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateShuntCompensatorCommand" );
    	CreateShuntCompensatorEvent event = new CreateShuntCompensatorEvent(command.getShuntCompensatorId(), command.getAVRDelay(), command.getGrounded(), command.getMaximumSections(), command.getNomU(), command.getNormalSections(), command.getSwitchOnCount(), command.getSwitchOnDate(), command.getVoltageSensitivity());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateShuntCompensatorCommand" );
    	UpdateShuntCompensatorEvent event = new UpdateShuntCompensatorEvent(command.getShuntCompensatorId(), command.getAVRDelay(), command.getGrounded(), command.getMaximumSections(), command.getNomU(), command.getNormalSections(), command.getSwitchOnCount(), command.getSwitchOnDate(), command.getVoltageSensitivity());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteShuntCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteShuntCompensatorCommand" );
        apply(new DeleteShuntCompensatorEvent(command.getShuntCompensatorId()));
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
    void on(CreateShuntCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateShuntCompensatorEvent" );
    	this.shuntCompensatorId = event.getShuntCompensatorId();
        this.aVRDelay = event.getAVRDelay();
        this.grounded = event.getGrounded();
        this.maximumSections = event.getMaximumSections();
        this.nomU = event.getNomU();
        this.normalSections = event.getNormalSections();
        this.switchOnCount = event.getSwitchOnCount();
        this.switchOnDate = event.getSwitchOnDate();
        this.voltageSensitivity = event.getVoltageSensitivity();
    }
    
    @EventSourcingHandler
    void on(UpdateShuntCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.aVRDelay = event.getAVRDelay();
        this.grounded = event.getGrounded();
        this.maximumSections = event.getMaximumSections();
        this.nomU = event.getNomU();
        this.normalSections = event.getNormalSections();
        this.switchOnCount = event.getSwitchOnCount();
        this.switchOnDate = event.getSwitchOnDate();
        this.voltageSensitivity = event.getVoltageSensitivity();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID shuntCompensatorId;
    
    private String aVRDelay;
    private String grounded;
    private String maximumSections;
    private String nomU;
    private String normalSections;
    private String switchOnCount;
    private String switchOnDate;
    private String voltageSensitivity;

    private static final Logger LOGGER 	= Logger.getLogger(ShuntCompensatorAggregate.class.getName());
}
