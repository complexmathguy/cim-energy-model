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
 * Projector for DCTopologicalIsland as outlined for the CQRS pattern.  All event handling and query handling related to DCTopologicalIsland are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCTopologicalIslandAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCTopologicalIsland")
@Component("dCTopologicalIsland-projector")
public class DCTopologicalIslandProjector extends DCTopologicalIslandEntityProjector {
		
	// core constructor
	public DCTopologicalIslandProjector(DCTopologicalIslandRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCTopologicalIslandEvent
     */
    @EventHandler( payloadType=CreateDCTopologicalIslandEvent.class )
    public void handle( CreateDCTopologicalIslandEvent event) {
	    LOGGER.info("handling CreateDCTopologicalIslandEvent - " + event );
	    DCTopologicalIsland entity = new DCTopologicalIsland();
        entity.setDCTopologicalIslandId( event.getDCTopologicalIslandId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalIsland( entity );
    }

    /*
     * @param	event UpdateDCTopologicalIslandEvent
     */
    @EventHandler( payloadType=UpdateDCTopologicalIslandEvent.class )
    public void handle( UpdateDCTopologicalIslandEvent event) {
    	LOGGER.info("handling UpdateDCTopologicalIslandEvent - " + event );
    	
	    DCTopologicalIsland entity = new DCTopologicalIsland();
        entity.setDCTopologicalIslandId( event.getDCTopologicalIslandId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCTopologicalIsland( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalIsland( entity );        
    }
    
    /*
     * @param	event DeleteDCTopologicalIslandEvent
     */
    @EventHandler( payloadType=DeleteDCTopologicalIslandEvent.class )
    public void handle( DeleteDCTopologicalIslandEvent event) {
    	LOGGER.info("handling DeleteDCTopologicalIslandEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCTopologicalIsland entity = delete( event.getDCTopologicalIslandId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalIsland( entity );

    }    




    /**
     * Method to retrieve the DCTopologicalIsland via an DCTopologicalIslandPrimaryKey.
     * @param 	id Long
     * @return 	DCTopologicalIsland
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCTopologicalIsland handle( FindDCTopologicalIslandQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCTopologicalIslandId() );
    }
    
    /**
     * Method to retrieve a collection of all DCTopologicalIslands
     *
     * @param	query	FindAllDCTopologicalIslandQuery 
     * @return 	List<DCTopologicalIsland> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCTopologicalIsland> handle( FindAllDCTopologicalIslandQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCTopologicalIsland, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCTopologicalIsland
	 */
	protected void emitFindDCTopologicalIsland( DCTopologicalIsland entity ) {
		LOGGER.info("handling emitFindDCTopologicalIsland" );
		
	    queryUpdateEmitter.emit(FindDCTopologicalIslandQuery.class,
	                            query -> query.getFilter().getDCTopologicalIslandId().equals(entity.getDCTopologicalIslandId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCTopologicalIsland
	 * 
	 * @param		entity	DCTopologicalIsland
	 */
	protected void emitFindAllDCTopologicalIsland( DCTopologicalIsland entity ) {
		LOGGER.info("handling emitFindAllDCTopologicalIsland" );
		
	    queryUpdateEmitter.emit(FindAllDCTopologicalIslandQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCTopologicalIslandProjector.class.getName());

}
