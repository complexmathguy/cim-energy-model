/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.projector;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for EquipmentVersion as outlined for the CQRS pattern.  All event handling and query handling related to EquipmentVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquipmentVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equipmentVersion")
@Component("equipmentVersion-projector")
public class EquipmentVersionProjector extends EquipmentVersionEntityProjector {
		
	// core constructor
	public EquipmentVersionProjector(EquipmentVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquipmentVersionEvent
     */
    @EventHandler( payloadType=CreateEquipmentVersionEvent.class )
    public void handle( CreateEquipmentVersionEvent event) {
	    LOGGER.info("handling CreateEquipmentVersionEvent - " + event );
	    EquipmentVersion entity = new EquipmentVersion();
        entity.setEquipmentVersionId( event.getEquipmentVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURIcore( event.getBaseURIcore() );
        entity.setBaseURIoperation( event.getBaseURIoperation() );
        entity.setBaseURIshortCircuit( event.getBaseURIshortCircuit() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURIcore( event.getEntsoeURIcore() );
        entity.setEntsoeURIoperation( event.getEntsoeURIoperation() );
        entity.setEntsoeURIshortCircuit( event.getEntsoeURIshortCircuit() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentVersion( entity );
    }

    /*
     * @param	event UpdateEquipmentVersionEvent
     */
    @EventHandler( payloadType=UpdateEquipmentVersionEvent.class )
    public void handle( UpdateEquipmentVersionEvent event) {
    	LOGGER.info("handling UpdateEquipmentVersionEvent - " + event );
    	
	    EquipmentVersion entity = new EquipmentVersion();
        entity.setEquipmentVersionId( event.getEquipmentVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURIcore( event.getBaseURIcore() );
        entity.setBaseURIoperation( event.getBaseURIoperation() );
        entity.setBaseURIshortCircuit( event.getBaseURIshortCircuit() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURIcore( event.getEntsoeURIcore() );
        entity.setEntsoeURIoperation( event.getEntsoeURIoperation() );
        entity.setEntsoeURIshortCircuit( event.getEntsoeURIshortCircuit() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquipmentVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentVersion( entity );        
    }
    
    /*
     * @param	event DeleteEquipmentVersionEvent
     */
    @EventHandler( payloadType=DeleteEquipmentVersionEvent.class )
    public void handle( DeleteEquipmentVersionEvent event) {
    	LOGGER.info("handling DeleteEquipmentVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquipmentVersion entity = delete( event.getEquipmentVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentVersion( entity );

    }    




    /**
     * Method to retrieve the EquipmentVersion via an EquipmentVersionPrimaryKey.
     * @param 	id Long
     * @return 	EquipmentVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquipmentVersion handle( FindEquipmentVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquipmentVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all EquipmentVersions
     *
     * @param	query	FindAllEquipmentVersionQuery 
     * @return 	List<EquipmentVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquipmentVersion> handle( FindAllEquipmentVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquipmentVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquipmentVersion
	 */
	protected void emitFindEquipmentVersion( EquipmentVersion entity ) {
		LOGGER.info("handling emitFindEquipmentVersion" );
		
	    queryUpdateEmitter.emit(FindEquipmentVersionQuery.class,
	                            query -> query.getFilter().getEquipmentVersionId().equals(entity.getEquipmentVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquipmentVersion
	 * 
	 * @param		entity	EquipmentVersion
	 */
	protected void emitFindAllEquipmentVersion( EquipmentVersion entity ) {
		LOGGER.info("handling emitFindAllEquipmentVersion" );
		
	    queryUpdateEmitter.emit(FindAllEquipmentVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquipmentVersionProjector.class.getName());

}
