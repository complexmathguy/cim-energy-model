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
 * Projector for VoltageAdjusterDynamics as outlined for the CQRS pattern.  All event handling and query handling related to VoltageAdjusterDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VoltageAdjusterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("voltageAdjusterDynamics")
@Component("voltageAdjusterDynamics-projector")
public class VoltageAdjusterDynamicsProjector extends VoltageAdjusterDynamicsEntityProjector {
		
	// core constructor
	public VoltageAdjusterDynamicsProjector(VoltageAdjusterDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVoltageAdjusterDynamicsEvent
     */
    @EventHandler( payloadType=CreateVoltageAdjusterDynamicsEvent.class )
    public void handle( CreateVoltageAdjusterDynamicsEvent event) {
	    LOGGER.info("handling CreateVoltageAdjusterDynamicsEvent - " + event );
	    VoltageAdjusterDynamics entity = new VoltageAdjusterDynamics();
        entity.setVoltageAdjusterDynamicsId( event.getVoltageAdjusterDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterDynamics( entity );
    }

    /*
     * @param	event UpdateVoltageAdjusterDynamicsEvent
     */
    @EventHandler( payloadType=UpdateVoltageAdjusterDynamicsEvent.class )
    public void handle( UpdateVoltageAdjusterDynamicsEvent event) {
    	LOGGER.info("handling UpdateVoltageAdjusterDynamicsEvent - " + event );
    	
	    VoltageAdjusterDynamics entity = new VoltageAdjusterDynamics();
        entity.setVoltageAdjusterDynamicsId( event.getVoltageAdjusterDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVoltageAdjusterDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterDynamics( entity );        
    }
    
    /*
     * @param	event DeleteVoltageAdjusterDynamicsEvent
     */
    @EventHandler( payloadType=DeleteVoltageAdjusterDynamicsEvent.class )
    public void handle( DeleteVoltageAdjusterDynamicsEvent event) {
    	LOGGER.info("handling DeleteVoltageAdjusterDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VoltageAdjusterDynamics entity = delete( event.getVoltageAdjusterDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterDynamics( entity );

    }    




    /**
     * Method to retrieve the VoltageAdjusterDynamics via an VoltageAdjusterDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	VoltageAdjusterDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VoltageAdjusterDynamics handle( FindVoltageAdjusterDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVoltageAdjusterDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all VoltageAdjusterDynamicss
     *
     * @param	query	FindAllVoltageAdjusterDynamicsQuery 
     * @return 	List<VoltageAdjusterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VoltageAdjusterDynamics> handle( FindAllVoltageAdjusterDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVoltageAdjusterDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	VoltageAdjusterDynamics
	 */
	protected void emitFindVoltageAdjusterDynamics( VoltageAdjusterDynamics entity ) {
		LOGGER.info("handling emitFindVoltageAdjusterDynamics" );
		
	    queryUpdateEmitter.emit(FindVoltageAdjusterDynamicsQuery.class,
	                            query -> query.getFilter().getVoltageAdjusterDynamicsId().equals(entity.getVoltageAdjusterDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVoltageAdjusterDynamics
	 * 
	 * @param		entity	VoltageAdjusterDynamics
	 */
	protected void emitFindAllVoltageAdjusterDynamics( VoltageAdjusterDynamics entity ) {
		LOGGER.info("handling emitFindAllVoltageAdjusterDynamics" );
		
	    queryUpdateEmitter.emit(FindAllVoltageAdjusterDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VoltageAdjusterDynamicsProjector.class.getName());

}
