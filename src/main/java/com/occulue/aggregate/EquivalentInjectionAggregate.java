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
 * Aggregate handler for EquivalentInjection as outlined for the CQRS pattern, all write responsibilities 
 * related to EquivalentInjection are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquivalentInjectionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquivalentInjectionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquivalentInjectionAggregate(CreateEquivalentInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquivalentInjectionCommand" );
    	CreateEquivalentInjectionEvent event = new CreateEquivalentInjectionEvent(command.getEquivalentInjectionId(), command.getMaxP(), command.getMaxQ(), command.getMinP(), command.getMinQ(), command.getR(), command.getR0(), command.getR2(), command.getRegulationCapability(), command.getX(), command.getX0(), command.getX2());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquivalentInjectionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquivalentInjectionCommand" );
    	UpdateEquivalentInjectionEvent event = new UpdateEquivalentInjectionEvent(command.getEquivalentInjectionId(), command.getMaxP(), command.getMaxQ(), command.getMinP(), command.getMinQ(), command.getR(), command.getR0(), command.getR2(), command.getRegulationCapability(), command.getX(), command.getX0(), command.getX2());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquivalentInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquivalentInjectionCommand" );
        apply(new DeleteEquivalentInjectionEvent(command.getEquivalentInjectionId()));
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
    void on(CreateEquivalentInjectionEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquivalentInjectionEvent" );
    	this.equivalentInjectionId = event.getEquivalentInjectionId();
        this.maxP = event.getMaxP();
        this.maxQ = event.getMaxQ();
        this.minP = event.getMinP();
        this.minQ = event.getMinQ();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.r2 = event.getR2();
        this.regulationCapability = event.getRegulationCapability();
        this.x = event.getX();
        this.x0 = event.getX0();
        this.x2 = event.getX2();
    }
    
    @EventSourcingHandler
    void on(UpdateEquivalentInjectionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.maxP = event.getMaxP();
        this.maxQ = event.getMaxQ();
        this.minP = event.getMinP();
        this.minQ = event.getMinQ();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.r2 = event.getR2();
        this.regulationCapability = event.getRegulationCapability();
        this.x = event.getX();
        this.x0 = event.getX0();
        this.x2 = event.getX2();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID equivalentInjectionId;
    
    private String maxP;
    private String maxQ;
    private String minP;
    private String minQ;
    private String r;
    private String r0;
    private String r2;
    private String regulationCapability;
    private String x;
    private String x0;
    private String x2;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentInjectionAggregate.class.getName());
}
