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
 * Aggregate handler for RegularTimePoint as outlined for the CQRS pattern, all write responsibilities 
 * related to RegularTimePoint are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class RegularTimePointAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public RegularTimePointAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public RegularTimePointAggregate(CreateRegularTimePointCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateRegularTimePointCommand" );
    	CreateRegularTimePointEvent event = new CreateRegularTimePointEvent(command.getRegularTimePointId(), command.getSequenceNumber(), command.getValue1(), command.getValue2());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateRegularTimePointCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateRegularTimePointCommand" );
    	UpdateRegularTimePointEvent event = new UpdateRegularTimePointEvent(command.getRegularTimePointId(), command.getSequenceNumber(), command.getValue1(), command.getValue2());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteRegularTimePointCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteRegularTimePointCommand" );
        apply(new DeleteRegularTimePointEvent(command.getRegularTimePointId()));
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
    void on(CreateRegularTimePointEvent event) {	
    	LOGGER.info( "Event sourcing CreateRegularTimePointEvent" );
    	this.regularTimePointId = event.getRegularTimePointId();
        this.sequenceNumber = event.getSequenceNumber();
        this.value1 = event.getValue1();
        this.value2 = event.getValue2();
    }
    
    @EventSourcingHandler
    void on(UpdateRegularTimePointEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.sequenceNumber = event.getSequenceNumber();
        this.value1 = event.getValue1();
        this.value2 = event.getValue2();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID regularTimePointId;
    
    private String sequenceNumber;
    private String value1;
    private String value2;

    private static final Logger LOGGER 	= Logger.getLogger(RegularTimePointAggregate.class.getName());
}
