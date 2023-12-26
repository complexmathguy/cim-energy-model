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
 * Projector for SubGeographicalRegion as outlined for the CQRS pattern.  All event handling and query handling related to SubGeographicalRegion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SubGeographicalRegionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("subGeographicalRegion")
@Component("subGeographicalRegion-projector")
public class SubGeographicalRegionProjector extends SubGeographicalRegionEntityProjector {
		
	// core constructor
	public SubGeographicalRegionProjector(SubGeographicalRegionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSubGeographicalRegionEvent
     */
    @EventHandler( payloadType=CreateSubGeographicalRegionEvent.class )
    public void handle( CreateSubGeographicalRegionEvent event) {
	    LOGGER.info("handling CreateSubGeographicalRegionEvent - " + event );
	    SubGeographicalRegion entity = new SubGeographicalRegion();
        entity.setSubGeographicalRegionId( event.getSubGeographicalRegionId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubGeographicalRegion( entity );
    }

    /*
     * @param	event UpdateSubGeographicalRegionEvent
     */
    @EventHandler( payloadType=UpdateSubGeographicalRegionEvent.class )
    public void handle( UpdateSubGeographicalRegionEvent event) {
    	LOGGER.info("handling UpdateSubGeographicalRegionEvent - " + event );
    	
	    SubGeographicalRegion entity = new SubGeographicalRegion();
        entity.setSubGeographicalRegionId( event.getSubGeographicalRegionId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSubGeographicalRegion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubGeographicalRegion( entity );        
    }
    
    /*
     * @param	event DeleteSubGeographicalRegionEvent
     */
    @EventHandler( payloadType=DeleteSubGeographicalRegionEvent.class )
    public void handle( DeleteSubGeographicalRegionEvent event) {
    	LOGGER.info("handling DeleteSubGeographicalRegionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SubGeographicalRegion entity = delete( event.getSubGeographicalRegionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubGeographicalRegion( entity );

    }    




    /**
     * Method to retrieve the SubGeographicalRegion via an SubGeographicalRegionPrimaryKey.
     * @param 	id Long
     * @return 	SubGeographicalRegion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SubGeographicalRegion handle( FindSubGeographicalRegionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSubGeographicalRegionId() );
    }
    
    /**
     * Method to retrieve a collection of all SubGeographicalRegions
     *
     * @param	query	FindAllSubGeographicalRegionQuery 
     * @return 	List<SubGeographicalRegion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SubGeographicalRegion> handle( FindAllSubGeographicalRegionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSubGeographicalRegion, 
	 * but only if the id matches
	 * 
	 * @param		entity	SubGeographicalRegion
	 */
	protected void emitFindSubGeographicalRegion( SubGeographicalRegion entity ) {
		LOGGER.info("handling emitFindSubGeographicalRegion" );
		
	    queryUpdateEmitter.emit(FindSubGeographicalRegionQuery.class,
	                            query -> query.getFilter().getSubGeographicalRegionId().equals(entity.getSubGeographicalRegionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSubGeographicalRegion
	 * 
	 * @param		entity	SubGeographicalRegion
	 */
	protected void emitFindAllSubGeographicalRegion( SubGeographicalRegion entity ) {
		LOGGER.info("handling emitFindAllSubGeographicalRegion" );
		
	    queryUpdateEmitter.emit(FindAllSubGeographicalRegionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SubGeographicalRegionProjector.class.getName());

}
