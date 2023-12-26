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
 * Projector for DomainVersion as outlined for the CQRS pattern.  All event handling and query handling related to DomainVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DomainVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("domainVersion")
@Component("domainVersion-projector")
public class DomainVersionProjector extends DomainVersionEntityProjector {
		
	// core constructor
	public DomainVersionProjector(DomainVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDomainVersionEvent
     */
    @EventHandler( payloadType=CreateDomainVersionEvent.class )
    public void handle( CreateDomainVersionEvent event) {
	    LOGGER.info("handling CreateDomainVersionEvent - " + event );
	    DomainVersion entity = new DomainVersion();
        entity.setDomainVersionId( event.getDomainVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setDate( event.getDate() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setVersion( event.getVersion() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDomainVersion( entity );
    }

    /*
     * @param	event UpdateDomainVersionEvent
     */
    @EventHandler( payloadType=UpdateDomainVersionEvent.class )
    public void handle( UpdateDomainVersionEvent event) {
    	LOGGER.info("handling UpdateDomainVersionEvent - " + event );
    	
	    DomainVersion entity = new DomainVersion();
        entity.setDomainVersionId( event.getDomainVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setDate( event.getDate() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setVersion( event.getVersion() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDomainVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDomainVersion( entity );        
    }
    
    /*
     * @param	event DeleteDomainVersionEvent
     */
    @EventHandler( payloadType=DeleteDomainVersionEvent.class )
    public void handle( DeleteDomainVersionEvent event) {
    	LOGGER.info("handling DeleteDomainVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DomainVersion entity = delete( event.getDomainVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDomainVersion( entity );

    }    




    /**
     * Method to retrieve the DomainVersion via an DomainVersionPrimaryKey.
     * @param 	id Long
     * @return 	DomainVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DomainVersion handle( FindDomainVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDomainVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all DomainVersions
     *
     * @param	query	FindAllDomainVersionQuery 
     * @return 	List<DomainVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DomainVersion> handle( FindAllDomainVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDomainVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	DomainVersion
	 */
	protected void emitFindDomainVersion( DomainVersion entity ) {
		LOGGER.info("handling emitFindDomainVersion" );
		
	    queryUpdateEmitter.emit(FindDomainVersionQuery.class,
	                            query -> query.getFilter().getDomainVersionId().equals(entity.getDomainVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDomainVersion
	 * 
	 * @param		entity	DomainVersion
	 */
	protected void emitFindAllDomainVersion( DomainVersion entity ) {
		LOGGER.info("handling emitFindAllDomainVersion" );
		
	    queryUpdateEmitter.emit(FindAllDomainVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DomainVersionProjector.class.getName());

}
