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
 * Projector for RotatingMachineDynamics as outlined for the CQRS pattern.  All event handling and query handling related to RotatingMachineDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RotatingMachineDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("rotatingMachineDynamics")
@Component("rotatingMachineDynamics-projector")
public class RotatingMachineDynamicsProjector extends RotatingMachineDynamicsEntityProjector {
		
	// core constructor
	public RotatingMachineDynamicsProjector(RotatingMachineDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRotatingMachineDynamicsEvent
     */
    @EventHandler( payloadType=CreateRotatingMachineDynamicsEvent.class )
    public void handle( CreateRotatingMachineDynamicsEvent event) {
	    LOGGER.info("handling CreateRotatingMachineDynamicsEvent - " + event );
	    RotatingMachineDynamics entity = new RotatingMachineDynamics();
        entity.setRotatingMachineDynamicsId( event.getRotatingMachineDynamicsId() );
        entity.setDamping( event.getDamping() );
        entity.setInertia( event.getInertia() );
        entity.setSaturationFactor( event.getSaturationFactor() );
        entity.setSaturationFactor120( event.getSaturationFactor120() );
        entity.setStatorLeakageReactance( event.getStatorLeakageReactance() );
        entity.setStatorResistance( event.getStatorResistance() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRotatingMachineDynamics( entity );
    }

    /*
     * @param	event UpdateRotatingMachineDynamicsEvent
     */
    @EventHandler( payloadType=UpdateRotatingMachineDynamicsEvent.class )
    public void handle( UpdateRotatingMachineDynamicsEvent event) {
    	LOGGER.info("handling UpdateRotatingMachineDynamicsEvent - " + event );
    	
	    RotatingMachineDynamics entity = new RotatingMachineDynamics();
        entity.setRotatingMachineDynamicsId( event.getRotatingMachineDynamicsId() );
        entity.setDamping( event.getDamping() );
        entity.setInertia( event.getInertia() );
        entity.setSaturationFactor( event.getSaturationFactor() );
        entity.setSaturationFactor120( event.getSaturationFactor120() );
        entity.setStatorLeakageReactance( event.getStatorLeakageReactance() );
        entity.setStatorResistance( event.getStatorResistance() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRotatingMachineDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRotatingMachineDynamics( entity );        
    }
    
    /*
     * @param	event DeleteRotatingMachineDynamicsEvent
     */
    @EventHandler( payloadType=DeleteRotatingMachineDynamicsEvent.class )
    public void handle( DeleteRotatingMachineDynamicsEvent event) {
    	LOGGER.info("handling DeleteRotatingMachineDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RotatingMachineDynamics entity = delete( event.getRotatingMachineDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRotatingMachineDynamics( entity );

    }    




    /**
     * Method to retrieve the RotatingMachineDynamics via an RotatingMachineDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	RotatingMachineDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RotatingMachineDynamics handle( FindRotatingMachineDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRotatingMachineDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all RotatingMachineDynamicss
     *
     * @param	query	FindAllRotatingMachineDynamicsQuery 
     * @return 	List<RotatingMachineDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RotatingMachineDynamics> handle( FindAllRotatingMachineDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRotatingMachineDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	RotatingMachineDynamics
	 */
	protected void emitFindRotatingMachineDynamics( RotatingMachineDynamics entity ) {
		LOGGER.info("handling emitFindRotatingMachineDynamics" );
		
	    queryUpdateEmitter.emit(FindRotatingMachineDynamicsQuery.class,
	                            query -> query.getFilter().getRotatingMachineDynamicsId().equals(entity.getRotatingMachineDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRotatingMachineDynamics
	 * 
	 * @param		entity	RotatingMachineDynamics
	 */
	protected void emitFindAllRotatingMachineDynamics( RotatingMachineDynamics entity ) {
		LOGGER.info("handling emitFindAllRotatingMachineDynamics" );
		
	    queryUpdateEmitter.emit(FindAllRotatingMachineDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RotatingMachineDynamicsProjector.class.getName());

}
