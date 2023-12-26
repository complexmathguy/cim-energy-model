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
 * Aggregate handler for WindGenType4IEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindGenType4IEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindGenType4IECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindGenType4IECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindGenType4IECAggregate(CreateWindGenType4IECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindGenType4IECCommand" );
    	CreateWindGenType4IECEvent event = new CreateWindGenType4IECEvent(command.getWindGenType4IECId(), command.getDipmax(), command.getDiqmax(), command.getDiqmin(), command.getTg());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindGenType4IECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindGenType4IECCommand" );
    	UpdateWindGenType4IECEvent event = new UpdateWindGenType4IECEvent(command.getWindGenType4IECId(), command.getDipmax(), command.getDiqmax(), command.getDiqmin(), command.getTg());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindGenType4IECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindGenType4IECCommand" );
        apply(new DeleteWindGenType4IECEvent(command.getWindGenType4IECId()));
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
    void on(CreateWindGenType4IECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindGenType4IECEvent" );
    	this.windGenType4IECId = event.getWindGenType4IECId();
        this.dipmax = event.getDipmax();
        this.diqmax = event.getDiqmax();
        this.diqmin = event.getDiqmin();
        this.tg = event.getTg();
    }
    
    @EventSourcingHandler
    void on(UpdateWindGenType4IECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dipmax = event.getDipmax();
        this.diqmax = event.getDiqmax();
        this.diqmin = event.getDiqmin();
        this.tg = event.getTg();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windGenType4IECId;
    
    private String dipmax;
    private String diqmax;
    private String diqmin;
    private String tg;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenType4IECAggregate.class.getName());
}
