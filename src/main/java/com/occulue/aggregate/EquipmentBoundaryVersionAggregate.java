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
 * Aggregate handler for EquipmentBoundaryVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to EquipmentBoundaryVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquipmentBoundaryVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquipmentBoundaryVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquipmentBoundaryVersionAggregate(CreateEquipmentBoundaryVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquipmentBoundaryVersionCommand" );
    	CreateEquipmentBoundaryVersionEvent event = new CreateEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURIcore(), command.getEntsoeURIoperation(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquipmentBoundaryVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquipmentBoundaryVersionCommand" );
    	UpdateEquipmentBoundaryVersionEvent event = new UpdateEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId(), command.getBaseUML(), command.getBaseURI(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURIcore(), command.getEntsoeURIoperation(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquipmentBoundaryVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquipmentBoundaryVersionCommand" );
        apply(new DeleteEquipmentBoundaryVersionEvent(command.getEquipmentBoundaryVersionId()));
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
    void on(CreateEquipmentBoundaryVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquipmentBoundaryVersionEvent" );
    	this.equipmentBoundaryVersionId = event.getEquipmentBoundaryVersionId();
        this.baseUML = event.getBaseUML();
        this.baseURI = event.getBaseURI();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURIcore = event.getEntsoeURIcore();
        this.entsoeURIoperation = event.getEntsoeURIoperation();
        this.modelDescriptionURI = event.getModelDescriptionURI();
        this.namespaceRDF = event.getNamespaceRDF();
        this.namespaceUML = event.getNamespaceUML();
        this.shortName = event.getShortName();
    }
    
    @EventSourcingHandler
    void on(UpdateEquipmentBoundaryVersionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.baseUML = event.getBaseUML();
        this.baseURI = event.getBaseURI();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURIcore = event.getEntsoeURIcore();
        this.entsoeURIoperation = event.getEntsoeURIoperation();
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
    private UUID equipmentBoundaryVersionId;
    
    private String baseUML;
    private String baseURI;
    private String date;
    private String differenceModelURI;
    private String entsoeUML;
    private String entsoeURIcore;
    private String entsoeURIoperation;
    private String modelDescriptionURI;
    private String namespaceRDF;
    private String namespaceUML;
    private String shortName;

    private static final Logger LOGGER 	= Logger.getLogger(EquipmentBoundaryVersionAggregate.class.getName());
}
