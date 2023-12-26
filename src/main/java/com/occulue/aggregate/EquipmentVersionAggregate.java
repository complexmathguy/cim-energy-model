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
 * Aggregate handler for EquipmentVersion as outlined for the CQRS pattern, all write responsibilities 
 * related to EquipmentVersion are handled here.
 * 
 * @author your_name_here
 * 
 */
@Aggregate
public class EquipmentVersionAggregate {  

	// -----------------------------------------
	// Axon requires an empty constructor
    // -----------------------------------------
    public EquipmentVersionAggregate() {
    }

	// ----------------------------------------------
	// intrinsic command handlers
	// ----------------------------------------------
    @CommandHandler
    public EquipmentVersionAggregate(CreateEquipmentVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command CreateEquipmentVersionCommand" );
    	CreateEquipmentVersionEvent event = new CreateEquipmentVersionEvent(command.getEquipmentVersionId(), command.getBaseUML(), command.getBaseURIcore(), command.getBaseURIoperation(), command.getBaseURIshortCircuit(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURIcore(), command.getEntsoeURIoperation(), command.getEntsoeURIshortCircuit(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());
    	
        apply(event);
    }

    @CommandHandler
    public void handle(UpdateEquipmentVersionCommand command) throws Exception {
    	LOGGER.info( "handling command UpdateEquipmentVersionCommand" );
    	UpdateEquipmentVersionEvent event = new UpdateEquipmentVersionEvent(command.getEquipmentVersionId(), command.getBaseUML(), command.getBaseURIcore(), command.getBaseURIoperation(), command.getBaseURIshortCircuit(), command.getDate(), command.getDifferenceModelURI(), command.getEntsoeUML(), command.getEntsoeURIcore(), command.getEntsoeURIoperation(), command.getEntsoeURIshortCircuit(), command.getModelDescriptionURI(), command.getNamespaceRDF(), command.getNamespaceUML(), command.getShortName());        
    	
        apply(event);
    }

    @CommandHandler
    public void handle(DeleteEquipmentVersionCommand command) throws Exception {
    	LOGGER.info( "Handling command DeleteEquipmentVersionCommand" );
        apply(new DeleteEquipmentVersionEvent(command.getEquipmentVersionId()));
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
    void on(CreateEquipmentVersionEvent event) {	
    	LOGGER.info( "Event sourcing CreateEquipmentVersionEvent" );
    	this.equipmentVersionId = event.getEquipmentVersionId();
        this.baseUML = event.getBaseUML();
        this.baseURIcore = event.getBaseURIcore();
        this.baseURIoperation = event.getBaseURIoperation();
        this.baseURIshortCircuit = event.getBaseURIshortCircuit();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURIcore = event.getEntsoeURIcore();
        this.entsoeURIoperation = event.getEntsoeURIoperation();
        this.entsoeURIshortCircuit = event.getEntsoeURIshortCircuit();
        this.modelDescriptionURI = event.getModelDescriptionURI();
        this.namespaceRDF = event.getNamespaceRDF();
        this.namespaceUML = event.getNamespaceUML();
        this.shortName = event.getShortName();
    }
    
    @EventSourcingHandler
    void on(UpdateEquipmentVersionEvent event) {
    	LOGGER.info( "Event sourcing classObject.getUpdateEventAlias()}" );
        this.baseUML = event.getBaseUML();
        this.baseURIcore = event.getBaseURIcore();
        this.baseURIoperation = event.getBaseURIoperation();
        this.baseURIshortCircuit = event.getBaseURIshortCircuit();
        this.date = event.getDate();
        this.differenceModelURI = event.getDifferenceModelURI();
        this.entsoeUML = event.getEntsoeUML();
        this.entsoeURIcore = event.getEntsoeURIcore();
        this.entsoeURIoperation = event.getEntsoeURIoperation();
        this.entsoeURIshortCircuit = event.getEntsoeURIshortCircuit();
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
    private UUID equipmentVersionId;
    
    private String baseUML;
    private String baseURIcore;
    private String baseURIoperation;
    private String baseURIshortCircuit;
    private String date;
    private String differenceModelURI;
    private String entsoeUML;
    private String entsoeURIcore;
    private String entsoeURIoperation;
    private String entsoeURIshortCircuit;
    private String modelDescriptionURI;
    private String namespaceRDF;
    private String namespaceUML;
    private String shortName;

    private static final Logger LOGGER 	= Logger.getLogger(EquipmentVersionAggregate.class.getName());
}
