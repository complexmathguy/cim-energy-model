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
 * Projector for NonConformLoadGroup as outlined for the CQRS pattern.  All event handling and query handling related to NonConformLoadGroup are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NonConformLoadGroupAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nonConformLoadGroup")
@Component("nonConformLoadGroup-projector")
public class NonConformLoadGroupProjector extends NonConformLoadGroupEntityProjector {
		
	// core constructor
	public NonConformLoadGroupProjector(NonConformLoadGroupRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNonConformLoadGroupEvent
     */
    @EventHandler( payloadType=CreateNonConformLoadGroupEvent.class )
    public void handle( CreateNonConformLoadGroupEvent event) {
	    LOGGER.info("handling CreateNonConformLoadGroupEvent - " + event );
	    NonConformLoadGroup entity = new NonConformLoadGroup();
        entity.setNonConformLoadGroupId( event.getNonConformLoadGroupId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadGroup( entity );
    }

    /*
     * @param	event UpdateNonConformLoadGroupEvent
     */
    @EventHandler( payloadType=UpdateNonConformLoadGroupEvent.class )
    public void handle( UpdateNonConformLoadGroupEvent event) {
    	LOGGER.info("handling UpdateNonConformLoadGroupEvent - " + event );
    	
	    NonConformLoadGroup entity = new NonConformLoadGroup();
        entity.setNonConformLoadGroupId( event.getNonConformLoadGroupId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNonConformLoadGroup( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadGroup( entity );        
    }
    
    /*
     * @param	event DeleteNonConformLoadGroupEvent
     */
    @EventHandler( payloadType=DeleteNonConformLoadGroupEvent.class )
    public void handle( DeleteNonConformLoadGroupEvent event) {
    	LOGGER.info("handling DeleteNonConformLoadGroupEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NonConformLoadGroup entity = delete( event.getNonConformLoadGroupId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadGroup( entity );

    }    




    /**
     * Method to retrieve the NonConformLoadGroup via an NonConformLoadGroupPrimaryKey.
     * @param 	id Long
     * @return 	NonConformLoadGroup
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NonConformLoadGroup handle( FindNonConformLoadGroupQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNonConformLoadGroupId() );
    }
    
    /**
     * Method to retrieve a collection of all NonConformLoadGroups
     *
     * @param	query	FindAllNonConformLoadGroupQuery 
     * @return 	List<NonConformLoadGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NonConformLoadGroup> handle( FindAllNonConformLoadGroupQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNonConformLoadGroup, 
	 * but only if the id matches
	 * 
	 * @param		entity	NonConformLoadGroup
	 */
	protected void emitFindNonConformLoadGroup( NonConformLoadGroup entity ) {
		LOGGER.info("handling emitFindNonConformLoadGroup" );
		
	    queryUpdateEmitter.emit(FindNonConformLoadGroupQuery.class,
	                            query -> query.getFilter().getNonConformLoadGroupId().equals(entity.getNonConformLoadGroupId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNonConformLoadGroup
	 * 
	 * @param		entity	NonConformLoadGroup
	 */
	protected void emitFindAllNonConformLoadGroup( NonConformLoadGroup entity ) {
		LOGGER.info("handling emitFindAllNonConformLoadGroup" );
		
	    queryUpdateEmitter.emit(FindAllNonConformLoadGroupQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadGroupProjector.class.getName());

}
