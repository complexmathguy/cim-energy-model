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
 * Projector for LoadAggregate as outlined for the CQRS pattern.  All event handling and query handling related to LoadAggregate are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadAggregateAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadAggregate")
@Component("loadAggregate-projector")
public class LoadAggregateProjector extends LoadAggregateEntityProjector {
		
	// core constructor
	public LoadAggregateProjector(LoadAggregateRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadAggregateEvent
     */
    @EventHandler( payloadType=CreateLoadAggregateEvent.class )
    public void handle( CreateLoadAggregateEvent event) {
	    LOGGER.info("handling CreateLoadAggregateEvent - " + event );
	    LoadAggregate entity = new LoadAggregate();
        entity.setLoadAggregateId( event.getLoadAggregateId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadAggregate( entity );
    }

    /*
     * @param	event UpdateLoadAggregateEvent
     */
    @EventHandler( payloadType=UpdateLoadAggregateEvent.class )
    public void handle( UpdateLoadAggregateEvent event) {
    	LOGGER.info("handling UpdateLoadAggregateEvent - " + event );
    	
	    LoadAggregate entity = new LoadAggregate();
        entity.setLoadAggregateId( event.getLoadAggregateId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadAggregate( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadAggregate( entity );        
    }
    
    /*
     * @param	event DeleteLoadAggregateEvent
     */
    @EventHandler( payloadType=DeleteLoadAggregateEvent.class )
    public void handle( DeleteLoadAggregateEvent event) {
    	LOGGER.info("handling DeleteLoadAggregateEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadAggregate entity = delete( event.getLoadAggregateId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadAggregate( entity );

    }    




    /**
     * Method to retrieve the LoadAggregate via an LoadAggregatePrimaryKey.
     * @param 	id Long
     * @return 	LoadAggregate
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadAggregate handle( FindLoadAggregateQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadAggregateId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadAggregates
     *
     * @param	query	FindAllLoadAggregateQuery 
     * @return 	List<LoadAggregate> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadAggregate> handle( FindAllLoadAggregateQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadAggregate, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadAggregate
	 */
	protected void emitFindLoadAggregate( LoadAggregate entity ) {
		LOGGER.info("handling emitFindLoadAggregate" );
		
	    queryUpdateEmitter.emit(FindLoadAggregateQuery.class,
	                            query -> query.getFilter().getLoadAggregateId().equals(entity.getLoadAggregateId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadAggregate
	 * 
	 * @param		entity	LoadAggregate
	 */
	protected void emitFindAllLoadAggregate( LoadAggregate entity ) {
		LOGGER.info("handling emitFindAllLoadAggregate" );
		
	    queryUpdateEmitter.emit(FindAllLoadAggregateQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadAggregateProjector.class.getName());

}
