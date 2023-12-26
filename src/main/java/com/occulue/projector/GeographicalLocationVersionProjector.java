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
 * Projector for GeographicalLocationVersion as outlined for the CQRS pattern.  All event handling and query handling related to GeographicalLocationVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GeographicalLocationVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("geographicalLocationVersion")
@Component("geographicalLocationVersion-projector")
public class GeographicalLocationVersionProjector extends GeographicalLocationVersionEntityProjector {
		
	// core constructor
	public GeographicalLocationVersionProjector(GeographicalLocationVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGeographicalLocationVersionEvent
     */
    @EventHandler( payloadType=CreateGeographicalLocationVersionEvent.class )
    public void handle( CreateGeographicalLocationVersionEvent event) {
	    LOGGER.info("handling CreateGeographicalLocationVersionEvent - " + event );
	    GeographicalLocationVersion entity = new GeographicalLocationVersion();
        entity.setGeographicalLocationVersionId( event.getGeographicalLocationVersionId() );
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
        emitFindAllGeographicalLocationVersion( entity );
    }

    /*
     * @param	event UpdateGeographicalLocationVersionEvent
     */
    @EventHandler( payloadType=UpdateGeographicalLocationVersionEvent.class )
    public void handle( UpdateGeographicalLocationVersionEvent event) {
    	LOGGER.info("handling UpdateGeographicalLocationVersionEvent - " + event );
    	
	    GeographicalLocationVersion entity = new GeographicalLocationVersion();
        entity.setGeographicalLocationVersionId( event.getGeographicalLocationVersionId() );
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
        emitFindGeographicalLocationVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeographicalLocationVersion( entity );        
    }
    
    /*
     * @param	event DeleteGeographicalLocationVersionEvent
     */
    @EventHandler( payloadType=DeleteGeographicalLocationVersionEvent.class )
    public void handle( DeleteGeographicalLocationVersionEvent event) {
    	LOGGER.info("handling DeleteGeographicalLocationVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GeographicalLocationVersion entity = delete( event.getGeographicalLocationVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeographicalLocationVersion( entity );

    }    




    /**
     * Method to retrieve the GeographicalLocationVersion via an GeographicalLocationVersionPrimaryKey.
     * @param 	id Long
     * @return 	GeographicalLocationVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GeographicalLocationVersion handle( FindGeographicalLocationVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGeographicalLocationVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all GeographicalLocationVersions
     *
     * @param	query	FindAllGeographicalLocationVersionQuery 
     * @return 	List<GeographicalLocationVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GeographicalLocationVersion> handle( FindAllGeographicalLocationVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGeographicalLocationVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	GeographicalLocationVersion
	 */
	protected void emitFindGeographicalLocationVersion( GeographicalLocationVersion entity ) {
		LOGGER.info("handling emitFindGeographicalLocationVersion" );
		
	    queryUpdateEmitter.emit(FindGeographicalLocationVersionQuery.class,
	                            query -> query.getFilter().getGeographicalLocationVersionId().equals(entity.getGeographicalLocationVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGeographicalLocationVersion
	 * 
	 * @param		entity	GeographicalLocationVersion
	 */
	protected void emitFindAllGeographicalLocationVersion( GeographicalLocationVersion entity ) {
		LOGGER.info("handling emitFindAllGeographicalLocationVersion" );
		
	    queryUpdateEmitter.emit(FindAllGeographicalLocationVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GeographicalLocationVersionProjector.class.getName());

}
