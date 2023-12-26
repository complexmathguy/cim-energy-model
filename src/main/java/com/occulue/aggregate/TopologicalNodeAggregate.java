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
 * Aggregate handler for TopologicalNode as outlined for the CQRS pattern, all write responsibilities 
 * related to TopologicalNode are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class TopologicalNodeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public TopologicalNodeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public TopologicalNodeAggregate(CreateTopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateTopologicalNodeCommand" );
    	CreateTopologicalNodeEvent event = new CreateTopologicalNodeEvent(command.getTopologicalNodeId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateTopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateTopologicalNodeCommand" );
    	UpdateTopologicalNodeEvent event = new UpdateTopologicalNodeEvent(command.getTopologicalNodeId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteTopologicalNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteTopologicalNodeCommand" );
        apply(new DeleteTopologicalNodeEvent(command.getTopologicalNodeId()));
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
    void on(CreateTopologicalNodeEvent event) {	
    	LOGGER.info( "Event sourcing CreateTopologicalNodeEvent" );
    	this.topologicalNodeId = event.getTopologicalNodeId();
        this.boundaryPoint = event.getBoundaryPoint();
        this.fromEndIsoCode = event.getFromEndIsoCode();
        this.fromEndName = event.getFromEndName();
        this.fromEndNameTso = event.getFromEndNameTso();
        this.toEndIsoCode = event.getToEndIsoCode();
        this.toEndName = event.getToEndName();
        this.toEndNameTso = event.getToEndNameTso();
    }
    
    @EventSourcingHandler
    void on(UpdateTopologicalNodeEvent event) {
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
    private UUID topologicalNodeId;
    
    private String boundaryPoint;
    private String fromEndIsoCode;
    private String fromEndName;
    private String fromEndNameTso;
    private String toEndIsoCode;
    private String toEndName;
    private String toEndNameTso;

    private static final Logger LOGGER 	= Logger.getLogger(TopologicalNodeAggregate.class.getName());
}
