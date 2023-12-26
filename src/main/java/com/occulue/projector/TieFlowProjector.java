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
 * Projector for TieFlow as outlined for the CQRS pattern.  All event handling and query handling related to TieFlow are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TieFlowAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("tieFlow")
@Component("tieFlow-projector")
public class TieFlowProjector extends TieFlowEntityProjector {
		
	// core constructor
	public TieFlowProjector(TieFlowRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTieFlowEvent
     */
    @EventHandler( payloadType=CreateTieFlowEvent.class )
    public void handle( CreateTieFlowEvent event) {
	    LOGGER.info("handling CreateTieFlowEvent - " + event );
	    TieFlow entity = new TieFlow();
        entity.setTieFlowId( event.getTieFlowId() );
        entity.setPositiveFlowIn( event.getPositiveFlowIn() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTieFlow( entity );
    }

    /*
     * @param	event UpdateTieFlowEvent
     */
    @EventHandler( payloadType=UpdateTieFlowEvent.class )
    public void handle( UpdateTieFlowEvent event) {
    	LOGGER.info("handling UpdateTieFlowEvent - " + event );
    	
	    TieFlow entity = new TieFlow();
        entity.setTieFlowId( event.getTieFlowId() );
        entity.setPositiveFlowIn( event.getPositiveFlowIn() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTieFlow( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTieFlow( entity );        
    }
    
    /*
     * @param	event DeleteTieFlowEvent
     */
    @EventHandler( payloadType=DeleteTieFlowEvent.class )
    public void handle( DeleteTieFlowEvent event) {
    	LOGGER.info("handling DeleteTieFlowEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TieFlow entity = delete( event.getTieFlowId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTieFlow( entity );

    }    




    /**
     * Method to retrieve the TieFlow via an TieFlowPrimaryKey.
     * @param 	id Long
     * @return 	TieFlow
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TieFlow handle( FindTieFlowQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTieFlowId() );
    }
    
    /**
     * Method to retrieve a collection of all TieFlows
     *
     * @param	query	FindAllTieFlowQuery 
     * @return 	List<TieFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TieFlow> handle( FindAllTieFlowQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTieFlow, 
	 * but only if the id matches
	 * 
	 * @param		entity	TieFlow
	 */
	protected void emitFindTieFlow( TieFlow entity ) {
		LOGGER.info("handling emitFindTieFlow" );
		
	    queryUpdateEmitter.emit(FindTieFlowQuery.class,
	                            query -> query.getFilter().getTieFlowId().equals(entity.getTieFlowId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTieFlow
	 * 
	 * @param		entity	TieFlow
	 */
	protected void emitFindAllTieFlow( TieFlow entity ) {
		LOGGER.info("handling emitFindAllTieFlow" );
		
	    queryUpdateEmitter.emit(FindAllTieFlowQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TieFlowProjector.class.getName());

}
