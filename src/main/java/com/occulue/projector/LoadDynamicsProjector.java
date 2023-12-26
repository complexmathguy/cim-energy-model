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
 * Projector for LoadDynamics as outlined for the CQRS pattern.  All event handling and query handling related to LoadDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadDynamics")
@Component("loadDynamics-projector")
public class LoadDynamicsProjector extends LoadDynamicsEntityProjector {
		
	// core constructor
	public LoadDynamicsProjector(LoadDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadDynamicsEvent
     */
    @EventHandler( payloadType=CreateLoadDynamicsEvent.class )
    public void handle( CreateLoadDynamicsEvent event) {
	    LOGGER.info("handling CreateLoadDynamicsEvent - " + event );
	    LoadDynamics entity = new LoadDynamics();
        entity.setLoadDynamicsId( event.getLoadDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadDynamics( entity );
    }

    /*
     * @param	event UpdateLoadDynamicsEvent
     */
    @EventHandler( payloadType=UpdateLoadDynamicsEvent.class )
    public void handle( UpdateLoadDynamicsEvent event) {
    	LOGGER.info("handling UpdateLoadDynamicsEvent - " + event );
    	
	    LoadDynamics entity = new LoadDynamics();
        entity.setLoadDynamicsId( event.getLoadDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadDynamics( entity );        
    }
    
    /*
     * @param	event DeleteLoadDynamicsEvent
     */
    @EventHandler( payloadType=DeleteLoadDynamicsEvent.class )
    public void handle( DeleteLoadDynamicsEvent event) {
    	LOGGER.info("handling DeleteLoadDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadDynamics entity = delete( event.getLoadDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadDynamics( entity );

    }    




    /**
     * Method to retrieve the LoadDynamics via an LoadDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	LoadDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadDynamics handle( FindLoadDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadDynamicss
     *
     * @param	query	FindAllLoadDynamicsQuery 
     * @return 	List<LoadDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadDynamics> handle( FindAllLoadDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadDynamics
	 */
	protected void emitFindLoadDynamics( LoadDynamics entity ) {
		LOGGER.info("handling emitFindLoadDynamics" );
		
	    queryUpdateEmitter.emit(FindLoadDynamicsQuery.class,
	                            query -> query.getFilter().getLoadDynamicsId().equals(entity.getLoadDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadDynamics
	 * 
	 * @param		entity	LoadDynamics
	 */
	protected void emitFindAllLoadDynamics( LoadDynamics entity ) {
		LOGGER.info("handling emitFindAllLoadDynamics" );
		
	    queryUpdateEmitter.emit(FindAllLoadDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadDynamicsProjector.class.getName());

}
