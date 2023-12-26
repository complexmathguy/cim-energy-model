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
 * Aggregate handler for WindProtectionIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindProtectionIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindProtectionIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindProtectionIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindProtectionIECAggregate(CreateWindProtectionIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindProtectionIECCommand" );
    	CreateWindProtectionIECEvent event = new CreateWindProtectionIECEvent(command.getWindProtectionIECId(), command.getFover(), command.getFunder(), command.getTfover(), command.getTfunder(), command.getTuover(), command.getTuunder(), command.getUover(), command.getUunder());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindProtectionIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindProtectionIECCommand" );
    	UpdateWindProtectionIECEvent event = new UpdateWindProtectionIECEvent(command.getWindProtectionIECId(), command.getFover(), command.getFunder(), command.getTfover(), command.getTfunder(), command.getTuover(), command.getTuunder(), command.getUover(), command.getUunder());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindProtectionIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindProtectionIECCommand" );
        apply(new DeleteWindProtectionIECEvent(command.getWindProtectionIECId()));
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
    void on(CreateWindProtectionIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindProtectionIECEvent" );
    	this.windProtectionIECId = event.getWindProtectionIECId();
        this.fover = event.getFover();
        this.funder = event.getFunder();
        this.tfover = event.getTfover();
        this.tfunder = event.getTfunder();
        this.tuover = event.getTuover();
        this.tuunder = event.getTuunder();
        this.uover = event.getUover();
        this.uunder = event.getUunder();
    }
    
    @EventSourcingHandler
    void on(UpdateWindProtectionIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.fover = event.getFover();
        this.funder = event.getFunder();
        this.tfover = event.getTfover();
        this.tfunder = event.getTfunder();
        this.tuover = event.getTuover();
        this.tuunder = event.getTuunder();
        this.uover = event.getUover();
        this.uunder = event.getUunder();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windProtectionIECId;
    
    private String fover;
    private String funder;
    private String tfover;
    private String tfunder;
    private String tuover;
    private String tuunder;
    private String uover;
    private String uunder;

    private static final Logger LOGGER 	= Logger.getLogger(WindProtectionIECAggregate.class.getName());
}
