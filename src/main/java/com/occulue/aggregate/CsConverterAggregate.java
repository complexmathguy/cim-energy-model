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
 * Aggregate handler for CsConverter as outlined for the CQRS pattern, all write responsibilities 
 * related to CsConverter are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CsConverterAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CsConverterAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CsConverterAggregate(CreateCsConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCsConverterCommand" );
    	CreateCsConverterEvent event = new CreateCsConverterEvent(command.getCsConverterId(), command.getMaxAlpha(), command.getMaxGamma(), command.getMaxIdc(), command.getMinAlpha(), command.getMinGamma(), command.getMinIdc(), command.getRatedIdc());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCsConverterCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCsConverterCommand" );
    	UpdateCsConverterEvent event = new UpdateCsConverterEvent(command.getCsConverterId(), command.getMaxAlpha(), command.getMaxGamma(), command.getMaxIdc(), command.getMinAlpha(), command.getMinGamma(), command.getMinIdc(), command.getRatedIdc());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCsConverterCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCsConverterCommand" );
        apply(new DeleteCsConverterEvent(command.getCsConverterId()));
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
    void on(CreateCsConverterEvent event) {	
    	LOGGER.info( "Event sourcing CreateCsConverterEvent" );
    	this.csConverterId = event.getCsConverterId();
        this.maxAlpha = event.getMaxAlpha();
        this.maxGamma = event.getMaxGamma();
        this.maxIdc = event.getMaxIdc();
        this.minAlpha = event.getMinAlpha();
        this.minGamma = event.getMinGamma();
        this.minIdc = event.getMinIdc();
        this.ratedIdc = event.getRatedIdc();
    }
    
    @EventSourcingHandler
    void on(UpdateCsConverterEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.maxAlpha = event.getMaxAlpha();
        this.maxGamma = event.getMaxGamma();
        this.maxIdc = event.getMaxIdc();
        this.minAlpha = event.getMinAlpha();
        this.minGamma = event.getMinGamma();
        this.minIdc = event.getMinIdc();
        this.ratedIdc = event.getRatedIdc();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID csConverterId;
    
    private String maxAlpha;
    private String maxGamma;
    private String maxIdc;
    private String minAlpha;
    private String minGamma;
    private String minIdc;
    private String ratedIdc;

    private static final Logger LOGGER 	= Logger.getLogger(CsConverterAggregate.class.getName());
}
