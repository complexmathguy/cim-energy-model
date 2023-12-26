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
 * Projector for LoadComposite as outlined for the CQRS pattern.  All event handling and query handling related to LoadComposite are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadCompositeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadComposite")
@Component("loadComposite-projector")
public class LoadCompositeProjector extends LoadCompositeEntityProjector {
		
	// core constructor
	public LoadCompositeProjector(LoadCompositeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadCompositeEvent
     */
    @EventHandler( payloadType=CreateLoadCompositeEvent.class )
    public void handle( CreateLoadCompositeEvent event) {
	    LOGGER.info("handling CreateLoadCompositeEvent - " + event );
	    LoadComposite entity = new LoadComposite();
        entity.setLoadCompositeId( event.getLoadCompositeId() );
        entity.setEpfd( event.getEpfd() );
        entity.setEpfs( event.getEpfs() );
        entity.setEpvd( event.getEpvd() );
        entity.setEpvs( event.getEpvs() );
        entity.setEqfd( event.getEqfd() );
        entity.setEqfs( event.getEqfs() );
        entity.setEqvd( event.getEqvd() );
        entity.setEqvs( event.getEqvs() );
        entity.setH( event.getH() );
        entity.setLfrac( event.getLfrac() );
        entity.setPfrac( event.getPfrac() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadComposite( entity );
    }

    /*
     * @param	event UpdateLoadCompositeEvent
     */
    @EventHandler( payloadType=UpdateLoadCompositeEvent.class )
    public void handle( UpdateLoadCompositeEvent event) {
    	LOGGER.info("handling UpdateLoadCompositeEvent - " + event );
    	
	    LoadComposite entity = new LoadComposite();
        entity.setLoadCompositeId( event.getLoadCompositeId() );
        entity.setEpfd( event.getEpfd() );
        entity.setEpfs( event.getEpfs() );
        entity.setEpvd( event.getEpvd() );
        entity.setEpvs( event.getEpvs() );
        entity.setEqfd( event.getEqfd() );
        entity.setEqfs( event.getEqfs() );
        entity.setEqvd( event.getEqvd() );
        entity.setEqvs( event.getEqvs() );
        entity.setH( event.getH() );
        entity.setLfrac( event.getLfrac() );
        entity.setPfrac( event.getPfrac() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadComposite( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadComposite( entity );        
    }
    
    /*
     * @param	event DeleteLoadCompositeEvent
     */
    @EventHandler( payloadType=DeleteLoadCompositeEvent.class )
    public void handle( DeleteLoadCompositeEvent event) {
    	LOGGER.info("handling DeleteLoadCompositeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadComposite entity = delete( event.getLoadCompositeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadComposite( entity );

    }    




    /**
     * Method to retrieve the LoadComposite via an LoadCompositePrimaryKey.
     * @param 	id Long
     * @return 	LoadComposite
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadComposite handle( FindLoadCompositeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadCompositeId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadComposites
     *
     * @param	query	FindAllLoadCompositeQuery 
     * @return 	List<LoadComposite> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadComposite> handle( FindAllLoadCompositeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadComposite, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadComposite
	 */
	protected void emitFindLoadComposite( LoadComposite entity ) {
		LOGGER.info("handling emitFindLoadComposite" );
		
	    queryUpdateEmitter.emit(FindLoadCompositeQuery.class,
	                            query -> query.getFilter().getLoadCompositeId().equals(entity.getLoadCompositeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadComposite
	 * 
	 * @param		entity	LoadComposite
	 */
	protected void emitFindAllLoadComposite( LoadComposite entity ) {
		LOGGER.info("handling emitFindAllLoadComposite" );
		
	    queryUpdateEmitter.emit(FindAllLoadCompositeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadCompositeProjector.class.getName());

}
