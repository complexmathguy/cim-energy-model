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
 * Projector for UnderexcitationLimiterDynamics as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcitationLimiterDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcitationLimiterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcitationLimiterDynamics")
@Component("underexcitationLimiterDynamics-projector")
public class UnderexcitationLimiterDynamicsProjector extends UnderexcitationLimiterDynamicsEntityProjector {
		
	// core constructor
	public UnderexcitationLimiterDynamicsProjector(UnderexcitationLimiterDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=CreateUnderexcitationLimiterDynamicsEvent.class )
    public void handle( CreateUnderexcitationLimiterDynamicsEvent event) {
	    LOGGER.info("handling CreateUnderexcitationLimiterDynamicsEvent - " + event );
	    UnderexcitationLimiterDynamics entity = new UnderexcitationLimiterDynamics();
        entity.setUnderexcitationLimiterDynamicsId( event.getUnderexcitationLimiterDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterDynamics( entity );
    }

    /*
     * @param	event UpdateUnderexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=UpdateUnderexcitationLimiterDynamicsEvent.class )
    public void handle( UpdateUnderexcitationLimiterDynamicsEvent event) {
    	LOGGER.info("handling UpdateUnderexcitationLimiterDynamicsEvent - " + event );
    	
	    UnderexcitationLimiterDynamics entity = new UnderexcitationLimiterDynamics();
        entity.setUnderexcitationLimiterDynamicsId( event.getUnderexcitationLimiterDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcitationLimiterDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterDynamics( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=DeleteUnderexcitationLimiterDynamicsEvent.class )
    public void handle( DeleteUnderexcitationLimiterDynamicsEvent event) {
    	LOGGER.info("handling DeleteUnderexcitationLimiterDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcitationLimiterDynamics entity = delete( event.getUnderexcitationLimiterDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterDynamics( entity );

    }    




    /**
     * Method to retrieve the UnderexcitationLimiterDynamics via an UnderexcitationLimiterDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	UnderexcitationLimiterDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcitationLimiterDynamics handle( FindUnderexcitationLimiterDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcitationLimiterDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcitationLimiterDynamicss
     *
     * @param	query	FindAllUnderexcitationLimiterDynamicsQuery 
     * @return 	List<UnderexcitationLimiterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcitationLimiterDynamics> handle( FindAllUnderexcitationLimiterDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcitationLimiterDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcitationLimiterDynamics
	 */
	protected void emitFindUnderexcitationLimiterDynamics( UnderexcitationLimiterDynamics entity ) {
		LOGGER.info("handling emitFindUnderexcitationLimiterDynamics" );
		
	    queryUpdateEmitter.emit(FindUnderexcitationLimiterDynamicsQuery.class,
	                            query -> query.getFilter().getUnderexcitationLimiterDynamicsId().equals(entity.getUnderexcitationLimiterDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcitationLimiterDynamics
	 * 
	 * @param		entity	UnderexcitationLimiterDynamics
	 */
	protected void emitFindAllUnderexcitationLimiterDynamics( UnderexcitationLimiterDynamics entity ) {
		LOGGER.info("handling emitFindAllUnderexcitationLimiterDynamics" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcitationLimiterDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcitationLimiterDynamicsProjector.class.getName());

}
