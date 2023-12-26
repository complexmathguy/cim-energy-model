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
 * Projector for DCChopper as outlined for the CQRS pattern.  All event handling and query handling related to DCChopper are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCChopperAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCChopper")
@Component("dCChopper-projector")
public class DCChopperProjector extends DCChopperEntityProjector {
		
	// core constructor
	public DCChopperProjector(DCChopperRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCChopperEvent
     */
    @EventHandler( payloadType=CreateDCChopperEvent.class )
    public void handle( CreateDCChopperEvent event) {
	    LOGGER.info("handling CreateDCChopperEvent - " + event );
	    DCChopper entity = new DCChopper();
        entity.setDCChopperId( event.getDCChopperId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCChopper( entity );
    }

    /*
     * @param	event UpdateDCChopperEvent
     */
    @EventHandler( payloadType=UpdateDCChopperEvent.class )
    public void handle( UpdateDCChopperEvent event) {
    	LOGGER.info("handling UpdateDCChopperEvent - " + event );
    	
	    DCChopper entity = new DCChopper();
        entity.setDCChopperId( event.getDCChopperId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCChopper( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCChopper( entity );        
    }
    
    /*
     * @param	event DeleteDCChopperEvent
     */
    @EventHandler( payloadType=DeleteDCChopperEvent.class )
    public void handle( DeleteDCChopperEvent event) {
    	LOGGER.info("handling DeleteDCChopperEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCChopper entity = delete( event.getDCChopperId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCChopper( entity );

    }    




    /**
     * Method to retrieve the DCChopper via an DCChopperPrimaryKey.
     * @param 	id Long
     * @return 	DCChopper
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCChopper handle( FindDCChopperQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCChopperId() );
    }
    
    /**
     * Method to retrieve a collection of all DCChoppers
     *
     * @param	query	FindAllDCChopperQuery 
     * @return 	List<DCChopper> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCChopper> handle( FindAllDCChopperQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCChopper, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCChopper
	 */
	protected void emitFindDCChopper( DCChopper entity ) {
		LOGGER.info("handling emitFindDCChopper" );
		
	    queryUpdateEmitter.emit(FindDCChopperQuery.class,
	                            query -> query.getFilter().getDCChopperId().equals(entity.getDCChopperId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCChopper
	 * 
	 * @param		entity	DCChopper
	 */
	protected void emitFindAllDCChopper( DCChopper entity ) {
		LOGGER.info("handling emitFindAllDCChopper" );
		
	    queryUpdateEmitter.emit(FindAllDCChopperQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCChopperProjector.class.getName());

}
