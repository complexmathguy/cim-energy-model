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
 * Projector for WindTurbineType1or2Dynamics as outlined for the CQRS pattern.  All event handling and query handling related to WindTurbineType1or2Dynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindTurbineType1or2DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windTurbineType1or2Dynamics")
@Component("windTurbineType1or2Dynamics-projector")
public class WindTurbineType1or2DynamicsProjector extends WindTurbineType1or2DynamicsEntityProjector {
		
	// core constructor
	public WindTurbineType1or2DynamicsProjector(WindTurbineType1or2DynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindTurbineType1or2DynamicsEvent
     */
    @EventHandler( payloadType=CreateWindTurbineType1or2DynamicsEvent.class )
    public void handle( CreateWindTurbineType1or2DynamicsEvent event) {
	    LOGGER.info("handling CreateWindTurbineType1or2DynamicsEvent - " + event );
	    WindTurbineType1or2Dynamics entity = new WindTurbineType1or2Dynamics();
        entity.setWindTurbineType1or2DynamicsId( event.getWindTurbineType1or2DynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType1or2Dynamics( entity );
    }

    /*
     * @param	event UpdateWindTurbineType1or2DynamicsEvent
     */
    @EventHandler( payloadType=UpdateWindTurbineType1or2DynamicsEvent.class )
    public void handle( UpdateWindTurbineType1or2DynamicsEvent event) {
    	LOGGER.info("handling UpdateWindTurbineType1or2DynamicsEvent - " + event );
    	
	    WindTurbineType1or2Dynamics entity = new WindTurbineType1or2Dynamics();
        entity.setWindTurbineType1or2DynamicsId( event.getWindTurbineType1or2DynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindTurbineType1or2Dynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType1or2Dynamics( entity );        
    }
    
    /*
     * @param	event DeleteWindTurbineType1or2DynamicsEvent
     */
    @EventHandler( payloadType=DeleteWindTurbineType1or2DynamicsEvent.class )
    public void handle( DeleteWindTurbineType1or2DynamicsEvent event) {
    	LOGGER.info("handling DeleteWindTurbineType1or2DynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindTurbineType1or2Dynamics entity = delete( event.getWindTurbineType1or2DynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindTurbineType1or2Dynamics( entity );

    }    




    /**
     * Method to retrieve the WindTurbineType1or2Dynamics via an WindTurbineType1or2DynamicsPrimaryKey.
     * @param 	id Long
     * @return 	WindTurbineType1or2Dynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindTurbineType1or2Dynamics handle( FindWindTurbineType1or2DynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindTurbineType1or2DynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType1or2Dynamicss
     *
     * @param	query	FindAllWindTurbineType1or2DynamicsQuery 
     * @return 	List<WindTurbineType1or2Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindTurbineType1or2Dynamics> handle( FindAllWindTurbineType1or2DynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindTurbineType1or2Dynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindTurbineType1or2Dynamics
	 */
	protected void emitFindWindTurbineType1or2Dynamics( WindTurbineType1or2Dynamics entity ) {
		LOGGER.info("handling emitFindWindTurbineType1or2Dynamics" );
		
	    queryUpdateEmitter.emit(FindWindTurbineType1or2DynamicsQuery.class,
	                            query -> query.getFilter().getWindTurbineType1or2DynamicsId().equals(entity.getWindTurbineType1or2DynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindTurbineType1or2Dynamics
	 * 
	 * @param		entity	WindTurbineType1or2Dynamics
	 */
	protected void emitFindAllWindTurbineType1or2Dynamics( WindTurbineType1or2Dynamics entity ) {
		LOGGER.info("handling emitFindAllWindTurbineType1or2Dynamics" );
		
	    queryUpdateEmitter.emit(FindAllWindTurbineType1or2DynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType1or2DynamicsProjector.class.getName());

}
