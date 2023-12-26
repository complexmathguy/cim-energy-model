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
 * Projector for Junction as outlined for the CQRS pattern.  All event handling and query handling related to Junction are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by JunctionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("junction")
@Component("junction-projector")
public class JunctionProjector extends JunctionEntityProjector {
		
	// core constructor
	public JunctionProjector(JunctionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateJunctionEvent
     */
    @EventHandler( payloadType=CreateJunctionEvent.class )
    public void handle( CreateJunctionEvent event) {
	    LOGGER.info("handling CreateJunctionEvent - " + event );
	    Junction entity = new Junction();
        entity.setJunctionId( event.getJunctionId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllJunction( entity );
    }

    /*
     * @param	event UpdateJunctionEvent
     */
    @EventHandler( payloadType=UpdateJunctionEvent.class )
    public void handle( UpdateJunctionEvent event) {
    	LOGGER.info("handling UpdateJunctionEvent - " + event );
    	
	    Junction entity = new Junction();
        entity.setJunctionId( event.getJunctionId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindJunction( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllJunction( entity );        
    }
    
    /*
     * @param	event DeleteJunctionEvent
     */
    @EventHandler( payloadType=DeleteJunctionEvent.class )
    public void handle( DeleteJunctionEvent event) {
    	LOGGER.info("handling DeleteJunctionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Junction entity = delete( event.getJunctionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllJunction( entity );

    }    




    /**
     * Method to retrieve the Junction via an JunctionPrimaryKey.
     * @param 	id Long
     * @return 	Junction
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Junction handle( FindJunctionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getJunctionId() );
    }
    
    /**
     * Method to retrieve a collection of all Junctions
     *
     * @param	query	FindAllJunctionQuery 
     * @return 	List<Junction> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Junction> handle( FindAllJunctionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindJunction, 
	 * but only if the id matches
	 * 
	 * @param		entity	Junction
	 */
	protected void emitFindJunction( Junction entity ) {
		LOGGER.info("handling emitFindJunction" );
		
	    queryUpdateEmitter.emit(FindJunctionQuery.class,
	                            query -> query.getFilter().getJunctionId().equals(entity.getJunctionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllJunction
	 * 
	 * @param		entity	Junction
	 */
	protected void emitFindAllJunction( Junction entity ) {
		LOGGER.info("handling emitFindAllJunction" );
		
	    queryUpdateEmitter.emit(FindAllJunctionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(JunctionProjector.class.getName());

}
