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
 * Projector for PowerSystemResource as outlined for the CQRS pattern.  All event handling and query handling related to PowerSystemResource are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PowerSystemResourceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("powerSystemResource")
@Component("powerSystemResource-projector")
public class PowerSystemResourceProjector extends PowerSystemResourceEntityProjector {
		
	// core constructor
	public PowerSystemResourceProjector(PowerSystemResourceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePowerSystemResourceEvent
     */
    @EventHandler( payloadType=CreatePowerSystemResourceEvent.class )
    public void handle( CreatePowerSystemResourceEvent event) {
	    LOGGER.info("handling CreatePowerSystemResourceEvent - " + event );
	    PowerSystemResource entity = new PowerSystemResource();
        entity.setPowerSystemResourceId( event.getPowerSystemResourceId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerSystemResource( entity );
    }

    /*
     * @param	event UpdatePowerSystemResourceEvent
     */
    @EventHandler( payloadType=UpdatePowerSystemResourceEvent.class )
    public void handle( UpdatePowerSystemResourceEvent event) {
    	LOGGER.info("handling UpdatePowerSystemResourceEvent - " + event );
    	
	    PowerSystemResource entity = new PowerSystemResource();
        entity.setPowerSystemResourceId( event.getPowerSystemResourceId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPowerSystemResource( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerSystemResource( entity );        
    }
    
    /*
     * @param	event DeletePowerSystemResourceEvent
     */
    @EventHandler( payloadType=DeletePowerSystemResourceEvent.class )
    public void handle( DeletePowerSystemResourceEvent event) {
    	LOGGER.info("handling DeletePowerSystemResourceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PowerSystemResource entity = delete( event.getPowerSystemResourceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerSystemResource( entity );

    }    




    /**
     * Method to retrieve the PowerSystemResource via an PowerSystemResourcePrimaryKey.
     * @param 	id Long
     * @return 	PowerSystemResource
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PowerSystemResource handle( FindPowerSystemResourceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPowerSystemResourceId() );
    }
    
    /**
     * Method to retrieve a collection of all PowerSystemResources
     *
     * @param	query	FindAllPowerSystemResourceQuery 
     * @return 	List<PowerSystemResource> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PowerSystemResource> handle( FindAllPowerSystemResourceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPowerSystemResource, 
	 * but only if the id matches
	 * 
	 * @param		entity	PowerSystemResource
	 */
	protected void emitFindPowerSystemResource( PowerSystemResource entity ) {
		LOGGER.info("handling emitFindPowerSystemResource" );
		
	    queryUpdateEmitter.emit(FindPowerSystemResourceQuery.class,
	                            query -> query.getFilter().getPowerSystemResourceId().equals(entity.getPowerSystemResourceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPowerSystemResource
	 * 
	 * @param		entity	PowerSystemResource
	 */
	protected void emitFindAllPowerSystemResource( PowerSystemResource entity ) {
		LOGGER.info("handling emitFindAllPowerSystemResource" );
		
	    queryUpdateEmitter.emit(FindAllPowerSystemResourceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemResourceProjector.class.getName());

}
