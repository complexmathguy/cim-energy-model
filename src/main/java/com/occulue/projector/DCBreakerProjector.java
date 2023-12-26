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
 * Projector for DCBreaker as outlined for the CQRS pattern.  All event handling and query handling related to DCBreaker are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCBreakerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCBreaker")
@Component("dCBreaker-projector")
public class DCBreakerProjector extends DCBreakerEntityProjector {
		
	// core constructor
	public DCBreakerProjector(DCBreakerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCBreakerEvent
     */
    @EventHandler( payloadType=CreateDCBreakerEvent.class )
    public void handle( CreateDCBreakerEvent event) {
	    LOGGER.info("handling CreateDCBreakerEvent - " + event );
	    DCBreaker entity = new DCBreaker();
        entity.setDCBreakerId( event.getDCBreakerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBreaker( entity );
    }

    /*
     * @param	event UpdateDCBreakerEvent
     */
    @EventHandler( payloadType=UpdateDCBreakerEvent.class )
    public void handle( UpdateDCBreakerEvent event) {
    	LOGGER.info("handling UpdateDCBreakerEvent - " + event );
    	
	    DCBreaker entity = new DCBreaker();
        entity.setDCBreakerId( event.getDCBreakerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCBreaker( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBreaker( entity );        
    }
    
    /*
     * @param	event DeleteDCBreakerEvent
     */
    @EventHandler( payloadType=DeleteDCBreakerEvent.class )
    public void handle( DeleteDCBreakerEvent event) {
    	LOGGER.info("handling DeleteDCBreakerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCBreaker entity = delete( event.getDCBreakerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBreaker( entity );

    }    




    /**
     * Method to retrieve the DCBreaker via an DCBreakerPrimaryKey.
     * @param 	id Long
     * @return 	DCBreaker
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCBreaker handle( FindDCBreakerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCBreakerId() );
    }
    
    /**
     * Method to retrieve a collection of all DCBreakers
     *
     * @param	query	FindAllDCBreakerQuery 
     * @return 	List<DCBreaker> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCBreaker> handle( FindAllDCBreakerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCBreaker, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCBreaker
	 */
	protected void emitFindDCBreaker( DCBreaker entity ) {
		LOGGER.info("handling emitFindDCBreaker" );
		
	    queryUpdateEmitter.emit(FindDCBreakerQuery.class,
	                            query -> query.getFilter().getDCBreakerId().equals(entity.getDCBreakerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCBreaker
	 * 
	 * @param		entity	DCBreaker
	 */
	protected void emitFindAllDCBreaker( DCBreaker entity ) {
		LOGGER.info("handling emitFindAllDCBreaker" );
		
	    queryUpdateEmitter.emit(FindAllDCBreakerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCBreakerProjector.class.getName());

}
