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
 * Aggregate handler for RotatingMachineDynamics as outlined for the CQRS pattern, all write responsibilities 
 * related to RotatingMachineDynamics are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RotatingMachineDynamicsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RotatingMachineDynamicsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RotatingMachineDynamicsAggregate(CreateRotatingMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRotatingMachineDynamicsCommand" );
    	CreateRotatingMachineDynamicsEvent event = new CreateRotatingMachineDynamicsEvent(command.getRotatingMachineDynamicsId(), command.getDamping(), command.getInertia(), command.getSaturationFactor(), command.getSaturationFactor120(), command.getStatorLeakageReactance(), command.getStatorResistance());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRotatingMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRotatingMachineDynamicsCommand" );
    	UpdateRotatingMachineDynamicsEvent event = new UpdateRotatingMachineDynamicsEvent(command.getRotatingMachineDynamicsId(), command.getDamping(), command.getInertia(), command.getSaturationFactor(), command.getSaturationFactor120(), command.getStatorLeakageReactance(), command.getStatorResistance());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRotatingMachineDynamicsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRotatingMachineDynamicsCommand" );
        apply(new DeleteRotatingMachineDynamicsEvent(command.getRotatingMachineDynamicsId()));
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
    void on(CreateRotatingMachineDynamicsEvent event) {	
    	LOGGER.info( "Event sourcing CreateRotatingMachineDynamicsEvent" );
    	this.rotatingMachineDynamicsId = event.getRotatingMachineDynamicsId();
        this.damping = event.getDamping();
        this.inertia = event.getInertia();
        this.saturationFactor = event.getSaturationFactor();
        this.saturationFactor120 = event.getSaturationFactor120();
        this.statorLeakageReactance = event.getStatorLeakageReactance();
        this.statorResistance = event.getStatorResistance();
    }
    
    @EventSourcingHandler
    void on(UpdateRotatingMachineDynamicsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.damping = event.getDamping();
        this.inertia = event.getInertia();
        this.saturationFactor = event.getSaturationFactor();
        this.saturationFactor120 = event.getSaturationFactor120();
        this.statorLeakageReactance = event.getStatorLeakageReactance();
        this.statorResistance = event.getStatorResistance();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID rotatingMachineDynamicsId;
    
    private String damping;
    private String inertia;
    private String saturationFactor;
    private String saturationFactor120;
    private String statorLeakageReactance;
    private String statorResistance;

    private static final Logger LOGGER 	= Logger.getLogger(RotatingMachineDynamicsAggregate.class.getName());
}
