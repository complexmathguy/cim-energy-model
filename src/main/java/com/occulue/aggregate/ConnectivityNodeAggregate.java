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
 * Aggregate handler for ConnectivityNode as outlined for the CQRS pattern, all write responsibilities 
 * related to ConnectivityNode are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class ConnectivityNodeAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public ConnectivityNodeAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public ConnectivityNodeAggregate(CreateConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateConnectivityNodeCommand" );
    	CreateConnectivityNodeEvent event = new CreateConnectivityNodeEvent(command.getConnectivityNodeId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateConnectivityNodeCommand" );
    	UpdateConnectivityNodeEvent event = new UpdateConnectivityNodeEvent(command.getConnectivityNodeId(), command.getBoundaryPoint(), command.getFromEndIsoCode(), command.getFromEndName(), command.getFromEndNameTso(), command.getToEndIsoCode(), command.getToEndName(), command.getToEndNameTso());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteConnectivityNodeCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteConnectivityNodeCommand" );
        apply(new DeleteConnectivityNodeEvent(command.getConnectivityNodeId()));
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
    void on(CreateConnectivityNodeEvent event) {	
    	LOGGER.info( "Event sourcing CreateConnectivityNodeEvent" );
    	this.connectivityNodeId = event.getConnectivityNodeId();
        this.boundaryPoint = event.getBoundaryPoint();
        this.fromEndIsoCode = event.getFromEndIsoCode();
        this.fromEndName = event.getFromEndName();
        this.fromEndNameTso = event.getFromEndNameTso();
        this.toEndIsoCode = event.getToEndIsoCode();
        this.toEndName = event.getToEndName();
        this.toEndNameTso = event.getToEndNameTso();
    }
    
    @EventSourcingHandler
    void on(UpdateConnectivityNodeEvent event) {
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
    private UUID connectivityNodeId;
    
    private String boundaryPoint;
    private String fromEndIsoCode;
    private String fromEndName;
    private String fromEndNameTso;
    private String toEndIsoCode;
    private String toEndName;
    private String toEndNameTso;

    private static final Logger LOGGER 	= Logger.getLogger(ConnectivityNodeAggregate.class.getName());
}
