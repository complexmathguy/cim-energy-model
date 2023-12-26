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
 * Aggregate handler for WindAeroLinearIEC as outlined for the CQRS pattern, all write responsibilities 
 * related to WindAeroLinearIEC are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class WindAeroLinearIECAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public WindAeroLinearIECAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public WindAeroLinearIECAggregate(CreateWindAeroLinearIECCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateWindAeroLinearIECCommand" );
    	CreateWindAeroLinearIECEvent event = new CreateWindAeroLinearIECEvent(command.getWindAeroLinearIECId(), command.getDpomega(), command.getDptheta(), command.getOmegazero(), command.getPavail(), command.getThetazero());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateWindAeroLinearIECCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateWindAeroLinearIECCommand" );
    	UpdateWindAeroLinearIECEvent event = new UpdateWindAeroLinearIECEvent(command.getWindAeroLinearIECId(), command.getDpomega(), command.getDptheta(), command.getOmegazero(), command.getPavail(), command.getThetazero());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteWindAeroLinearIECCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteWindAeroLinearIECCommand" );
        apply(new DeleteWindAeroLinearIECEvent(command.getWindAeroLinearIECId()));
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
    void on(CreateWindAeroLinearIECEvent event) {	
    	LOGGER.info( "Event sourcing CreateWindAeroLinearIECEvent" );
    	this.windAeroLinearIECId = event.getWindAeroLinearIECId();
        this.dpomega = event.getDpomega();
        this.dptheta = event.getDptheta();
        this.omegazero = event.getOmegazero();
        this.pavail = event.getPavail();
        this.thetazero = event.getThetazero();
    }
    
    @EventSourcingHandler
    void on(UpdateWindAeroLinearIECEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.dpomega = event.getDpomega();
        this.dptheta = event.getDptheta();
        this.omegazero = event.getOmegazero();
        this.pavail = event.getPavail();
        this.thetazero = event.getThetazero();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID windAeroLinearIECId;
    
    private String dpomega;
    private String dptheta;
    private String omegazero;
    private String pavail;
    private String thetazero;

    private static final Logger LOGGER 	= Logger.getLogger(WindAeroLinearIECAggregate.class.getName());
}
