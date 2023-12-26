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
 * Aggregate handler for WindMechIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindMechIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindMechIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindMechIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindMechIECAggregate(CreateWindMechIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindMechIECCommand" );
    	CreateWindMechIECEvent event = new CreateWindMechIECEvent(command.getWindMechIECId(), command.getCdrt(), command.getHgen(), command.getHwtr(), command.getKdrt());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindMechIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindMechIECCommand" );
    	UpdateWindMechIECEvent event = new UpdateWindMechIECEvent(command.getWindMechIECId(), command.getCdrt(), command.getHgen(), command.getHwtr(), command.getKdrt());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindMechIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindMechIECCommand" );
        apply(new DeleteWindMechIECEvent(command.getWindMechIECId()));
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
    void on(CreateWindMechIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindMechIECEvent" );
    	this.windMechIECId = event.getWindMechIECId();
        this.cdrt = event.getCdrt();
        this.hgen = event.getHgen();
        this.hwtr = event.getHwtr();
        this.kdrt = event.getKdrt();
    }
    
    @EventSourcingHandler
    void on(UpdateWindMechIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.cdrt = event.getCdrt();
        this.hgen = event.getHgen();
        this.hwtr = event.getHwtr();
        this.kdrt = event.getKdrt();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windMechIECId;
    
    private String cdrt;
    private String hgen;
    private String hwtr;
    private String kdrt;

    private static final Logger LOGGER 	= Logger.getLogger(WindMechIECAggregate.class.getName());
}
