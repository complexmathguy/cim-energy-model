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
 * Aggregate handler for SwitchIt as outlined for the CQRS pattern, all write responsibilities 
 * related to SwitchIt are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SwitchItAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SwitchItAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SwitchItAggregate(CreateSwitchItCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSwitchItCommand" );
    	CreateSwitchItEvent event = new CreateSwitchItEvent(command.getSwitchItId(), command.getOpen());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSwitchItCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSwitchItCommand" );
    	UpdateSwitchItEvent event = new UpdateSwitchItEvent(command.getSwitchItId(), command.getOpen());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSwitchItCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSwitchItCommand" );
        apply(new DeleteSwitchItEvent(command.getSwitchItId()));
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
    void on(CreateSwitchItEvent event) {	
    	LOGGER.info( "Event sourcing CreateSwitchItEvent" );
    	this.switchItId = event.getSwitchItId();
        this.open = event.getOpen();
    }
    
    @EventSourcingHandler
    void on(UpdateSwitchItEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.open = event.getOpen();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID switchItId;
    
    private String open;

    private static final Logger LOGGER 	= Logger.getLogger(SwitchItAggregate.class.getName());
}
