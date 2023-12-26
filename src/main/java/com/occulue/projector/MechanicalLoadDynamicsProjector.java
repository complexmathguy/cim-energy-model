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
 * Projector for MechanicalLoadDynamics as outlined for the CQRS pattern.  All event handling and query handling related to MechanicalLoadDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MechanicalLoadDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("mechanicalLoadDynamics")
@Component("mechanicalLoadDynamics-projector")
public class MechanicalLoadDynamicsProjector extends MechanicalLoadDynamicsEntityProjector {
		
	// core constructor
	public MechanicalLoadDynamicsProjector(MechanicalLoadDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMechanicalLoadDynamicsEvent
     */
    @EventHandler( payloadType=CreateMechanicalLoadDynamicsEvent.class )
    public void handle( CreateMechanicalLoadDynamicsEvent event) {
	    LOGGER.info("handling CreateMechanicalLoadDynamicsEvent - " + event );
	    MechanicalLoadDynamics entity = new MechanicalLoadDynamics();
        entity.setMechanicalLoadDynamicsId( event.getMechanicalLoadDynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechanicalLoadDynamics( entity );
    }

    /*
     * @param	event UpdateMechanicalLoadDynamicsEvent
     */
    @EventHandler( payloadType=UpdateMechanicalLoadDynamicsEvent.class )
    public void handle( UpdateMechanicalLoadDynamicsEvent event) {
    	LOGGER.info("handling UpdateMechanicalLoadDynamicsEvent - " + event );
    	
	    MechanicalLoadDynamics entity = new MechanicalLoadDynamics();
        entity.setMechanicalLoadDynamicsId( event.getMechanicalLoadDynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMechanicalLoadDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechanicalLoadDynamics( entity );        
    }
    
    /*
     * @param	event DeleteMechanicalLoadDynamicsEvent
     */
    @EventHandler( payloadType=DeleteMechanicalLoadDynamicsEvent.class )
    public void handle( DeleteMechanicalLoadDynamicsEvent event) {
    	LOGGER.info("handling DeleteMechanicalLoadDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MechanicalLoadDynamics entity = delete( event.getMechanicalLoadDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMechanicalLoadDynamics( entity );

    }    




    /**
     * Method to retrieve the MechanicalLoadDynamics via an MechanicalLoadDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	MechanicalLoadDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MechanicalLoadDynamics handle( FindMechanicalLoadDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMechanicalLoadDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all MechanicalLoadDynamicss
     *
     * @param	query	FindAllMechanicalLoadDynamicsQuery 
     * @return 	List<MechanicalLoadDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MechanicalLoadDynamics> handle( FindAllMechanicalLoadDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMechanicalLoadDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	MechanicalLoadDynamics
	 */
	protected void emitFindMechanicalLoadDynamics( MechanicalLoadDynamics entity ) {
		LOGGER.info("handling emitFindMechanicalLoadDynamics" );
		
	    queryUpdateEmitter.emit(FindMechanicalLoadDynamicsQuery.class,
	                            query -> query.getFilter().getMechanicalLoadDynamicsId().equals(entity.getMechanicalLoadDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMechanicalLoadDynamics
	 * 
	 * @param		entity	MechanicalLoadDynamics
	 */
	protected void emitFindAllMechanicalLoadDynamics( MechanicalLoadDynamics entity ) {
		LOGGER.info("handling emitFindAllMechanicalLoadDynamics" );
		
	    queryUpdateEmitter.emit(FindAllMechanicalLoadDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MechanicalLoadDynamicsProjector.class.getName());

}
