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
 * Aggregate handler for SteadyStateHypothesisVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to SteadyStateHypothesisVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class SteadyStateHypothesisVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public SteadyStateHypothesisVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public SteadyStateHypothesisVersionAggregate(CreateSteadyStateHypothesisVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateSteadyStateHypothesisVersionCommand" );
    	CreateSteadyStateHypothesisVersionEvent event = new CreateSteadyStateHypothesisVersionEvent(command.getSteadyStateHypothesisVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURI(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateSteadyStateHypothesisVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateSteadyStateHypothesisVersionCommand" );
    	UpdateSteadyStateHypothesisVersionEvent event = new UpdateSteadyStateHypothesisVersionEvent(command.getSteadyStateHypothesisVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURI(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteSteadyStateHypothesisVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteSteadyStateHypothesisVersionCommand" );
        apply(new DeleteSteadyStateHypothesisVersionEvent(command.getSteadyStateHypothesisVersionId()));
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
    void on(CreateSteadyStateHypothesisVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateSteadyStateHypothesisVersionEvent" );
    	this.steadyStateHypothesisVersionId = event.getSteadyStateHypothesisVersionId();
        this.baseUML = event.getBaseUML();
        this.baseURI = event.getBaseURI();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURI = event.getEntsoeURI();
        this.modelDescriptionURI = event.getModelDescriptionURI();
        this.namespaceRDF = event.getNamespaceRDF();
        this.namespaceUML = event.getNamespaceUML();
        this.shortName = event.getShortName();
    }
    
    @EventSourcingHandler
    void on(UpdateSteadyStateHypothesisVersionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.baseUML = event.getBaseUML();
        this.baseURI = event.getBaseURI();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURI = event.getEntsoeURI();
        this.modelDescriptionURI = event.getModelDescriptionURI();
        this.namespaceRDF = event.getNamespaceRDF();
        this.namespaceUML = event.getNamespaceUML();
        this.shortName = event.getShortName();
    }   

	// ----------------------------------------------
	// association event source handlers
	// ----------------------------------------------


    // ------------------------------------------
    // attributes
    // ------------------------------------------
	
    @AggregateIdentifier
    private UUID steadyStateHypothesisVersionId;
    
    private String baseUML;
    private String baseURI;
    private String date;
    private String differenceModelURI;
    private String entsoeUML;
    private String entsoeURI;
    private String modelDescriptionURI;
    private String namespaceRDF;
    private String namespaceUML;
    private String shortName;

    private static final Logger LOGGER 	= Logger.getLogger(SteadyStateHypothesisVersionAggregate.class.getName());
}
