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
 * Projector for DCDisconnector as outlined for the CQRS pattern.  All event handling and query handling related to DCDisconnector are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCDisconnectorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCDisconnector")
@Component("dCDisconnector-projector")
public class DCDisconnectorProjector extends DCDisconnectorEntityProjector {
		
	// core constructor
	public DCDisconnectorProjector(DCDisconnectorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCDisconnectorEvent
     */
    @EventHandler( payloadType=CreateDCDisconnectorEvent.class )
    public void handle( CreateDCDisconnectorEvent event) {
	    LOGGER.info("handling CreateDCDisconnectorEvent - " + event );
	    DCDisconnector entity = new DCDisconnector();
        entity.setDCDisconnectorId( event.getDCDisconnectorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCDisconnector( entity );
    }

    /*
     * @param	event UpdateDCDisconnectorEvent
     */
    @EventHandler( payloadType=UpdateDCDisconnectorEvent.class )
    public void handle( UpdateDCDisconnectorEvent event) {
    	LOGGER.info("handling UpdateDCDisconnectorEvent - " + event );
    	
	    DCDisconnector entity = new DCDisconnector();
        entity.setDCDisconnectorId( event.getDCDisconnectorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCDisconnector( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCDisconnector( entity );        
    }
    
    /*
     * @param	event DeleteDCDisconnectorEvent
     */
    @EventHandler( payloadType=DeleteDCDisconnectorEvent.class )
    public void handle( DeleteDCDisconnectorEvent event) {
    	LOGGER.info("handling DeleteDCDisconnectorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCDisconnector entity = delete( event.getDCDisconnectorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCDisconnector( entity );

    }    




    /**
     * Method to retrieve the DCDisconnector via an DCDisconnectorPrimaryKey.
     * @param 	id Long
     * @return 	DCDisconnector
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCDisconnector handle( FindDCDisconnectorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCDisconnectorId() );
    }
    
    /**
     * Method to retrieve a collection of all DCDisconnectors
     *
     * @param	query	FindAllDCDisconnectorQuery 
     * @return 	List<DCDisconnector> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCDisconnector> handle( FindAllDCDisconnectorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCDisconnector, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCDisconnector
	 */
	protected void emitFindDCDisconnector( DCDisconnector entity ) {
		LOGGER.info("handling emitFindDCDisconnector" );
		
	    queryUpdateEmitter.emit(FindDCDisconnectorQuery.class,
	                            query -> query.getFilter().getDCDisconnectorId().equals(entity.getDCDisconnectorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCDisconnector
	 * 
	 * @param		entity	DCDisconnector
	 */
	protected void emitFindAllDCDisconnector( DCDisconnector entity ) {
		LOGGER.info("handling emitFindAllDCDisconnector" );
		
	    queryUpdateEmitter.emit(FindAllDCDisconnectorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCDisconnectorProjector.class.getName());

}
