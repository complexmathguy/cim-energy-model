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
 * Projector for TurbineGovernorDynamics as outlined for the CQRS pattern.  All event handling and query handling related to TurbineGovernorDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TurbineGovernorDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("turbineGovernorDynamics")
@Component("turbineGovernorDynamics-projector")
public class TurbineGovernorDynamicsProjector extends TurbineGovernorDynamicsEntityProjector {
		
	// core constructor
	public TurbineGovernorDynamicsProjector(TurbineGovernorDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTurbineGovernorDynamicsEvent
     */
    @EventHandler( payloadType=CreateTurbineGovernorDynamicsEvent.class )
    public void handle( CreateTurbineGovernorDynamicsEvent event) {
	    LOGGER.info("handling CreateTurbineGovernorDynamicsEvent - " + event );
	    TurbineGovernorDynamics entity = new TurbineGovernorDynamics();
        entity.setTurbineGovernorDynamicsId( event.getTurbineGovernorDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbineGovernorDynamics( entity );
    }

    /*
     * @param	event UpdateTurbineGovernorDynamicsEvent
     */
    @EventHandler( payloadType=UpdateTurbineGovernorDynamicsEvent.class )
    public void handle( UpdateTurbineGovernorDynamicsEvent event) {
    	LOGGER.info("handling UpdateTurbineGovernorDynamicsEvent - " + event );
    	
	    TurbineGovernorDynamics entity = new TurbineGovernorDynamics();
        entity.setTurbineGovernorDynamicsId( event.getTurbineGovernorDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTurbineGovernorDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbineGovernorDynamics( entity );        
    }
    
    /*
     * @param	event DeleteTurbineGovernorDynamicsEvent
     */
    @EventHandler( payloadType=DeleteTurbineGovernorDynamicsEvent.class )
    public void handle( DeleteTurbineGovernorDynamicsEvent event) {
    	LOGGER.info("handling DeleteTurbineGovernorDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TurbineGovernorDynamics entity = delete( event.getTurbineGovernorDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbineGovernorDynamics( entity );

    }    




    /**
     * Method to retrieve the TurbineGovernorDynamics via an TurbineGovernorDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	TurbineGovernorDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TurbineGovernorDynamics handle( FindTurbineGovernorDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTurbineGovernorDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all TurbineGovernorDynamicss
     *
     * @param	query	FindAllTurbineGovernorDynamicsQuery 
     * @return 	List<TurbineGovernorDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TurbineGovernorDynamics> handle( FindAllTurbineGovernorDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTurbineGovernorDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	TurbineGovernorDynamics
	 */
	protected void emitFindTurbineGovernorDynamics( TurbineGovernorDynamics entity ) {
		LOGGER.info("handling emitFindTurbineGovernorDynamics" );
		
	    queryUpdateEmitter.emit(FindTurbineGovernorDynamicsQuery.class,
	                            query -> query.getFilter().getTurbineGovernorDynamicsId().equals(entity.getTurbineGovernorDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTurbineGovernorDynamics
	 * 
	 * @param		entity	TurbineGovernorDynamics
	 */
	protected void emitFindAllTurbineGovernorDynamics( TurbineGovernorDynamics entity ) {
		LOGGER.info("handling emitFindAllTurbineGovernorDynamics" );
		
	    queryUpdateEmitter.emit(FindAllTurbineGovernorDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TurbineGovernorDynamicsProjector.class.getName());

}
