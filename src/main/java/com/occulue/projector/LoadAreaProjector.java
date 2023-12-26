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
 * Projector for LoadArea as outlined for the CQRS pattern.  All event handling and query handling related to LoadArea are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadAreaAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadArea")
@Component("loadArea-projector")
public class LoadAreaProjector extends LoadAreaEntityProjector {
		
	// core constructor
	public LoadAreaProjector(LoadAreaRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadAreaEvent
     */
    @EventHandler( payloadType=CreateLoadAreaEvent.class )
    public void handle( CreateLoadAreaEvent event) {
	    LOGGER.info("handling CreateLoadAreaEvent - " + event );
	    LoadArea entity = new LoadArea();
        entity.setLoadAreaId( event.getLoadAreaId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadArea( entity );
    }

    /*
     * @param	event UpdateLoadAreaEvent
     */
    @EventHandler( payloadType=UpdateLoadAreaEvent.class )
    public void handle( UpdateLoadAreaEvent event) {
    	LOGGER.info("handling UpdateLoadAreaEvent - " + event );
    	
	    LoadArea entity = new LoadArea();
        entity.setLoadAreaId( event.getLoadAreaId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadArea( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadArea( entity );        
    }
    
    /*
     * @param	event DeleteLoadAreaEvent
     */
    @EventHandler( payloadType=DeleteLoadAreaEvent.class )
    public void handle( DeleteLoadAreaEvent event) {
    	LOGGER.info("handling DeleteLoadAreaEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadArea entity = delete( event.getLoadAreaId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadArea( entity );

    }    




    /**
     * Method to retrieve the LoadArea via an LoadAreaPrimaryKey.
     * @param 	id Long
     * @return 	LoadArea
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadArea handle( FindLoadAreaQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadAreaId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadAreas
     *
     * @param	query	FindAllLoadAreaQuery 
     * @return 	List<LoadArea> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadArea> handle( FindAllLoadAreaQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadArea, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadArea
	 */
	protected void emitFindLoadArea( LoadArea entity ) {
		LOGGER.info("handling emitFindLoadArea" );
		
	    queryUpdateEmitter.emit(FindLoadAreaQuery.class,
	                            query -> query.getFilter().getLoadAreaId().equals(entity.getLoadAreaId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadArea
	 * 
	 * @param		entity	LoadArea
	 */
	protected void emitFindAllLoadArea( LoadArea entity ) {
		LOGGER.info("handling emitFindAllLoadArea" );
		
	    queryUpdateEmitter.emit(FindAllLoadAreaQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadAreaProjector.class.getName());

}
