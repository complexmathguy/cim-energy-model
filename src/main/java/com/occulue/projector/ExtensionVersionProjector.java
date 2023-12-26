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
 * Projector for ExtensionVersion as outlined for the CQRS pattern.  All event handling and query handling related to ExtensionVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExtensionVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("extensionVersion")
@Component("extensionVersion-projector")
public class ExtensionVersionProjector extends ExtensionVersionEntityProjector {
		
	// core constructor
	public ExtensionVersionProjector(ExtensionVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExtensionVersionEvent
     */
    @EventHandler( payloadType=CreateExtensionVersionEvent.class )
    public void handle( CreateExtensionVersionEvent event) {
	    LOGGER.info("handling CreateExtensionVersionEvent - " + event );
	    ExtensionVersion entity = new ExtensionVersion();
        entity.setExtensionVersionId( event.getExtensionVersionId() );
        entity.setDate( event.getDate() );
        entity.setNamespaceURI( event.getNamespaceURI() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExtensionVersion( entity );
    }

    /*
     * @param	event UpdateExtensionVersionEvent
     */
    @EventHandler( payloadType=UpdateExtensionVersionEvent.class )
    public void handle( UpdateExtensionVersionEvent event) {
    	LOGGER.info("handling UpdateExtensionVersionEvent - " + event );
    	
	    ExtensionVersion entity = new ExtensionVersion();
        entity.setExtensionVersionId( event.getExtensionVersionId() );
        entity.setDate( event.getDate() );
        entity.setNamespaceURI( event.getNamespaceURI() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExtensionVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExtensionVersion( entity );        
    }
    
    /*
     * @param	event DeleteExtensionVersionEvent
     */
    @EventHandler( payloadType=DeleteExtensionVersionEvent.class )
    public void handle( DeleteExtensionVersionEvent event) {
    	LOGGER.info("handling DeleteExtensionVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExtensionVersion entity = delete( event.getExtensionVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExtensionVersion( entity );

    }    




    /**
     * Method to retrieve the ExtensionVersion via an ExtensionVersionPrimaryKey.
     * @param 	id Long
     * @return 	ExtensionVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExtensionVersion handle( FindExtensionVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExtensionVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all ExtensionVersions
     *
     * @param	query	FindAllExtensionVersionQuery 
     * @return 	List<ExtensionVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExtensionVersion> handle( FindAllExtensionVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExtensionVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExtensionVersion
	 */
	protected void emitFindExtensionVersion( ExtensionVersion entity ) {
		LOGGER.info("handling emitFindExtensionVersion" );
		
	    queryUpdateEmitter.emit(FindExtensionVersionQuery.class,
	                            query -> query.getFilter().getExtensionVersionId().equals(entity.getExtensionVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExtensionVersion
	 * 
	 * @param		entity	ExtensionVersion
	 */
	protected void emitFindAllExtensionVersion( ExtensionVersion entity ) {
		LOGGER.info("handling emitFindAllExtensionVersion" );
		
	    queryUpdateEmitter.emit(FindAllExtensionVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExtensionVersionProjector.class.getName());

}
