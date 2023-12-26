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
 * Aggregate handler for ACDCConverter as outlined for the CQRS pattern, all write responsibilities 
 * related to ACDCConverter are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ACDCConverterAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ACDCConverterAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ACDCConverterAggregate(CreateACDCConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateACDCConverterCommand" );
    	CreateACDCConverterEvent event = new CreateACDCConverterEvent(command.getACDCConverterId(), command.getBaseS(), command.getIdleLoss(), command.getMaxUdc(), command.getMinUdc(), command.getNumberOfValves(), command.getRatedUdc(), command.getResistiveLoss(), command.getSwitchingLoss(), command.getValveU0());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateACDCConverterCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateACDCConverterCommand" );
    	UpdateACDCConverterEvent event = new UpdateACDCConverterEvent(command.getACDCConverterId(), command.getBaseS(), command.getIdleLoss(), command.getMaxUdc(), command.getMinUdc(), command.getNumberOfValves(), command.getRatedUdc(), command.getResistiveLoss(), command.getSwitchingLoss(), command.getValveU0());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteACDCConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteACDCConverterCommand" );
        apply(new DeleteACDCConverterEvent(command.getACDCConverterId()));
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
    void on(CreateACDCConverterEvent event) {	
    	LOGGER.info( "Event sourcing CreateACDCConverterEvent" );
    	this.aCDCConverterId = event.getACDCConverterId();
        this.baseS = event.getBaseS();
        this.idleLoss = event.getIdleLoss();
        this.maxUdc = event.getMaxUdc();
        this.minUdc = event.getMinUdc();
        this.numberOfValves = event.getNumberOfValves();
        this.ratedUdc = event.getRatedUdc();
        this.resistiveLoss = event.getResistiveLoss();
        this.switchingLoss = event.getSwitchingLoss();
        this.valveU0 = event.getValveU0();
    }
    
    @EventSourcingHandler
    void on(UpdateACDCConverterEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.baseS = event.getBaseS();
        this.idleLoss = event.getIdleLoss();
        this.maxUdc = event.getMaxUdc();
        this.minUdc = event.getMinUdc();
        this.numberOfValves = event.getNumberOfValves();
        this.ratedUdc = event.getRatedUdc();
        this.resistiveLoss = event.getResistiveLoss();
        this.switchingLoss = event.getSwitchingLoss();
        this.valveU0 = event.getValveU0();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID aCDCConverterId;
    
    private String baseS;
    private String idleLoss;
    private String maxUdc;
    private String minUdc;
    private String numberOfValves;
    private String ratedUdc;
    private String resistiveLoss;
    private String switchingLoss;
    private String valveU0;

    private static final Logger LOGGER 	= Logger.getLogger(ACDCConverterAggregate.class.getName());
}
