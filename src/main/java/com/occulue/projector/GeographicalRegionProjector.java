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
 * Projector for GeographicalRegion as outlined for the CQRS pattern.  All event handling and query handling related to GeographicalRegion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GeographicalRegionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("geographicalRegion")
@Component("geographicalRegion-projector")
public class GeographicalRegionProjector extends GeographicalRegionEntityProjector {
		
	// core constructor
	public GeographicalRegionProjector(GeographicalRegionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGeographicalRegionEvent
     */
    @EventHandler( payloadType=CreateGeographicalRegionEvent.class )
    public void handle( CreateGeographicalRegionEvent event) {
	    LOGGER.info("handling CreateGeographicalRegionEvent - " + event );
	    GeographicalRegion entity = new GeographicalRegion();
        entity.setGeographicalRegionId( event.getGeographicalRegionId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeographicalRegion( entity );
    }

    /*
     * @param	event UpdateGeographicalRegionEvent
     */
    @EventHandler( payloadType=UpdateGeographicalRegionEvent.class )
    public void handle( UpdateGeographicalRegionEvent event) {
    	LOGGER.info("handling UpdateGeographicalRegionEvent - " + event );
    	
	    GeographicalRegion entity = new GeographicalRegion();
        entity.setGeographicalRegionId( event.getGeographicalRegionId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGeographicalRegion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeographicalRegion( entity );        
    }
    
    /*
     * @param	event DeleteGeographicalRegionEvent
     */
    @EventHandler( payloadType=DeleteGeographicalRegionEvent.class )
    public void handle( DeleteGeographicalRegionEvent event) {
    	LOGGER.info("handling DeleteGeographicalRegionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GeographicalRegion entity = delete( event.getGeographicalRegionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGeographicalRegion( entity );

    }    




    /**
     * Method to retrieve the GeographicalRegion via an GeographicalRegionPrimaryKey.
     * @param 	id Long
     * @return 	GeographicalRegion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GeographicalRegion handle( FindGeographicalRegionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGeographicalRegionId() );
    }
    
    /**
     * Method to retrieve a collection of all GeographicalRegions
     *
     * @param	query	FindAllGeographicalRegionQuery 
     * @return 	List<GeographicalRegion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GeographicalRegion> handle( FindAllGeographicalRegionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGeographicalRegion, 
	 * but only if the id matches
	 * 
	 * @param		entity	GeographicalRegion
	 */
	protected void emitFindGeographicalRegion( GeographicalRegion entity ) {
		LOGGER.info("handling emitFindGeographicalRegion" );
		
	    queryUpdateEmitter.emit(FindGeographicalRegionQuery.class,
	                            query -> query.getFilter().getGeographicalRegionId().equals(entity.getGeographicalRegionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGeographicalRegion
	 * 
	 * @param		entity	GeographicalRegion
	 */
	protected void emitFindAllGeographicalRegion( GeographicalRegion entity ) {
		LOGGER.info("handling emitFindAllGeographicalRegion" );
		
	    queryUpdateEmitter.emit(FindAllGeographicalRegionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GeographicalRegionProjector.class.getName());

}
