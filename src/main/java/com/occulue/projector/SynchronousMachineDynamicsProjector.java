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
 * Projector for SynchronousMachineDynamics as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachineDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachineDynamics")
@Component("synchronousMachineDynamics-projector")
public class SynchronousMachineDynamicsProjector extends SynchronousMachineDynamicsEntityProjector {
		
	// core constructor
	public SynchronousMachineDynamicsProjector(SynchronousMachineDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineDynamicsEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineDynamicsEvent.class )
    public void handle( CreateSynchronousMachineDynamicsEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineDynamicsEvent - " + event );
	    SynchronousMachineDynamics entity = new SynchronousMachineDynamics();
        entity.setSynchronousMachineDynamicsId( event.getSynchronousMachineDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineDynamics( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineDynamicsEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineDynamicsEvent.class )
    public void handle( UpdateSynchronousMachineDynamicsEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineDynamicsEvent - " + event );
    	
	    SynchronousMachineDynamics entity = new SynchronousMachineDynamics();
        entity.setSynchronousMachineDynamicsId( event.getSynchronousMachineDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachineDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineDynamics( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineDynamicsEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineDynamicsEvent.class )
    public void handle( DeleteSynchronousMachineDynamicsEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachineDynamics entity = delete( event.getSynchronousMachineDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineDynamics( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachineDynamics via an SynchronousMachineDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachineDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachineDynamics handle( FindSynchronousMachineDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineDynamicss
     *
     * @param	query	FindAllSynchronousMachineDynamicsQuery 
     * @return 	List<SynchronousMachineDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachineDynamics> handle( FindAllSynchronousMachineDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachineDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachineDynamics
	 */
	protected void emitFindSynchronousMachineDynamics( SynchronousMachineDynamics entity ) {
		LOGGER.info("handling emitFindSynchronousMachineDynamics" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineDynamicsQuery.class,
	                            query -> query.getFilter().getSynchronousMachineDynamicsId().equals(entity.getSynchronousMachineDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachineDynamics
	 * 
	 * @param		entity	SynchronousMachineDynamics
	 */
	protected void emitFindAllSynchronousMachineDynamics( SynchronousMachineDynamics entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachineDynamics" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineDynamicsProjector.class.getName());

}
