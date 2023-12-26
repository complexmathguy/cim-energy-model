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
 * Aggregate handler for TapChangerTablePoint as outlined for the CQRS pattern, all write responsibilities 
 * related to TapChangerTablePoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TapChangerTablePointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TapChangerTablePointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TapChangerTablePointAggregate(CreateTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTapChangerTablePointCommand" );
    	CreateTapChangerTablePointEvent event = new CreateTapChangerTablePointEvent(command.getTapChangerTablePointId(), command.getB(), command.getG(), command.getR(), command.getRatio(), command.getStep(), command.getX());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTapChangerTablePointCommand" );
    	UpdateTapChangerTablePointEvent event = new UpdateTapChangerTablePointEvent(command.getTapChangerTablePointId(), command.getB(), command.getG(), command.getR(), command.getRatio(), command.getStep(), command.getX());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTapChangerTablePointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTapChangerTablePointCommand" );
        apply(new DeleteTapChangerTablePointEvent(command.getTapChangerTablePointId()));
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
    void on(CreateTapChangerTablePointEvent event) {	
    	LOGGER.info( "Event sourcing CreateTapChangerTablePointEvent" );
    	this.tapChangerTablePointId = event.getTapChangerTablePointId();
        this.b = event.getB();
        this.g = event.getG();
        this.r = event.getR();
        this.ratio = event.getRatio();
        this.step = event.getStep();
        this.x = event.getX();
    }
    
    @EventSourcingHandler
    void on(UpdateTapChangerTablePointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.b = event.getB();
        this.g = event.getG();
        this.r = event.getR();
        this.ratio = event.getRatio();
        this.step = event.getStep();
        this.x = event.getX();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID tapChangerTablePointId;
    
    private String b;
    private String g;
    private String r;
    private String ratio;
    private String step;
    private String x;

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerTablePointAggregate.class.getName());
}
