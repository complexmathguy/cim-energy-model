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
 * Projector for WindPlantDynamics as outlined for the CQRS pattern.  All event handling and query handling related to WindPlantDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindPlantDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windPlantDynamics")
@Component("windPlantDynamics-projector")
public class WindPlantDynamicsProjector extends WindPlantDynamicsEntityProjector {
		
	// core constructor
	public WindPlantDynamicsProjector(WindPlantDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindPlantDynamicsEvent
     */
    @EventHandler( payloadType=CreateWindPlantDynamicsEvent.class )
    public void handle( CreateWindPlantDynamicsEvent event) {
	    LOGGER.info("handling CreateWindPlantDynamicsEvent - " + event );
	    WindPlantDynamics entity = new WindPlantDynamics();
        entity.setWindPlantDynamicsId( event.getWindPlantDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantDynamics( entity );
    }

    /*
     * @param	event UpdateWindPlantDynamicsEvent
     */
    @EventHandler( payloadType=UpdateWindPlantDynamicsEvent.class )
    public void handle( UpdateWindPlantDynamicsEvent event) {
    	LOGGER.info("handling UpdateWindPlantDynamicsEvent - " + event );
    	
	    WindPlantDynamics entity = new WindPlantDynamics();
        entity.setWindPlantDynamicsId( event.getWindPlantDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindPlantDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantDynamics( entity );        
    }
    
    /*
     * @param	event DeleteWindPlantDynamicsEvent
     */
    @EventHandler( payloadType=DeleteWindPlantDynamicsEvent.class )
    public void handle( DeleteWindPlantDynamicsEvent event) {
    	LOGGER.info("handling DeleteWindPlantDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindPlantDynamics entity = delete( event.getWindPlantDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindPlantDynamics( entity );

    }    




    /**
     * Method to retrieve the WindPlantDynamics via an WindPlantDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	WindPlantDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindPlantDynamics handle( FindWindPlantDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindPlantDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all WindPlantDynamicss
     *
     * @param	query	FindAllWindPlantDynamicsQuery 
     * @return 	List<WindPlantDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindPlantDynamics> handle( FindAllWindPlantDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindPlantDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindPlantDynamics
	 */
	protected void emitFindWindPlantDynamics( WindPlantDynamics entity ) {
		LOGGER.info("handling emitFindWindPlantDynamics" );
		
	    queryUpdateEmitter.emit(FindWindPlantDynamicsQuery.class,
	                            query -> query.getFilter().getWindPlantDynamicsId().equals(entity.getWindPlantDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindPlantDynamics
	 * 
	 * @param		entity	WindPlantDynamics
	 */
	protected void emitFindAllWindPlantDynamics( WindPlantDynamics entity ) {
		LOGGER.info("handling emitFindAllWindPlantDynamics" );
		
	    queryUpdateEmitter.emit(FindAllWindPlantDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindPlantDynamicsProjector.class.getName());

}
