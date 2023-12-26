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
 * Aggregate handler for DiagramLayoutVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to DiagramLayoutVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class DiagramLayoutVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public DiagramLayoutVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public DiagramLayoutVersionAggregate(CreateDiagramLayoutVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateDiagramLayoutVersionCommand" );
    	CreateDiagramLayoutVersionEvent event = new CreateDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURI(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateDiagramLayoutVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateDiagramLayoutVersionCommand" );
    	UpdateDiagramLayoutVersionEvent event = new UpdateDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURI(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteDiagramLayoutVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteDiagramLayoutVersionCommand" );
        apply(new DeleteDiagramLayoutVersionEvent(command.getDiagramLayoutVersionId()));
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
    void on(CreateDiagramLayoutVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateDiagramLayoutVersionEvent" );
    	this.diagramLayoutVersionId = event.getDiagramLayoutVersionId();
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
    void on(UpdateDiagramLayoutVersionEvent event) {
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
    private UUID diagramLayoutVersionId;
    
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

    private static final Logger LOGGER 	= Logger.getLogger(DiagramLayoutVersionAggregate.class.getName());
}
