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
 * Aggregate handler for CurveData as outlined for the CQRS pattern, all write responsibilities 
 * related to CurveData are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CurveDataAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CurveDataAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CurveDataAggregate(CreateCurveDataCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCurveDataCommand" );
    	CreateCurveDataEvent event = new CreateCurveDataEvent(command.getCurveDataId(), command.getXvalue(), command.getY1value(), command.getY2value());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCurveDataCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCurveDataCommand" );
    	UpdateCurveDataEvent event = new UpdateCurveDataEvent(command.getCurveDataId(), command.getXvalue(), command.getY1value(), command.getY2value());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCurveDataCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCurveDataCommand" );
        apply(new DeleteCurveDataEvent(command.getCurveDataId()));
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
    void on(CreateCurveDataEvent event) {	
    	LOGGER.info( "Event sourcing CreateCurveDataEvent" );
    	this.curveDataId = event.getCurveDataId();
        this.xvalue = event.getXvalue();
        this.y1value = event.getY1value();
        this.y2value = event.getY2value();
    }
    
    @EventSourcingHandler
    void on(UpdateCurveDataEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.xvalue = event.getXvalue();
        this.y1value = event.getY1value();
        this.y2value = event.getY2value();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID curveDataId;
    
    private String xvalue;
    private String y1value;
    private String y2value;

    private static final Logger LOGGER 	= Logger.getLogger(CurveDataAggregate.class.getName());
}
