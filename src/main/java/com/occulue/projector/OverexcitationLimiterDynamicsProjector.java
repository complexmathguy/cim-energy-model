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
 * Projector for OverexcitationLimiterDynamics as outlined for the CQRS pattern.  All event handling and query handling related to OverexcitationLimiterDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcitationLimiterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcitationLimiterDynamics")
@Component("overexcitationLimiterDynamics-projector")
public class OverexcitationLimiterDynamicsProjector extends OverexcitationLimiterDynamicsEntityProjector {
		
	// core constructor
	public OverexcitationLimiterDynamicsProjector(OverexcitationLimiterDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=CreateOverexcitationLimiterDynamicsEvent.class )
    public void handle( CreateOverexcitationLimiterDynamicsEvent event) {
	    LOGGER.info("handling CreateOverexcitationLimiterDynamicsEvent - " + event );
	    OverexcitationLimiterDynamics entity = new OverexcitationLimiterDynamics();
        entity.setOverexcitationLimiterDynamicsId( event.getOverexcitationLimiterDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterDynamics( entity );
    }

    /*
     * @param	event UpdateOverexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=UpdateOverexcitationLimiterDynamicsEvent.class )
    public void handle( UpdateOverexcitationLimiterDynamicsEvent event) {
    	LOGGER.info("handling UpdateOverexcitationLimiterDynamicsEvent - " + event );
    	
	    OverexcitationLimiterDynamics entity = new OverexcitationLimiterDynamics();
        entity.setOverexcitationLimiterDynamicsId( event.getOverexcitationLimiterDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOverexcitationLimiterDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterDynamics( entity );        
    }
    
    /*
     * @param	event DeleteOverexcitationLimiterDynamicsEvent
     */
    @EventHandler( payloadType=DeleteOverexcitationLimiterDynamicsEvent.class )
    public void handle( DeleteOverexcitationLimiterDynamicsEvent event) {
    	LOGGER.info("handling DeleteOverexcitationLimiterDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcitationLimiterDynamics entity = delete( event.getOverexcitationLimiterDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterDynamics( entity );

    }    




    /**
     * Method to retrieve the OverexcitationLimiterDynamics via an OverexcitationLimiterDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	OverexcitationLimiterDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcitationLimiterDynamics handle( FindOverexcitationLimiterDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcitationLimiterDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcitationLimiterDynamicss
     *
     * @param	query	FindAllOverexcitationLimiterDynamicsQuery 
     * @return 	List<OverexcitationLimiterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcitationLimiterDynamics> handle( FindAllOverexcitationLimiterDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcitationLimiterDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcitationLimiterDynamics
	 */
	protected void emitFindOverexcitationLimiterDynamics( OverexcitationLimiterDynamics entity ) {
		LOGGER.info("handling emitFindOverexcitationLimiterDynamics" );
		
	    queryUpdateEmitter.emit(FindOverexcitationLimiterDynamicsQuery.class,
	                            query -> query.getFilter().getOverexcitationLimiterDynamicsId().equals(entity.getOverexcitationLimiterDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcitationLimiterDynamics
	 * 
	 * @param		entity	OverexcitationLimiterDynamics
	 */
	protected void emitFindAllOverexcitationLimiterDynamics( OverexcitationLimiterDynamics entity ) {
		LOGGER.info("handling emitFindAllOverexcitationLimiterDynamics" );
		
	    queryUpdateEmitter.emit(FindAllOverexcitationLimiterDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcitationLimiterDynamicsProjector.class.getName());

}
