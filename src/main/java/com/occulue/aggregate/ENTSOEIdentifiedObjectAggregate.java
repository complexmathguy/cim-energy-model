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
 * Aggregate handler for ENTSOEIdentifiedObject as outlined for the CQRS pattern, all write responsibilities 
 * related to ENTSOEIdentifiedObject are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ENTSOEIdentifiedObjectAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ENTSOEIdentifiedObjectAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ENTSOEIdentifiedObjectAggregate(CreateENTSOEIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateENTSOEIdentifiedObjectCommand" );
    	CreateENTSOEIdentifiedObjectEvent event = new CreateENTSOEIdentifiedObjectEvent(command.getENTSOEIdentifiedObjectId(), command.getEnergyIdentCodeEic(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateENTSOEIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateENTSOEIdentifiedObjectCommand" );
    	UpdateENTSOEIdentifiedObjectEvent event = new UpdateENTSOEIdentifiedObjectEvent(command.getENTSOEIdentifiedObjectId(), command.getEnergyIdentCodeEic(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteENTSOEIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteENTSOEIdentifiedObjectCommand" );
        apply(new DeleteENTSOEIdentifiedObjectEvent(command.getENTSOEIdentifiedObjectId()));
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
    void on(CreateENTSOEIdentifiedObjectEvent event) {	
    	LOGGER.info( "Event sourcing CreateENTSOEIdentifiedObjectEvent" );
    	this.eNTSOEIdentifiedObjectId = event.getENTSOEIdentifiedObjectId();
        this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
        this.shortName = event.getShortName();
    }
    
    @EventSourcingHandler
    void on(UpdateENTSOEIdentifiedObjectEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
        this.shortName = event.getShortName();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID eNTSOEIdentifiedObjectId;
    
    private String energyIdentCodeEic;
    private String shortName;

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEIdentifiedObjectAggregate.class.getName());
}
