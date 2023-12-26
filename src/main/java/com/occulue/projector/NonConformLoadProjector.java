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
 * Projector for NonConformLoad as outlined for the CQRS pattern.  All event handling and query handling related to NonConformLoad are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NonConformLoadAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nonConformLoad")
@Component("nonConformLoad-projector")
public class NonConformLoadProjector extends NonConformLoadEntityProjector {
		
	// core constructor
	public NonConformLoadProjector(NonConformLoadRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNonConformLoadEvent
     */
    @EventHandler( payloadType=CreateNonConformLoadEvent.class )
    public void handle( CreateNonConformLoadEvent event) {
	    LOGGER.info("handling CreateNonConformLoadEvent - " + event );
	    NonConformLoad entity = new NonConformLoad();
        entity.setNonConformLoadId( event.getNonConformLoadId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoad( entity );
    }

    /*
     * @param	event UpdateNonConformLoadEvent
     */
    @EventHandler( payloadType=UpdateNonConformLoadEvent.class )
    public void handle( UpdateNonConformLoadEvent event) {
    	LOGGER.info("handling UpdateNonConformLoadEvent - " + event );
    	
	    NonConformLoad entity = new NonConformLoad();
        entity.setNonConformLoadId( event.getNonConformLoadId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNonConformLoad( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoad( entity );        
    }
    
    /*
     * @param	event DeleteNonConformLoadEvent
     */
    @EventHandler( payloadType=DeleteNonConformLoadEvent.class )
    public void handle( DeleteNonConformLoadEvent event) {
    	LOGGER.info("handling DeleteNonConformLoadEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NonConformLoad entity = delete( event.getNonConformLoadId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoad( entity );

    }    




    /**
     * Method to retrieve the NonConformLoad via an NonConformLoadPrimaryKey.
     * @param 	id Long
     * @return 	NonConformLoad
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NonConformLoad handle( FindNonConformLoadQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNonConformLoadId() );
    }
    
    /**
     * Method to retrieve a collection of all NonConformLoads
     *
     * @param	query	FindAllNonConformLoadQuery 
     * @return 	List<NonConformLoad> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NonConformLoad> handle( FindAllNonConformLoadQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNonConformLoad, 
	 * but only if the id matches
	 * 
	 * @param		entity	NonConformLoad
	 */
	protected void emitFindNonConformLoad( NonConformLoad entity ) {
		LOGGER.info("handling emitFindNonConformLoad" );
		
	    queryUpdateEmitter.emit(FindNonConformLoadQuery.class,
	                            query -> query.getFilter().getNonConformLoadId().equals(entity.getNonConformLoadId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNonConformLoad
	 * 
	 * @param		entity	NonConformLoad
	 */
	protected void emitFindAllNonConformLoad( NonConformLoad entity ) {
		LOGGER.info("handling emitFindAllNonConformLoad" );
		
	    queryUpdateEmitter.emit(FindAllNonConformLoadQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadProjector.class.getName());

}
