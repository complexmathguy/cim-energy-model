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
 * Projector for LoadBreakSwitch as outlined for the CQRS pattern.  All event handling and query handling related to LoadBreakSwitch are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadBreakSwitchAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadBreakSwitch")
@Component("loadBreakSwitch-projector")
public class LoadBreakSwitchProjector extends LoadBreakSwitchEntityProjector {
		
	// core constructor
	public LoadBreakSwitchProjector(LoadBreakSwitchRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadBreakSwitchEvent
     */
    @EventHandler( payloadType=CreateLoadBreakSwitchEvent.class )
    public void handle( CreateLoadBreakSwitchEvent event) {
	    LOGGER.info("handling CreateLoadBreakSwitchEvent - " + event );
	    LoadBreakSwitch entity = new LoadBreakSwitch();
        entity.setLoadBreakSwitchId( event.getLoadBreakSwitchId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadBreakSwitch( entity );
    }

    /*
     * @param	event UpdateLoadBreakSwitchEvent
     */
    @EventHandler( payloadType=UpdateLoadBreakSwitchEvent.class )
    public void handle( UpdateLoadBreakSwitchEvent event) {
    	LOGGER.info("handling UpdateLoadBreakSwitchEvent - " + event );
    	
	    LoadBreakSwitch entity = new LoadBreakSwitch();
        entity.setLoadBreakSwitchId( event.getLoadBreakSwitchId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadBreakSwitch( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadBreakSwitch( entity );        
    }
    
    /*
     * @param	event DeleteLoadBreakSwitchEvent
     */
    @EventHandler( payloadType=DeleteLoadBreakSwitchEvent.class )
    public void handle( DeleteLoadBreakSwitchEvent event) {
    	LOGGER.info("handling DeleteLoadBreakSwitchEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadBreakSwitch entity = delete( event.getLoadBreakSwitchId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadBreakSwitch( entity );

    }    




    /**
     * Method to retrieve the LoadBreakSwitch via an LoadBreakSwitchPrimaryKey.
     * @param 	id Long
     * @return 	LoadBreakSwitch
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadBreakSwitch handle( FindLoadBreakSwitchQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadBreakSwitchId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadBreakSwitchs
     *
     * @param	query	FindAllLoadBreakSwitchQuery 
     * @return 	List<LoadBreakSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadBreakSwitch> handle( FindAllLoadBreakSwitchQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadBreakSwitch, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadBreakSwitch
	 */
	protected void emitFindLoadBreakSwitch( LoadBreakSwitch entity ) {
		LOGGER.info("handling emitFindLoadBreakSwitch" );
		
	    queryUpdateEmitter.emit(FindLoadBreakSwitchQuery.class,
	                            query -> query.getFilter().getLoadBreakSwitchId().equals(entity.getLoadBreakSwitchId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadBreakSwitch
	 * 
	 * @param		entity	LoadBreakSwitch
	 */
	protected void emitFindAllLoadBreakSwitch( LoadBreakSwitch entity ) {
		LOGGER.info("handling emitFindAllLoadBreakSwitch" );
		
	    queryUpdateEmitter.emit(FindAllLoadBreakSwitchQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadBreakSwitchProjector.class.getName());

}
