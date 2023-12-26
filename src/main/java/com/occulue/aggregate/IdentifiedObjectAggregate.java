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
 * Aggregate handler for IdentifiedObject as outlined for the CQRS pattern, all write responsibilities 
 * related to IdentifiedObject are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class IdentifiedObjectAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public IdentifiedObjectAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public IdentifiedObjectAggregate(CreateIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateIdentifiedObjectCommand" );
    	CreateIdentifiedObjectEvent event = new CreateIdentifiedObjectEvent(command.getIdentifiedObjectId(), command.getDescription(), command.getEnergyIdentCodeEic(), command.getMRID(), command.getName(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateIdentifiedObjectCommand" );
    	UpdateIdentifiedObjectEvent event = new UpdateIdentifiedObjectEvent(command.getIdentifiedObjectId(), command.getDescription(), command.getEnergyIdentCodeEic(), command.getMRID(), command.getName(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteIdentifiedObjectCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteIdentifiedObjectCommand" );
        apply(new DeleteIdentifiedObjectEvent(command.getIdentifiedObjectId()));
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
    void on(CreateIdentifiedObjectEvent event) {	
    	LOGGER.info( "Event sourcing CreateIdentifiedObjectEvent" );
    	this.identifiedObjectId = event.getIdentifiedObjectId();
        this.description = event.getDescription();
        this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
        this.mRID = event.getMRID();
        this.name = event.getName();
        this.shortName = event.getShortName();
    }
    
    @EventSourcingHandler
    void on(UpdateIdentifiedObjectEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.description = event.getDescription();
        this.energyIdentCodeEic = event.getEnergyIdentCodeEic();
        this.mRID = event.getMRID();
        this.name = event.getName();
        this.shortName = event.getShortName();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID identifiedObjectId;
    
    private String description;
    private String energyIdentCodeEic;
    private String mRID;
    private String name;
    private String shortName;

    private static final Logger LOGGER 	= Logger.getLogger(IdentifiedObjectAggregate.class.getName());
}
