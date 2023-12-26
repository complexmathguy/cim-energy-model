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
 * Projector for ExcitationSystemDynamics as outlined for the CQRS pattern.  All event handling and query handling related to ExcitationSystemDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcitationSystemDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excitationSystemDynamics")
@Component("excitationSystemDynamics-projector")
public class ExcitationSystemDynamicsProjector extends ExcitationSystemDynamicsEntityProjector {
		
	// core constructor
	public ExcitationSystemDynamicsProjector(ExcitationSystemDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcitationSystemDynamicsEvent
     */
    @EventHandler( payloadType=CreateExcitationSystemDynamicsEvent.class )
    public void handle( CreateExcitationSystemDynamicsEvent event) {
	    LOGGER.info("handling CreateExcitationSystemDynamicsEvent - " + event );
	    ExcitationSystemDynamics entity = new ExcitationSystemDynamics();
        entity.setExcitationSystemDynamicsId( event.getExcitationSystemDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemDynamics( entity );
    }

    /*
     * @param	event UpdateExcitationSystemDynamicsEvent
     */
    @EventHandler( payloadType=UpdateExcitationSystemDynamicsEvent.class )
    public void handle( UpdateExcitationSystemDynamicsEvent event) {
    	LOGGER.info("handling UpdateExcitationSystemDynamicsEvent - " + event );
    	
	    ExcitationSystemDynamics entity = new ExcitationSystemDynamics();
        entity.setExcitationSystemDynamicsId( event.getExcitationSystemDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcitationSystemDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemDynamics( entity );        
    }
    
    /*
     * @param	event DeleteExcitationSystemDynamicsEvent
     */
    @EventHandler( payloadType=DeleteExcitationSystemDynamicsEvent.class )
    public void handle( DeleteExcitationSystemDynamicsEvent event) {
    	LOGGER.info("handling DeleteExcitationSystemDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcitationSystemDynamics entity = delete( event.getExcitationSystemDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemDynamics( entity );

    }    




    /**
     * Method to retrieve the ExcitationSystemDynamics via an ExcitationSystemDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	ExcitationSystemDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcitationSystemDynamics handle( FindExcitationSystemDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcitationSystemDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcitationSystemDynamicss
     *
     * @param	query	FindAllExcitationSystemDynamicsQuery 
     * @return 	List<ExcitationSystemDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcitationSystemDynamics> handle( FindAllExcitationSystemDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcitationSystemDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcitationSystemDynamics
	 */
	protected void emitFindExcitationSystemDynamics( ExcitationSystemDynamics entity ) {
		LOGGER.info("handling emitFindExcitationSystemDynamics" );
		
	    queryUpdateEmitter.emit(FindExcitationSystemDynamicsQuery.class,
	                            query -> query.getFilter().getExcitationSystemDynamicsId().equals(entity.getExcitationSystemDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcitationSystemDynamics
	 * 
	 * @param		entity	ExcitationSystemDynamics
	 */
	protected void emitFindAllExcitationSystemDynamics( ExcitationSystemDynamics entity ) {
		LOGGER.info("handling emitFindAllExcitationSystemDynamics" );
		
	    queryUpdateEmitter.emit(FindAllExcitationSystemDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcitationSystemDynamicsProjector.class.getName());

}
