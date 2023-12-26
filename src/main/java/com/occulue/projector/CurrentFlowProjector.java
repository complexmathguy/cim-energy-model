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
 * Projector for CurrentFlow as outlined for the CQRS pattern.  All event handling and query handling related to CurrentFlow are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CurrentFlowAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("currentFlow")
@Component("currentFlow-projector")
public class CurrentFlowProjector extends CurrentFlowEntityProjector {
		
	// core constructor
	public CurrentFlowProjector(CurrentFlowRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCurrentFlowEvent
     */
    @EventHandler( payloadType=CreateCurrentFlowEvent.class )
    public void handle( CreateCurrentFlowEvent event) {
	    LOGGER.info("handling CreateCurrentFlowEvent - " + event );
	    CurrentFlow entity = new CurrentFlow();
        entity.setCurrentFlowId( event.getCurrentFlowId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentFlow( entity );
    }

    /*
     * @param	event UpdateCurrentFlowEvent
     */
    @EventHandler( payloadType=UpdateCurrentFlowEvent.class )
    public void handle( UpdateCurrentFlowEvent event) {
    	LOGGER.info("handling UpdateCurrentFlowEvent - " + event );
    	
	    CurrentFlow entity = new CurrentFlow();
        entity.setCurrentFlowId( event.getCurrentFlowId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCurrentFlow( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentFlow( entity );        
    }
    
    /*
     * @param	event DeleteCurrentFlowEvent
     */
    @EventHandler( payloadType=DeleteCurrentFlowEvent.class )
    public void handle( DeleteCurrentFlowEvent event) {
    	LOGGER.info("handling DeleteCurrentFlowEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	CurrentFlow entity = delete( event.getCurrentFlowId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurrentFlow( entity );

    }    




    /**
     * Method to retrieve the CurrentFlow via an CurrentFlowPrimaryKey.
     * @param 	id Long
     * @return 	CurrentFlow
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public CurrentFlow handle( FindCurrentFlowQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCurrentFlowId() );
    }
    
    /**
     * Method to retrieve a collection of all CurrentFlows
     *
     * @param	query	FindAllCurrentFlowQuery 
     * @return 	List<CurrentFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<CurrentFlow> handle( FindAllCurrentFlowQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCurrentFlow, 
	 * but only if the id matches
	 * 
	 * @param		entity	CurrentFlow
	 */
	protected void emitFindCurrentFlow( CurrentFlow entity ) {
		LOGGER.info("handling emitFindCurrentFlow" );
		
	    queryUpdateEmitter.emit(FindCurrentFlowQuery.class,
	                            query -> query.getFilter().getCurrentFlowId().equals(entity.getCurrentFlowId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCurrentFlow
	 * 
	 * @param		entity	CurrentFlow
	 */
	protected void emitFindAllCurrentFlow( CurrentFlow entity ) {
		LOGGER.info("handling emitFindAllCurrentFlow" );
		
	    queryUpdateEmitter.emit(FindAllCurrentFlowQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CurrentFlowProjector.class.getName());

}
