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
 * Projector for WindTurbineType3or4Dynamics as outlined for the CQRS pattern.  All event handling and query handling related to WindTurbineType3or4Dynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindTurbineType3or4DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windTurbineType3or4Dynamics")
@Component("windTurbineType3or4Dynamics-projector")
public class WindTurbineType3or4DynamicsProjector extends WindTurbineType3or4DynamicsEntityProjector {
		
	// core constructor
	public WindTurbineType3or4DynamicsProjector(WindTurbineType3or4DynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindTurbineType3or4DynamicsEvent
     */
    @EventHandler( payloadType=CreateWindTurbineType3or4DynamicsEvent.class )
    public void handle( CreateWindTurbineType3or4DynamicsEvent event) {
	    LOGGER.info("handling CreateWindTurbineType3or4DynamicsEvent - " + event );
	    WindTurbineType3or4Dynamics entity = new WindTurbineType3or4Dynamics();
        entity.setWindTurbineType3or4DynamicsId( event.getWindTurbineType3or4DynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4Dynamics( entity );
    }

    /*
     * @param	event UpdateWindTurbineType3or4DynamicsEvent
     */
    @EventHandler( payloadType=UpdateWindTurbineType3or4DynamicsEvent.class )
    public void handle( UpdateWindTurbineType3or4DynamicsEvent event) {
    	LOGGER.info("handling UpdateWindTurbineType3or4DynamicsEvent - " + event );
    	
	    WindTurbineType3or4Dynamics entity = new WindTurbineType3or4Dynamics();
        entity.setWindTurbineType3or4DynamicsId( event.getWindTurbineType3or4DynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindTurbineType3or4Dynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4Dynamics( entity );        
    }
    
    /*
     * @param	event DeleteWindTurbineType3or4DynamicsEvent
     */
    @EventHandler( payloadType=DeleteWindTurbineType3or4DynamicsEvent.class )
    public void handle( DeleteWindTurbineType3or4DynamicsEvent event) {
    	LOGGER.info("handling DeleteWindTurbineType3or4DynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindTurbineType3or4Dynamics entity = delete( event.getWindTurbineType3or4DynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType3or4Dynamics( entity );

    }    




    /**
     * Method to retrieve the WindTurbineType3or4Dynamics via an WindTurbineType3or4DynamicsPrimaryKey.
     * @param 	id Long
     * @return 	WindTurbineType3or4Dynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindTurbineType3or4Dynamics handle( FindWindTurbineType3or4DynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindTurbineType3or4DynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType3or4Dynamicss
     *
     * @param	query	FindAllWindTurbineType3or4DynamicsQuery 
     * @return 	List<WindTurbineType3or4Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindTurbineType3or4Dynamics> handle( FindAllWindTurbineType3or4DynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindTurbineType3or4Dynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindTurbineType3or4Dynamics
	 */
	protected void emitFindWindTurbineType3or4Dynamics( WindTurbineType3or4Dynamics entity ) {
		LOGGER.info("handling emitFindWindTurbineType3or4Dynamics" );
		
	    queryUpdateEmitter.emit(FindWindTurbineType3or4DynamicsQuery.class,
	                            query -> query.getFilter().getWindTurbineType3or4DynamicsId().equals(entity.getWindTurbineType3or4DynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindTurbineType3or4Dynamics
	 * 
	 * @param		entity	WindTurbineType3or4Dynamics
	 */
	protected void emitFindAllWindTurbineType3or4Dynamics( WindTurbineType3or4Dynamics entity ) {
		LOGGER.info("handling emitFindAllWindTurbineType3or4Dynamics" );
		
	    queryUpdateEmitter.emit(FindAllWindTurbineType3or4DynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType3or4DynamicsProjector.class.getName());

}
