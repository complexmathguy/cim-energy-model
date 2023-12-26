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
 * Projector for LoadUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to LoadUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadUserDefined")
@Component("loadUserDefined-projector")
public class LoadUserDefinedProjector extends LoadUserDefinedEntityProjector {
		
	// core constructor
	public LoadUserDefinedProjector(LoadUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadUserDefinedEvent
     */
    @EventHandler( payloadType=CreateLoadUserDefinedEvent.class )
    public void handle( CreateLoadUserDefinedEvent event) {
	    LOGGER.info("handling CreateLoadUserDefinedEvent - " + event );
	    LoadUserDefined entity = new LoadUserDefined();
        entity.setLoadUserDefinedId( event.getLoadUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadUserDefined( entity );
    }

    /*
     * @param	event UpdateLoadUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateLoadUserDefinedEvent.class )
    public void handle( UpdateLoadUserDefinedEvent event) {
    	LOGGER.info("handling UpdateLoadUserDefinedEvent - " + event );
    	
	    LoadUserDefined entity = new LoadUserDefined();
        entity.setLoadUserDefinedId( event.getLoadUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteLoadUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteLoadUserDefinedEvent.class )
    public void handle( DeleteLoadUserDefinedEvent event) {
    	LOGGER.info("handling DeleteLoadUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadUserDefined entity = delete( event.getLoadUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadUserDefined( entity );

    }    




    /**
     * Method to retrieve the LoadUserDefined via an LoadUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	LoadUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadUserDefined handle( FindLoadUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadUserDefineds
     *
     * @param	query	FindAllLoadUserDefinedQuery 
     * @return 	List<LoadUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadUserDefined> handle( FindAllLoadUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadUserDefined
	 */
	protected void emitFindLoadUserDefined( LoadUserDefined entity ) {
		LOGGER.info("handling emitFindLoadUserDefined" );
		
	    queryUpdateEmitter.emit(FindLoadUserDefinedQuery.class,
	                            query -> query.getFilter().getLoadUserDefinedId().equals(entity.getLoadUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadUserDefined
	 * 
	 * @param		entity	LoadUserDefined
	 */
	protected void emitFindAllLoadUserDefined( LoadUserDefined entity ) {
		LOGGER.info("handling emitFindAllLoadUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllLoadUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadUserDefinedProjector.class.getName());

}
