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
 * Aggregate handler for ExternalNetworkInjection as outlined for the CQRS pattern, all write responsibilities 
 * related to ExternalNetworkInjection are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ExternalNetworkInjectionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ExternalNetworkInjectionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ExternalNetworkInjectionAggregate(CreateExternalNetworkInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateExternalNetworkInjectionCommand" );
    	CreateExternalNetworkInjectionEvent event = new CreateExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId(), command.getGovernorSCD(), command.getIkSecond(), command.getMaxInitialSymShCCurrent(), command.getMaxP(), command.getMaxQ(), command.getMaxR0ToX0Ratio(), command.getMaxR1ToX1Ratio(), command.getMaxZ0ToZ1Ratio(), command.getMinInitialSymShCCurrent(), command.getMinP(), command.getMinQ(), command.getMinR0ToX0Ratio(), command.getMinR1ToX1Ratio(), command.getMinZ0ToZ1Ratio(), command.getVoltageFactor());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateExternalNetworkInjectionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateExternalNetworkInjectionCommand" );
    	UpdateExternalNetworkInjectionEvent event = new UpdateExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId(), command.getGovernorSCD(), command.getIkSecond(), command.getMaxInitialSymShCCurrent(), command.getMaxP(), command.getMaxQ(), command.getMaxR0ToX0Ratio(), command.getMaxR1ToX1Ratio(), command.getMaxZ0ToZ1Ratio(), command.getMinInitialSymShCCurrent(), command.getMinP(), command.getMinQ(), command.getMinR0ToX0Ratio(), command.getMinR1ToX1Ratio(), command.getMinZ0ToZ1Ratio(), command.getVoltageFactor());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteExternalNetworkInjectionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteExternalNetworkInjectionCommand" );
        apply(new DeleteExternalNetworkInjectionEvent(command.getExternalNetworkInjectionId()));
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
    void on(CreateExternalNetworkInjectionEvent event) {	
    	LOGGER.info( "Event sourcing CreateExternalNetworkInjectionEvent" );
    	this.externalNetworkInjectionId = event.getExternalNetworkInjectionId();
        this.governorSCD = event.getGovernorSCD();
        this.ikSecond = event.getIkSecond();
        this.maxInitialSymShCCurrent = event.getMaxInitialSymShCCurrent();
        this.maxP = event.getMaxP();
        this.maxQ = event.getMaxQ();
        this.maxR0ToX0Ratio = event.getMaxR0ToX0Ratio();
        this.maxR1ToX1Ratio = event.getMaxR1ToX1Ratio();
        this.maxZ0ToZ1Ratio = event.getMaxZ0ToZ1Ratio();
        this.minInitialSymShCCurrent = event.getMinInitialSymShCCurrent();
        this.minP = event.getMinP();
        this.minQ = event.getMinQ();
        this.minR0ToX0Ratio = event.getMinR0ToX0Ratio();
        this.minR1ToX1Ratio = event.getMinR1ToX1Ratio();
        this.minZ0ToZ1Ratio = event.getMinZ0ToZ1Ratio();
        this.voltageFactor = event.getVoltageFactor();
    }
    
    @EventSourcingHandler
    void on(UpdateExternalNetworkInjectionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.governorSCD = event.getGovernorSCD();
        this.ikSecond = event.getIkSecond();
        this.maxInitialSymShCCurrent = event.getMaxInitialSymShCCurrent();
        this.maxP = event.getMaxP();
        this.maxQ = event.getMaxQ();
        this.maxR0ToX0Ratio = event.getMaxR0ToX0Ratio();
        this.maxR1ToX1Ratio = event.getMaxR1ToX1Ratio();
        this.maxZ0ToZ1Ratio = event.getMaxZ0ToZ1Ratio();
        this.minInitialSymShCCurrent = event.getMinInitialSymShCCurrent();
        this.minP = event.getMinP();
        this.minQ = event.getMinQ();
        this.minR0ToX0Ratio = event.getMinR0ToX0Ratio();
        this.minR1ToX1Ratio = event.getMinR1ToX1Ratio();
        this.minZ0ToZ1Ratio = event.getMinZ0ToZ1Ratio();
        this.voltageFactor = event.getVoltageFactor();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID externalNetworkInjectionId;
    
    private String governorSCD;
    private String ikSecond;
    private String maxInitialSymShCCurrent;
    private String maxP;
    private String maxQ;
    private String maxR0ToX0Ratio;
    private String maxR1ToX1Ratio;
    private String maxZ0ToZ1Ratio;
    private String minInitialSymShCCurrent;
    private String minP;
    private String minQ;
    private String minR0ToX0Ratio;
    private String minR1ToX1Ratio;
    private String minZ0ToZ1Ratio;
    private String voltageFactor;

    private static final Logger LOGGER 	= Logger.getLogger(ExternalNetworkInjectionAggregate.class.getName());
}
