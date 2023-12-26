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
 * Projector for Breaker as outlined for the CQRS pattern.  All event handling and query handling related to Breaker are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BreakerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("breaker")
@Component("breaker-projector")
public class BreakerProjector extends BreakerEntityProjector {
		
	// core constructor
	public BreakerProjector(BreakerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBreakerEvent
     */
    @EventHandler( payloadType=CreateBreakerEvent.class )
    public void handle( CreateBreakerEvent event) {
	    LOGGER.info("handling CreateBreakerEvent - " + event );
	    Breaker entity = new Breaker();
        entity.setBreakerId( event.getBreakerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBreaker( entity );
    }

    /*
     * @param	event UpdateBreakerEvent
     */
    @EventHandler( payloadType=UpdateBreakerEvent.class )
    public void handle( UpdateBreakerEvent event) {
    	LOGGER.info("handling UpdateBreakerEvent - " + event );
    	
	    Breaker entity = new Breaker();
        entity.setBreakerId( event.getBreakerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBreaker( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBreaker( entity );        
    }
    
    /*
     * @param	event DeleteBreakerEvent
     */
    @EventHandler( payloadType=DeleteBreakerEvent.class )
    public void handle( DeleteBreakerEvent event) {
    	LOGGER.info("handling DeleteBreakerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Breaker entity = delete( event.getBreakerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBreaker( entity );

    }    




    /**
     * Method to retrieve the Breaker via an BreakerPrimaryKey.
     * @param 	id Long
     * @return 	Breaker
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Breaker handle( FindBreakerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBreakerId() );
    }
    
    /**
     * Method to retrieve a collection of all Breakers
     *
     * @param	query	FindAllBreakerQuery 
     * @return 	List<Breaker> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Breaker> handle( FindAllBreakerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBreaker, 
	 * but only if the id matches
	 * 
	 * @param		entity	Breaker
	 */
	protected void emitFindBreaker( Breaker entity ) {
		LOGGER.info("handling emitFindBreaker" );
		
	    queryUpdateEmitter.emit(FindBreakerQuery.class,
	                            query -> query.getFilter().getBreakerId().equals(entity.getBreakerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBreaker
	 * 
	 * @param		entity	Breaker
	 */
	protected void emitFindAllBreaker( Breaker entity ) {
		LOGGER.info("handling emitFindAllBreaker" );
		
	    queryUpdateEmitter.emit(FindAllBreakerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BreakerProjector.class.getName());

}
