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
 * Aggregate handler for GeneratingUnit as outlined for the CQRS pattern, all write responsibilities 
 * related to GeneratingUnit are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class GeneratingUnitAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public GeneratingUnitAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public GeneratingUnitAggregate(CreateGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateGeneratingUnitCommand" );
    	CreateGeneratingUnitEvent event = new CreateGeneratingUnitEvent(command.getGeneratingUnitId(), command.getGenControlSource(), command.getGovernorSCD(), command.getInitialP(), command.getLongPF(), command.getMaximumAllowableSpinningReserve(), command.getMaxOperatingP(), command.getMinOperatingP(), command.getNominalP(), command.getRatedGrossMaxP(), command.getRatedGrossMinP(), command.getRatedNetMaxP(), command.getShortPF(), command.getStartupCost(), command.getTotalEfficiency(), command.getVariableCost());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateGeneratingUnitCommand" );
    	UpdateGeneratingUnitEvent event = new UpdateGeneratingUnitEvent(command.getGeneratingUnitId(), command.getGenControlSource(), command.getGovernorSCD(), command.getInitialP(), command.getLongPF(), command.getMaximumAllowableSpinningReserve(), command.getMaxOperatingP(), command.getMinOperatingP(), command.getNominalP(), command.getRatedGrossMaxP(), command.getRatedGrossMinP(), command.getRatedNetMaxP(), command.getShortPF(), command.getStartupCost(), command.getTotalEfficiency(), command.getVariableCost());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteGeneratingUnitCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteGeneratingUnitCommand" );
        apply(new DeleteGeneratingUnitEvent(command.getGeneratingUnitId()));
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
    void on(CreateGeneratingUnitEvent event) {	
    	LOGGER.info( "Event sourcing CreateGeneratingUnitEvent" );
    	this.generatingUnitId = event.getGeneratingUnitId();
        this.genControlSource = event.getGenControlSource();
        this.governorSCD = event.getGovernorSCD();
        this.initialP = event.getInitialP();
        this.longPF = event.getLongPF();
        this.maximumAllowableSpinningReserve = event.getMaximumAllowableSpinningReserve();
        this.maxOperatingP = event.getMaxOperatingP();
        this.minOperatingP = event.getMinOperatingP();
        this.nominalP = event.getNominalP();
        this.ratedGrossMaxP = event.getRatedGrossMaxP();
        this.ratedGrossMinP = event.getRatedGrossMinP();
        this.ratedNetMaxP = event.getRatedNetMaxP();
        this.shortPF = event.getShortPF();
        this.startupCost = event.getStartupCost();
        this.totalEfficiency = event.getTotalEfficiency();
        this.variableCost = event.getVariableCost();
    }
    
    @EventSourcingHandler
    void on(UpdateGeneratingUnitEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.genControlSource = event.getGenControlSource();
        this.governorSCD = event.getGovernorSCD();
        this.initialP = event.getInitialP();
        this.longPF = event.getLongPF();
        this.maximumAllowableSpinningReserve = event.getMaximumAllowableSpinningReserve();
        this.maxOperatingP = event.getMaxOperatingP();
        this.minOperatingP = event.getMinOperatingP();
        this.nominalP = event.getNominalP();
        this.ratedGrossMaxP = event.getRatedGrossMaxP();
        this.ratedGrossMinP = event.getRatedGrossMinP();
        this.ratedNetMaxP = event.getRatedNetMaxP();
        this.shortPF = event.getShortPF();
        this.startupCost = event.getStartupCost();
        this.totalEfficiency = event.getTotalEfficiency();
        this.variableCost = event.getVariableCost();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID generatingUnitId;
    
    private String genControlSource;
    private String governorSCD;
    private String initialP;
    private String longPF;
    private String maximumAllowableSpinningReserve;
    private String maxOperatingP;
    private String minOperatingP;
    private String nominalP;
    private String ratedGrossMaxP;
    private String ratedGrossMinP;
    private String ratedNetMaxP;
    private String shortPF;
    private String startupCost;
    private String totalEfficiency;
    private String variableCost;

    private static final Logger LOGGER 	= Logger.getLogger(GeneratingUnitAggregate.class.getName());
}
