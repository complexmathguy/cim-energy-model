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
 * Aggregate handler for BoundaryExtensions as outlined for the CQRS pattern, all write responsibilities 
 * related to BoundaryExtensions are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class BoundaryExtensionsAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public BoundaryExtensionsAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public BoundaryExtensionsAggregate(CreateBoundaryExtensionsCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateBoundaryExtensionsCommand" );
    	CreateBoundaryExtensionsEvent event = new CreateBoundaryExtensionsEvent(command.getBoundaryExtensionsId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateBoundaryExtensionsCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateBoundaryExtensionsCommand" );
    	UpdateBoundaryExtensionsEvent event = new UpdateBoundaryExtensionsEvent(command.getBoundaryExtensionsId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteBoundaryExtensionsCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteBoundaryExtensionsCommand" );
        apply(new DeleteBoundaryExtensionsEvent(command.getBoundaryExtensionsId()));
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
    void on(CreateBoundaryExtensionsEvent event) {	
    	LOGGER.info( "Event sourcing CreateBoundaryExtensionsEvent" );
    	this.boundaryExtensionsId = event.getBoundaryExtensionsId();
        this.boundaryPoint = event.getBoundaryPoint();
        this.fromEndIsoCode = event.getFromEndIsoCode();
        this.fromEndName = event.getFromEndName();
        this.fromEndNameTso = event.getFromEndNameTso();
        this.toEndIsoCode = event.getToEndIsoCode();
        this.toEndName = event.getToEndName();
        this.toEndNameTso = event.getToEndNameTso();
    }
    
    @EventSourcingHandler
    void on(UpdateBoundaryExtensionsEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.boundaryPoint = event.getBoundaryPoint();
        this.fromEndIsoCode = event.getFromEndIsoCode();
        this.fromEndName = event.getFromEndName();
        this.fromEndNameTso = event.getFromEndNameTso();
        this.toEndIsoCode = event.getToEndIsoCode();
        this.toEndName = event.getToEndName();
        this.toEndNameTso = event.getToEndNameTso();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID boundaryExtensionsId;
    
    private String boundaryPoint;
    private String fromEndIsoCode;
    private String fromEndName;
    private String fromEndNameTso;
    private String toEndIsoCode;
    private String toEndName;
    private String toEndNameTso;

    private static final Logger LOGGER 	= Logger.getLogger(BoundaryExtensionsAggregate.class.getName());
}
