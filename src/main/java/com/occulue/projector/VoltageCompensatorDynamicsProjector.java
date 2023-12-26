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
 * Projector for VoltageCompensatorDynamics as outlined for the CQRS pattern.  All event handling and query handling related to VoltageCompensatorDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VoltageCompensatorDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("voltageCompensatorDynamics")
@Component("voltageCompensatorDynamics-projector")
public class VoltageCompensatorDynamicsProjector extends VoltageCompensatorDynamicsEntityProjector {
		
	// core constructor
	public VoltageCompensatorDynamicsProjector(VoltageCompensatorDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVoltageCompensatorDynamicsEvent
     */
    @EventHandler( payloadType=CreateVoltageCompensatorDynamicsEvent.class )
    public void handle( CreateVoltageCompensatorDynamicsEvent event) {
	    LOGGER.info("handling CreateVoltageCompensatorDynamicsEvent - " + event );
	    VoltageCompensatorDynamics entity = new VoltageCompensatorDynamics();
        entity.setVoltageCompensatorDynamicsId( event.getVoltageCompensatorDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageCompensatorDynamics( entity );
    }

    /*
     * @param	event UpdateVoltageCompensatorDynamicsEvent
     */
    @EventHandler( payloadType=UpdateVoltageCompensatorDynamicsEvent.class )
    public void handle( UpdateVoltageCompensatorDynamicsEvent event) {
    	LOGGER.info("handling UpdateVoltageCompensatorDynamicsEvent - " + event );
    	
	    VoltageCompensatorDynamics entity = new VoltageCompensatorDynamics();
        entity.setVoltageCompensatorDynamicsId( event.getVoltageCompensatorDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVoltageCompensatorDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageCompensatorDynamics( entity );        
    }
    
    /*
     * @param	event DeleteVoltageCompensatorDynamicsEvent
     */
    @EventHandler( payloadType=DeleteVoltageCompensatorDynamicsEvent.class )
    public void handle( DeleteVoltageCompensatorDynamicsEvent event) {
    	LOGGER.info("handling DeleteVoltageCompensatorDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VoltageCompensatorDynamics entity = delete( event.getVoltageCompensatorDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageCompensatorDynamics( entity );

    }    




    /**
     * Method to retrieve the VoltageCompensatorDynamics via an VoltageCompensatorDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	VoltageCompensatorDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VoltageCompensatorDynamics handle( FindVoltageCompensatorDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVoltageCompensatorDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all VoltageCompensatorDynamicss
     *
     * @param	query	FindAllVoltageCompensatorDynamicsQuery 
     * @return 	List<VoltageCompensatorDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VoltageCompensatorDynamics> handle( FindAllVoltageCompensatorDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVoltageCompensatorDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	VoltageCompensatorDynamics
	 */
	protected void emitFindVoltageCompensatorDynamics( VoltageCompensatorDynamics entity ) {
		LOGGER.info("handling emitFindVoltageCompensatorDynamics" );
		
	    queryUpdateEmitter.emit(FindVoltageCompensatorDynamicsQuery.class,
	                            query -> query.getFilter().getVoltageCompensatorDynamicsId().equals(entity.getVoltageCompensatorDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVoltageCompensatorDynamics
	 * 
	 * @param		entity	VoltageCompensatorDynamics
	 */
	protected void emitFindAllVoltageCompensatorDynamics( VoltageCompensatorDynamics entity ) {
		LOGGER.info("handling emitFindAllVoltageCompensatorDynamics" );
		
	    queryUpdateEmitter.emit(FindAllVoltageCompensatorDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VoltageCompensatorDynamicsProjector.class.getName());

}
