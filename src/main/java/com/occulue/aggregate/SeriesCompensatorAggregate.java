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
 * Aggregate handler for SeriesCompensator as outlined for the CQRS pattern, all write responsibilities 
 * related to SeriesCompensator are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SeriesCompensatorAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SeriesCompensatorAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SeriesCompensatorAggregate(CreateSeriesCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSeriesCompensatorCommand" );
    	CreateSeriesCompensatorEvent event = new CreateSeriesCompensatorEvent(command.getSeriesCompensatorId(), command.getR(), command.getR0(), command.getVaristorPresent(), command.getVaristorRatedCurrent(), command.getVaristorVoltageThreshold(), command.getX(), command.getX0());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSeriesCompensatorCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSeriesCompensatorCommand" );
    	UpdateSeriesCompensatorEvent event = new UpdateSeriesCompensatorEvent(command.getSeriesCompensatorId(), command.getR(), command.getR0(), command.getVaristorPresent(), command.getVaristorRatedCurrent(), command.getVaristorVoltageThreshold(), command.getX(), command.getX0());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSeriesCompensatorCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSeriesCompensatorCommand" );
        apply(new DeleteSeriesCompensatorEvent(command.getSeriesCompensatorId()));
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
    void on(CreateSeriesCompensatorEvent event) {	
    	LOGGER.info( "Event sourcing CreateSeriesCompensatorEvent" );
    	this.seriesCompensatorId = event.getSeriesCompensatorId();
        this.r = event.getR();
        this.r0 = event.getR0();
        this.varistorPresent = event.getVaristorPresent();
        this.varistorRatedCurrent = event.getVaristorRatedCurrent();
        this.varistorVoltageThreshold = event.getVaristorVoltageThreshold();
        this.x = event.getX();
        this.x0 = event.getX0();
    }
    
    @EventSourcingHandler
    void on(UpdateSeriesCompensatorEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.r = event.getR();
        this.r0 = event.getR0();
        this.varistorPresent = event.getVaristorPresent();
        this.varistorRatedCurrent = event.getVaristorRatedCurrent();
        this.varistorVoltageThreshold = event.getVaristorVoltageThreshold();
        this.x = event.getX();
        this.x0 = event.getX0();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID seriesCompensatorId;
    
    private String r;
    private String r0;
    private String varistorPresent;
    private String varistorRatedCurrent;
    private String varistorVoltageThreshold;
    private String x;
    private String x0;

    private static final Logger LOGGER 	= Logger.getLogger(SeriesCompensatorAggregate.class.getName());
}
