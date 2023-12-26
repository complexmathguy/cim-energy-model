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
 * Projector for CoordinateSystem as outlined for the CQRS pattern.  All event handling and query handling related to CoordinateSystem are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CoordinateSystemAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("coordinateSystem")
@Component("coordinateSystem-projector")
public class CoordinateSystemProjector extends CoordinateSystemEntityProjector {
		
	// core constructor
	public CoordinateSystemProjector(CoordinateSystemRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCoordinateSystemEvent
     */
    @EventHandler( payloadType=CreateCoordinateSystemEvent.class )
    public void handle( CreateCoordinateSystemEvent event) {
	    LOGGER.info("handling CreateCoordinateSystemEvent - " + event );
	    CoordinateSystem entity = new CoordinateSystem();
        entity.setCoordinateSystemId( event.getCoordinateSystemId() );
        entity.setCrsUrn( event.getCrsUrn() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCoordinateSystem( entity );
    }

    /*
     * @param	event UpdateCoordinateSystemEvent
     */
    @EventHandler( payloadType=UpdateCoordinateSystemEvent.class )
    public void handle( UpdateCoordinateSystemEvent event) {
    	LOGGER.info("handling UpdateCoordinateSystemEvent - " + event );
    	
	    CoordinateSystem entity = new CoordinateSystem();
        entity.setCoordinateSystemId( event.getCoordinateSystemId() );
        entity.setCrsUrn( event.getCrsUrn() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCoordinateSystem( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCoordinateSystem( entity );        
    }
    
    /*
     * @param	event DeleteCoordinateSystemEvent
     */
    @EventHandler( payloadType=DeleteCoordinateSystemEvent.class )
    public void handle( DeleteCoordinateSystemEvent event) {
    	LOGGER.info("handling DeleteCoordinateSystemEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	CoordinateSystem entity = delete( event.getCoordinateSystemId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCoordinateSystem( entity );

    }    




    /**
     * Method to retrieve the CoordinateSystem via an CoordinateSystemPrimaryKey.
     * @param 	id Long
     * @return 	CoordinateSystem
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public CoordinateSystem handle( FindCoordinateSystemQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCoordinateSystemId() );
    }
    
    /**
     * Method to retrieve a collection of all CoordinateSystems
     *
     * @param	query	FindAllCoordinateSystemQuery 
     * @return 	List<CoordinateSystem> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<CoordinateSystem> handle( FindAllCoordinateSystemQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCoordinateSystem, 
	 * but only if the id matches
	 * 
	 * @param		entity	CoordinateSystem
	 */
	protected void emitFindCoordinateSystem( CoordinateSystem entity ) {
		LOGGER.info("handling emitFindCoordinateSystem" );
		
	    queryUpdateEmitter.emit(FindCoordinateSystemQuery.class,
	                            query -> query.getFilter().getCoordinateSystemId().equals(entity.getCoordinateSystemId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCoordinateSystem
	 * 
	 * @param		entity	CoordinateSystem
	 */
	protected void emitFindAllCoordinateSystem( CoordinateSystem entity ) {
		LOGGER.info("handling emitFindAllCoordinateSystem" );
		
	    queryUpdateEmitter.emit(FindAllCoordinateSystemQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CoordinateSystemProjector.class.getName());

}
