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
 * Projector for Dynamicsmodel as outlined for the CQRS pattern.  All event handling and query handling related to Dynamicsmodel are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DynamicsmodelAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dynamicsmodel")
@Component("dynamicsmodel-projector")
public class DynamicsmodelProjector extends DynamicsmodelEntityProjector {
		
	// core constructor
	public DynamicsmodelProjector(DynamicsmodelRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDynamicsmodelEvent
     */
    @EventHandler( payloadType=CreateDynamicsmodelEvent.class )
    public void handle( CreateDynamicsmodelEvent event) {
	    LOGGER.info("handling CreateDynamicsmodelEvent - " + event );
	    Dynamicsmodel entity = new Dynamicsmodel();
        entity.setDynamicsmodelId( event.getDynamicsmodelId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsmodel( entity );
    }

    /*
     * @param	event UpdateDynamicsmodelEvent
     */
    @EventHandler( payloadType=UpdateDynamicsmodelEvent.class )
    public void handle( UpdateDynamicsmodelEvent event) {
    	LOGGER.info("handling UpdateDynamicsmodelEvent - " + event );
    	
	    Dynamicsmodel entity = new Dynamicsmodel();
        entity.setDynamicsmodelId( event.getDynamicsmodelId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDynamicsmodel( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsmodel( entity );        
    }
    
    /*
     * @param	event DeleteDynamicsmodelEvent
     */
    @EventHandler( payloadType=DeleteDynamicsmodelEvent.class )
    public void handle( DeleteDynamicsmodelEvent event) {
    	LOGGER.info("handling DeleteDynamicsmodelEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Dynamicsmodel entity = delete( event.getDynamicsmodelId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsmodel( entity );

    }    




    /**
     * Method to retrieve the Dynamicsmodel via an DynamicsmodelPrimaryKey.
     * @param 	id Long
     * @return 	Dynamicsmodel
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Dynamicsmodel handle( FindDynamicsmodelQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDynamicsmodelId() );
    }
    
    /**
     * Method to retrieve a collection of all Dynamicsmodels
     *
     * @param	query	FindAllDynamicsmodelQuery 
     * @return 	List<Dynamicsmodel> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Dynamicsmodel> handle( FindAllDynamicsmodelQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDynamicsmodel, 
	 * but only if the id matches
	 * 
	 * @param		entity	Dynamicsmodel
	 */
	protected void emitFindDynamicsmodel( Dynamicsmodel entity ) {
		LOGGER.info("handling emitFindDynamicsmodel" );
		
	    queryUpdateEmitter.emit(FindDynamicsmodelQuery.class,
	                            query -> query.getFilter().getDynamicsmodelId().equals(entity.getDynamicsmodelId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDynamicsmodel
	 * 
	 * @param		entity	Dynamicsmodel
	 */
	protected void emitFindAllDynamicsmodel( Dynamicsmodel entity ) {
		LOGGER.info("handling emitFindAllDynamicsmodel" );
		
	    queryUpdateEmitter.emit(FindAllDynamicsmodelQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DynamicsmodelProjector.class.getName());

}
