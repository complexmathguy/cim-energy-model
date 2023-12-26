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
 * Projector for NonlinearShuntCompensatorPoint as outlined for the CQRS pattern.  All event handling and query handling related to NonlinearShuntCompensatorPoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NonlinearShuntCompensatorPointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nonlinearShuntCompensatorPoint")
@Component("nonlinearShuntCompensatorPoint-projector")
public class NonlinearShuntCompensatorPointProjector extends NonlinearShuntCompensatorPointEntityProjector {
		
	// core constructor
	public NonlinearShuntCompensatorPointProjector(NonlinearShuntCompensatorPointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNonlinearShuntCompensatorPointEvent
     */
    @EventHandler( payloadType=CreateNonlinearShuntCompensatorPointEvent.class )
    public void handle( CreateNonlinearShuntCompensatorPointEvent event) {
	    LOGGER.info("handling CreateNonlinearShuntCompensatorPointEvent - " + event );
	    NonlinearShuntCompensatorPoint entity = new NonlinearShuntCompensatorPoint();
        entity.setNonlinearShuntCompensatorPointId( event.getNonlinearShuntCompensatorPointId() );
        entity.setB( event.getB() );
        entity.setB0( event.getB0() );
        entity.setG( event.getG() );
        entity.setG0( event.getG0() );
        entity.setSectionNumber( event.getSectionNumber() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensatorPoint( entity );
    }

    /*
     * @param	event UpdateNonlinearShuntCompensatorPointEvent
     */
    @EventHandler( payloadType=UpdateNonlinearShuntCompensatorPointEvent.class )
    public void handle( UpdateNonlinearShuntCompensatorPointEvent event) {
    	LOGGER.info("handling UpdateNonlinearShuntCompensatorPointEvent - " + event );
    	
	    NonlinearShuntCompensatorPoint entity = new NonlinearShuntCompensatorPoint();
        entity.setNonlinearShuntCompensatorPointId( event.getNonlinearShuntCompensatorPointId() );
        entity.setB( event.getB() );
        entity.setB0( event.getB0() );
        entity.setG( event.getG() );
        entity.setG0( event.getG0() );
        entity.setSectionNumber( event.getSectionNumber() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNonlinearShuntCompensatorPoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensatorPoint( entity );        
    }
    
    /*
     * @param	event DeleteNonlinearShuntCompensatorPointEvent
     */
    @EventHandler( payloadType=DeleteNonlinearShuntCompensatorPointEvent.class )
    public void handle( DeleteNonlinearShuntCompensatorPointEvent event) {
    	LOGGER.info("handling DeleteNonlinearShuntCompensatorPointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NonlinearShuntCompensatorPoint entity = delete( event.getNonlinearShuntCompensatorPointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensatorPoint( entity );

    }    




    /**
     * Method to retrieve the NonlinearShuntCompensatorPoint via an NonlinearShuntCompensatorPointPrimaryKey.
     * @param 	id Long
     * @return 	NonlinearShuntCompensatorPoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NonlinearShuntCompensatorPoint handle( FindNonlinearShuntCompensatorPointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNonlinearShuntCompensatorPointId() );
    }
    
    /**
     * Method to retrieve a collection of all NonlinearShuntCompensatorPoints
     *
     * @param	query	FindAllNonlinearShuntCompensatorPointQuery 
     * @return 	List<NonlinearShuntCompensatorPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NonlinearShuntCompensatorPoint> handle( FindAllNonlinearShuntCompensatorPointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNonlinearShuntCompensatorPoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	NonlinearShuntCompensatorPoint
	 */
	protected void emitFindNonlinearShuntCompensatorPoint( NonlinearShuntCompensatorPoint entity ) {
		LOGGER.info("handling emitFindNonlinearShuntCompensatorPoint" );
		
	    queryUpdateEmitter.emit(FindNonlinearShuntCompensatorPointQuery.class,
	                            query -> query.getFilter().getNonlinearShuntCompensatorPointId().equals(entity.getNonlinearShuntCompensatorPointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNonlinearShuntCompensatorPoint
	 * 
	 * @param		entity	NonlinearShuntCompensatorPoint
	 */
	protected void emitFindAllNonlinearShuntCompensatorPoint( NonlinearShuntCompensatorPoint entity ) {
		LOGGER.info("handling emitFindAllNonlinearShuntCompensatorPoint" );
		
	    queryUpdateEmitter.emit(FindAllNonlinearShuntCompensatorPointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NonlinearShuntCompensatorPointProjector.class.getName());

}
