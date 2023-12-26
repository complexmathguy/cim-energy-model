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
 * Aggregate handler for Curve as outlined for the CQRS pattern, all write responsibilities 
 * related to Curve are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class CurveAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public CurveAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public CurveAggregate(CreateCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateCurveCommand" );
    	CreateCurveEvent event = new CreateCurveEvent(command.getCurveId(), command.getCurveStyle(), command.getXUnit(), command.getY1Unit(), command.getY2Unit());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateCurveCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateCurveCommand" );
    	UpdateCurveEvent event = new UpdateCurveEvent(command.getCurveId(), command.getCurveStyle(), command.getXUnit(), command.getY1Unit(), command.getY2Unit());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteCurveCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteCurveCommand" );
        apply(new DeleteCurveEvent(command.getCurveId()));
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
    void on(CreateCurveEvent event) {	
    	LOGGER.info( "Event sourcing CreateCurveEvent" );
    	this.curveId = event.getCurveId();
        this.curveStyle = event.getCurveStyle();
        this.xUnit = event.getXUnit();
        this.y1Unit = event.getY1Unit();
        this.y2Unit = event.getY2Unit();
    }
    
    @EventSourcingHandler
    void on(UpdateCurveEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.curveStyle = event.getCurveStyle();
        this.xUnit = event.getXUnit();
        this.y1Unit = event.getY1Unit();
        this.y2Unit = event.getY2Unit();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID curveId;
    
    private String curveStyle;
    private String xUnit;
    private String y1Unit;
    private String y2Unit;

    private static final Logger LOGGER 	= Logger.getLogger(CurveAggregate.class.getName());
}
