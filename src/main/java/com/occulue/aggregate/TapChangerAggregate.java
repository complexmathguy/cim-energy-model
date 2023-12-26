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
 * Aggregate handler for TapChanger as outlined for the CQRS pattern, all write responsibilities 
 * related to TapChanger are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TapChangerAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TapChangerAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TapChangerAggregate(CreateTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTapChangerCommand" );
    	CreateTapChangerEvent event = new CreateTapChangerEvent(command.getTapChangerId(), command.getHighStep(), command.getLowStep(), command.getLtcFlag(), command.getNeutralStep(), command.getNeutralU(), command.getNormalStep());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTapChangerCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTapChangerCommand" );
    	UpdateTapChangerEvent event = new UpdateTapChangerEvent(command.getTapChangerId(), command.getHighStep(), command.getLowStep(), command.getLtcFlag(), command.getNeutralStep(), command.getNeutralU(), command.getNormalStep());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTapChangerCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTapChangerCommand" );
        apply(new DeleteTapChangerEvent(command.getTapChangerId()));
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
    void on(CreateTapChangerEvent event) {	
    	LOGGER.info( "Event sourcing CreateTapChangerEvent" );
    	this.tapChangerId = event.getTapChangerId();
        this.highStep = event.getHighStep();
        this.lowStep = event.getLowStep();
        this.ltcFlag = event.getLtcFlag();
        this.neutralStep = event.getNeutralStep();
        this.neutralU = event.getNeutralU();
        this.normalStep = event.getNormalStep();
    }
    
    @EventSourcingHandler
    void on(UpdateTapChangerEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.highStep = event.getHighStep();
        this.lowStep = event.getLowStep();
        this.ltcFlag = event.getLtcFlag();
        this.neutralStep = event.getNeutralStep();
        this.neutralU = event.getNeutralU();
        this.normalStep = event.getNormalStep();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID tapChangerId;
    
    private String highStep;
    private String lowStep;
    private String ltcFlag;
    private String neutralStep;
    private String neutralU;
    private String normalStep;

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerAggregate.class.getName());
}
