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
 * Projector for Season as outlined for the CQRS pattern.  All event handling and query handling related to Season are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SeasonAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("season")
@Component("season-projector")
public class SeasonProjector extends SeasonEntityProjector {
		
	// core constructor
	public SeasonProjector(SeasonRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSeasonEvent
     */
    @EventHandler( payloadType=CreateSeasonEvent.class )
    public void handle( CreateSeasonEvent event) {
	    LOGGER.info("handling CreateSeasonEvent - " + event );
	    Season entity = new Season();
        entity.setSeasonId( event.getSeasonId() );
        entity.setEndDate( event.getEndDate() );
        entity.setStartDate( event.getStartDate() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeason( entity );
    }

    /*
     * @param	event UpdateSeasonEvent
     */
    @EventHandler( payloadType=UpdateSeasonEvent.class )
    public void handle( UpdateSeasonEvent event) {
    	LOGGER.info("handling UpdateSeasonEvent - " + event );
    	
	    Season entity = new Season();
        entity.setSeasonId( event.getSeasonId() );
        entity.setEndDate( event.getEndDate() );
        entity.setStartDate( event.getStartDate() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSeason( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeason( entity );        
    }
    
    /*
     * @param	event DeleteSeasonEvent
     */
    @EventHandler( payloadType=DeleteSeasonEvent.class )
    public void handle( DeleteSeasonEvent event) {
    	LOGGER.info("handling DeleteSeasonEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Season entity = delete( event.getSeasonId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeason( entity );

    }    




    /**
     * Method to retrieve the Season via an SeasonPrimaryKey.
     * @param 	id Long
     * @return 	Season
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Season handle( FindSeasonQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSeasonId() );
    }
    
    /**
     * Method to retrieve a collection of all Seasons
     *
     * @param	query	FindAllSeasonQuery 
     * @return 	List<Season> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Season> handle( FindAllSeasonQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSeason, 
	 * but only if the id matches
	 * 
	 * @param		entity	Season
	 */
	protected void emitFindSeason( Season entity ) {
		LOGGER.info("handling emitFindSeason" );
		
	    queryUpdateEmitter.emit(FindSeasonQuery.class,
	                            query -> query.getFilter().getSeasonId().equals(entity.getSeasonId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSeason
	 * 
	 * @param		entity	Season
	 */
	protected void emitFindAllSeason( Season entity ) {
		LOGGER.info("handling emitFindAllSeason" );
		
	    queryUpdateEmitter.emit(FindAllSeasonQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SeasonProjector.class.getName());

}
