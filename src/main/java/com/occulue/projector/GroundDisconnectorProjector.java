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
 * Projector for GroundDisconnector as outlined for the CQRS pattern.  All event handling and query handling related to GroundDisconnector are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GroundDisconnectorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("groundDisconnector")
@Component("groundDisconnector-projector")
public class GroundDisconnectorProjector extends GroundDisconnectorEntityProjector {
		
	// core constructor
	public GroundDisconnectorProjector(GroundDisconnectorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGroundDisconnectorEvent
     */
    @EventHandler( payloadType=CreateGroundDisconnectorEvent.class )
    public void handle( CreateGroundDisconnectorEvent event) {
	    LOGGER.info("handling CreateGroundDisconnectorEvent - " + event );
	    GroundDisconnector entity = new GroundDisconnector();
        entity.setGroundDisconnectorId( event.getGroundDisconnectorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGroundDisconnector( entity );
    }

    /*
     * @param	event UpdateGroundDisconnectorEvent
     */
    @EventHandler( payloadType=UpdateGroundDisconnectorEvent.class )
    public void handle( UpdateGroundDisconnectorEvent event) {
    	LOGGER.info("handling UpdateGroundDisconnectorEvent - " + event );
    	
	    GroundDisconnector entity = new GroundDisconnector();
        entity.setGroundDisconnectorId( event.getGroundDisconnectorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGroundDisconnector( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGroundDisconnector( entity );        
    }
    
    /*
     * @param	event DeleteGroundDisconnectorEvent
     */
    @EventHandler( payloadType=DeleteGroundDisconnectorEvent.class )
    public void handle( DeleteGroundDisconnectorEvent event) {
    	LOGGER.info("handling DeleteGroundDisconnectorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GroundDisconnector entity = delete( event.getGroundDisconnectorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGroundDisconnector( entity );

    }    




    /**
     * Method to retrieve the GroundDisconnector via an GroundDisconnectorPrimaryKey.
     * @param 	id Long
     * @return 	GroundDisconnector
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GroundDisconnector handle( FindGroundDisconnectorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGroundDisconnectorId() );
    }
    
    /**
     * Method to retrieve a collection of all GroundDisconnectors
     *
     * @param	query	FindAllGroundDisconnectorQuery 
     * @return 	List<GroundDisconnector> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GroundDisconnector> handle( FindAllGroundDisconnectorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGroundDisconnector, 
	 * but only if the id matches
	 * 
	 * @param		entity	GroundDisconnector
	 */
	protected void emitFindGroundDisconnector( GroundDisconnector entity ) {
		LOGGER.info("handling emitFindGroundDisconnector" );
		
	    queryUpdateEmitter.emit(FindGroundDisconnectorQuery.class,
	                            query -> query.getFilter().getGroundDisconnectorId().equals(entity.getGroundDisconnectorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGroundDisconnector
	 * 
	 * @param		entity	GroundDisconnector
	 */
	protected void emitFindAllGroundDisconnector( GroundDisconnector entity ) {
		LOGGER.info("handling emitFindAllGroundDisconnector" );
		
	    queryUpdateEmitter.emit(FindAllGroundDisconnectorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GroundDisconnectorProjector.class.getName());

}
