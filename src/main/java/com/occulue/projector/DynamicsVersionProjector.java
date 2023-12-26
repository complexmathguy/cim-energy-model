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
 * Projector for DynamicsVersion as outlined for the CQRS pattern.  All event handling and query handling related to DynamicsVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DynamicsVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dynamicsVersion")
@Component("dynamicsVersion-projector")
public class DynamicsVersionProjector extends DynamicsVersionEntityProjector {
		
	// core constructor
	public DynamicsVersionProjector(DynamicsVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDynamicsVersionEvent
     */
    @EventHandler( payloadType=CreateDynamicsVersionEvent.class )
    public void handle( CreateDynamicsVersionEvent event) {
	    LOGGER.info("handling CreateDynamicsVersionEvent - " + event );
	    DynamicsVersion entity = new DynamicsVersion();
        entity.setDynamicsVersionId( event.getDynamicsVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
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
        emitFindAllDynamicsVersion( entity );
    }

    /*
     * @param	event UpdateDynamicsVersionEvent
     */
    @EventHandler( payloadType=UpdateDynamicsVersionEvent.class )
    public void handle( UpdateDynamicsVersionEvent event) {
    	LOGGER.info("handling UpdateDynamicsVersionEvent - " + event );
    	
	    DynamicsVersion entity = new DynamicsVersion();
        entity.setDynamicsVersionId( event.getDynamicsVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
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
        emitFindDynamicsVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsVersion( entity );        
    }
    
    /*
     * @param	event DeleteDynamicsVersionEvent
     */
    @EventHandler( payloadType=DeleteDynamicsVersionEvent.class )
    public void handle( DeleteDynamicsVersionEvent event) {
    	LOGGER.info("handling DeleteDynamicsVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DynamicsVersion entity = delete( event.getDynamicsVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsVersion( entity );

    }    




    /**
     * Method to retrieve the DynamicsVersion via an DynamicsVersionPrimaryKey.
     * @param 	id Long
     * @return 	DynamicsVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DynamicsVersion handle( FindDynamicsVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDynamicsVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all DynamicsVersions
     *
     * @param	query	FindAllDynamicsVersionQuery 
     * @return 	List<DynamicsVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DynamicsVersion> handle( FindAllDynamicsVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDynamicsVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	DynamicsVersion
	 */
	protected void emitFindDynamicsVersion( DynamicsVersion entity ) {
		LOGGER.info("handling emitFindDynamicsVersion" );
		
	    queryUpdateEmitter.emit(FindDynamicsVersionQuery.class,
	                            query -> query.getFilter().getDynamicsVersionId().equals(entity.getDynamicsVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDynamicsVersion
	 * 
	 * @param		entity	DynamicsVersion
	 */
	protected void emitFindAllDynamicsVersion( DynamicsVersion entity ) {
		LOGGER.info("handling emitFindAllDynamicsVersion" );
		
	    queryUpdateEmitter.emit(FindAllDynamicsVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DynamicsVersionProjector.class.getName());

}
