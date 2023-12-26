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
 * Projector for EquipmentBoundaryVersion as outlined for the CQRS pattern.  All event handling and query handling related to EquipmentBoundaryVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquipmentBoundaryVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equipmentBoundaryVersion")
@Component("equipmentBoundaryVersion-projector")
public class EquipmentBoundaryVersionProjector extends EquipmentBoundaryVersionEntityProjector {
		
	// core constructor
	public EquipmentBoundaryVersionProjector(EquipmentBoundaryVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquipmentBoundaryVersionEvent
     */
    @EventHandler( payloadType=CreateEquipmentBoundaryVersionEvent.class )
    public void handle( CreateEquipmentBoundaryVersionEvent event) {
	    LOGGER.info("handling CreateEquipmentBoundaryVersionEvent - " + event );
	    EquipmentBoundaryVersion entity = new EquipmentBoundaryVersion();
        entity.setEquipmentBoundaryVersionId( event.getEquipmentBoundaryVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURIcore( event.getEntsoeURIcore() );
        entity.setEntsoeURIoperation( event.getEntsoeURIoperation() );
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
        emitFindAllEquipmentBoundaryVersion( entity );
    }

    /*
     * @param	event UpdateEquipmentBoundaryVersionEvent
     */
    @EventHandler( payloadType=UpdateEquipmentBoundaryVersionEvent.class )
    public void handle( UpdateEquipmentBoundaryVersionEvent event) {
    	LOGGER.info("handling UpdateEquipmentBoundaryVersionEvent - " + event );
    	
	    EquipmentBoundaryVersion entity = new EquipmentBoundaryVersion();
        entity.setEquipmentBoundaryVersionId( event.getEquipmentBoundaryVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURIcore( event.getEntsoeURIcore() );
        entity.setEntsoeURIoperation( event.getEntsoeURIoperation() );
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
        emitFindEquipmentBoundaryVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentBoundaryVersion( entity );        
    }
    
    /*
     * @param	event DeleteEquipmentBoundaryVersionEvent
     */
    @EventHandler( payloadType=DeleteEquipmentBoundaryVersionEvent.class )
    public void handle( DeleteEquipmentBoundaryVersionEvent event) {
    	LOGGER.info("handling DeleteEquipmentBoundaryVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquipmentBoundaryVersion entity = delete( event.getEquipmentBoundaryVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentBoundaryVersion( entity );

    }    




    /**
     * Method to retrieve the EquipmentBoundaryVersion via an EquipmentBoundaryVersionPrimaryKey.
     * @param 	id Long
     * @return 	EquipmentBoundaryVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquipmentBoundaryVersion handle( FindEquipmentBoundaryVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquipmentBoundaryVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all EquipmentBoundaryVersions
     *
     * @param	query	FindAllEquipmentBoundaryVersionQuery 
     * @return 	List<EquipmentBoundaryVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquipmentBoundaryVersion> handle( FindAllEquipmentBoundaryVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquipmentBoundaryVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquipmentBoundaryVersion
	 */
	protected void emitFindEquipmentBoundaryVersion( EquipmentBoundaryVersion entity ) {
		LOGGER.info("handling emitFindEquipmentBoundaryVersion" );
		
	    queryUpdateEmitter.emit(FindEquipmentBoundaryVersionQuery.class,
	                            query -> query.getFilter().getEquipmentBoundaryVersionId().equals(entity.getEquipmentBoundaryVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquipmentBoundaryVersion
	 * 
	 * @param		entity	EquipmentBoundaryVersion
	 */
	protected void emitFindAllEquipmentBoundaryVersion( EquipmentBoundaryVersion entity ) {
		LOGGER.info("handling emitFindAllEquipmentBoundaryVersion" );
		
	    queryUpdateEmitter.emit(FindAllEquipmentBoundaryVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquipmentBoundaryVersionProjector.class.getName());

}
