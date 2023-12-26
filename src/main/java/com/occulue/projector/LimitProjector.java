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
 * Projector for Limit as outlined for the CQRS pattern.  All event handling and query handling related to Limit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("limit")
@Component("limit-projector")
public class LimitProjector extends LimitEntityProjector {
		
	// core constructor
	public LimitProjector(LimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLimitEvent
     */
    @EventHandler( payloadType=CreateLimitEvent.class )
    public void handle( CreateLimitEvent event) {
	    LOGGER.info("handling CreateLimitEvent - " + event );
	    Limit entity = new Limit();
        entity.setLimitId( event.getLimitId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimit( entity );
    }

    /*
     * @param	event UpdateLimitEvent
     */
    @EventHandler( payloadType=UpdateLimitEvent.class )
    public void handle( UpdateLimitEvent event) {
    	LOGGER.info("handling UpdateLimitEvent - " + event );
    	
	    Limit entity = new Limit();
        entity.setLimitId( event.getLimitId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimit( entity );        
    }
    
    /*
     * @param	event DeleteLimitEvent
     */
    @EventHandler( payloadType=DeleteLimitEvent.class )
    public void handle( DeleteLimitEvent event) {
    	LOGGER.info("handling DeleteLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Limit entity = delete( event.getLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimit( entity );

    }    




    /**
     * Method to retrieve the Limit via an LimitPrimaryKey.
     * @param 	id Long
     * @return 	Limit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Limit handle( FindLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all Limits
     *
     * @param	query	FindAllLimitQuery 
     * @return 	List<Limit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Limit> handle( FindAllLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	Limit
	 */
	protected void emitFindLimit( Limit entity ) {
		LOGGER.info("handling emitFindLimit" );
		
	    queryUpdateEmitter.emit(FindLimitQuery.class,
	                            query -> query.getFilter().getLimitId().equals(entity.getLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLimit
	 * 
	 * @param		entity	Limit
	 */
	protected void emitFindAllLimit( Limit entity ) {
		LOGGER.info("handling emitFindAllLimit" );
		
	    queryUpdateEmitter.emit(FindAllLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LimitProjector.class.getName());

}
