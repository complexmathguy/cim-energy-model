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
 * Projector for CurrentLimit as outlined for the CQRS pattern.  All event handling and query handling related to CurrentLimit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CurrentLimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("currentLimit")
@Component("currentLimit-projector")
public class CurrentLimitProjector extends CurrentLimitEntityProjector {
		
	// core constructor
	public CurrentLimitProjector(CurrentLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCurrentLimitEvent
     */
    @EventHandler( payloadType=CreateCurrentLimitEvent.class )
    public void handle( CreateCurrentLimitEvent event) {
	    LOGGER.info("handling CreateCurrentLimitEvent - " + event );
	    CurrentLimit entity = new CurrentLimit();
        entity.setCurrentLimitId( event.getCurrentLimitId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentLimit( entity );
    }

    /*
     * @param	event UpdateCurrentLimitEvent
     */
    @EventHandler( payloadType=UpdateCurrentLimitEvent.class )
    public void handle( UpdateCurrentLimitEvent event) {
    	LOGGER.info("handling UpdateCurrentLimitEvent - " + event );
    	
	    CurrentLimit entity = new CurrentLimit();
        entity.setCurrentLimitId( event.getCurrentLimitId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCurrentLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentLimit( entity );        
    }
    
    /*
     * @param	event DeleteCurrentLimitEvent
     */
    @EventHandler( payloadType=DeleteCurrentLimitEvent.class )
    public void handle( DeleteCurrentLimitEvent event) {
    	LOGGER.info("handling DeleteCurrentLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	CurrentLimit entity = delete( event.getCurrentLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentLimit( entity );

    }    




    /**
     * Method to retrieve the CurrentLimit via an CurrentLimitPrimaryKey.
     * @param 	id Long
     * @return 	CurrentLimit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public CurrentLimit handle( FindCurrentLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCurrentLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all CurrentLimits
     *
     * @param	query	FindAllCurrentLimitQuery 
     * @return 	List<CurrentLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<CurrentLimit> handle( FindAllCurrentLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCurrentLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	CurrentLimit
	 */
	protected void emitFindCurrentLimit( CurrentLimit entity ) {
		LOGGER.info("handling emitFindCurrentLimit" );
		
	    queryUpdateEmitter.emit(FindCurrentLimitQuery.class,
	                            query -> query.getFilter().getCurrentLimitId().equals(entity.getCurrentLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCurrentLimit
	 * 
	 * @param		entity	CurrentLimit
	 */
	protected void emitFindAllCurrentLimit( CurrentLimit entity ) {
		LOGGER.info("handling emitFindAllCurrentLimit" );
		
	    queryUpdateEmitter.emit(FindAllCurrentLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CurrentLimitProjector.class.getName());

}
