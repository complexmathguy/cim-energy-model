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
 * Projector for ConformLoadGroup as outlined for the CQRS pattern.  All event handling and query handling related to ConformLoadGroup are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConformLoadGroupAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("conformLoadGroup")
@Component("conformLoadGroup-projector")
public class ConformLoadGroupProjector extends ConformLoadGroupEntityProjector {
		
	// core constructor
	public ConformLoadGroupProjector(ConformLoadGroupRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConformLoadGroupEvent
     */
    @EventHandler( payloadType=CreateConformLoadGroupEvent.class )
    public void handle( CreateConformLoadGroupEvent event) {
	    LOGGER.info("handling CreateConformLoadGroupEvent - " + event );
	    ConformLoadGroup entity = new ConformLoadGroup();
        entity.setConformLoadGroupId( event.getConformLoadGroupId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadGroup( entity );
    }

    /*
     * @param	event UpdateConformLoadGroupEvent
     */
    @EventHandler( payloadType=UpdateConformLoadGroupEvent.class )
    public void handle( UpdateConformLoadGroupEvent event) {
    	LOGGER.info("handling UpdateConformLoadGroupEvent - " + event );
    	
	    ConformLoadGroup entity = new ConformLoadGroup();
        entity.setConformLoadGroupId( event.getConformLoadGroupId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConformLoadGroup( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadGroup( entity );        
    }
    
    /*
     * @param	event DeleteConformLoadGroupEvent
     */
    @EventHandler( payloadType=DeleteConformLoadGroupEvent.class )
    public void handle( DeleteConformLoadGroupEvent event) {
    	LOGGER.info("handling DeleteConformLoadGroupEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConformLoadGroup entity = delete( event.getConformLoadGroupId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadGroup( entity );

    }    




    /**
     * Method to retrieve the ConformLoadGroup via an ConformLoadGroupPrimaryKey.
     * @param 	id Long
     * @return 	ConformLoadGroup
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConformLoadGroup handle( FindConformLoadGroupQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConformLoadGroupId() );
    }
    
    /**
     * Method to retrieve a collection of all ConformLoadGroups
     *
     * @param	query	FindAllConformLoadGroupQuery 
     * @return 	List<ConformLoadGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConformLoadGroup> handle( FindAllConformLoadGroupQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConformLoadGroup, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConformLoadGroup
	 */
	protected void emitFindConformLoadGroup( ConformLoadGroup entity ) {
		LOGGER.info("handling emitFindConformLoadGroup" );
		
	    queryUpdateEmitter.emit(FindConformLoadGroupQuery.class,
	                            query -> query.getFilter().getConformLoadGroupId().equals(entity.getConformLoadGroupId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConformLoadGroup
	 * 
	 * @param		entity	ConformLoadGroup
	 */
	protected void emitFindAllConformLoadGroup( ConformLoadGroup entity ) {
		LOGGER.info("handling emitFindAllConformLoadGroup" );
		
	    queryUpdateEmitter.emit(FindAllConformLoadGroupQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadGroupProjector.class.getName());

}
