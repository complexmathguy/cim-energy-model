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
 * Projector for ConformLoad as outlined for the CQRS pattern.  All event handling and query handling related to ConformLoad are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConformLoadAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("conformLoad")
@Component("conformLoad-projector")
public class ConformLoadProjector extends ConformLoadEntityProjector {
		
	// core constructor
	public ConformLoadProjector(ConformLoadRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConformLoadEvent
     */
    @EventHandler( payloadType=CreateConformLoadEvent.class )
    public void handle( CreateConformLoadEvent event) {
	    LOGGER.info("handling CreateConformLoadEvent - " + event );
	    ConformLoad entity = new ConformLoad();
        entity.setConformLoadId( event.getConformLoadId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoad( entity );
    }

    /*
     * @param	event UpdateConformLoadEvent
     */
    @EventHandler( payloadType=UpdateConformLoadEvent.class )
    public void handle( UpdateConformLoadEvent event) {
    	LOGGER.info("handling UpdateConformLoadEvent - " + event );
    	
	    ConformLoad entity = new ConformLoad();
        entity.setConformLoadId( event.getConformLoadId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConformLoad( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoad( entity );        
    }
    
    /*
     * @param	event DeleteConformLoadEvent
     */
    @EventHandler( payloadType=DeleteConformLoadEvent.class )
    public void handle( DeleteConformLoadEvent event) {
    	LOGGER.info("handling DeleteConformLoadEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConformLoad entity = delete( event.getConformLoadId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoad( entity );

    }    




    /**
     * Method to retrieve the ConformLoad via an ConformLoadPrimaryKey.
     * @param 	id Long
     * @return 	ConformLoad
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConformLoad handle( FindConformLoadQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConformLoadId() );
    }
    
    /**
     * Method to retrieve a collection of all ConformLoads
     *
     * @param	query	FindAllConformLoadQuery 
     * @return 	List<ConformLoad> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConformLoad> handle( FindAllConformLoadQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConformLoad, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConformLoad
	 */
	protected void emitFindConformLoad( ConformLoad entity ) {
		LOGGER.info("handling emitFindConformLoad" );
		
	    queryUpdateEmitter.emit(FindConformLoadQuery.class,
	                            query -> query.getFilter().getConformLoadId().equals(entity.getConformLoadId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConformLoad
	 * 
	 * @param		entity	ConformLoad
	 */
	protected void emitFindAllConformLoad( ConformLoad entity ) {
		LOGGER.info("handling emitFindAllConformLoad" );
		
	    queryUpdateEmitter.emit(FindAllConformLoadQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadProjector.class.getName());

}
