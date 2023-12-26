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
 * Projector for TopologicalIsland as outlined for the CQRS pattern.  All event handling and query handling related to TopologicalIsland are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TopologicalIslandAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("topologicalIsland")
@Component("topologicalIsland-projector")
public class TopologicalIslandProjector extends TopologicalIslandEntityProjector {
		
	// core constructor
	public TopologicalIslandProjector(TopologicalIslandRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTopologicalIslandEvent
     */
    @EventHandler( payloadType=CreateTopologicalIslandEvent.class )
    public void handle( CreateTopologicalIslandEvent event) {
	    LOGGER.info("handling CreateTopologicalIslandEvent - " + event );
	    TopologicalIsland entity = new TopologicalIsland();
        entity.setTopologicalIslandId( event.getTopologicalIslandId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalIsland( entity );
    }

    /*
     * @param	event UpdateTopologicalIslandEvent
     */
    @EventHandler( payloadType=UpdateTopologicalIslandEvent.class )
    public void handle( UpdateTopologicalIslandEvent event) {
    	LOGGER.info("handling UpdateTopologicalIslandEvent - " + event );
    	
	    TopologicalIsland entity = new TopologicalIsland();
        entity.setTopologicalIslandId( event.getTopologicalIslandId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTopologicalIsland( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalIsland( entity );        
    }
    
    /*
     * @param	event DeleteTopologicalIslandEvent
     */
    @EventHandler( payloadType=DeleteTopologicalIslandEvent.class )
    public void handle( DeleteTopologicalIslandEvent event) {
    	LOGGER.info("handling DeleteTopologicalIslandEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TopologicalIsland entity = delete( event.getTopologicalIslandId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalIsland( entity );

    }    




    /**
     * Method to retrieve the TopologicalIsland via an TopologicalIslandPrimaryKey.
     * @param 	id Long
     * @return 	TopologicalIsland
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TopologicalIsland handle( FindTopologicalIslandQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTopologicalIslandId() );
    }
    
    /**
     * Method to retrieve a collection of all TopologicalIslands
     *
     * @param	query	FindAllTopologicalIslandQuery 
     * @return 	List<TopologicalIsland> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TopologicalIsland> handle( FindAllTopologicalIslandQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTopologicalIsland, 
	 * but only if the id matches
	 * 
	 * @param		entity	TopologicalIsland
	 */
	protected void emitFindTopologicalIsland( TopologicalIsland entity ) {
		LOGGER.info("handling emitFindTopologicalIsland" );
		
	    queryUpdateEmitter.emit(FindTopologicalIslandQuery.class,
	                            query -> query.getFilter().getTopologicalIslandId().equals(entity.getTopologicalIslandId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTopologicalIsland
	 * 
	 * @param		entity	TopologicalIsland
	 */
	protected void emitFindAllTopologicalIsland( TopologicalIsland entity ) {
		LOGGER.info("handling emitFindAllTopologicalIsland" );
		
	    queryUpdateEmitter.emit(FindAllTopologicalIslandQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TopologicalIslandProjector.class.getName());

}
